package com.example.home.numberprimalityexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView num;
    private Button true_button, false_button, next;
    private int rand_num;
    private boolean prime;
    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (TextView)findViewById(R.id.number);
        true_button = (Button)findViewById(R.id.true_button);
        false_button = (Button)findViewById(R.id.false_button);
        next = (Button)findViewById(R.id.next_button);

        rand = new Random();

        changeNumber(rand, 2, 100);

        true_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        if(prime)
                            Toast.makeText(getApplicationContext(), "Answer is correct", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "Answer is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        false_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        if(prime)
                            Toast.makeText(getApplicationContext(), "Answer is incorrect", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "Answer is correct", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        next.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        changeNumber(rand, 2, 100);
                    }
                }
        );
    }

    private void changeNumber(Random rand, int min, int max)
    {
        rand_num = rand.nextInt((max - min) + 1) + min;
        num.setText(String.valueOf(rand_num));

        prime = true;

        for(int i=2; i<rand_num; i++)
        {
            if(rand_num % i == 0)
            {
                prime = false;
                break;
            }
        }
    }
}
