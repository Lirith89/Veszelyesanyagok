package com.a1989gmail.er.poor.veszelyesanyagok;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {


    //adatbázis verziója
    private static final int DATABASE_VERSION = 1;
    // adatbázis file neve
    public static final String DATABASE_NAME = "veszelyesanyagok.sql";
    // tábla neve
    public static final String TABLE_NAME = "substances";
    private static String DB_PATH = "";
    private SQLiteDatabase mDataBase;
    private final Context mContext;


    /*//a táblában található oszlopok
    public static final String id = "ID";
    public static final String COL_2 = "EricardSubkey";
    public static final String COL_3 = "Anyagnev";
    public static final String COL_4 = "UnSzam";
    public static final String COL_5 = "VeszelyJel";
    public static final String COL_6 = "AdrVeszelyessegiBarcaSzama";
    public static final String COL_7 = "AdrVeszelyessegiOsztaly";
    public static final String COL_8 = "EricardsHivatkozasiSzam";
    public static final String COL_9 = "InformacioVeszhelyzetbenValoBeavatkozashoz";
    public static final String COL_10 = "JellemzoTulajdonsagai";
    public static final String COL_11 = "Veszelyek";
    public static final String COL_12 = "Szemelyvedelem";
    public static final String COL_13 = "BeavatkozasiTevekenyseg";
    public static final String COL_14 = "Elsosegelynyujtas";
    public static final String COL_15 = "AlapvetoOvintezkedesekOsszegyujteshez";
    public static final String COL_16 = "OvintezkedesekABeavatkozasUtan";
*/
    public static final String ID = "id";
    public static final String EricardSubkey = "ericard_subkey";
    public static final String Anyagnev = "anyagnev";
    public static final String UnSzam = "un_szam";
    public static final String VeszelyJel = "veszely_jel";
    public static final String AdrVeszelyessegiBarcaSzama = "adr_veszelyessegi_barca_szama";
    public static final String AdrVeszelyessegiOsztaly = "adr_veszelyessegi_osztaly";
    public static final String EricardsHivatkozasiSzam = "ericards_hivatkozasi_szam";
    public static final String InformacioVeszhelyzetbenValoBeavatkozashoz = "informacio_veszhelyzetben_valo_beavatkozashoz";
    public static final String JellemzoTulajdonsagai = "jellemzo_tulajdonsagai";
    public static final String Veszelyek = "veszelyek";
    public static final String Szemelyvedelem = "szemelyvedelem";
    public static final String BeavatkozasiTevekenyseg = "beavatkozasi_tevekenyseg";
    public static final String Elsosegelynyujtas = "elsosegelynyujtas";
    public static final String AlapvetoOvintezkedesekOsszegyujteshez = "alapveto_ovintezkedesek_osszegyujteshez";
    public static final String OvintezkedesekABeavatkozasUtan = "ovintezkedesek_a_beavatkozas_utan";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        boolean mDataBaseExist = checkDataBase();
        /*String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY, "+EricardSubkey+" TEXT, "+Anyagnev+" TEXT, "+UnSzam+" TEXT, "+VeszelyJel+" TEXT, "+AdrVeszelyessegiBarcaSzama+" TEXT, "+AdrVeszelyessegiOsztaly+" TEXT, "+EricardsHivatkozasiSzam+" TEXT, "+InformacioVeszhelyzetbenValoBeavatkozashoz+" TEXT, "+JellemzoTulajdonsagai+" TEXT, "+Veszelyek+" TEXT, "+Szemelyvedelem+" TEXT, "+BeavatkozasiTevekenyseg+" TEXT, "+Elsosegelynyujtas+" TEXT, "+AlapvetoOvintezkedesekOsszegyujteshez+" TEXT, "+OvintezkedesekABeavatkozasUtan+" TEXT)";
        db.execSQL(CREATE_TABLE);*/
        if(!mDataBaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                //Copy the database from assests
                copyDataBase();
                Log.e("DbHelper", "createDatabase database created");
            }catch (IOException mIOException){
                throw new Error("ErrorCopyingDataBase");
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DATABASE_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close()
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DATABASE_NAME);
        String outFileName = DB_PATH + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = " SELECT " + "un_szam" + " FROM "+ "substances";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    //innen kezdődik a stackoverflow-s kód
    // Database Name
    //static String DATABASE_NAME="define_products_database";
    // Labels table name
    //public static final String TABLE_DEFINE_PRODUCT_NAME="define_products";
    // Labels Table Columns names
    //public static final String KEY_PRODUCTS_NAME="product_name";
    //public static final String KEY_PRODUCTS_DETAILS="products_details";
    //public static final String KEY_ID="id";
    //public DbHelper(Context context) {
       // super(context, DATABASE_NAME, null, 1);
    //}
    //@Override
    //public void onCreate(SQLiteDatabase db) {
    //    String CREATE_TABLE="CREATE TABLE "+TABLE_DEFINE_PRODUCT_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_PRODUCTS_NAME+" TEXT, "+KEY_PRODUCTS_DETAILS+" TEXT)";
    //    db.execSQL(CREATE_TABLE);
    //}

    //@Override
    //public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //    db.execSQL("DROP TABLE IF EXISTS "+TABLE_DEFINE_PRODUCT_NAME);
     //   onCreate(db);
    //}


    /**
     * Getting all labels
     * returns list of labels
     * */

    /*public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = " SELECT " + KEY_PRODUCTS_NAME + " FROM "+ TABLE_DEFINE_PRODUCT_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    //EZ A MÁSIK SRÁC KÓDJA, AKI SZERINT EZZEL FOG MŰKÖDNI
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = " SELECT " + KEY_PRODUCTS_NAME + " FROM "+ TABLE_DEFINE_PRODUCT_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }*/
    }