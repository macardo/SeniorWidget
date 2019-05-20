package com.macardo.seniorwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] data = {"文件1","文件2","文件3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
/*        getMenuInflater().inflate(R.menu.context_menu,menu);*/
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");
        menu.add(1,3,1,"剪切");
        menu.add(1,4,1,"重命名");
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this,"点击了复制",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,"粘贴",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,"剪切",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this,"重命名",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
