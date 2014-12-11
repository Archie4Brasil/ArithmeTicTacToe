package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9;  //Grid Buttons
    Button ansButton1, ansButton2, ansButton3;
    private int number1;                //First Operand
    private int number2;                //Second Operand
    private ArrayList<Integer> answers; //ArrayList contains 3 answer options including the correct answer
    private TextView msgText;           //Textview to display the question or any message

    private int correctAnswer;          //correct answer after calclulation
    private int correctAnswers = 0;     // No of correct answers
    private int incorrectAnswers = 0; // No of incorrect answers
    private String operator;            //operator variable
    String buttonDefaultColor = "cyan";      // initial button color
    String buttonClickColor = "green";
    String buttonCorrectAnsColor = "blue";
    String buttonIncorrectAnsColor = "red";
    String questionString = null;
    boolean newGridButtonSelected = false;
    private TextView questionText;
    int selectedButtonIndex = -1;
    boolean correctAnsSelected = false;
    private ArithMagic generate;               //calling class of problem generator
    int correctAnswerPosition = 0;
    int[] winnerGrid = new int[9];
    String[] buttonState = new String[9];
    Button resetButton;
    Button endGameButton;
    int noOfClicks =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generate = new ArithMagic();
        answers = new ArrayList<Integer>();
     //  resetEndGameButton();
        for (int i = 0; i < 9; i++) {
            buttonState[i] = buttonDefaultColor;
        }
        for(int i=0;i<winnerGrid.length; i++){
            winnerGrid[i] =0;
        }

        if (savedInstanceState == null) {
            randomize();
        }
        drawButtonImages();

        endGameButton = (Button)findViewById(R.id.endGameButton);

        endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View paramView) {
                MainActivity.this.finish();
            }
        });
        resetButton = (Button) findViewById(R.id.reSetButton);

        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View paramView) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetButton.setEnabled(false);
        endGameButton.setEnabled(false);
    }
