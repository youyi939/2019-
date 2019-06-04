package com.example.youyi.sixthree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class QrcodeFragment extends Fragment {
    private TextView msg ;
    private ImageView imageView;
    private  Bitmap bitmap;
    private Queue<String> queue;
    private String level = "M";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qrcode, container, false);
        msg = view.findViewById(R.id.txt6);
        imageView = view.findViewById(R.id.img5);
        queue = new LinkedList<>();
        final String message = "付款项目: 故宫,付款金额: 60元";

        MakeImage(level,message);
        queue.add("L");
        queue.add("M");
        queue.add("H");
        queue.add("Q");

        final Handler handler = new Handler();
        final  int num = 5000;
        Runnable r  = new Runnable() {
            @Override
            public void run() {
                level = queue.poll();
                queue.add(level);
                MakeImage(level,message);
                handler.postDelayed(this,num);
            }
        };
        handler.postDelayed(r,num);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                msg.setText(message);
                return true;
            }
        });

        return view;
    }


    private void MakeImage(String levle,String message){
        Hashtable<EncodeHintType,String> hints = new Hashtable<>();
        hints.put(EncodeHintType.MARGIN,"4");
        hints.put(EncodeHintType.ERROR_CORRECTION,levle);
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(message,BarcodeFormat.QR_CODE,700,700,hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height;y++){
                for (int x = 0; x < width; x ++){
                    if (matrix.get(x,y)){
                        pixels[y * width + x] = Color.BLACK;
                    }
                }
            }
            bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels,0,width,0,0,width,height);
            imageView.setImageBitmap(bitmap);
        }catch (WriterException w){
            w.printStackTrace();
        }

    }

}