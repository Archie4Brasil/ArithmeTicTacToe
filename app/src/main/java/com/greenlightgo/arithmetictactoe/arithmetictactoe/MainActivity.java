package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import  android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends Activity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;  //Grid Buttons
    Button ansButton1,ansButton2,ansButton3;
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
    String questionString="";
    private TextView questionText ;
    int selectedButtonIndex=-1;
    boolean correctAnsSelected = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = (TextView)findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.grid1x1);
        b2 = (Button) findViewById(R.id.grid1x2);
        b3 = (Button) findViewById(R.id.grid1x3);
        b4 = (Button) findViewById(R.id.grid2x1);
        b5 = (Button) findViewById(R.id.grid2x2);
        b6 = (Button) findViewById(R.id.grid2x3);
        b7 = (Button) findViewById(R.id.grid3x1);
        b8 = (Button) findViewById(R.id.grid3x2);
        b9 = (Button) findViewById(R.id.grid3x3);
        ansButton1 = (Button) findViewById(R.id.answers1);
        ansButton2 = (Button) findViewById(R.id.answers2);
        ansButton3 = (Button) findViewById(R.id.answers3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);


        ansButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansButton1 = (Button)view;
                if (ansButton1.getText().equals(Integer.toString(correctAnswer))){
                    correctAnswers++;
                    correctAnsSelected=true;
                }else
                {
                    incorrectAnswers++;
                    correctAnsSelected =false;
                }
            }
        });
        ansButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansButton1 = (Button)view;
                if (ansButton2.getText().equals(Integer.toString(correctAnswer))){
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
                if (ansButton3.getText().equals(Integer.toString(correctAnswer))){
                    correctAnswers++;
                    correctAnsSelected=true;
                }
                else
                {
                    incorrectAnswers++;
                    correctAnsSelected =false;
                }
            }

        });
        setGridButtonColorAnsOnClick();
        if (savedInstanceState == null)
        {
            randomize();
        }
    }

    public void buttonSelection(){
        Button b;
        if(selectedButtonIndex==1) {
            b = (Button) findViewById(R.id.grid1x1);
            setGridButtonColor(b);

        }else if(selectedButtonIndex==2) {
            b = (Button) findViewById(R.id.grid1x2);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==3) {
            b = (Button) findViewById(R.id.grid1x3);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==4) {
            b = (Button) findViewById(R.id.grid2x1);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==5) {
            b = (Button) findViewById(R.id.grid2x2);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==6) {
            b = (Button) findViewById(R.id.grid2x3);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==7) {
            b = (Button) findViewById(R.id.grid3x1);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==8) {
            b = (Button) findViewById(R.id.grid3x2);
            setGridButtonColor(b);
        }else if(selectedButtonIndex==9) {
            b = (Button) findViewById(R.id.grid3x3);
            setGridButtonColor(b);
        }



    }
    @Override
    public void onClick(View v) {
        Button bClick = (Button)v;
        ColorDrawable buttonColor = (ColorDrawable) bClick.getBackground();
        int colorId = buttonColor.getColor();
        if(colorId == Color.parseColor(buttonInitColor )) {
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
            msgText.setText("You have already clicked the button");
        }

    }

    public void setGridButtonColor(Button bClick)
    {
        bClick.setBackgroundColor(Color.parseColor(buttonClickColor));
    }
    public void setGridButtonColorAnsOnClick()
    {
        if(correctAnsSelected)
        {
            if(selectedButtonIndex==1)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==2)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==3)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==4)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==5)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==6)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==7)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==8)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==9)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
        }else
        if(!correctAnsSelected)
        {
            if(selectedButtonIndex==1)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==2)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==3)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==4)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==5)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==6)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==7)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==8)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==9)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
        }
    }
    public void displayText()
    {
        questionText.setText(questionString);
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
        buttonInitColor = savedInstanceState.getString("buttonInitColor");
        buttonClickColor = savedInstanceState.getString("buttonClickColor");
        buttonCorrectAnsColor = savedInstanceState.getString("buttonCorrectAnsColor");
        buttonIncorrectAnsColor = savedInstanceState.getString("buttonIncorrectAnsColor");
        questionString = savedInstanceState.getString("QuestionString");
        selectedButtonIndex = savedInstanceState.getInt("selectedButtonIndex");
        correctAnsSelected = savedInstanceState.getBoolean("correctAnsSelected");

        b1.setBackgroundResource(android.R.drawable.btn_default);
        b2.setBackgroundResource(android.R.drawable.btn_default);
        b3.setBackgroundResource(android.R.drawable.btn_default);
        b4.setBackgroundResource(android.R.drawable.btn_default);
        b5.setBackgroundResource(android.R.drawable.btn_default);
        b6.setBackgroundResource(android.R.drawable.btn_default);
        b7.setBackgroundResource(android.R.drawable.btn_default);
        b8.setBackgroundResource(android.R.drawable.btn_default);
        b9.setBackgroundResource(android.R.drawable.btn_default);

        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
        ansButton1.setBackgroundResource(android.R.drawable.btn_default);
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
        ansButton1.setText(Integer.toString(answers.get(0)));
        ansButton2.setText(Integer.toString(answers.get(1)));
        ansButton3.setText(Integer.toString(answers.get(2)));
        msgText.setText(questionString);


    }
    public void randomize()
    {
        questionString = questionText.getText().toString();
        String[] mathOp= questionString.split(" ");
        number1 = Integer.parseInt(mathOp[0]);
        number2 = Integer.parseInt(mathOp[2]);
        operator = mathOp[1];
        if (operator.equals("+"))
        {
            answers.add(number1 + number2);
            randomGenerator(2, 10);
        }
        else if (operator.equals("-"))
        {
            answers.add(number1 - number2);
            randomGenerator(0, 4);
        }
        else if (operator.equals("*"))
        {
            answers.add(number1 * number2);
            randomGenerator(2, 25);
        }
        else if (operator.equals("/"))
        {
            answers.add(number1 / number2);
            randomGenerator(1, 5);
        }

        Collections.shuffle(answers);

        ansButton1.setText(Integer.toString(answers.get(0)));
        ansButton1.setBackgroundResource(android.R.drawable.btn_default);

        ansButton2.setText(Integer.toString(answers.get(1)));
        ansButton2.setBackgroundResource(android.R.drawable.btn_default);

        ansButton3.setText(Integer.toString(answers.get(2)));
        ansButton3.setBackgroundResource(android.R.drawable.btn_default);
    }

    public void randomGenerator(int max, int min)
    {
        correctAnswer = answers.get(0);

        int temp;

        do
        {
            temp = (int) (Math.random() * (max - min)) + min;

        }
        while (temp == answers.get(0));
        answers.add(temp);
        do
        {
            temp = (int) (Math.random() * (max - min)) + min;
        }
        while (temp == answers.get(0) || temp == answers.get(1));
        answers.add(temp);
    }

}
