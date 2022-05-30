package com.prama.pahlawannasional.kuis;

import androidx.appcompat.app.AppCompatActivity;
import com.prama.pahlawannasional.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.OptionalDataException;

public class SkorActivity extends AppCompatActivity {

    TextView finalScore;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        finalScore = (TextView)findViewById(R.id.finalScore);
        retryButton = (Button)findViewById(R.id.buttonRetry);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        finalScore.setText("Skor Anda adalah " + score + " :D");

        retryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SkorActivity.this, KuisActivity.class));
                SkorActivity.this.finish();
                };
            });

    }
}