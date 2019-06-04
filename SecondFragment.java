package com.example.youyi.sixthree;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second2, container, false);
        textView1 = view.findViewById(R.id.txt1);
        textView2 = view.findViewById(R.id.txt2);
        textView3 = view.findViewById(R.id.txt3);
        textView4 = view.findViewById(R.id.txt4);
        textView5 = view.findViewById(R.id.txt5);

        int num = 4;

        switch (num){
            case 1:
                textView1.setBackgroundResource(R.drawable.circle2);
                break;
            case 2:
                textView1.setBackgroundResource(R.drawable.circle2);
                textView2.setBackgroundResource(R.drawable.circle2);
                break;
            case 3:
                textView1.setBackgroundResource(R.drawable.circle2);
                textView2.setBackgroundResource(R.drawable.circle2);
                textView3.setBackgroundResource(R.drawable.circle2);
                break;
            case 4:
                textView1.setBackgroundResource(R.drawable.circle2);
                textView2.setBackgroundResource(R.drawable.circle2);
                textView3.setBackgroundResource(R.drawable.circle2);
                textView4.setBackgroundResource(R.drawable.circle2);
                break;
            case 5:
                textView1.setBackgroundResource(R.drawable.circle2);
                textView2.setBackgroundResource(R.drawable.circle2);
                textView3.setBackgroundResource(R.drawable.circle2);
                textView4.setBackgroundResource(R.drawable.circle2);
                textView5.setBackgroundResource(R.drawable.circle2);
                break;
                default:
                    break;
        }

        return view;
    }

}