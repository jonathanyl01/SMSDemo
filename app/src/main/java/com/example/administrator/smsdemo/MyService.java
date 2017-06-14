package com.example.administrator.smsdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer player;

    @Override
    public void onCreate() {
        player = MediaPlayer.create(getApplicationContext(),R.raw.music);
        player.setLooping(true);
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        player.start();
        super.onStart(intent, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        player.start();
        return null;
    }
}
