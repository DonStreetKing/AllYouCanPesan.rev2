package com.example.allyoucanpesanrev2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

public class SignUp extends AppCompatActivity {
    ProgressDialog progressDialog;
    Button BuatAkun;
    EditText KolomIsi_Nama, editTextBuatEmail, editTextPassword1, editTextPassword2;
    Intent intent;

    int success;
    ConnectivityManager connectivityManager;

    private String url = Server.URL + "Registrasi_User.php";
    private static final String TAG = SignUp.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
            }
            else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }

        BuatAkun = (Button) findViewById(R.id.Tombol_MasukAkun);
        KolomIsi_Nama = (EditText) findViewById(R.id.KolomIsi_Nama);
        editTextBuatEmail = (EditText) findViewById(R.id.editTextBuatEmail);
        editTextPassword1 = (EditText) findViewById(R.id.editTextPassword1);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        //TOmbol buat akun
        BuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nama = KolomIsi_Nama.getText().toString();
                String Email = editTextBuatEmail.getText().toString();
                String Password = editTextPassword1.getText().toString();
                String Confirm_Password = editTextPassword2.getText().toString();

                if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
                    checkUser_Account(Nama, Email, Password, Confirm_Password);
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Tombol Sudah Punya Akun
        TextView sudahpunyakun = (TextView) findViewById(R.id.Tombol_KalauBelumPunyaAkun);
        sudahpunyakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(SignUp.this, Login.class);
                startActivity(x);
            }
        });
    }

    private void checkUser_Account(String Nama, final String Email, final String Password, final String Confirm_Password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Register...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_SUCCESS);

                    //Check kalau ada error node di JSON
                    if (success == 1) {
                        Log.e("Successfully Register!", jsonObject.toString());
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                        KolomIsi_Nama.setText("");
                        editTextBuatEmail.setText("");
                        editTextPassword1.setText("");
                        editTextPassword2.setText("");
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
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
//                        hideDialog();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Nama", Nama);
                params.put("Email", Email);
                params.put("Password", Password);
                params.put("Confirm_Password", Confirm_Password);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog () {
        if (!progressDialog.isShowing())
            progressDialog.dismiss();
    }
    @Override
    public void onBackPressed() {
        intent = new Intent(SignUp.this, Login.class);
        finish();
        startActivity(intent);
    }
}