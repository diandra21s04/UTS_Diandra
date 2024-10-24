package com.masayu.uts_diandra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variabel Pendukung
    private TextView Hasil;
    private EditText Masukan;
    private Button Eksekusi;

    //Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;

    //Digunakan Untuk Konfigurasi
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukan=(EditText)findViewById(R.id.input);
        Hasil=(TextView)findViewById(R.id.output);
        Eksekusi=(Button)findViewById(R.id.save);

        //Membuat File BAru Beserta Modifiernya
        preferences=getSharedPreferences("Belajar_SharedPreferences", Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData(){
        //Mendapatkan Input dari user
        String getKonten=Masukan.getText().toString();

        //Digunakan Untuk Pengaturan Konfigurasi SharedPreferences
        editor=preferences.edit();

        //Memasukkan Data Pada Editor SharedPreferences dengan key (data_saya)
        editor.putString("data_saya",getKonten);

        //Menjalankan Operasi
        editor.apply();;

        //Menampilkan Output
        Hasil.setText("Output Data : "+preferences.getString("data_saya",null));
    }
}