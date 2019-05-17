package com.example.playyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout start, explanation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        start = (LinearLayout) findViewById(R.id.start);
        explanation = (LinearLayout) findViewById(R.id.explanation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
                break;
            case R.id.explanation:
                Intent intent2 = new Intent(MainActivity.this, ExplanationActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
