package com.example.allyoucanpesanrev2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.allyoucanpesanrev2.AdditionalNeededClass.AppController;
import com.example.allyoucanpesanrev2.AdditionalNeededClass.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    ProgressDialog progressDialog;
    Button Tombol_MasukAkun;
    TextView signup;
    EditText EditText_Email, EditText_Password;
    Intent intent;

    int success;
    ConnectivityManager connectivityManager;

    private String url = Server.URLLocal + "Login_User.php";

    private static final String TAG = Login.class.getSimpleName();
    private static final String TAG_Success = "Sukses";
    private static final String TAG_MESSAGE = "Message";

    public final static String TAG_EMAIL = "Email";
    public final static String TAG_NAMA = "Nama";

    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedPreferences;
    Boolean session = false;
    String Nama, Email;

    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
            }
            else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }
        signup = findViewById(R.id.Tombol_KalauBelumPunyaAkun);
        Tombol_MasukAkun = findViewById(R.id.Tombol_BuatAkun);
        EditText_Email = findViewById(R.id.KolomIsi_Nama);
        EditText_Password = findViewById(R.id.editTextTextPassword);

        // cek session login
        sharedPreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(session_status, false);
        Nama = sharedPreferences.getString(TAG_NAMA, null);
        Email = sharedPreferences.getString(TAG_EMAIL, null);

        if (session) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra(TAG_NAMA, Nama);
            intent.putExtra(TAG_EMAIL, Email);
            finish();
            startActivity(intent);
        }

        Tombol_MasukAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = EditText_Email.getText().toString();
                String Password = EditText_Password.getText().toString();

                //Cek kolom kosong
                if (Email.trim().length() > 0 && Password.trim().length() > 0) {
                    if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
                        checkLogin(Email, Password);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    private void checkLogin(final String Email, final String Password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Logging in...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Login Response:" + response.toString());
                hideDialog();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_Success);

                    // check error node in json
                    if (success == 1) {
                        String Nama = jsonObject.getString(TAG_NAMA);
                        String Email = jsonObject.getString(TAG_EMAIL);

                        Log.e("Login Success!", jsonObject.toString());
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        // simpan login ke session
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(session_status, true);
                        editor.putString(TAG_EMAIL, Email);
                        editor.putString(TAG_NAMA, Nama);
                        editor.commit();

                        // call main actibiyt
                        Intent intent = new Intent(Login.this, MainActivity.class);
//                        intent.putExtra(TAG_EMAIL, Email);
//                        intent.putExtra(TAG_NAMA, Nama);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Login Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        hideDialog();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                //Posting parameters to login url
                Map<String, String> params = new HashMap<>();
                params.put("Email", Email);
                params.put("Password", Password);
                return params;
            }
        };

        // Adding request to request ueue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    private void hideDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void showDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}