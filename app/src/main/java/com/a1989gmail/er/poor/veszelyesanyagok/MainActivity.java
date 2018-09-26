package com.a1989gmail.er.poor.veszelyesanyagok;

import android.content.Context;
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

import static com.a1989gmail.er.poor.veszelyesanyagok.DbConnect.DATABASE_NAME;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    SearchView searchView;
    Button searchButton;
    //DataAdapter mDbHelper;
    //DbConnect db;
    DbConnect dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "Elindult");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //init();
        //db = new DbHelper(this);
        //db.getReadableDatabase();
        //Log.wtf("MainActivity", "a meghívásokon túljutott");
        Log.i("mainactivity", "dbc meghívása indul");
        dbc = new DbConnect(this);
        try {
            dbc.onCreate(this);

        }
        Log.i("mainactivity", "dbc meghívása sikeres");
        //adatLekerdezes();
        dbc.insertData();
        spinner=(Spinner)findViewById(R.id.spinner);
        loadSpinnerData();
        Log.wtf("MainActivity", "végig ért");
    }

    private void loadSpinnerData() {
        // database handler
        Log.wtf("MainActivity", "belép a feltöltésbe");
        dbc = new DbConnect(getApplicationContext());
        try {
            SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_NAME, null, Context.MODE_PRIVATE);
        }catch (Exception e){
            e.printStackTrace();
        }
        // Spinner Drop down elements
        List<String> lables = dbc.getAllLabels();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void searchClicked (View searchView){
        Log.wtf("MainActivity","Button press!");
    }

    /*try {
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_NAME, null, Context.MODE_PRIVATE);
    }catch (Exception e){
        e.printStackTrace();
    }*/

    //TODO: adatlekérdezést felvenni
    //ADAT LEKÉRDEZÉS

    /*public Cursor adatLekerdezes()
    {
        Log.i("MainActivity","belépünk az adatlekérdezésbe");
        SQLiteDatabase db = dbc.getReadableDatabase();
        Log.i("MainActivity","sqldb kész ");
        Cursor c = db.rawQuery("SELECT un_szam FROM substances",null);
        Log.i("MainActivity"," az query ok");
        int unszamIndex = c.getColumnIndex(COL_4);
        Log.i("MainActivity"," az indexkészítés ok ");
        c.moveToFirst();
        Log.i("MainActivity"," az mozgás vissza ok ");
        while (c != null){
            Log.i(COL_4, c.getString(unszamIndex));
            c.moveToNext();
        }Log.i("MainActivity"," az while ok");
        return c;
    }*/
}
