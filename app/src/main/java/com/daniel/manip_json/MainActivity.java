package com.daniel.manip_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.operation();
    }
    private  void operation(){
        TextView output = (TextView)findViewById(R.id.output);
        String json = null;
        InputStream jsonfile = null;
        try{
            jsonfile = getAssets().open("json.json");
            int size = jsonfile.available();
            byte[] buffer = new byte[size];
            jsonfile.read(buffer);
            jsonfile.close();
            json = new String(buffer, "UTF-8");
            output.setText(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}