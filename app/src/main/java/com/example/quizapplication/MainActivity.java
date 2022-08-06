package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView que,result;
    Button yes,no,restart;
    private String[] questions={
            "1. Is Java programming language?",
            "2. Is Java used for cyber security?",
            "3. Is Java developed in 1986?",
            "4. Is python better than java?",
            "5. Is java cover OOPS concept?"
    };
    private boolean[] answer={true,false,false,true,true};
    private int score=0;
    private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        que=findViewById(R.id.question);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        restart=findViewById(R.id.restart);
        result=findViewById(R.id.result);
       que.setText(questions[index]);
        if (index==4)
        {
           yes.setClickable(false);
            no.setClickable(false);
        }
        yes.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(index==questions.length-1)
                {
                    yes.setClickable(false);
                }
                if (index <= questions.length - 1) {
                    if (answer[index] == true) {
                        {
                            score++;
                        }
                    }
                        if (index < questions.length - 1) {
                            que.setText(questions[++index]);
                        } else if (index == questions.length - 1) {
                            result.setText("Your test is over.\n You have scored " + score + " from total 5 marks");
                        }

                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==questions.length-1)
                {
                    no.setClickable(false);
                }
                if (index <=  questions.length - 1) {
                    if (answer[index] == false) {
                        score++;
                    }
                    if (index < questions.length - 1) {
                        que.setText(questions[++index]);
                    }  else if (index==questions.length-1){
                        result.setText("Your test is over.\n You have scored "+score +" from total 5 marks");                    }
                }
            }
        });
        if (index==questions.length)
        {
            que.setText("Your score is " + score);
            Toast.makeText(MainActivity.this, "Your score is " + score, Toast.LENGTH_SHORT).show();
        }
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index=0;
                score=0;
                que.setText(questions[0]);
                result.setText("");
                Toast.makeText(MainActivity.this, "Quiz is Restarted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}