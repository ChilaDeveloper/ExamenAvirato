package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.examen.services.Login;

public class MainActivity extends AppCompatActivity {

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText
                Login login = new Login("brayanpablo@ooutlook.com","604358715");
                if(login.saveToken()){
                    userList();
                }else{
                    //Toast
                }
            }
        });


    }

    private void userList() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }



}