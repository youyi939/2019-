package com.example.youyi.sixthree;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManagerFragment extends Fragment {
    private Button pay;
    private TextView textView1;
    private TextView textView2;
    private Button buttonreduce;
    private Button buttonadd;
    private TextView textViewcount;
    private TextView textViewprice;
    private Button buttonempty;
    private LinearLayout linearLayout;
    private TextView textViewmanager;
    private TextView textViewdelete;
    private TextView more;
    int price=60;
    public ManagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_manager, container, false);
        pay = view.findViewById(R.id.pay);
        textView1=view.findViewById(R.id.today);
        textView2=view.findViewById(R.id.tomorrow);
        buttonreduce=view.findViewById(R.id.btn_reduce);
        buttonadd=view.findViewById(R.id.btn_add);
        textViewcount=view.findViewById(R.id.tv_count);
        textViewprice=view.findViewById(R.id.price);
        buttonempty=view.findViewById(R.id.empty);
        linearLayout=view.findViewById(R.id.message1);
        textViewmanager=view.findViewById(R.id.manager);
        textViewdelete=view.findViewById(R.id.delete);
        more  = view.findViewById(R.id.moretime);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime();
            }
        });
        textViewmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewdelete.setVisibility(View.VISIBLE);
            }
        });
        textViewdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
            }
        });
        buttonempty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
                pay.setEnabled(false);

            }
        });

        buttonreduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewcount.getText().equals("0")){
                    buttonreduce.setEnabled(false);
                }else {
                    int data = Integer.parseInt(textViewcount.getText().toString()) - 1;
                    textViewcount.setText(data + "");
                    textViewprice.setText(data*price+"元");
                }
            }
        });
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(textViewcount.getText().toString())>0){
                    buttonreduce.setEnabled(true);
                }
                int data = Integer.parseInt(textViewcount.getText().toString())+1;
                textViewcount.setText(data + "");
                textViewprice.setText(data*price+"元");
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setTextColor(Color.BLACK);
                textView2.setTextColor(Color.GRAY);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setTextColor(Color.BLACK);
                textView1.setTextColor(Color.GRAY);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction
                        .replace(R.id.frame,new QrcodeFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    }
    private void showTime(){
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                more.setText(i +"/" + (i1 + 1) + "/" + i2);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}