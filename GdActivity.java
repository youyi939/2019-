package com.lenovo.smarttraffic.ui.activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;
import com.lenovo.smarttraffic.MainActivity;
import com.lenovo.smarttraffic.R;

public class GdActivity extends BaseActivity {
    private AMap aMap;
    private UiSettings uiSettings;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private TextView textView;
    private ImageButton imageMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageButton = findViewById(R.id.cj_coating);
        imageButton2 = findViewById(R.id.cj_return);
        imageMenu = findViewById(R.id.cj_menu);
        textView = findViewById(R.id.cj_txt);


        // 一定要在mapView工作之前设置离线地图位置
        // MapsInitializer.sdcardDir =OffLineMapUtils.getSdCacheDir(this);
        MapView mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        aMap=mapView.getMap();
        uiSettings = aMap.getUiSettings();
        uiSettings.setLogoBottomMargin(100);

        //uiSettings.setZoomControlsEnabled(true);
        //支持所有的手势
        uiSettings.setAllGesturesEnabled(true);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng latlng = new LatLng(39.761, 116.434);

                //文字的位置
//                LatLng latlngT = new LatLng(39.78, 116.434);

                //自定义图片的位置

                LatLng latlng1 = new LatLng(39.661, 116.534);

                MarkerOptions markerOption = new MarkerOptions();
                markerOption.position(latlng).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_one));
                aMap.addMarker(markerOption);
                //添加文字
//        TextOptions textOptions= new TextOptions();
//        textOptions.position(latlngT).text("1");
//        aMap.addText(textOptions);
                //添加图片
                aMap.addMarker(new MarkerOptions().position(latlng1).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_second)));

                textView.setText("1,2,3,4号小车地图标记已完成");
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(GdActivity.this,imageMenu);
                getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                 switch (menuItem.getTitle().toString()){
                    case "卫星视图":
                        aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
                        Toast.makeText(GdActivity.this,"hello",Toast.LENGTH_SHORT).show();
                        break;
                    case "导航视图":
                        aMap.setMapType(AMap.MAP_TYPE_NAVI);
                        break;
                    case "导航视图(Night)":
                        aMap.setMapType(AMap.MAP_TYPE_NIGHT);
                        break;
                    case "正常视图":
                        aMap.setMapType(AMap.MAP_TYPE_NORMAL);
                        break;
                    case "交通视图":
                        aMap.setMapType(AMap.MAP_TYPE_BUS);
                        break;
                    default:
                        break;
                }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_gd;
    }

}