package craze.music;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaiify on 7/23/2017.
 */

public class songsAdapter extends ArrayAdapter {
    Context context;
    int resource;
     ArrayList<String>userList;
    public songsAdapter(@NonNull Context context, @LayoutRes int resource,   ArrayList objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        userList=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myview=null;
          myview= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView txtsongs=(TextView)myview.findViewById(R.id.TextSong);
          String songName=userList.get(position);
            txtsongs.setText(songName);

        return myview;
    }
}
