package com.example.lenovo.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    Button getNewTicket;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getNewTicket=(Button)findViewById(R.id.genNewTicket);
        getNewTicket.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent newpage2 = new Intent(getApplicationContext(),bookTicket.class);
                startActivity(newpage2);
            }
        });
       final Button button = findViewById(R.id.verifyTicket);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent newpage = new Intent(getApplicationContext(),VerifyTicket.class);
                startActivity(newpage);
            }
        });
    }
}