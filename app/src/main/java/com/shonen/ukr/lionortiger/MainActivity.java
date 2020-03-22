package com.shonen.ukr.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        enum Player {
           ONE, TWO;
        }
        Player currentPlayer = Player.ONE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getAnimationOnImgView(View imgView) {
        ImageView img = (ImageView) imgView;
        img.setTranslationY(-2000);
        img.setImageResource(R.drawable.tiger);
        img.animate().translationYBy(2000f).rotation(3600).setDuration(3000);
    }

}