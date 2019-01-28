package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mfalseButton;
    private Button mNextButton;
    private TextView mquestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_africa,true),
            new Question(R.string.question_america,false),
            new Question(R.string.question_asia,false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_oceans,true)
    };

    private int currentIndex = 0;

    public void updateQuestion(){
        int question = mQuestionBank[currentIndex].getID();
        mquestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressed){
        boolean answer = mQuestionBank[currentIndex].getAnswer();
        int messageID = 0;

        if(answer == userPressed){
            messageID = R.string.correct_Toast;
        }
        else
            messageID = R.string.incorrect_Toast;

        Toast.makeText(this, messageID, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mfalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mquestionTextView = (TextView) findViewById(R.id.questionTextView);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }
}
