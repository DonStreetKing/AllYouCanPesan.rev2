package com.example.allyoucanpesanrev2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    ProgressDialog progressDialog;
    Button login;
    TextView signup;
    EditText EditText_Email, EditText_Password;
    Intent intent;

    int success;
    ConnectivityManager connectivityManager;

    private String url = Server.URL + "Login_User.php";

    private static final String TAG = Login.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAAGE = "Message";

    public final static String TAG_EMAIL = "Email";
    public final static String TAG_ID = "ID";

    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedPreferences;
    Boolean session = false;
    String ID, Email;

    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Code untuk login PHP
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetwork() !=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
            }
            else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }

        //Tombol login
        Button login = (Button) findViewById(R.id.Tombol_MasukAkun);
        TextView signup = (TextView) findViewById(R.id.Tombol_KalauBelumPunyaAkun);
        EditText_Email = (EditText) findViewById(R.id.KolomIsi_Nama);
        EditText_Password = (EditText) findViewById(R.id.editTextTextPassword);

        // cek session
        sharedPreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(session_status, false);
        ID = sharedPreferences.getString(TAG_ID, null);
        Email = sharedPreferences.getString(TAG_EMAIL, null);

        if (session) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra(TAG_ID, ID);
            intent.putExtra(TAG_EMAIL, Email);
            finish();
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = EditText_Email.getText().toString();
                String Password = EditText_Password.getText().toString();

                // Cek Kolom Kosong
                if (Email.trim().length() > 0 && Password.trim().length() > 0) {
                    if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
                        checkLogin(Email, Password);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Isi Kolom nya!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Tombol Belum Punya akun
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(Login.this, SignUp.class);
                startActivity(x);
            }
        });
    }

    private void checkLogin(final String Email, final String Password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Logging In...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        String Email = jsonObject.getString(TAG_EMAIL);
                        String ID = jsonObject.getString(TAG_ID);

                        Log.e("Successfully Login", jsonObject.toString());
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAAGE), Toast.LENGTH_LONG).show();

                        //Simpan Sesi Login
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(session_status, true);
                        editor.putString(TAG_ID, ID);
                        editor.putString(TAG_EMAIL, Email);
                        editor.commit();

                        // Munculin Main Activity
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra(TAG_ID, ID);
                        intent.putExtra(TAG_EMAIL, Email);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Login Error:" + error.getMessage());
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        hideDialog();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Email", Email);
                params.put("Password", Password);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hideDialog() {
        if (!progressDialog.isShowing())
            progressDialog.dismiss();
    }
}