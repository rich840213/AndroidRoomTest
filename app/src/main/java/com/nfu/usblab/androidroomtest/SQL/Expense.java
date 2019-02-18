package com.nfu.usblab.androidroomtest.SQL;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.nfu.usblab.androidroomtest.SQL.Expense.TABLE_EXPENSE;

@Entity(tableName = TABLE_EXPENSE)
public class Expense {
    public static final String TABLE_EXPENSE = "expense";

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String cdate;
    private String item;
    private String info;
    private int price;

    public Expense() {

    }

    public Expense(String cdate, String item, String info, int price) {
        this.cdate = cdate;
        this.item = item;
        this.info = info;
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
