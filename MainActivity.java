package com.example.youyi.recyclerview2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_up;
    private RecyclerView recyclerView_down;
    private List<String> listUp = new ArrayList<>();
    private List<String> listDown = new ArrayList<>();
    DownAdapter adapter_down;
    UpAdapter upAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_down = findViewById(R.id.recyclerView_down);
        recyclerView_up = findViewById(R.id.recyclerView_up);

        initData();             //初始化数据
        initView();
    }

    public void initView(){
        upAdapter = new UpAdapter(listUp,null,listDown);
        adapter_down = new DownAdapter(listDown,listUp,upAdapter);
        upAdapter.setDownAdapter(adapter_down);
        GridLayoutManager gridLayoutManagerDown2 = new GridLayoutManager(this, 5);
        GridLayoutManager gridLayoutManagerDown = new GridLayoutManager(this, 5);
        recyclerView_up.setLayoutManager(gridLayoutManagerDown2);

        recyclerView_down.setLayoutManager(gridLayoutManagerDown);
        recyclerView_up.setAdapter(upAdapter);
        recyclerView_down.setAdapter(adapter_down);
    }

    public void initUp(){
        GridLayoutManager gridLayoutManagerDown2 = new GridLayoutManager(this, 5);
        upAdapter = new UpAdapter(listUp,adapter_down,listDown);
        recyclerView_up.setLayoutManager(gridLayoutManagerDown2);
        recyclerView_up.setAdapter(upAdapter);

    }

    public void  initData(){
        listDown.add("反浩克");
        listDown.add("浪子");
        listDown.add("MK1");
        listDown.add("鹰眼");
        listDown.add("蜘蛛");
        listUp.add("路人甲");
        listUp.add("炮灰乙");
        listUp.add("流氓丙");
        listUp.add("白痴丁");
    }
}