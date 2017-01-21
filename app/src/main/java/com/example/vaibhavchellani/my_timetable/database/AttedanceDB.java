package com.example.vaibhavchellani.my_timetable.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vaibhavchellani on 1/17/17.
 */

public class AttedanceDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "attendanceDB.db";
    private static final int DATABASE_VERSION=1;
    ContentValues values=new ContentValues();

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAY="DAY";
    public static final String COLUMN_LECTURE1="10:30 AM";
    public static final String COLUMN_LECTURE2="11:25 AM";
    public static final String COLUMN_LECTURE3="12:20 PM";
    public static final String COLUMN_LECTURE4="12:50 PM";
    public static final String COLUMN_LECTURE5="1:45 PM";
    public static final String COLUMN_LECTURE6="2:40 AM";
    public static final String COLUMN_LECTURE7="3:35 AM";
    public static final String COLUMN_LECTURE8="4:30 AM";
    public static final String COLUMN_LECTURE9="4:40 AM";
    public static final String COLUMN_LECTURE10="5:35 AM";


    public static final String TABLE_CHECK_CLASS = "check_class";
    public static final String TABLE_CLASS_DETAIL = "class_detail";

    public AttedanceDB(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_STRING="CREATE TABLE " + TABLE_CHECK_CLASS + "("
                +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_DAY + " TEXT, "
                +COLUMN_LECTURE1 +" TEXT, "
                +COLUMN_LECTURE2 +" TEXT, "
                +COLUMN_LECTURE3 + " TEXT, "
                +COLUMN_LECTURE4 +  " TEXT, "
                +COLUMN_LECTURE5 + " TEXT, "
                +COLUMN_LECTURE6 + " TEXT, "
                +COLUMN_LECTURE7 + " TEXT, "
                +COLUMN_LECTURE8 + " TEXT, "
                +COLUMN_LECTURE9 + " TEXT, "
                +COLUMN_LECTURE10 + " TEXT "
                + ");";
        Log.d(" ", "QUERY IS "+ SQL_CREATE_STRING);
        sqLiteDatabase.execSQL(SQL_CREATE_STRING);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CHECK_CLASS);
        onCreate(sqLiteDatabase);

    }
    public void addrow_check_class(){
        SQLiteDatabase db=getWritableDatabase();
        values.put(COLUMN_DAY,"MONDAY");
        values.put(COLUMN_LECTURE1,"blah 1");
        db.insert(TABLE_CHECK_CLASS,null,values);
        values.put(COLUMN_DAY,"TUESDAY");
        db.insert(TABLE_CHECK_CLASS,null,values);
        values.put(COLUMN_DAY,"WEDNESDAY");
        db.insert(TABLE_CHECK_CLASS,null,values);
        values.put(COLUMN_DAY,"THURSDAY");
        db.insert(TABLE_CHECK_CLASS,null,values);

        /*  values.put(COLUMN_DAY,"FRIDAY");
        values.put(COLUMN_LECTURE1,"blah 1");
        values.put(COLUMN_LECTURE2,"blah 2");
        values.put(COLUMN_LECTURE3,"blah 3");
        values.put(COLUMN_LECTURE4,"blah 4");
        values.put(COLUMN_LECTURE5,"blah 5");
        values.put(COLUMN_LECTURE6,"blah 6");
        values.put(COLUMN_LECTURE7,"blah 7");
        values.put(COLUMN_LECTURE8,"blah 8");
        values.put(COLUMN_LECTURE9,"blah 9");
        values.put(COLUMN_LECTURE10,"blah 10");*/

        db.close();

        Log.d(" ", "addrow_check_class: Succesfully added day");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CHECK_CLASS ;// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex(COLUMN_DAY)) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex(COLUMN_DAY));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    /*public String getTableAsString(String tableName) {
        SQLiteDatabase db=getWritableDatabase();
        String TAG=TABLE_CHECK_CLASS;
        Log.d(TAG, "getTableAsString called");
        String tableString = "";
        Cursor allRows  = db.rawQuery("SELECT * FROM " + tableName, null);
        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name: columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }
        return tableString;
    }*/
    public void deleteTable(String TABLE_NAME){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME +  " WHERE 1 ");
    }

    public void makeDatabase_one(){
        values.put(COLUMN_DAY,"MONDAY");
        values.put(COLUMN_DAY,"TUESDAY");
        values.put(COLUMN_DAY,"WEDNESDAY");
        values.put(COLUMN_DAY,"THURSDAY");
        values.put(COLUMN_DAY,"FRIDAY");
        values.put(COLUMN_LECTURE1,"blah 1");
        values.put(COLUMN_LECTURE2,"blah 2");
        values.put(COLUMN_LECTURE3,"blah 3");
        values.put(COLUMN_LECTURE4,"blah 4");
        values.put(COLUMN_LECTURE5,"blah 5");
        values.put(COLUMN_LECTURE6,"blah 6");
        values.put(COLUMN_LECTURE7,"blah 7");
        values.put(COLUMN_LECTURE8,"blah 8");
        values.put(COLUMN_LECTURE9,"blah 9");
        values.put(COLUMN_LECTURE10,"blah 10");
    }
    /*
    public class TestProjectActivity extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            SQLiteDatabase db;
            db = openOrCreateDatabase( "Temp.db"        , SQLiteDatabase.CREATE_IF_NECESSARY        , null          );
            try {
                final String CREATE_TABLE_CONTAIN = "CREATE TABLE IF NOT EXISTS tbl_Contain ("
                        + "ID INTEGER primary key AUTOINCREMENT,"
                        + "DESCRIPTION TEXT,"
                        + "expirydate DATETIME,"
                        + "AMOUNT TEXT,"
                        + "TRNS TEXT," + "isdefault TEXT);";
                db.execSQL(CREATE_TABLE_CONTAIN);
                Toast.makeText(TestProjectActivity.this, "table created ", Toast.LENGTH_LONG).show();
                String sql =
                        "INSERT or replace INTO tbl_Contain (DESCRIPTION, expirydate, AMOUNT, TRNS,isdefault) VALUES('this is','03/04/2005','5000','tran','y')" ;
                db.execSQL(sql);
            }
            catch (Exception e) {
                Toast.makeText(TestProjectActivity.this, "ERROR "+e.toString(), Toast.LENGTH_LONG).show();
            }}}*/
}