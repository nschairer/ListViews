package com.noahschairer.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NoahSchairer on 7/16/18.
 */

public class ListAdapter extends BaseAdapter {

    //Things to use
    private ArrayList<String> dataSource;
    private LayoutInflater inflater;

    //Not necessary for now but adding a Context for future methods is helpful
    private Context context;

    //constructor
    public ListAdapter(Context context, ArrayList<String> data) {
        context = context;
        dataSource = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    //Required Methods


    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Adding a ViewHolder class helps with smooth scrolling by storing it at each list item
    static class ViewHolder {
        TextView mainTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mainTextView = convertView.findViewById(R.id.list_item_textview);
            //This stores a view holder as the generated views tag
            convertView.setTag(viewHolder);
        } else {
            //retrieve the stored view holder if we have already scrolled/generated the view
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TextView mainTextView = viewHolder.mainTextView;
        //we use the position of the view to find the correct item in the datasource
        mainTextView.setText(dataSource.get(position));

        return convertView;
    }
}
