package com.example.apple.gridlistview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private String[] mStage ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        mStage = getResources().getStringArray(R.array.stage);

        ListView listView = findViewById(R.id.listview);

        listView.setAdapter(new ListViewAdapter(this,R.layout.list_row_grid));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "item name"+ position, Toast.LENGTH_SHORT).show();
                showAlertDialog();
            }
        });

    }

    private void showAlertDialog() {
        new DialogView().show(getSupportFragmentManager(),"stageDialog");
    }


}
