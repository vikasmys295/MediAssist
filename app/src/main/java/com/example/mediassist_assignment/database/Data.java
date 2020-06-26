package com.example.mediassist_assignment.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userData")
public class Data {

    @PrimaryKey
    @NonNull
    public String firstname;

    @NonNull
    public String lastname;

    @NonNull
    public String gender;

    public Data(@NonNull String firstname, @NonNull String lastname, @NonNull String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    @NonNull
    public String getGender() {
        return gender;
    }
}
