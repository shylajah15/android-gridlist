package com.example.apple.gridlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    public Context mContext;
    public  int listRowId;

    public ListViewAdapter(Context context, int Id) {
        mContext = context;
        listRowId = Id;
    }

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
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row  = convertView;
        ListViewAdapter.RecordHolder holder =  null;

        if(convertView == null){
            LayoutInflater inflater =((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(listRowId,parent,false);

            holder = new RecordHolder();
            holder.textView1 = (TextView) row.findViewById(R.id.textHeading);
            holder.textView2 = (TextView) row.findViewById(R.id.textView2);
            holder.textView3 = (TextView) row.findViewById(R.id.textView3);
            holder.imageView1 = (ImageView) row.findViewById(R.id.imageView);
            holder.imageView1.setBackgroundResource(R.drawable.border_round);
            holder.imageView2 = (ImageView) row.findViewById(R.id.imageView2);

            row.setTag(holder);
        }
        else{
            holder = (ListViewAdapter.RecordHolder) row.getTag();
        }

        holder.imageView1.setImageResource(mThumbIds[position]);
        return row;
    }
    static class RecordHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        ImageView imageView1;
        ImageView imageView2;
    }
}
