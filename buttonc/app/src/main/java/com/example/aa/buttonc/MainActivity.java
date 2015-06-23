package com.example.aa.buttonc;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Set;


public class MainActivity extends Activity implements View.OnClickListener {
    private static final int REQUEST_ENABLE_BLUETOOTH =10 ;
    private SensorManager Smanager;
    private TextView text;
    //BluetoothAdapter取得


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

        TextView text = (TextView)findViewById(R.id.temperature);


        Smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //List<Sensor> sensors = Smanager.getSensorList(Sensor.TYPE_LIGHT);



        BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
        if(Bt!=null){
            //Bluetooth対応端末の場合の処理
            Log.d("Bluetoothがサポートされてます。","a"+Bt);
        }else{
            //Bluetooth非対応端末の場合の処理
            Log.d("Bluetoothがサポートされていません。","a"+Bt);

        }
        boolean btEnable = Bt.isEnabled();
        if(btEnable == true){
            //BluetoothがONだった場合の処理
        }else{
            //OFFだった場合、ONにすることを促すダイアログを表示する画面に遷移
            Intent btOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(btOn, REQUEST_ENABLE_BLUETOOTH);
        }

    }

    public void onSensorChanged(SensorEvent event) {
        int light_value = (int)(event.values[0]);
        text.setText("明るすぎて眼が痛いにゃ。"+light_value);
    }


    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
        if(requestCode == REQUEST_ENABLE_BLUETOOTH){
            if(ResultCode == Activity.RESULT_OK){
                //BluetoothがONにされた場合の処理
                Log.d("BluetoothをONにしてもらえました。","a"+1);
            }else{
                Log.d("BluetoothがONにしてもらえませんでした。","a"+2);
                finish();
            }
        }
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
