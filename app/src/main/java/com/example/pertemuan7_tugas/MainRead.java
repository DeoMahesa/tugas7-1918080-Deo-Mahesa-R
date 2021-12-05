package com.example.pertemuan7_tugas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Helm> ListHelm = new ArrayList<Helm>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListHelm);
        mListView = (ListView) findViewById(R.id.list_helm);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListHelm.clear();
        List<Helm> helm = db.ReadHelm();
        for (Helm hlm : helm) {
            Helm daftar = new Helm();
            daftar.set_id(hlm.get_id());
            daftar.set_nama(hlm.get_nama());
            daftar.set_brand(hlm.get_brand());
            ListHelm.add(daftar);
            if ((ListHelm.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Helm detailMhs = (Helm)o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama();
        String Sbrand = detailMhs.get_brand();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ibrand", Sbrand);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListHelm.clear();
        mListView.setAdapter(adapter_off);
        List<Helm> helm = db.ReadHelm();
        for (Helm mhs : helm) {
            Helm daftar = new Helm();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_brand(mhs.get_brand());
            ListHelm.add(daftar);
            if ((ListHelm.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}