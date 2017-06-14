package com.example.administrator.smsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Music{

    String msg="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicReciever mussicReciever = new MusicReciever();
        mussicReciever.setListener(this);
        if (msg.equals("1")){
            startSerrvice();
        }

    }

    private void startSerrvice() {
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }

    @Override
    public void sendMsg(String key) {
        Log.d("222","1111111"+key);
        this.msg = key;
    }
}
