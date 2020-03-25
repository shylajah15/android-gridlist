package com.example.apple.gridlistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageAdapter extends BaseAdapter {

    public Context mContext;
    public  int layoutId;
    private final JSONArray cropList;

    public ImageAdapter(Context c, int layoutId, JSONArray cropList){
        mContext = c;
        this.layoutId = layoutId;
        this.cropList = cropList;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

    @Override
    public int getCount() {
//        return mThumbIds.length;
        return this.cropList.length();
    }

    @Override
    public Object getItem(int position) {
        JSONObject curCrop = new JSONObject();
        try {
            curCrop = this.cropList.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return curCrop;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
        View row  = convertView;
        RecordHolder holder =  null;
        Log.i("crop","position "+position);

        JSONObject currentCrop = (JSONObject) getItem(position);
        if(convertView == null){
            LayoutInflater inflater =((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutId,parent,false);

            holder = new RecordHolder();
            holder.textView = (TextView) row.findViewById(R.id.item_text);
            holder.imageView = (ImageView) row.findViewById(R.id.item_image);
            holder.imageView.setBackgroundResource(R.drawable.border_image);
            row.setTag(holder);
        }
        else{
            holder = (RecordHolder) row.getTag();
        }

        Log.i("crop","currentCrop "+currentCrop);
        try {
           new GetImageUrl(holder.imageView).execute( currentCrop.getString("prod_thumb"));
            Log.i("crop","currentCrop "+ currentCrop.getString("prod_name"));
            holder.textView.setText(currentCrop.getString("prod_name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return row;
    }

    static class RecordHolder{
        TextView textView;
        ImageView imageView;
    }
}
