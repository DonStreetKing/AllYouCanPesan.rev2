package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Tombol Sudah Punya Akun
        TextView sudahpunyakun = (TextView) findViewById(R.id.Tombol_SudahPunyaAkun);
        sudahpunyakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(SignUp.this, Login.class);
                startActivity(x);
            }
        });
    }
}