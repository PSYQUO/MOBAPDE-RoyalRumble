package mobapde.royalrumble.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import mobapde.royalrumble.R;

public class BackgroundSoundService extends Service
{
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.bgmusic);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    protected void onNewIntent()
    {
        player.pause();
    }
}