package com.nfu.usblab.androidroomtest.SQL;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Expense.class}, version = 1)
public abstract class ExpenseDatabase extends RoomDatabase {
    public static final String DBNAME = "Expenses";
    public static ExpenseDatabase INSTANCE;

    public abstract ExpenseDao expenseDao();

    public static ExpenseDatabase getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, ExpenseDatabase.class, DBNAME).build();
        }

        return INSTANCE;
    }

    public static void destoryInstance() {
        if (INSTANCE != null)
            INSTANCE.close();
        INSTANCE = null;
    }
}
