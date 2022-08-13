package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = findViewById(R.id.name);
        TextView age = findViewById(R.id.age);
        Button back = findViewById(R.id.back);

        Bundle bundle = getIntent().getExtras();
        String nm = bundle.getString("name");
        int ag = bundle.getInt("age");

        name.setText(nm);
        age.setText(String.valueOf(ag));



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });





    }
}