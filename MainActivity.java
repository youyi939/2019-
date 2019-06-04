package com.example.youyi.parkingmeter;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button button;
    private Button button2;
    private Chronometer chronometer;
    private TextView textViewCost;
    private int rate = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.start);
        button2 = findViewById(R.id.settle);
        chronometer = findViewById(R.id.chronometer);
        textViewCost = findViewById(R.id.cost);
        int hour = (int)((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000/ 60);
        chronometer.setFormat("0"+String.valueOf(hour) + ":%s" );
        pref = getSharedPreferences("time",MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("start".equals(button.getText())){
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.start();
                        final int time = (int) chronometer.getBase( );
                        editor = getSharedPreferences("time",MODE_PRIVATE).edit();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                editor.putInt("time",time);
                                editor.apply();
                            }
                        }).start();
                    button.setText("end");
                    textViewCost.setText("计时中，按结算按钮统计付费");
                }else {
                    button.setText("start");
                    int cost = 0;
                    cost = (int) (SystemClock.elapsedRealtime() - chronometer.getBase())/(3600*1000);
                    System.out.println(cost);
                    textViewCost.setText("需缴费用:"+(cost + 1)*rate+"元");
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.stop();
                    pref.edit().clear().commit();
                }
            }
        });
        int time2 = pref.getInt("time",0);
        if (time2 != 0){
            chronometer.setBase(time2);
            chronometer.start();
            button.setText("end");
            textViewCost.setText("计时中，按结算按钮统计付费");
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewCost.setText("已结算，需缴费用:0元");
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
            }
        });
    }
}