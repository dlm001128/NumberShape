package com.example.numbershape;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView mInfoTextView;
    private Button testButton;
    Boolean square;
    Boolean triangular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.numET);
        mInfoTextView = (TextView) findViewById(R.id.information);
        testButton = (Button) findViewById(R.id.testBtn);
        testButton.setText(R.string.test_button);
        testButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String check = input.getText().toString();
                if(check.equals("")){
                    mInfoTextView.setText("Please enter a number in the above text field.");
                }
                else{
                    int number = Integer.parseInt(check);
                    Number n = new Number(number);
                    square = n.isSquare();
                    triangular = n.isTriangular();
                    if(square && !triangular){
                        String text1 = number + " is a square, but not a triangular.";
                        System.out.println(text1);
                        mInfoTextView.setText(text1);
                    }
                    else if(!square && triangular){
                        String text2 = number + " is a triangular, but not a square.";
                        mInfoTextView.setText(text2);
                    }
                    else if(square && triangular){
                        String text3 = number + " is a square and a triangular.";
                        mInfoTextView.setText(text3);
                    }
                    else{
                        String text4 = number + " is not a square or a triangular.";
                        mInfoTextView.setText(text4);
                    }
                }
            }
        });
    }
}