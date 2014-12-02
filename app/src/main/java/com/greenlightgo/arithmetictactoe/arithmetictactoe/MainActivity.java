package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button a1,a2,a3,g1x1,g1x2,g1x3,
            g2x1,g2x2,g2x3,
            g3x1,g3x2,g3x3;
    TextView rN1,rN2,sign;
    String math;
    private static int correctGuesses = 0, totalGuesses = 0, firstNumber, secondNumber,
            randomOne, randomTwo, answer, range, min;
    private String operand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // random generator of numbers of arithmetic problems
    public void artihMagic() {

        // setting random first and second number
        firstNumber = (int) (Math.random() * 10) + 1;
        secondNumber = (int) (Math.random() * 10) + 1;

        // random cases for different problems from addition to division
        int i = (int)   (Math.random() *4);
        switch (i) {
            case 0:
                operand = "+";
                answer = firstNumber + secondNumber;
                min = 2;
                range = (20 - min) + 1;
                break;
            case 1:
                operand = "-";
                answer = firstNumber - secondNumber;
                min = -9;
                range = (9 - min) + 1;
                break;
            case 2:
                operand = "*";
                answer = firstNumber * secondNumber;
                min = 1;
                range = (100 - min) + 1;
                break;
            case 3:
                operand = "/";
                answer = firstNumber / secondNumber;
                min = 0;
                range = (10 - min) + 1;
                break;
        }

        // generation and check of possible random answers within range of operation
        randomOne = (int) ((Math.random() * range) + min);
        randomTwo = (int) ((Math.random() * range) + min);
        while (randomOne == randomTwo || randomOne == (answer)) {
            randomOne = (int) ((Math.random() * range) + min);
        }

        while (randomOne == randomTwo || randomTwo == (answer)) {
            randomTwo = (int) (Math.random() * range) + min;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
