package com.nfu.usblab.androidroomtest.SQL;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ExpenseDao {

    @Query("select * from " + Expense.TABLE_EXPENSE)
    public List<Expense> getAll();

    @Query("select * from " + Expense.TABLE_EXPENSE + " where price >= :price")
    public List<Expense> queryByPrice(int price);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Expense expense);
}
