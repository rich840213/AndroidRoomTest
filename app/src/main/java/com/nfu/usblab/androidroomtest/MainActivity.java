package com.nfu.usblab.androidroomtest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.nfu.usblab.androidroomtest.SQL.Expense;
import com.nfu.usblab.androidroomtest.SQL.ExpenseDao;
import com.nfu.usblab.androidroomtest.SQL.ExpenseDatabase;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ExpenseDao mExpenseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExpenseDao = ExpenseDatabase.getDataBase(MainActivity.this).expenseDao();
    }

    public void insertData(View view) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mExpenseDao.insert(new Expense("2017-12-27", "book", "android 8.1", 249));

                List<Expense> expenses = mExpenseDao.getAll();
                assert expenses.get(0).getPrice() == 249;
                System.out.println("insert OK: " + expenses.get(0).getPrice());
            }
        });
    }

    public void queryByPrice(View view) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Expense> expenses = mExpenseDao.queryByPrice(200);
                assert expenses.size() > 0;
                for (int i = 0; i < expenses.size(); i++) {
                    System.out.println(expenses.get(i).getUid());
                    System.out.println(expenses.get(i).getCdate());
                    System.out.println(expenses.get(i).getItem());
                    System.out.println(expenses.get(i).getInfo());
                    System.out.println(expenses.get(i).getPrice());
                }
            }
        });
    }
}
