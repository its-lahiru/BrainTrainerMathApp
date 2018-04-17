package com.example.lahiru.brintrainermathapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView quizText;
    TextView resultText;
    TextView totalText;
    TextView timerText;
    Button startButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    RelativeLayout game;

    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void playAgain(View view) {

        score =0;
        numberOfQuestions =0;

        timerText.setText("30s");
        totalText.setText("0/0");
        resultText.setText("");

        playAgain.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                timerText.setText(String.valueOf(millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {

                playAgain.setVisibility(View.VISIBLE);
                timerText.setText("0s");
                resultText.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));

            }
        }.start();

    }

    public void generateQuestion() {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        quizText.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        int incorrectAnswer;

        for (int i=0 ; i<4; i++) {

            if (i == locationOfCorrectAnswer) {

                answers.add(a + b);

            } else {

                incorrectAnswer = rand.nextInt(41);

                while (incorrectAnswer == (a + b)) {

                    incorrectAnswer = rand.nextInt(41);

                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button2.setText(Integer.toString(answers.get(3)));
    }

    ///////////////////////////////////////////////////////////

    public void chooseAnswer(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            resultText.setText("Correct!!");
        } else {
            resultText.setText("Wrong!!");
        }

        numberOfQuestions++;
        totalText.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    ////////////////////////////////////////////////////////////////

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        game.setVisibility(RelativeLayout.VISIBLE);

        playAgain(findViewById(R.id.btn_playAgain));
    }

    /////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.btn_start);
        quizText = findViewById(R.id.tv_quiz);
        button0 =findViewById(R.id.button0);
        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);
        button3 =findViewById(R.id.button3);
        resultText = findViewById(R.id.tv_resultText);
        totalText = findViewById(R.id.tv_total);
        timerText = findViewById(R.id.tv_timer);
        playAgain = findViewById(R.id.btn_playAgain);
        game = findViewById(R.id.gameRelativeLayout);


    }















}
