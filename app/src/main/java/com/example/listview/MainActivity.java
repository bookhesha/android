package com.example.listview;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String studentDetails = "This is a sample detail for the student.";
            String studentName = "Student " + i;
            int photoResourceId = getResources().getIdentifier("student" + i + "_photo", "drawable", getPackageName());
            students.add(new Student(studentName, photoResourceId, studentDetails));
        }

        StudentAdapter adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = students.get(position);
            Intent intent = new Intent(MainActivity.this, StudentDetailsActivity.class);
            intent.putExtra("STUDENT_NAME", selectedStudent.getName());
            intent.putExtra("STUDENT_DETAILS", selectedStudent.getDetails());
            startActivity(intent);
        });
    }
}
