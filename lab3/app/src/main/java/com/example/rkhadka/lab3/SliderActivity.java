package com.example.rkhadka.lab3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;


public class SliderActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private static final String Slider_Value_Key = "slider value key";

    public static Intent newIntent(Context context, int intValue){
        Intent i = new Intent(context, SliderActivity.class);
        i.putExtra(Slider_Value_Key, intValue);
        return i;
    }

    public static int getValueFromSeekBar(Intent i){
        return i.getIntExtra(SliderActivity.Slider_Value_Key, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        int intValue = getIntent().getIntExtra(Slider_Value_Key, 0);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setProgress(intValue);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Slider_Value_Key, mSeekBar.getProgress());
                setResult(RESULT_OK, returnIntent );
            }
        });
    }
}

