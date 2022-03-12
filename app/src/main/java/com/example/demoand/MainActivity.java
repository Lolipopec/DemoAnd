package com.example.demoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    SimpleAdapter ad;
    public void GetData(View v)
    {
        ListView lstv =(ListView) findViewById(R.id.lw1);

        List<Map<String,String>> Mydatalist = null;
        ListItem Mydata = new ListItem();
        Mydatalist = Mydata.getlist();

        String[] Fromw = {"Prod","Name","Des","Col"};
        int[] Tow = {R.id.Prod,R.id.Name,R.id.Des,R.id.Col};
        ad = new SimpleAdapter(MainActivity.this,Mydatalist,R.layout.listlayouttemplate,Fromw,Tow);
        lstv.setAdapter(ad);
    }
}