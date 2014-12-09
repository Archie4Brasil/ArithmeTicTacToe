package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
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
    int[] buttonColor = new int[9];
    String[] buttonState = new String[9];
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generate = new ArithMagic();
        answers = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            buttonState[i] = buttonDefaultColor;
        }

        if (savedInstanceState == null) {
            randomize();
        }
        drawButtonImages();


   /*     ansButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansButton1 = (Button)view;
                ansClick();

        ansButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansButton1 = (Button)view;
                if (ansButton2.getText().equals(generate.getRightAnswer())){
                    correctAnswers++;
                    correctAnsSelected=true;
                }else
                {
                    incorrectAnswers++;
                    correctAnsSelected =false;
                }
            }
        });
        ansButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansButton3 = (Button)view;
                if (ansButton3.getText().equals(generate.getRightAnswer())){
                    correctAnswers++;
                    correctAnsSelected=true;
                }
                else
                {
                    incorrectAnswers++;
                    correctAnsSelected =false;
                }
            }

        });*/
    }

    /*public void ansClick(View v) {
        Button b=(Button)v;

        switch (b.getId()) {
            case R.id.answers1: {
                if (a.getText().equals(generate.getRightAnswer())){
                    correctAnswers++;
                    correctAnsSelected=true;
                }
                else
                {
                    incorrectAnswers++;
                    correctAnsSelected =false;
                }
                break;
            }
        if (b.getText().equals(generate.getRightAnswer())){
            correctAnswers++;
            correctAnsSelected=true;
        }else
        {
            incorrectAnswers++;
            correctAnsSelected =false;
        }
    }*/



/* this method is to determine whether user clicks a right or wrong answer when the answer buttons
are clicked. Calls a method to change the background color of the grid buttons depending on the user
clicks on correct or incorrect answer*/


    public void ansClick(View bClick) {
        newGridButtonSelected = false;
//        Toast.makeText(getApplicationContext(), "" + correctAnswer + " " + ansButton1.getText() + " " + ansButton2.getText() + " " + ansButton3.getText(), Toast.LENGTH_LONG).show();
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

//        questionText.setText("Pick another position");

        setGridButtonColorAnsOnClick();
        generate.generateNumbers();
        randomize();

    }

    public boolean selectWinner() {
        if ((buttonColor[0] + buttonColor[1] + buttonColor[2] == 3) || (buttonColor[3] + buttonColor[4] + buttonColor[5] == 3) || (buttonColor[6] + buttonColor[7] + buttonColor[8] == 3)) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            return true;
        }
        if ((buttonColor[0] + buttonColor[3] + buttonColor[6] == 3) || (buttonColor[1] + buttonColor[4] + buttonColor[7] == 3) || (buttonColor[2] + buttonColor[5] + buttonColor[8] == 3)) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            return true;
        }
        if ((buttonColor[0] + buttonColor[4] + buttonColor[8] == 3) || (buttonColor[2] + buttonColor[4] + buttonColor[6] == 3))

        {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            return true;
        }
        if ((buttonColor[2] + buttonColor[4] + buttonColor[6] == 3) || (buttonColor[2] + buttonColor[4] + buttonColor[6] == 3)) {
            Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }


    /*This method is to assign  indexes from 1 to 9 for   9 grid buttons */
//    public void buttonSelection() {
//        if (selectedButtonIndex == 1) {
//            setGridButtonColor(b1);
//        } else if (selectedButtonIndex == 2) {
//            setGridButtonColor(b2);
//        } else if (selectedButtonIndex == 3) {
//            setGridButtonColor(b3);
//        } else if (selectedButtonIndex == 4) {
//            setGridButtonColor(b4);
//        } else if (selectedButtonIndex == 5) {
//            setGridButtonColor(b5);
//        } else if (selectedButtonIndex == 6) {
//            setGridButtonColor(b6);
//        } else if (selectedButtonIndex == 7) {
//            setGridButtonColor(b7);
//        } else if (selectedButtonIndex == 8) {
//            setGridButtonColor(b8);
//        } else if (selectedButtonIndex == 9) {
//            setGridButtonColor(b9);
//        }
//    }


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



        /*ColorDrawable buttonColor = (ColorDrawable) bClick.getBackground();
        int colorId = buttonColor.getColor();
        if(colorId == Color.parseColor(buttonDefaultColor)) {
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
        }else
        {
            questionText.setText("You have already clicked the button");
        }

    }*/

    /*This is to set the grid button enabled if it is disable,  or enable if it is disabled*/
//    public void setButtonEnabledDisabled(Button b) {
//        if (b.isEnabled())
//            b.setEnabled(true);
//        else if (!b.isEnabled())
//            b.setSaveEnabled(false);
//
//    }


    /*This method to set the color of grid button  just after clicking on them */
