package com.example.listview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        TextView tvStudentName = findViewById(R.id.tvStudentName);
        TextView tvStudentDetails = findViewById(R.id.tvStudentDetails);

        Intent intent = getIntent();
        String name = intent.getStringExtra("STUDENT_NAME");
        String details = intent.getStringExtra("STUDENT_DETAILS");

        tvStudentName.setText(name);
        tvStudentDetails.setText(details);
    }
}
