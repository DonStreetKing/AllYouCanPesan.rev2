package com.example.allyoucanpesanrev2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
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
    EditText KolomIsiNama, KolomIsiEmail, KolomIsiPassword, KolomConfirmPassword;
    TextView SudahPunyaAkun;
    Intent intent;

    int success;
    ConnectivityManager connectivityManager;

    private String url = Server.URL + "Registrasi_User_SQLI.php";
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
        SudahPunyaAkun = findViewById(R.id.Tombol_KalauSudahPunyaAkun);
        BuatAkun = findViewById(R.id.Tombol_BuatAkun);
        KolomIsiNama = findViewById(R.id.KolomIsi_Nama);
        KolomIsiEmail = findViewById(R.id.editTextBuatEmail);
        KolomIsiPassword = findViewById(R.id.KolomIsi_Password);
        KolomConfirmPassword = findViewById(R.id.editTextPassword2);

        BuatAkun.setOnClickListener(v -> {
            String Nama = KolomIsiNama.getText().toString();
            String Email = KolomIsiEmail.getText().toString();
            String Password = KolomIsiPassword.getText().toString();
            String Confirm_Password = KolomConfirmPassword.getText().toString();

            if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
                checkRegister(Nama, Email, Password, Confirm_Password);
            }
            else {
                Toast.makeText(getApplicationContext(), "No Network Connection", Toast.LENGTH_SHORT).show();
            }
        });

        SudahPunyaAkun.setOnClickListener(v -> {
            intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);
        });

    }
    private void checkRegister(final String Nama, final String Email, final String Password, final String Confirm_Password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Registering....");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            Log.e(TAG, "Register Response: " + response.toString());
            hideDialog();

            try {
                JSONObject jsonObject = new JSONObject(response);
                success = jsonObject.getInt(TAG_SUCCESS);

                // check error node in json
                if (success == 1) {
                    Log.e("Successfuly Register!", jsonObject.toString());

                    Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    KolomIsiNama.setText("");
                    KolomIsiEmail.setText("");
                    KolomIsiPassword.setText("");
                    KolomConfirmPassword.setText("");

                    intent = new Intent(SignUp.this, Login.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.e(TAG, "Login Error: " + error.getMessage());
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            hideDialog();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
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
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
    @Override
    public void onBackPressed() {
        intent = new Intent(SignUp.this, Login.class);
        finish();
        startActivity(intent);
    }
}