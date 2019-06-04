package com.example.youyi.qecode;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    private String money;
    private ImageView imageView;
    private TextView message;
    private Bitmap bitmap;
    private String level = "M";
    private Queue<String> queue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.img);
        message = findViewById(R.id.message);
        queue = new LinkedList<>();

        queue.add("L");
        queue.add("M");
        queue.add("H");
        queue.add("Q");

        final Intent intent = getIntent();
        money = "车辆编号:"+intent.getStringExtra("num")+","+"付款金额="+intent.getStringExtra("money");
        final String data = intent.getStringExtra("data");
        final int num = Integer.parseInt(data)* 1000;

        makeImage(level);


        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        level = queue.poll();
                        queue.add(level);
                        makeImage(level);
                    }
                });
            }
        },0L,Integer.parseInt(data) * 1000);


        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {                //长按点击事件
                message.setText(money);
                return true;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                       //普通点击事件
                Bitmap bmp=bitmap;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);

                byte[] bytes=baos.toByteArray();
                Bundle b = new Bundle();
                b.putByteArray("bitmap", bytes);

                Intent intent1 = new Intent(Main2Activity.this,Main3Activity.class);

                intent1.putExtras(b);
                startActivity(intent1);
            }
        });

    }

    private void makeImage(String level){
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();            //定义二维码参数
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");       //设置字符
        hints.put(EncodeHintType.ERROR_CORRECTION,level);        // 容错级别设置 L,H,M,Q
        hints.put(EncodeHintType.MARGIN, "4");                  // 空白边距设置
        try {
            //    生成二维码
            BitMatrix matrix = new MultiFormatWriter().encode(money,BarcodeFormat.QR_CODE, 700, 700,hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y))
                        pixels[y * width + x] = Color.BLACK;
                    }
                }
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}