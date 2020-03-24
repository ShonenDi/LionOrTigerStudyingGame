package com.shonen.ukr.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum Player {
        ONE, TWO, NO
    }

    Player currentPlayer = Player.ONE;
    Player[] playersChoices = new Player[9];
    int[][] winnersRowNColumn = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private boolean gameOver = false;
    private Button btnReset;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int length = playersChoices.length;
        for (int i = 0; i <length ; i++) {
            playersChoices[i]=Player.NO;
        }

        btnReset = findViewById(R.id.btnReset);
        gridLayout = findViewById(R.id.gridLayout);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }

    public void getAnimationOnImgView(View imgView) {
        ImageView img = (ImageView) imgView;
        int index = Integer.parseInt(img.getTag().toString());
        if (playersChoices[index] == Player.NO && gameOver == false) {
            playersChoices[index] = currentPlayer;
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
            img.animate().translationYBy(2000f).alpha(1).rotation(3600).setDuration(2000);
            Toast.makeText(this, img.getTag().toString(), Toast.LENGTH_SHORT).show();

            for (int[] winColumn : winnersRowNColumn) {
                if (playersChoices[winColumn[0]] == playersChoices[winColumn[1]] &&
                        playersChoices[winColumn[1]] == playersChoices[winColumn[2]] && playersChoices[winColumn[0]] != Player.NO) {
                    gameOver = true;
                    btnReset.setVisibility(View.VISIBLE);
                    String winner = "";
                    if (currentPlayer == Player.ONE) {
                        winner = "Player two ";
                    } else if (currentPlayer == Player.TWO) {
                        winner = "Player one ";
                    }
                    Toast.makeText(this, winner + "Win the game", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    // Reset game functions
    private void resetGame() {
        int childCount = gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
          ImageView image = (ImageView) gridLayout.getChildAt(i);
          image.setImageDrawable(null);
          image.setAlpha(0.2f);
            }
        int length = playersChoices.length;
        for (int i = 0; i <length ; i++) {
            playersChoices[i]=Player.NO;
        }
        currentPlayer = Player.ONE;
        gameOver = false;
        }


}