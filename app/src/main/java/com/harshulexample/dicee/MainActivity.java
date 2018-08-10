package com.harshulexample.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int number,num1;
    private Button rollButton;
    private ImageView leftDice, rightDice;
    final int[] DiceArray = {R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton =  findViewById(R.id.button_roll);

        leftDice =  findViewById(R.id.dice_left);
        rightDice = findViewById(R.id.dice_right);

        if (savedInstanceState != null){
            number=savedInstanceState.getInt("numIndex");
            num1=savedInstanceState.getInt("num1Index");
            leftDice.setImageResource(DiceArray[number]);
            rightDice.setImageResource(DiceArray[num1]);


        }


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dicee", "The button has been pressed ");

                Random randonNumberGenerator = new Random();
                Random ranNumGen = new Random();
                 number = randonNumberGenerator.nextInt(6);
                 num1 = ranNumGen.nextInt(6);
                Log.d("Dicee", "The random generated number one is" + number);
                Log.d("Dicee", "The random generated number two is" + num1);

                leftDice.setImageResource(DiceArray[number]);
                rightDice.setImageResource(DiceArray[num1]);


            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("numIndex",number);
        outState.putInt("num1Index",num1);

    }
}
