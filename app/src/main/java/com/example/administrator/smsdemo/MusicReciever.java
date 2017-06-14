package com.example.administrator.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MusicReciever extends BroadcastReceiver {

    Music music ;

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        if (bundle != null) {
            Object[] smsObject = (Object[]) bundle.get("pdus");
            for (Object obj : smsObject) {
                msg = SmsMessage.createFromPdu((byte[]) obj);
                Log.d("ssssssss", msg.getOriginatingAddress().toString());
                if (msg.getOriginatingAddress().equals("17768373003")) {

                    music.sendMsg("1");
                }
            }
        }


    }


    public void setListener(Music music){
        this.music = music;
    }

}