/* this method is to determine whether user clicks a right or wrong answer when the answer buttons
are clicked. Calls a method to change the background color of the grid buttons depending on the user
clicks on correct or incorrect answer*/

    public void ansClick(View bClick) {
        newGridButtonSelected = false;
        switch (bClick.getId()) {
            case R.id.answers1: {
                if (ansButton1.getText().equals("" + correctAnswer)) {
                    correctAnswers++;
                    correctAnsSelected = true;
                    // ansButton1.setBackgroundColor(Color.GREEN);

                } else {
                    incorrectAnswers++;
                    correctAnsSelected = false;
                    //ansButton1.setBackgroundColor(Color.RED);
                }
                break;
            }
            case R.id.answers2: {
                if (ansButton2.getText().equals("" + correctAnswer)) {
                    correctAnswers++;
                    correctAnsSelected = true;
                } else {
                    incorrectAnswers++;
                    correctAnsSelected = false;
                }
                break;
            }
            case R.id.answers3: {
                if (ansButton3.getText().equals("" + correctAnswer)) {
                    correctAnswers++;
                    correctAnsSelected = true;
                } else {
                    incorrectAnswers++;
                    correctAnsSelected = false;
                }
                break;
            }
        }
        setGridButtonColorAnsOnClick();
        generate.generateNumbers();
        randomize();

    }

    public void selectWinner() {
        if (winnerGrid[0] + winnerGrid[1] + winnerGrid[2] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
        if (winnerGrid[3] + winnerGrid[4] + winnerGrid[5] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
        if (winnerGrid[6] + winnerGrid[7] + winnerGrid[8] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
        if (winnerGrid[1] + winnerGrid[4] + winnerGrid[7] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
        if (winnerGrid[2] + winnerGrid[5] + winnerGrid[8] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        } else{
        if (winnerGrid[0] + winnerGrid[3] + winnerGrid[6] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
        if (winnerGrid[2] + winnerGrid[4] + winnerGrid[6] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
         if (winnerGrid[0] + winnerGrid[4] + winnerGrid[8] == 3) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            selectWinnerWidgetState();
        }else{
            if(noOfClicks==9){
                Toast.makeText(getApplicationContext(), "try again or end the game", Toast.LENGTH_LONG).show();
                selectWinnerWidgetState();
            }
        }
        }
        }}}}}}
    }

    private void selectWinnerWidgetState() {
        setAllButtonDisable();
        resetButton.setEnabled(true);
        endGameButton.setEnabled(true);
        questionText.setVisibility(View.GONE);
    }

    public void setAllButtonDisable()
    {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }


    /*this is to describe the action when user clicks on gird buttons*/
    public void gridClick(View v) {
        if (newGridButtonSelected) return;
        ImageButton bClick = (ImageButton) v;
        bClick.setActivated(true);
        questionText.setText(generate.getProblem());
        selectedButtonIndex = -1;
        switch (bClick.getId()) {
            case R.id.grid1x1: {
                selectedButtonIndex = 0;
                break;
            }
            case R.id.grid1x2: {
                selectedButtonIndex = 1;
                break;
            }
            case R.id.grid1x3: {
                selectedButtonIndex = 2;
                break;
            }
            case R.id.grid2x1: {
                selectedButtonIndex = 3;
                break;
            }
            case R.id.grid2x2: {
                selectedButtonIndex = 4;
                break;
            }
            case R.id.grid2x3: {
                selectedButtonIndex = 5;
                break;
            }
            case R.id.grid3x1: {
                selectedButtonIndex = 6;
                break;
            }
            case R.id.grid3x2: {
                selectedButtonIndex = 7;
                break;
            }
            case R.id.grid3x3: {
                selectedButtonIndex = 8;
                break;
            }
        }
        newGridButtonSelected = buttonState[selectedButtonIndex].equals(buttonDefaultColor);
        if (newGridButtonSelected) {
            buttonState[selectedButtonIndex] = buttonClickColor;
//            setAnswerButtonsVisible();
        }
        drawButtonImages();
    }

    /*This method to set the color of grid button  just after clicking on answer buttons this sets color of the grid button
     * depending on the user clicks on correct answer or wrong answer */
    public void setGridButtonColorAnsOnClick() {
        if (correctAnsSelected) {
            buttonState[selectedButtonIndex] = buttonCorrectAnsColor;
            winnerGrid[selectedButtonIndex] = 1;
            noOfClicks++;
        } else {
            buttonState[selectedButtonIndex] = buttonIncorrectAnsColor;
           noOfClicks++;

        }
        selectWinner();
        drawButtonImages();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        number1 = savedInstanceState.getInt("number1");
        number2 = savedInstanceState.getInt("number2");
        correctAnswer = savedInstanceState.getInt("correctAnswer");
        correctAnswers = savedInstanceState.getInt("correctAnswers");
        incorrectAnswers = savedInstanceState.getInt("incorrectAnswers");
        answers = savedInstanceState.getIntegerArrayList("answers");
        operator = savedInstanceState.getString("operator");
        buttonDefaultColor = savedInstanceState.getString("buttonInitColor");
        buttonClickColor = savedInstanceState.getString("buttonClickColor");
        buttonCorrectAnsColor = savedInstanceState.getString("buttonCorrectAnsColor");
        buttonIncorrectAnsColor = savedInstanceState.getString("buttonIncorrectAnsColor");
        questionString = savedInstanceState.getString("questionString");
        selectedButtonIndex = savedInstanceState.getInt("selectedButtonIndex");
        correctAnsSelected = savedInstanceState.getBoolean("correctAnsSelected");
        newGridButtonSelected = savedInstanceState.getBoolean("newGridButtonSelected");
        buttonState = savedInstanceState.getStringArray("buttonState");
        drawButtonImages();
        super.onRestoreInstanceState(savedInstanceState);
    }

    void drawButtonImages() {
        b1 = (ImageButton) findViewById(R.id.grid1x1);
        b2 = (ImageButton) findViewById(R.id.grid1x2);
        b3 = (ImageButton) findViewById(R.id.grid1x3);
        b4 = (ImageButton) findViewById(R.id.grid2x1);
        b5 = (ImageButton) findViewById(R.id.grid2x2);
        b6 = (ImageButton) findViewById(R.id.grid2x3);
        b7 = (ImageButton) findViewById(R.id.grid3x1);
        b8 = (ImageButton) findViewById(R.id.grid3x2);
        b9 = (ImageButton) findViewById(R.id.grid3x3);
        questionText = (TextView) findViewById(R.id.textView);
        ansButton1 = (Button) findViewById(R.id.answers1);
        ansButton2 = (Button) findViewById(R.id.answers2);
        ansButton3 = (Button) findViewById(R.id.answers3);
//        Toast.makeText(getApplicationContext(), "" + b1, Toast.LENGTH_LONG).show();
        if (buttonState[0].equals(buttonClickColor)) b1.setImageResource(R.drawable.green);
        else if (buttonState[0].equals(buttonDefaultColor)) b1.setImageResource(R.drawable.white);
        else if (buttonState[0].equals(buttonCorrectAnsColor)) blueButton(b1);
        else if (buttonState[0].equals(buttonIncorrectAnsColor)) redButton(b1);
        if (buttonState[1].equals(buttonClickColor)) b2.setImageResource(R.drawable.green);
        else if (buttonState[1].equals(buttonDefaultColor)) b2.setImageResource(R.drawable.white);
        else if (buttonState[1].equals(buttonCorrectAnsColor)) blueButton(b2);
        else if (buttonState[1].equals(buttonIncorrectAnsColor)) redButton(b2);
        if (buttonState[2].equals(buttonClickColor)) b3.setImageResource(R.drawable.green);
        else if (buttonState[2].equals(buttonDefaultColor)) b3.setImageResource(R.drawable.white);
        else if (buttonState[2].equals(buttonCorrectAnsColor)) blueButton(b3);
        else if (buttonState[2].equals(buttonIncorrectAnsColor)) redButton(b3);
        if (buttonState[3].equals(buttonClickColor)) b4.setImageResource(R.drawable.green);
        else if (buttonState[3].equals(buttonDefaultColor)) b4.setImageResource(R.drawable.white);
        else if (buttonState[3].equals(buttonCorrectAnsColor)) blueButton(b4);
        else if (buttonState[3].equals(buttonIncorrectAnsColor)) redButton(b4);
        if (buttonState[4].equals(buttonClickColor)) b5.setImageResource(R.drawable.green);
        else if (buttonState[4].equals(buttonDefaultColor)) b5.setImageResource(R.drawable.white);
        else if (buttonState[4].equals(buttonCorrectAnsColor)) blueButton(b5);
        else if (buttonState[4].equals(buttonIncorrectAnsColor)) redButton(b5);
        if (buttonState[5].equals(buttonClickColor)) b6.setImageResource(R.drawable.green);
        else if (buttonState[5].equals(buttonDefaultColor)) b6.setImageResource(R.drawable.white);
        else if (buttonState[5].equals(buttonCorrectAnsColor)) blueButton(b6);
        else if (buttonState[5].equals(buttonIncorrectAnsColor)) redButton(b6);
        if (buttonState[6].equals(buttonClickColor)) b7.setImageResource(R.drawable.green);
        else if (buttonState[6].equals(buttonDefaultColor)) b7.setImageResource(R.drawable.white);
        else if (buttonState[6].equals(buttonCorrectAnsColor)) blueButton(b7);
        else if (buttonState[6].equals(buttonIncorrectAnsColor)) redButton(b7);
        if (buttonState[7].equals(buttonClickColor)) b8.setImageResource(R.drawable.green);
        else if (buttonState[7].equals(buttonDefaultColor)) b8.setImageResource(R.drawable.white);
        else if (buttonState[7].equals(buttonCorrectAnsColor)) blueButton(b8);
        else if (buttonState[7].equals(buttonIncorrectAnsColor)) redButton(b8);
        if (buttonState[8].equals(buttonClickColor)) b9.setImageResource(R.drawable.green);
        else if (buttonState[8].equals(buttonDefaultColor)) b9.setImageResource(R.drawable.white);
        else if (buttonState[8].equals(buttonCorrectAnsColor)) blueButton(b9);
        else if (buttonState[8].equals(buttonIncorrectAnsColor)) redButton(b9);
        if (newGridButtonSelected) {
            ansButton1.setText(Integer.toString(answers.get(0)));
            ansButton2.setText(Integer.toString(answers.get(1)));
            ansButton3.setText(Integer.toString(answers.get(2)));
            questionText.setText(questionString);
            ansButton1.setVisibility(View.VISIBLE);
            ansButton2.setVisibility(View.VISIBLE);
            ansButton3.setVisibility(View.VISIBLE);
        } else {
            questionText.setText("Pick your position");
            ansButton1.setVisibility(View.INVISIBLE);
            ansButton2.setVisibility(View.INVISIBLE);
            ansButton3.setVisibility(View.INVISIBLE);
        }

    }

    void blueButton(ImageButton b) {
        b.setImageResource(R.drawable.blue_x);
        b.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
    }

    void redButton(ImageButton b) {
        b.setImageResource(R.drawable.red_o);
        b.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("number1", number1);
        outState.putInt("number2", number2);
        outState.putInt("correctAnswer", correctAnswer);
        outState.putInt("correctAnswers", correctAnswers);
        outState.putInt("incorrectAnswers", incorrectAnswers);
        outState.putIntegerArrayList("answers", answers);
        outState.putString("operator", operator);
        outState.putString("buttonInitColor", buttonDefaultColor);
        outState.putString("buttonClickColor", buttonClickColor);
        outState.putString("buttonCorrectAnsColor", buttonCorrectAnsColor);
        outState.putString("buttonIncorrectAnsColor", buttonIncorrectAnsColor);
        outState.putStringArray("buttonState", buttonState);
        outState.putBoolean("newGridButtonSelected", newGridButtonSelected);
        outState.putString("questionString", questionString);
        outState.putInt("selectedButtonIndex", selectedButtonIndex);
    }

    public void randomize() {
        questionString = generate.getProblem();
        answers.clear();
        switch ((int) (Math.random() * 3) + 1) {
            case 1: { // first possible order
                answers.add(Integer.parseInt(generate.getFirstRandom()));
                answers.add(Integer.parseInt(generate.getSecondRandom()));
                correctAnswer = Integer.parseInt(generate.getRightAnswer());
                answers.add(correctAnswer);
                break;
            }
            case 2: {
                answers.add(Integer.parseInt(generate.getFirstRandom()));
                correctAnswer = Integer.parseInt(generate.getRightAnswer());
                answers.add(correctAnswer);
                answers.add(Integer.parseInt(generate.getSecondRandom()));
                break;
            }
            case 3: {
                correctAnswer = Integer.parseInt(generate.getRightAnswer());
                answers.add(correctAnswer);
                answers.add(Integer.parseInt(generate.getFirstRandom()));
                answers.add(Integer.parseInt(generate.getSecondRandom()));
                break;
            }
        }

    }



}
