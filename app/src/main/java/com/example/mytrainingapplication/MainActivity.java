package com.example.mytrainingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView txt;
private EditText canal;
private SensorManager sensorManage ;
private Sensor pressureSensor;
private SensorEventListener sensorEvent = new SensorEventListener() {
    @Override
    public void onSensorChanged(SensorEvent event) {
        double [] values = sensorEvent.values;
        canal.setText(String.format(",.3f", (Object) values [0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.text);
        canal = findViewById(R.id.channel);
        sensorManage = (SensorManager) getSystemService(SENSOR_SERVICE);
        pressureSensor= sensorManage.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManage.registerListener(sensorEvent , pressureSensor ,SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        super.onPause();
sensorManage.unregisterListener(sensorEvent);
    }
}
