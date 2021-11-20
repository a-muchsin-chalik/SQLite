package com.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView nim, nama, alamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery ("SELECT * FROM mahasiswa WHERE nim = '" +
                getIntent().getStringExtra("nim")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nim.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            alamat.setText(cursor.getString(2).toString());
        }
    }
}