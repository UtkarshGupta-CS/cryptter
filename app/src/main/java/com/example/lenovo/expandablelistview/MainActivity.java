package com.example.lenovo.expandablelistview;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText editUsername;
    EditText editPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUsername = (EditText)findViewById(R.id.editUsername);
        editPassword=(EditText)findViewById(R.id.editPassword);
        btnlogin=(Button)findViewById(R.id.btnLogin);
        mAuth=FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                loginuser(email,password);
            }
        });
    }
    private void loginuser(String email, String password){
       mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {
                   Intent login = new Intent(MainActivity.this, Navigationtte.class);
                   startActivity(login);

               } else {
                   Toast.makeText(getApplicationContext(), "WRong inputs", Toast.LENGTH_LONG
                   ).show();
               }
           }

       });
}
    }

