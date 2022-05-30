package com.prama.pahlawannasional.kuis;

import androidx.appcompat.app.AppCompatActivity;
import com.prama.pahlawannasional.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KuisActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private Button falseButton;
    private TextView question;
    private Button nextButton;
    private Button backButton;

    private Question[] questionBank = new Question[]{
            new Question(R.string.pertanyaan, true),
            new Question(R.string.pertanyaan2, false),
            new Question(R.string.pertanyaan3, true),
            new Question(R.string.pertanyaan4, true),
            new Question(R.string.pertanyaan5, false)
    };

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
        question = findViewById(R.id.question);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.trueButton:
                checkAnswer(true);
                break;

            case R.id.falseButton:
                checkAnswer(false);
                break;

            case R.id.nextButton:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;

            case R.id.backButton:
                if(currentQuestionIndex > 0){
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
        }

    }
    private void updateQuestion(){
        Log.d("current", "onclick" + currentQuestionIndex);
        question.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }
    private void checkAnswer(boolean userChoosenCorrect){
        boolean answerIsTrue= questionBank[currentQuestionIndex].isAnswerTrue();

        int toastMessage = 0;
        if (userChoosenCorrect == answerIsTrue){
            toastMessage = R.string.correct_answer;
        }else{
            toastMessage = R.string.wrong_answer;
        }
        Toast.makeText(KuisActivity.this,toastMessage,Toast.LENGTH_SHORT).show();

    }
}