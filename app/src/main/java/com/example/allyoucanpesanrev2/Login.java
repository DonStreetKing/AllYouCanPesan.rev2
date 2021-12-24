package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public final static  String TAG_USERNAME = "Username";
    public final static String TAG_ID = "ID";

    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedPreferences;
    Boolean session = false;
    String ID, Username;

    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Code untuk login PHP
        connectivityManager = (connectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetwork() !=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()) {
            }
            else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }

        //Tombol login
        Button login = (Button) findViewById(R.id.Tombol_Login);
        TextView signup = (TextView) findViewById(R.id.Tombol_KalauBelumPunyaAkun);
        EditText_Email = (EditText) findViewById(R.id.KolomIsi_Email);
        EditText_Password = (EditText) findViewById(R.id.editTextTextPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Login.this, MainActivity.class);
                startActivity(x);
            }
        });

        //Tombol Belum Punya akun
        TextView signup = (TextView) findViewById(R.id.Tombol_KalauBelumPunyaAkun);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Login.this, SignUp.class);
                startActivity(x);
            }
        });
    }
}