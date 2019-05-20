package com.example.keerthana.expiration;

import android.content.Intent;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;

public class categories extends AppCompatActivity{
   /* private CardView F_v,soft_drinks,documents,med,cos,c_d;
    private ImageButton f;*/
    GridLayout grid;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //
        /*F_v=(CardView)findViewById(R.id.fruits);
        soft_drinks=(CardView)findViewById(R.id.drinks);
        documents=(CardView)findViewById(R.id.doc);
        med=(CardView)findViewById(R.id.medicines);
        cos=(CardView)findViewById(R.id.cosmetic);
        c_d=(CardView)findViewById(R.id.cards);*/
        grid=(GridLayout)findViewById(R.id.maingrid);
        setSingleEvent(grid);
    }

    private void setSingleEvent(GridLayout grid)
    {
        for (int i=0;i<grid.getChildCount();i++)
        {
            CardView cardView=(CardView)grid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(categories.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    /*public void openMain(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }*/
   /* @Override
            public void onClick(View v) {
            Intent i;

            switch (v.getId())
            {
                case R.id.fruits:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.drinks:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.doc:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.medicines:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.cosmetic:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.cards:
                    i=new Intent(this,MainActivity.class);
                    startActivity(i);
                    break;
        }
    }*/
}
