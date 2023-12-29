package com.example.listview;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
            holder = new ViewHolder();
            holder.tvStudentName = convertView.findViewById(R.id.tvStudentName);
            holder.ivStudentPhoto = convertView.findViewById(R.id.ivStudentPhoto);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the student at the current position
        Student student = getItem(position);

        // Set the text for the TextView using the student's name
        if (student != null) {
            holder.tvStudentName.setText(student.getName());
            holder.ivStudentPhoto.setImageResource(student.getPhotoResourceId());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tvStudentName;
        ImageView ivStudentPhoto;
        // Other views can be added here
    }
}

