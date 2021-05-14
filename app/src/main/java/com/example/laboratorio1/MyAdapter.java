package com.example.laboratorio1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;

    public MyAdapter(Context context, int layout, List<String> nombres) {
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //View v = convertView;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            //convertView = layoutInflater.inflate(R.layout.list_item, null);
            convertView = layoutInflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.nombreTextView = convertView.findViewById(R.id.textViewGrid);
            convertView.setTag(holder);
            //v = layoutInflater.inflate(R.layout.list_item, null);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String nombreActual = nombres.get(position);
        holder.nombreTextView.setText(nombreActual);

        return convertView;
    }

    static class ViewHolder {
        public TextView nombreTextView;
    }

}
