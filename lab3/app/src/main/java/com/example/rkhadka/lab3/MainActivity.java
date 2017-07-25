package com.example.rkhadka.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mValueA;
    private int mValueB;

    private static final int Request_Code_A = 0;
    private static final int Request_Code_B = 1;
    private static final String VALUE_A_KEY = "value_A";
    private static final String VALUE_B_KEY = "value_B";

    private Button mButtonA;
    private Button mButtonB;

    private TextView mTextViewA;
    private TextView mTextViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewA = (TextView) findViewById(R.id.value_A_textview);
        mButtonA = (Button) findViewById(R.id.value_A_button);
        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = SliderActivity.newIntent(MainActivity.this, mValueA);
                startActivityForResult(i, Request_Code_A);

            }
        });

        mTextViewB = (TextView) findViewById(R.id.value_B_textview);
        mButtonB = (Button) findViewById(R.id.value_B_button);
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = SliderActivity.newIntent(MainActivity.this, mValueB);
                startActivityForResult(i, Request_Code_B);

            }
        });

        if (savedInstanceState != null) {
            mValueA = savedInstanceState.getInt(VALUE_A_KEY, 0);
            mValueB = savedInstanceState.getInt(VALUE_B_KEY, 0);
            mTextViewA.setText("" + mValueA);
            mTextViewB.setText("" + mValueB);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i){
        if(resultCode == RESULT_OK){
            if(requestCode == Request_Code_A){
                mValueA = SliderActivity.getValueFromSeekBar(i);
                mTextViewA.setText(""+mValueA);
            } else if (requestCode == Request_Code_B){
                mValueB = SliderActivity.getValueFromSeekBar(i);
                mTextViewB.setText(""+mValueB);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(VALUE_A_KEY, mValueA);
        savedInstanceState.putInt(VALUE_B_KEY, mValueB);
    }


}
