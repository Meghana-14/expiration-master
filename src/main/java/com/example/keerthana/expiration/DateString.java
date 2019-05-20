package com.example.keerthana.expiration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.keerthana.expiration.OcrCaptureActivity;
import com.example.keerthana.expiration.MainActivity;
import org.w3c.dom.Text;

public class DateString extends AppCompatActivity {

    private TextView ds;
    private Button bcancel;
    private Button bconfirm;
    private String dstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_string);

        ds=findViewById(R.id.text_date);
        ds.setText(OcrCaptureActivity.dstring);
        dstring=OcrCaptureActivity.dstring;

        bcancel=findViewById(R.id.bcancel);
        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DateString.this,OcrCaptureActivity.class);
                startActivity(i);
            }
        });

        bconfirm=findViewById(R.id.bconfirm);
        bconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.d=2;
                MainActivity.m=2;
                MainActivity.y=3;
                Intent i=new Intent(DateString.this,MainActivity.class);
                startActivity(i);

            }
        });


    }
}
