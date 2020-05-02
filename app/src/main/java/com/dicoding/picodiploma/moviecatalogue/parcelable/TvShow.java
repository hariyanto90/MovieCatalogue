package com.dicoding.picodiploma.moviecatalogue.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable { //Implementasikan parcelable di kelas Movie.
    private int shPhoto;
    private String shName;
    private String shDescription;
    private String shRelease;

    public String getRelease() {
        return shRelease;
    }

    public void setRelease(String release) {
        this.shRelease = release;
    }

    public TvShow() {

    }

    public int getPhoto() {
        return shPhoto;
    }

    public void setPhoto(int photo) {
        this.shPhoto = photo;
    }

    public String getName() {
        return shName;
    }

    public void setName(String name) {
        this.shName = name;
    }

    public String getDescription() {
        return shDescription;
    }

    public void setDescription(String description) {
        this.shDescription = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(shPhoto);
        parcel.writeString(shName);
        parcel.writeString(shRelease);
        parcel.writeString(shDescription);

    }

    protected TvShow (Parcel in) {
        shPhoto = in.readInt();
        shName = in.readString();
        shRelease = in.readString();
        shDescription = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}