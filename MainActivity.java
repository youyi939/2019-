package com.example.youyi.trafficlightmanagement2;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Road> roads ;
    private Spinner spinner;
    private Button find;
    private ListView listView;
    private ListViewAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roads = new ArrayList<>();
        String[] name = new String[]{
                "路口升序",
                "路口降序",
                "红灯升序",
                "红灯降序",
                "绿灯升序",
                "绿灯降序",
                "黄灯升序",
                "黄灯降序"
        };
        initData();                         //初始化数据


        find = findViewById(R.id.find);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lv);
        listAdapter = new ListViewAdapter(MainActivity.this,R.layout.item,roads);
        listView.setAdapter(listAdapter);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        spinner.setAdapter(adapter);
        find.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                switch (spinner.getSelectedItem().toString()){
                    case "路口升序":
                        Collections.sort(roads, new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getNumber();
                                Integer b = o2.getNumber();
                                return (int)a-(int)b;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "路口降序":
                        Collections.sort(roads, new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getNumber();
                                Integer b = o2.getNumber();
                                return (int)b-(int)a;
                            }
                        });

                        listAdapter.notifyDataSetChanged();
                        break;
                    case "红灯升序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getRed();
                                Integer b = o2.getRed();
                                return a-b;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "红灯降序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getRed();
                                Integer b = o2.getRed();
                                return b-a;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "黄灯升序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getYellow();
                                Integer b = o2.getYellow();
                                return a-b;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "黄灯降序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getYellow();
                                Integer b = o2.getYellow();
                                return b-a;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "绿灯升序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getGreen();
                                Integer b = o2.getGreen();
                                return a-b;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                    case "绿灯降序":
                        Collections.sort(roads,new Comparator<Road>() {
                            @Override
                            public int compare(Road o1, Road o2) {
                                Integer a = o1.getGreen();
                                Integer b = o2.getGreen();
                                return b-a;
                            }
                        });
                        listAdapter.notifyDataSetChanged();
                        break;
                        default:
                            break;
                }
            }
        });
    }


    private void initData(){
        roads.add(new Road(1,9,9,9));
        roads.add(new Road(2,8,8,8));
        roads.add(new Road(3,7,8,7));
    }
}