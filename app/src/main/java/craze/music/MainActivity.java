package craze.music;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    songsAdapter adapter;
    ArrayList<String> userList;

    void readSdCard() {
        userList = new ArrayList<>();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(path);

        String[] fileName = file.list();
        if (fileName != null) {
            for (String s : fileName) {
                if (s.endsWith(".mp3")) {
                    userList.add(s);
                }

            }
        }
    }

    void initAdapter() {
        adapter = new songsAdapter(this, R.layout.listitems, userList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(ItemClickListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSdCard();
        listView = (ListView) findViewById(R.id.listView);
        initAdapter();


    }

    AdapterView.OnItemClickListener ItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            String Songsname = userList.get(position);
          // Toast.makeText(MainActivity.this, "You Clicked:" + Songsname, Toast.LENGTH_SHORT).show();

            Intent i=new Intent(MainActivity.this,Player.class);
            i.putExtra("s",Songsname);
            startActivity(i);


        }
    };
}




    