//    public void setGridButtonColor(ImageButton bClick) {
//        drawButtonImages();
//    }

    /*This method to set the color of grid button  just after clicking on answer buttons this sets color of the grid button
     * depending on the user clicks on correct answer or wrong answer */
    public void setGridButtonColorAnsOnClick() {
        if (correctAnsSelected) {
            buttonState[selectedButtonIndex] = buttonCorrectAnsColor;
            buttonColor[selectedButtonIndex] = 1;
        } else {
            buttonState[selectedButtonIndex] = buttonIncorrectAnsColor;
        }
        win = selectWinner();
        //   if(win){
        //     resetButton();
        // }
        drawButtonImages();
    }

    public void resetButton() {
        for (int i = 0; i < 9; i++) {
            if (buttonColor[i] + buttonColor[i + 1] + buttonColor[i + 2] == 3) {
                if (i == 0) clearGrid(0, 2);
                if (i == 3) clearGrid(3, 5);
                if (i == 6) clearGrid(6, 8);
            }
            if (buttonColor[i] + buttonColor[i + 1] + buttonColor[i + 2] == 3) {
                if (i == 0) clearGrid(0, 2);
                if (i == 3) clearGrid(3, 5);
                if (i == 6) clearGrid(6, 8);
            }
        }


        if (buttonColor[0] + buttonColor[3] + buttonColor[6] == 3) clearGrid(0, 6);
        if (buttonColor[1] + buttonColor[4] + buttonColor[7] == 3) clearGrid(1, 7);
        if (buttonColor[2] + buttonColor[5] + buttonColor[8] == 3) clearGrid(2, 8);
        if (buttonColor[0] + buttonColor[4] + buttonColor[8] == 3) clearGrid(0, 8);
        if (buttonColor[2] + buttonColor[4] + buttonColor[6] == 3) clearGrid(2, 6);


    }

    public void clearGrid(int x, int y) {
        if (x == 0 && y == 2) {

//            b4.setVisibility(View.GONE);
//            b5.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
//            b7.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);
//            b9.setVisibility(View.GONE);
        }
        if (x == 3 && y == 5) {
//            b1.setVisibility(View.GONE);
//            b2.setVisibility(View.GONE);
//            b3.setVisibility(View.GONE);
//            b7.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);
//            b9.setVisibility(View.GONE);
        }
        if (x == 6 && y == 8) {
//            b1.setVisibility(View.GONE);
//            b2.setVisibility(View.GONE);
//            b3.setVisibility(View.GONE);
//            b4.setVisibility(View.GONE);
//            b5.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
        }
        if (x == 0 && y == 6) {
//            b2.setVisibility(View.GONE);
//            b3.setVisibility(View.GONE);
//            b5.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);
//            b9.setVisibility(View.GONE);
        }
        if (x == 0 && y == 8) {
//            b2.setVisibility(View.GONE);
//            b3.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
//            b4.setVisibility(View.GONE);
//            b7.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);

        }
        if (x == 3 && y == 7) {
//            b1.setVisibility(View.GONE);
//            b2.setVisibility(View.GONE);
//            b4.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);
//            b9.setVisibility(View.GONE);
        }
        if (x == 3 && y == 7) {
//            b1.setVisibility(View.GONE);
//            b2.setVisibility(View.GONE);
//            b4.setVisibility(View.GONE);
//            b6.setVisibility(View.GONE);
//            b8.setVisibility(View.GONE);
//            b9.setVisibility(View.GONE);
        }


    }


//    public void displayText() {
//        questionText.setText(questionString);
//    }


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
        questionString = savedInstanceState.getString("QuestionString");
        selectedButtonIndex = savedInstanceState.getInt("selectedButtonIndex");
        correctAnsSelected = savedInstanceState.getBoolean("correctAnsSelected");
        newGridButtonSelected = savedInstanceState.getBoolean("newGridButtonState");
        buttonState = savedInstanceState.getStringArray("buttonState");
        drawButtonImages();

//        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
//        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
//        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
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
//                ansButton1.setVisibility(View.INVISIBLE);
//                ansButton1.setText(generate.getFirstRandom());
//                ansButton2.setVisibility(View.INVISIBLE);
//                ansButton2.setText(generate.getSecondRandom());
//                ansButton3.setVisibility(View.INVISIBLE);
//                ansButton3.setText(generate.getRightAnswer());
                break;
            }
            case 2: {
                answers.add(Integer.parseInt(generate.getFirstRandom()));
                correctAnswer = Integer.parseInt(generate.getRightAnswer());
                answers.add(correctAnswer);
                answers.add(Integer.parseInt(generate.getSecondRandom()));
//                ansButton1.setVisibility(View.INVISIBLE);
//                ansButton1.setText(generate.getFirstRandom());
//                ansButton2.setVisibility(View.INVISIBLE);
//                ansButton2.setText(generate.getRightAnswer());
//                ansButton3.setVisibility(View.INVISIBLE);
//                ansButton3.setText(generate.getSecondRandom());
                break;
            }
            case 3: {
                correctAnswer = Integer.parseInt(generate.getRightAnswer());
                answers.add(correctAnswer);
                answers.add(Integer.parseInt(generate.getFirstRandom()));
                answers.add(Integer.parseInt(generate.getSecondRandom()));
//                ansButton1.setVisibility(View.INVISIBLE);
//                ansButton1.setText(generate.getRightAnswer());
//                ansButton2.setVisibility(View.INVISIBLE);
//                ansButton2.setText(generate.getSecondRandom());
//                ansButton3.setVisibility(View.INVISIBLE);
//                ansButton3.setText(generate.getFirstRandom());
                break;
            }
        }

    }

//    public void setAnswerButtonsVisible() {
//        ansButton1.setVisibility(View.VISIBLE);
//        ansButton2.setVisibility(View.VISIBLE);
//        ansButton3.setVisibility(View.VISIBLE);
//    }


}
