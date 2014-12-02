package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import  android.widget.Button;
import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;  //Grid Buttons
    private int number1;                //First Operand
    private int number2;                //Second Operand
    private ArrayList<Integer> answers; //ArrayList contains 3 answer options including the correct answer
    private TextView msgText;           //Textview to display the question or any message

    private int correctAnswer;          //No of correct answer
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private String operator;
    String buttonInitColor ="";
    String buttonClickColor ="";
    String buttonCorrectAnsColor ="";
    String buttonIncorrectAnsColor ="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.grid1x1);
        b2 = (Button) findViewById(R.id.grid1x2);
        b3 = (Button) findViewById(R.id.grid1x3);
        b4 = (Button) findViewById(R.id.grid2x1);
        b5 = (Button) findViewById(R.id.grid2x1);
        b6 = (Button) findViewById(R.id.grid2x1);
        b7 = (Button) findViewById(R.id.grid3x1);
        b8 = (Button) findViewById(R.id.grid3x1);
        b9 = (Button) findViewById(R.id.grid3x1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button bClick = (Button)v;
        ColorDrawable buttonColor = (ColorDrawable) bClick.getBackground();
        int colorId = buttonColor.getColor();
        if(colorId == Color.parseColor(buttonInitColor )) {
            displayEditText();
            displayAnsButton();

            setGridButtonColor(bClick);
        }
        else
        {
            msgText.setText("You have already clicked the button");
        }
    }
    public void setGridButtonColor(Button bClick)
    {
        bClick.setBackgroundColor(Color.parseColor(buttonClickColor));
    }
    public void setGridButtonColorAnsOnClick(Button b)
    {
        if(checkAnswer())
            b.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
        else
            b.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
    }
    public void displayEditText()
    {

    }
    public void displayAnsButton()
    {

    }
    public boolean checkAnswer()
    {
        boolean correctAns =true;
        return correctAns;

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
        super.onRestoreInstanceState(savedInstanceState);
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



    }


}
