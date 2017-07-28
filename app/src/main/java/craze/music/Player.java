package craze.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Player extends AppCompatActivity implements View.OnClickListener {
     TextView songView;
    Button stop;
    Button  play;
   String songTittle;
    void initViews() {

        songView = (TextView) findViewById(R.id.SongView);
        play = (Button) findViewById(R.id.Play);
        stop = (Button) findViewById(R.id.Stop);
        ///
         play.setOnClickListener(this);
         stop.setOnClickListener(this);

        Intent rcv=getIntent();
        songTittle=rcv.getStringExtra("s");
        songView.setText(songTittle);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initViews();
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==(R.id.Play)){
       // Toast.makeText(this,"Playing"+songTittle,Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Player.this,MusicService.class);
            i.putExtra("s",songTittle);
            startService(i);
        }
        else {
            //Toast.makeText(this,"Stop"+songTittle,Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Player.this,MusicService.class);
            stopService(i);
        }


    }


    }

