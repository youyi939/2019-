package com.lenovo.smarttraffic.util;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;

public class QrcodeUtil {
    public String levle;
    public String message;
    public Bitmap bitmap;

    public Bitmap makeImage(){
        Hashtable<EncodeHintType,String> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION,levle);
        hints.put(EncodeHintType.MARGIN,"4");
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(message,BarcodeFormat.QR_CODE,700,700,hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] piexl = new int[width * height];
            for (int y = 0; y < height; y++){
                for (int x = 0; x < width ;x ++){
                    if (matrix.get(x,y)){
                        piexl[width * y  +  width] = Color.BLACK;
                    }
                }
            }
            bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
            bitmap.setPixels(piexl,0,width,0,0,width,height);
        }catch (WriterException w){
            w.printStackTrace();
        }
        return  bitmap;
    }

}
