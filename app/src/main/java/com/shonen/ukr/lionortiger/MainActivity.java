package com.shonen.ukr.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum Player {
        ONE, TWO
    }

    Player currentPlayer = Player.ONE;
    Player[] playersChoices = new Player[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getAnimationOnImgView(View imgView) {
        ImageView img = (ImageView) imgView;
        img.setTranslationY(-2000);
        Toast playerOneTurn = Toast.makeText(getApplicationContext(), "Player one turn", Toast.LENGTH_SHORT);
        playerOneTurn.show();
        if (currentPlayer == Player.ONE) {
            img.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if (currentPlayer == Player.TWO) {
            img.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }
        img.animate().translationYBy(2000f).alpha(1).rotation(3600).setDuration(3000);
        Toast.makeText(this, img.getTag().toString(), Toast.LENGTH_SHORT).show();

    }
}