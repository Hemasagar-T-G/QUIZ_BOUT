package com.example.quiz_bout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quizpage1 extends AppCompatActivity implements View.OnClickListener
{

    TextView name;

    TextView totalQuestionTeexView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion=QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage1);

        name=findViewById(R.id.ViewName);

        Intent getVal = getIntent();
        String str = getVal.getStringExtra("Name");
        name.setText(str);

        totalQuestionTeexView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        submitBtn = findViewById(R.id.nxt);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionTeexView.setText("Total Question: "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.nxt){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex]))
            {
                score++;
            }
            currentQuestionIndex++;
        loadNewQuestion();

        }
        else{
            //choice clicked
            selectedAnswer = clickedButton.getText().toString();
        }
    }
    void loadNewQuestion()
    {
        if(currentQuestionIndex == totalQuestion)
        {
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz()
    {
        String passStatus = "";
        if(score>=totalQuestion*0.75)
        { passStatus = "PASS"; }
        else
        { passStatus = "FAIL"; }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score: "+score+" out of "+totalQuestion)
                .setPositiveButton("RESTART",(dialogInterface, i) -> restartQuiz())
                        .setCancelable(false)
                        .show();
    }
                void restartQuiz()
                {
                    score=0;
                    currentQuestionIndex=0;
                    loadNewQuestion();
                }
    }