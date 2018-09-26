package com.a1989gmail.er.poor.veszelyesanyagok;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataAdapter {

    protected static final String TAG = "DataAdapter";
    private final Context mContext;
    private SQLiteDatabase db;
    private DbConnect dbc;

    public DataAdapter(Context context)
    {
        this.mContext = context;
        dbc = new DbConnect(mContext);
    }

   /* public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDatabase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }*/

   /* public DataAdapter open() throws SQLException
    {
        try
        {
            db.openDataBase();
            db.close();
            mDb = db.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }*/

    public void close()
    {
        dbc.close();
    }

    public Cursor getTestData()
    {
        try
        {
            String sql ="SELECT * FROM myTable";

            Cursor mCur = db.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            return mCur;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

}
