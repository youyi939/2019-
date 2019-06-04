package com.lenovo.smarttraffic.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtil {
    private String name;
    private Context context;

    public ShareUtil(String name, Context context) {
        this.name = name;
        this.context = context;
    }

    public static ShareUtil instance(String name,Context context){
        return new ShareUtil(name,context);
    }

    public <V> void saveValue(String key,V value){
        SharedPreferences pref = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (value instanceof String){
            editor.putString(key,(String) value);
        }else if (value instanceof Long){
            editor.putLong(key,(Long) value);
        }else if (value instanceof Integer){
            editor.putInt(key,(Integer) value);
        }else if (value instanceof Float){
            editor.putFloat(key,(Float)value);
        }else if (value instanceof Boolean){
            editor.putBoolean(key,(Boolean) value);
        }
        editor.commit();
    }

    public <V> V getValue(String key,V defautValue){
        SharedPreferences pref = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        Object value = defautValue;
        if (defautValue instanceof String){
            value = pref.getString(key,(String) defautValue);
        }else if (defautValue instanceof  Boolean){
            value = pref.getBoolean(key,(Boolean) defautValue);
        }

        return (V) value;
    }

    public void clearData(){
        SharedPreferences.Editor editor = context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }


}
