package com.example.pertemuan7_tugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_motorhelm";
    private static final String tb_helm = "tb_helm";
    private static final String tb_helm_id = "id";
    private static final String tb_helm_nama = "nama";
    private static final String tb_helm_brand = "brand";
    private static final String CREATE_TABLE_HELM = "CREATE TABLE " +
            tb_helm +"("
            + tb_helm_id + " INTEGER PRIMARY KEY ,"
            + tb_helm_nama + " TEXT ,"
            + tb_helm_brand + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HELM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateHelm(Helm data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_helm_id, data.get_id());
        values.put(tb_helm_nama, data.get_nama());
        values.put(tb_helm_brand, data.get_brand());
        db.insert(tb_helm, null, values);
        db.close();
    }
    public List<Helm> ReadHelm() {
        List<Helm> listHlm = new ArrayList<Helm>();
        String selectQuery = "SELECT * FROM " + tb_helm;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Helm data = new Helm();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_brand(cursor.getString(2));
                listHlm.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listHlm;
    }
    public int UpdateHelm (Helm data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_helm_nama, data.get_nama());
        values.put(tb_helm_brand, data.get_brand());
        return db.update(tb_helm, values, tb_helm_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteHelm(Helm data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_helm,tb_helm_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
