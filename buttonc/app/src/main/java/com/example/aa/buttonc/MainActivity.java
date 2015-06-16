package com.example.aa.buttonc;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button down = (Button)findViewById(R.id.down);
        down.setOnClickListener(this);
        Button left = (Button)findViewById(R.id.left);
        left.setOnClickListener(this);
        Button right = (Button)findViewById(R.id.right);
        right.setOnClickListener(this);
        Button up = (Button)findViewById(R.id.up);
        up.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onClick(View v){
        Log.d("MyApp:", "num=" + v.getId());
        //押したボタンがvになっています．この箇所を変更してください．

    }

}
