package com.example.parceable;

import android.os.Parcel;
import android.os.Parcelable;

public class Teacher implements Parcelable {

    String name ;
    String family ;
    int age ;

    public Teacher(String name, String family, int age) {
        this.name = name;
        this.family = family;
        this.age = age;
    }

    protected Teacher(Parcel in) {
        name = in.readString();
        family = in.readString();
        age = in.readInt();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(family);
        parcel.writeInt(age);
    }
}
