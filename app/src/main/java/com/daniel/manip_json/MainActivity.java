package com.daniel.manip_json;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            this.operation();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private  void operation() throws IOException, JSONException {
        TextView output = (TextView)findViewById(R.id.output);
        //String jsonText = readText()
        JSONObject data = ReadJson.read(MainActivity.this);
        JSONArray donnees = data.getJSONArray("data");
        String data1 = data.getString("title");
        String[]metadata = new String[donnees.length()];
        for(int i=0; i<donnees.length(); i++){
            metadata[i]=donnees.getJSONObject(i).getString("room");
        }
        String json = null;
        InputStream jsonfile = null;
        try{
            jsonfile = getAssets().open("json.json");
            int size = jsonfile.available();
            byte[] buffer = new byte[size];
            jsonfile.read(buffer);
            jsonfile.close();
            json = new String(buffer, "UTF-8");
            output.setText(metadata[0].toString());
            String[] tableau = new String[]{
                    "Un" ,"Deux" ,"Trois" ,"Quatre"
                    ,"Cinq" ,"Six" ,"Sept" ,"Huit"
                    ,"Neuf" ,"Dix"};
            JsonAdapter adapter = new JsonAdapter(MainActivity.this, donnees);
            ListView l = (ListView)findViewById(R.id.liste);
            l.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}