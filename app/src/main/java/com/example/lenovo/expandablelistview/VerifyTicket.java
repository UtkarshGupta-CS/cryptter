package com.example.lenovo.expandablelistview;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.json.JSONException;
import org.json.JSONObject;

public class VerifyTicket extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference mdatabase;
    //veiw objects
    private Button buttonScan;
    private TextView textViewName, textViewAddress;
    //qr code scanner object
    private IntentIntegrator qrScan;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_ticket);
       textView6=(TextView)findViewById(R.id.textView6);
        //view objects
        mdatabase=FirebaseDatabase.getInstance().getReference().child("User");

        buttonScan = (Button) findViewById(R.id.buttonScan);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);

        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        buttonScan.setOnClickListener(this);

            }


    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    final String st=obj.getString("pnr");
                    final String ss=obj.getString("aadhar");
                    textViewName.setText(obj.getString("pnr"));
                    textViewAddress.setText(obj.getString("aadhar"));
                    mdatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {
                                String uidai = dataSnapshot.child(st).child("uidai").getValue().toString();
                                if (uidai.equals(ss)) {
                                    textView6.setText("Verified");
                                    Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_LONG).show();
                                } else {
                                    textView6.setText("Not verified");
                                }
                            } catch (Exception e){
                                 textView6.setText("Not Verified");
                            }
                        }



                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                             textView6.setText("Not Verified");
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
}
