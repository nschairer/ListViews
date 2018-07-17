package com.noahschairer.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //reference to our list view
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect to the listview by id
        listView = findViewById(R.id.list_view);
        //call setup function
        setUpListView();
    }

    //function to setup list view and datasource
    private void setUpListView() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Detroit");
        data.add("New York");
        data.add("Chicago");
        data.add("Baltimore");
        data.add("Seattle");
        data.add("Naples");
        data.add("Miami");
        data.add("Houston");
        data.add("Boulder");
        data.add("Denver");
        //instantiate our adapter
        ListAdapter adapter = new ListAdapter(this, data);
        //set the adapter for the listview
        listView.setAdapter(adapter);
    }
}

//Ask any questions in the comments about features you would like to see a video about such as onclicklisteners
//expandable listviews etc.

//thanks for watching
