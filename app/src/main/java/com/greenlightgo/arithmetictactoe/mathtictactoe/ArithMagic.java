package com.greenlightgo.arithmetictactoe.mathtictactoe;

/**
 * Created by Archie on 12/2/2014.
 * latest update: 15:39 12/2/2014
 */
public class ArithMagic {
    private static int firstNumber, secondNumber, randomOne, randomTwo, answer, range, min, temp;
    protected String problem;

    public ArithMagic() {
        generateNumbers();
    }

    public void generateNumbers()
    {
        // setting random first and second number
        firstNumber = (int) (Math.random() * 10) + 1;
        secondNumber = (int) (Math.random() * 10) + 1;

        // random cases for different problems from addition to division
        int i = (int) (Math.random() * 4);
        switch (i) {
            case 0:
                answer = firstNumber + secondNumber;
                min = 2;
                range = (20 - min) + 1;
                problem = firstNumber+" + "+secondNumber;
                break;
            case 1:
                if (firstNumber < secondNumber){
                    temp = firstNumber;
                    firstNumber = secondNumber;
                    secondNumber = temp;
                }
                answer = firstNumber - secondNumber;
                min = -9;
                range = (9 - min) + 1;
                problem = firstNumber+" - "+secondNumber;
                break;
            case 2:
                answer = firstNumber * secondNumber;
                min = 1;
                range = (100 - min) + 1;
                problem = firstNumber+" * "+secondNumber;
                break;

            case 3:
              int[] question = generateDivideQuestion(20);
                firstNumber = question [0];
                secondNumber = question[1];
                answer = firstNumber / secondNumber;
                min = 0;
                range = (10 - min) + 1;
                problem = firstNumber+" / "+secondNumber;
                break;
        }

//nothing

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
    private int[] generateDivideQuestion(int range) {
        int[] question = { 0, 0 };
        int first, second;
        question[0] = (int) (Math.random() * (range-1));
        question[0]++;
        question[1] = (int) (Math.random() * (range-1));
        first = question[0];
        question[1]++;
        second = question[1];
        if (first < second) {
            question[0] = second;
            question[1] = first;
        }
        while (question[0] % question[1] != 0) {
            question[0]--;
        }
        return question;
    }

public String getProblem()
        {
        return problem;
        }

public String getFirstRandom()
        {
        return randomOne+"";
        }

public String getSecondRandom()
        {
        return randomTwo+"";
        }

public String getRightAnswer()
        {
        return answer+"";
        }

        }