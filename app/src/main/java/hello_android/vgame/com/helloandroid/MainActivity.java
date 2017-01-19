package hello_android.vgame.com.helloandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.view.View;
import android.widget.VideoView;

import com.example.MyMath;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(customMethodJNI() + " Math " + MyMath.add(1,2));

        //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_360_240_5mb);
        final VideoView videoView = (VideoView)
                findViewById(R.id.videoView);

        //videoView.setVideoPath("http://192.168.142.48:8080/sample.mp4");
        //videoView.setVideoPath("http://192.168.142.48:8080/sample_5.mp4");
        //videoView.setVideoPath("rtsp://192.168.142.48:1935/vod/sample.mp4");
        //videoView.setVideoPath("rtsp://cdn01-mstream.w88livestream.com/etable1m/live_1");
        videoView.setVideoPath("rtsp://cdn01-mstream.w88livestream.com/etable4m/live_1");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new
                                                MediaPlayer.OnPreparedListener()  {
                                                    @Override
                                                    public void onPrepared(MediaPlayer mp) {
                                                        Log.w("", "Duration = " + videoView.getDuration());
                                                    }
                                                });
        videoView.start();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String customMethodJNI();
    public native String stringFromJNI();

    public void onNext(View view) {
        Intent intent = new Intent(this, GameScene.class);
        //intent.putExtra("HELLO_MESSAGE", "hi this is a message from MainActivity");
        startActivity(intent);
    }

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
