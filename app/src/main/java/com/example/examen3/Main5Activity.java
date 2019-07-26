package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
TextView TVM5;
Button Btn1,Btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Btn1=(Button)findViewById(R.id.Btn1);
        Btn2=(Button)findViewById(R.id.Btn2);
        TVM5=(TextView)findViewById(R.id.TVM5);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent5, 0);
                System.exit(0);
            }
        });
    }
    public void corregir(View v){
        AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        String nocontrol = TVM5.getText().toString();
        if(!nocontrol.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("select nombre,apellido from alumno where control=" + nocontrol, null);
            if (fila.moveToFirst()) {
                TVM5.setText(fila.getString(0));
                BaseDeDatos.close();
                Intent intent = new Intent(v.getContext(), Main3Activity.class);
                startActivityForResult(intent, 0);
            }
        }

        Intent intent5 = new Intent(v.getContext(), Main3Activity.class);
        startActivityForResult(intent5, 0);
    }
    protected void OnResume(){
        AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        String nocontrol = TVM5.getText().toString();
        if(!nocontrol.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("select nombre,apellido from alumno where control=" + nocontrol, null);
            if (fila.moveToFirst()) {
                TVM5.setText(fila.getString(0));
                BaseDeDatos.close();

            }
        }
    }
}
