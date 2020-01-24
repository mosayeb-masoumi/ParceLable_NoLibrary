package com.example.parceable;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    String name;
    int code;

    public Country() {
    }

    public Country(String name, int code) {
        this.name = name;
        this.code = code;
    }

    protected Country(Parcel in) {
        name = in.readString();
        code = in.readInt();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(code);
    }
}
