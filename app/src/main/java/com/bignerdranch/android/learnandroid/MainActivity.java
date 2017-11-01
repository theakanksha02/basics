package com.bignerdranch.android.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]
            {
             new Question(R.string.q1,true),
                    new Question(R.string.q2,false),
                    new Question(R.string.q3,true)
            };
    private int mCurrentIndex=0;
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue)
    {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId= 0;
        if(userPressedTrue== answerIsTrue)
        {
            messageResId=R.string.correct_toast;
        }
        else
        {
            messageResId= R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        mNextButton= findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex= (mCurrentIndex+1)% mQuestionBank.length;
                updateQuestion();
            }
        });
    }
}
