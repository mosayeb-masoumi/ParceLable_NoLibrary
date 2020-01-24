package com.example.parceable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

//3                //2
public class Student implements Parcelable {

    //1
    String name;
    String family;
    int age;
    Object country;  // to send object
    ArrayList teacherList ;  // to send arraylist



    //2
    public Student(String name, String family, int age, Country country, ArrayList<Teacher> teacherList) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.country = country;  // to send object
        this.teacherList = teacherList;  // to send arraylist
    }

    public Student(Parcel in) {
        name = in.readString();
        family = in.readString();
        age = in.readInt();
        country = in.readValue(Country.class.getClassLoader());  // to send object
        teacherList = in.readArrayList(Teacher.class.getClassLoader());  // to send arraylist
    }





    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    // at the end gettre setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public static Creator<Student> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(family);
        parcel.writeInt(age);
        parcel.writeValue(country);            // to pass object
        parcel.writeList(teacherList);  // to pass arraylist
    }
}
