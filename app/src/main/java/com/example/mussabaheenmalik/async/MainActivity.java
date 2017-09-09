package com.example.mussabaheenmalik.async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyProgressTask pg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dosomething(View view) {
        pg1 = new MyProgressTask(this);
        pg1.execute();

    }
}
