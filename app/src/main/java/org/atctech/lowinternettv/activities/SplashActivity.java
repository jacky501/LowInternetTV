package org.atctech.lowinternettv.activities;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import org.atctech.lowinternettv.R;
import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity implements  MediaPlayer.OnPreparedListener,
        SurfaceHolder.Callback{

    String URL;
    ProgressDialog progressDialog;
    private MediaPlayer _mediaPlayer;
    private SurfaceHolder _surfaceHolder;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
        setContentView(R.layout.activity_splash);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Buffering....");
        progressDialog.show();
        URL = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov";

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;

        SurfaceView surfaceView = findViewById(R.id.videoPlayer);
        TextView startTime = findViewById(R.id.startText);
        TextView endTime = findViewById(R.id.endTime);
        SeekBar videoProgressBar = findViewById(R.id.progressBar);

        _surfaceHolder = surfaceView.getHolder();
        _surfaceHolder.addCallback(this);
        _surfaceHolder.setFixedSize(1280, 800);

    }



    @Override
    public void onPrepared(MediaPlayer mp) {
        progressDialog.dismiss();
        _mediaPlayer.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        _mediaPlayer = new MediaPlayer();
        _mediaPlayer.setDisplay(_surfaceHolder);
        Uri source = Uri.parse(URL);

        try {
            // Specify the IP camera's URL and auth headers.
            _mediaPlayer.setDataSource(String.valueOf(source));

            // Begin the process of setting up a video stream.
            _mediaPlayer.setOnPreparedListener(this);
            _mediaPlayer.prepareAsync();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        progressDialog.show();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        _mediaPlayer.release();
    }


}
