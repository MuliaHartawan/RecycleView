package com.example.pijee.mysubmission.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Anggota implements Parcelable {

    private String nama;
    private String biodata;
    private int picture;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.biodata);
        dest.writeInt(this.picture);
    }
    public Anggota() {
    }

    protected Anggota(Parcel in) {
        this.nama = in.readString();
        this.biodata = in.readString();
        this.picture = in.readInt();
    }

    public static final Creator<Anggota> CREATOR = new Creator<Anggota>() {
        @Override
        public Anggota createFromParcel(Parcel source) {
            return new Anggota(source);
        }

        @Override
        public Anggota[] newArray(int size) {
            return new Anggota[size];
        }
    };
}