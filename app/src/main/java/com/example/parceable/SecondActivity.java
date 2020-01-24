package com.example.parceable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();

        Student students = intent.getParcelableExtra("Data");

        String name = students.getName();
        String family = students.getFamily();
        int age = students.getAge();


  // down is correct
//        Country country = new Country();
//        country = (Country) students.getCountry();

        Object country = new Country();
        country = students.getCountry();

        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.addAll(students.getTeacherList());

        Toast.makeText(this, ""+name+family+age, Toast.LENGTH_SHORT).show();
    }
}
