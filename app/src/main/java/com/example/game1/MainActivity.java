package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    CheckBox checkboxone,checkboxtow,checkboxthree;
    SeekBar skone,sktow,skthree;
    Button button;
    int sodiem=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        skone.setEnabled(false);
        sktow.setEnabled(false);
        skthree.setEnabled(false);
        txtdiem.setText(String.valueOf(sodiem));
        CountDownTimer countDownTimer= new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                int rd1 = random.nextInt(5);
                int rd2 = random.nextInt(5);
                int rd3 = random.nextInt(5);
                if(skone.getProgress()>=skone.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"one win",Toast.LENGTH_SHORT).show();
                    if(checkboxone.isChecked()){
                        sodiem+=10;
                    }else {
                        sodiem-=5;
                    }
                    txtdiem.setText(String.valueOf(sodiem));
                    enablecheckbox();
                }
                if (sktow.getProgress()>=sktow.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"tow win",Toast.LENGTH_SHORT).show();
                    if(checkboxtow.isChecked()){
                        sodiem+=10;
                    }else {
                        sodiem-=5;
                    }
                    txtdiem.setText(String.valueOf(sodiem));
                    enablecheckbox();
                }
                if(skthree.getProgress()>=skthree.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"three win",Toast.LENGTH_SHORT).show();
                    if(checkboxthree.isChecked()){
                        sodiem+=10;
                    }else {
                        sodiem-=5;
                    }
                    txtdiem.setText(String.valueOf(sodiem));
                    enablecheckbox();
                }
                skone.setProgress(skone.getProgress()+rd1);
                sktow.setProgress(sktow.getProgress()+rd2);
                skthree.setProgress(skthree.getProgress()+rd3);
            }

            @Override
            public void onFinish() {
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkboxone.isChecked()|| checkboxtow.isChecked()||checkboxthree.isChecked()){
                    button.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    skone.setProgress(0);
                    sktow.setProgress(0);
                    skthree.setProgress(0);
                    disablecheckbox();
                }else {
                    Toast.makeText(MainActivity.this,"vui long dat cuoc",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkboxone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkboxtow.setChecked(false);
                    checkboxthree.setChecked(false);
                }
            }
        });
        checkboxtow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkboxthree.setChecked(false);
                    checkboxone.setChecked(false);
                }
            }
        });
        checkboxthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkboxone.setChecked(false);
                    checkboxtow.setChecked(false);
                }
            }
        });

    }
    public void enablecheckbox(){
        checkboxone.setEnabled(true);
        checkboxtow.setEnabled(true);
        checkboxthree.setEnabled(true);
    }
    public void disablecheckbox(){
        checkboxone.setEnabled(false);
        checkboxtow.setEnabled(false);
        checkboxthree.setEnabled(false);
    }
    public void anhxa(){
        txtdiem       = (TextView) findViewById(R.id.diem);
        button        = (Button) findViewById(R.id.play);
        checkboxone   =(CheckBox) findViewById(R.id.checkboxone);
        checkboxtow   =(CheckBox) findViewById(R.id.checkboxtow);
        checkboxthree =(CheckBox) findViewById(R.id.checkboxthree);
        skone         =(SeekBar) findViewById(R.id.seerbarone);
        sktow         =(SeekBar) findViewById(R.id.seerbartow);
        skthree       =(SeekBar) findViewById(R.id.seekbarthree);
    }
}