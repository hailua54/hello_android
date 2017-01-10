package hello_android.vgame.com.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(customMethodJNI());
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
