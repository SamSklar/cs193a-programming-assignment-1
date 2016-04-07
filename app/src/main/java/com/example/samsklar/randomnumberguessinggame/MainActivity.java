/*
This is a number guessing game. The computer generates a
number between one and one thousand, and the user can type
in a guess and click the check guess button to see if they were
right.  If not, the app will tell the user if they were too
high or too low. By Sam Sklar

 */

package com.example.samsklar.randomnumberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playGame();
    }

    public void playGame(){
        Random random = new Random();
        secretNumber = random.nextInt(1000);
        android.widget.Button high = (android.widget.Button)findViewById(R.id.highButton);
        android.widget.Button low = (android.widget.Button)findViewById(R.id.lowButton);
        TextView Title = (TextView)findViewById(R.id.title);
        Title.setText("Welcome to the Number Guessing Game");
        high.setVisibility(View.INVISIBLE);
        low.setVisibility(View.INVISIBLE);

    }

    public void playAgain(){
        playGame();
    }

    public void checkGuess(View view) {
        EditText mEdit = (EditText)findViewById(R.id.currGuess);
        android.widget.Button high = (android.widget.Button)findViewById(R.id.highButton);
        android.widget.Button low = (android.widget.Button)findViewById(R.id.lowButton);
        int Guess = Integer.parseInt(mEdit.getText().toString());
        if(secretNumber == Guess){

            TextView Title = (TextView)findViewById(R.id.title);
            Title.setText("You Win! The number was " + secretNumber);
            android.widget.Button playAgain = (android.widget.Button)findViewById(R.id.playAgainButton);
            playAgain.setVisibility(View.VISIBLE);

        }else if(secretNumber < Guess){

            if(low.getVisibility() == View.VISIBLE){
                low.setVisibility(View.INVISIBLE);
            }

            high.setVisibility(View.VISIBLE);

        }else{

            if(high.getVisibility() == View.VISIBLE){
                high.setVisibility(View.INVISIBLE);
            }

            low.setVisibility(View.VISIBLE);

        }
    }
}
