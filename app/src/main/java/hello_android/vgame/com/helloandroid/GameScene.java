package hello_android.vgame.com.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.MyMath;

public class GameScene extends AppCompatActivity {
    GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize gameView and set it as the view
        setContentView(R.layout.activity_game_scene);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_game_scene);
        gameView = new GameView(this);
        layout.addView(gameView);
        Log.w("test", "MyMath  " + MyMath.add(1,2));
    }

    // More SimpleGameEngine methods will go here

    // This method executes when the player starts the game
    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        gameView.resume();
    }

    // This method executes when the player quits the game
    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        gameView.pause();
    }

    public void onBack(View view)
    {
        this.finish();
    }

}
