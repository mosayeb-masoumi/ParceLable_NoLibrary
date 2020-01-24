package com.example.parceable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;

    Student students;
    ArrayList<Teacher> teacherList;
    Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.E_btn);

        country = new Country("iran",98);


        teacherList = new ArrayList<>();
        teacherList.add(new Teacher("reza","rezai",25));
        teacherList.add(new Teacher("iman","imani",36));
        teacherList.add(new Teacher("milad","miladi",45));
        teacherList.add(new Teacher("hassan","hassani",50));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                students =new Student("reza","rezai",25,country,teacherList);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Data", students);
                startActivity(intent);

            }
        });

    }
}
