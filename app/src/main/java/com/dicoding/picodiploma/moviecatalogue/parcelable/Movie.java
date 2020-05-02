package com.dicoding.picodiploma.moviecatalogue.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable { //Implementasikan parcelable di kelas Movie.
    private int photo;
    private String name;
    private String description;
    private String release;



    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Movie() {

    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photo);
        parcel.writeString(name);
        parcel.writeString(release);
        parcel.writeString(description);

    }

    protected Movie(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        release = in.readString();
        description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}