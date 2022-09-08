package com.daniel.manip_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonAdapter extends BaseAdapter {
    LayoutInflater inflater;
    JSONArray data;
    JsonAdapter(Context context, JSONArray data)
    {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.length();
    }

    @Override
    public Object getItem(int i) {
        try {
             data.getJSONObject(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adaptateur, null);
        TextView t1 = (TextView)view.findViewById(R.id.textView2);
        TextView t2 = (TextView)view.findViewById(R.id.textView3);
        TextView t3 = (TextView)view.findViewById(R.id.textView4);
        try {
            t1.setText("subject : "+data.getJSONObject(i).getString("subject"));
            t2.setText("room: "+data.getJSONObject(i).getString("room"));
            t3.setText("uid: "+ data.getJSONObject(i).getString("uid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}
