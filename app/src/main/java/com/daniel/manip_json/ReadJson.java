package com.daniel.manip_json;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;


public class ReadJson {

    // Read the json file and convert it to a java object.
    public static JSONObject read(Context context) throws IOException,JSONException {

        // Read content of json
        String jsonText = readText(context, R.raw.json);

        JSONObject jsonRoot = new JSONObject(jsonText);

        return jsonRoot;
    }



    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}
