package com.thuduyen07.diceroller;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public int getRandomDiceImage() {
        Random ran = new Random();
        int randomInt = ran.nextInt((6 - 1) + 1) + 1;                // ran.nextInt((max-min)+1)+min
        int drawableResource = 0;
        if (randomInt == 1) {
            drawableResource = R.drawable.dice_1;
        } else if (randomInt == 2) {
            drawableResource = R.drawable.dice_2;
        } else if (randomInt == 3) {
            drawableResource = R.drawable.dice_3;
        } else if (randomInt == 4) {
            drawableResource = R.drawable.dice_4;
        } else if (randomInt == 5) {
            drawableResource = R.drawable.dice_5;
        } else
            drawableResource = R.drawable.dice_6;

        return drawableResource;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ImageView[] diceImage = new ImageView[1];
        final ImageView[] diceImage2 = new ImageView[1];
        Button clearButton;
        Button rollButton;
        Button rollButton2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage[0] = findViewById(R.id.dice_image);
        diceImage2[0] = findViewById(R.id.dice_image2);

        clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clear Button clicked!", Toast.LENGTH_SHORT).show();
                diceImage[0].setImageResource(R.drawable.empty_dice);
                diceImage2[0].setImageResource(R.drawable.empty_dice);


            }
        });


        rollButton = findViewById(R.id.roll_button);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Roll Button clicked!", Toast.LENGTH_SHORT).show();   //MainActivity.this

                //TextView resultText = findViewById(R.id.result_text);
                //resultText.setText("Dice Rolled!");

                diceImage[0].setImageResource(getRandomDiceImage());

            }

        });

        rollButton2 = findViewById(R.id.roll_button2);
        rollButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Roll Button 2 clicked!", Toast.LENGTH_SHORT).show();

                diceImage2[0].setImageResource(getRandomDiceImage());
            }
        });


    }
}