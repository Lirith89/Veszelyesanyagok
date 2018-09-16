package com.a1989gmail.er.poor.veszelyesanyagok;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.List;

import static com.a1989gmail.er.poor.veszelyesanyagok.DbHelper.DATABASE_NAME;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    SearchView searchView;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "Elindult");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataAdapter mDbHelper = new DataAdapter();
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor testdata = mDbHelper.getTestData();

        mDbHelper.close();
        //DbHelper db = new DbHelper(this);
        spinner=(Spinner)findViewById(R.id.spinner);
        loadSpinnerData();
        Log.d("MainActivity", "onCreate fut");
    }

    private void loadSpinnerData() {
        // database handler
        DbHelper db = new DbHelper(getApplicationContext());
        try {
            SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_NAME, null, Context.MODE_PRIVATE);
        }catch (Exception e){
            e.printStackTrace();
        }
        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void searchClicked (View searchView){
        Log.i("MainActivity","Button press!");
    }

    /*try {
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_NAME, null, Context.MODE_PRIVATE);
    }catch (Exception e){
        e.printStackTrace();
    }*/


    /*public Cursor adatLekerdezes()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;

    }*/


}
