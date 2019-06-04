package com.example.youyi.qecode;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private Spinner numberSpinner;
    private EditText moneyEdit;
    private EditText timeEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyEdit = findViewById(R.id.money);
        timeEdit = findViewById(R.id.time);
        String[] num = {
                "1","2","3","4","5","6"
        };

        SharedPreferences sharedPreferences ;

        numberSpinner = findViewById(R.id.numSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,num);
        numberSpinner.setAdapter(adapter);
    }

    public void makeImage(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        String money = moneyEdit.getText()+"";
        String data = timeEdit.getText()+"";
        intent.putExtra("money",money);
        intent.putExtra("num",numberSpinner.getSelectedItem().toString());
        intent.putExtra("data",data);
        startActivity(intent);
    }
}