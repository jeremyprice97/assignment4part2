package cmsc355.assignmnet4part2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tenni_000 on 4/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Pairs.db";
    private static final String TABLE_NAME = "Pairs";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String COLUMN_ANTONYM = "antonym";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create stable Pairs(id integer primary key not null auto_increment, " +
            "synonym test not null, antonym text not null)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(Pairs p) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SYNONYM, p.getSynonym());
        values.put(COLUMN_ANTONYM, p.getAntonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchSynonym(String synonym) {
        db = this.getReadableDatabase();
        String query = "select synonym, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {

            do{
                a = cursor.getString(0);

                if(a.equals(synonym)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXITS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
