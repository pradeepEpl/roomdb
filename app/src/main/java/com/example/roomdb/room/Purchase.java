package com.example.roomdb.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Purchase {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "km")
    private String km;

    @ColumnInfo(name = "rupee")
    private int rupee;

    @ColumnInfo(name = "litre")
    private float litre;

    @ColumnInfo(name = "date")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getRupee() {
        return rupee;
    }

    public void setRupee(int rupee) {
        this.rupee = rupee;
    }

    public float getLitre() {
        return litre;
    }

    public void setLitre(float litre) {
        this.litre = litre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", km='" + km + '\'' +
                ", rupee=" + rupee +
                ", litre=" + litre +
                ", date='" + date + '\'' +
                '}';
    }
}
