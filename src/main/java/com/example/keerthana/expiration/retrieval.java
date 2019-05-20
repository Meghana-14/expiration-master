package com.example.keerthana.expiration;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;


public class retrieval extends AppCompatActivity {

    private ListView listView;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private Button maddBtn,bocr;
    public static String name;

    List<product>productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieval);

        mAuth= FirebaseAuth.getInstance();

        listView=findViewById(R.id.list);
        productList=new ArrayList<>();
        maddBtn=findViewById(R.id.addBtn);
        bocr = (Button) findViewById(R.id.scanbtn);
    }

    @Override
    protected void onStart() {
        super.onStart();

        currentUser=mAuth.getCurrentUser();

        if(currentUser==null)
        {
            Intent authIntent =new Intent(retrieval.this,Login.class);
            startActivity(authIntent);
            finish();
        }
        else
            {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                name = currentUser.getPhoneNumber();
                DatabaseReference myRef = database.getReference(name);
                myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot productSnapshot: dataSnapshot.getChildren()){
                        product p=productSnapshot.getValue(product.class);
                        productList.add(p);
                    }
                    productInfoAdapter InfoAdapter=new productInfoAdapter(retrieval.this,productList);
                    listView.setAdapter(InfoAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            }

            );
               maddBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(retrieval.this,categories.class);
                        startActivity(i);
                    }
                });

                bocr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(retrieval.this,com.example.keerthana.expiration.OcrCaptureActivity.class);
                        startActivity(i);
                    }
                });

            }

    }
}