package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;  //Grid Buttons
    Button ansButton1,ansButton2,ansButton3;
    private int number1;                //First Operand
    private int number2;                //Second Operand
    private ArrayList<Integer> answers; //ArrayList contains 3 answer options including the correct answer
    private TextView msgText;           //Textview to display the question or any message

    private int correctAnswer;          //correct answer after calclulation
    private int correctAnswers = 0;     // No of correct answers
    private int incorrectAnswers = 0; // No of incorrect answers
    private String operator;            //operator variable
    String buttonDefaultColor ="CYAN";      // initial button color
    String buttonClickColor ="GREEN";
    String buttonCorrectAnsColor ="BLUE";
    String buttonIncorrectAnsColor ="RED";
    String questionString=null;
    private TextView questionText ;
    int selectedButtonIndex=-1;
    boolean correctAnsSelected = false;
    private ArithMagic generate;               //calling class of problem generator
    int correctAnswerPosition = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = new ArithMagic();

        questionText = (TextView)findViewById(R.id.textView);
        questionText.setText("Pick your position");
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


//
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


        if (savedInstanceState == null)
        {
            randomize();
        }
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



    public void ansClick(View v) {
        Button bClick = (Button) v;

        switch (bClick.getId()) {
            case R.id.answers1: {
                if (ansButton2.getText().equals(generate.getRightAnswer())) {
                    correctAnswers++;
                    correctAnsSelected = true;

                } else
                    correctAnsSelected = false;

                break;
            }
            case R.id.answers2: {
                if (ansButton2.getText().equals(generate.getRightAnswer())) {
                    correctAnswers++;
                    correctAnsSelected = true;
                } else {
                    incorrectAnswers++;
                    correctAnsSelected = false;
                }
                break;
            }
            case R.id.answers3: {
                if (ansButton3.getText().equals(generate.getRightAnswer())) {
                    correctAnswers++;
                    correctAnsSelected = true;
                } else {
                    incorrectAnswers++;
                    correctAnsSelected = false;
                }
                break;
            }
        }

        questionText.setText("Pick another position");
        generate.generateNumbers();
        randomize();
        setGridButtonColorAnsOnClick();
    }




/*This method is to assign  indexes from 1 to 9 for   9 grid buttons */
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



    /*this is to describe the action when user clicks on gird buttons*/
    @Override
    public void onClick(View v) {
        Button bClick = (Button)v;
        bClick.setActivated(true);
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
        */

        questionText.setText(generate.getProblem());

    }




    /*This method to set the color of grid button  just after clicking on them */
    public void setGridButtonColor(Button bClick)
    {
        bClick.setBackgroundColor(Color.parseColor(buttonClickColor));
    }

    /*This method to set the color of grid button  just after clicking on answer buttons this sets color of the grid button
     * depending on the user clicks on correct answer or wrong answer */
    public void setGridButtonColorAnsOnClick()
    {
        if(correctAnsSelected)
        {
            if(selectedButtonIndex==1)
                b1.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==2)
                b2.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==3)
                b3.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==4)
                b4.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==5)
                b5.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==6)
                b6.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==7)
                b7.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==8)
                b8.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
            else if(selectedButtonIndex==9)
                b9.setBackgroundColor(Color.parseColor(buttonCorrectAnsColor));
        }else
        if(!correctAnsSelected)
        {
            if(selectedButtonIndex==1)
                b1.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==2)
                b2.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==3)
                b3.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==4)
                b4.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==5)
                b5.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==6)
                b6.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==7)
                b7.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==8)
                b8.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
            else if(selectedButtonIndex==9)
                b9.setBackgroundColor(Color.parseColor(buttonIncorrectAnsColor));
        }
        else
        {
            switch (selectedButtonIndex)
            {
                case 1:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 2:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 3:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 4:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 5:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 6:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 7:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 8:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
                case 9:
                    b1.setBackgroundColor(Color.parseColor(buttonDefaultColor));
                    break;
            }
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
        buttonDefaultColor = savedInstanceState.getString("buttonInitColor");
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
        questionString = generate.getProblem();

        switch ((int) (Math.random() * 3) + 1) {
            case 1: // first possible order
                ansButton1 = (Button) findViewById(R.id.answers1);
                ansButton1.setText(generate.getFirstRandom());
                ansButton2 = (Button) findViewById(R.id.answers2);
                ansButton2.setText(generate.getSecondRandom());
                ansButton3 = (Button) findViewById(R.id.answers3);
                ansButton3.setText(generate.getRightAnswer());
                break;
            case 2:
                ansButton1 = (Button) findViewById(R.id.answers1);
                ansButton1.setText(generate.getFirstRandom());
                ansButton2 = (Button) findViewById(R.id.answers2);
                ansButton2.setText(generate.getRightAnswer());
                ansButton3 = (Button) findViewById(R.id.answers3);
                ansButton3.setText(generate.getSecondRandom());
                break;
            case 3:
                ansButton1 = (Button) findViewById(R.id.answers1);
                ansButton1.setText(generate.getRightAnswer());
                ansButton2 = (Button) findViewById(R.id.answers2);
                ansButton2.setText(generate.getSecondRandom());
                ansButton3 = (Button) findViewById(R.id.answers3);
                ansButton3.setText(generate.getFirstRandom());
                break;
        }

    }


}
