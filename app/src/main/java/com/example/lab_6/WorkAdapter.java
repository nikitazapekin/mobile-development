package com.example.lab_6;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WorkAdapter extends ArrayAdapter<Work> {

    public WorkAdapter(Context context, List<Work> works) {
        super(context, 0, works);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Work work = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.work_item, parent, false);
        }

        TextView titleView = convertView.findViewById(R.id.title);
        TextView dateView = convertView.findViewById(R.id.releaseDate);

        titleView.setText(work.getTitle());
        dateView.setText(work.getReleaseDate());

        return convertView;
    }
}


/*
package com.example.lab_6;


public class ListView {
}
*/