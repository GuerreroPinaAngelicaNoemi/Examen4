package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
    String nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Button b1 =(Button)findViewById(R.id.b1);
    Button b2 =(Button)findViewById(R.id.b2);
    et1=(EditText)findViewById(R.id.et1) ;
    et2=(EditText)findViewById(R.id.et2) ;



    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1= new Intent(v.getContext(),Main2Activity.class);
            startActivityForResult(intent1,0);
        }
    });
    }
    public void ingresar(View v){
       AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        String nocontrol = et2.getText().toString();
 if(!nocontrol.isEmpty()) {
     Cursor fila = BaseDeDatos.rawQuery("select nombre,apellido from alumno where control=" + nocontrol, null);
     if (fila.moveToFirst()) {
         et1.setText(fila.getString(0));
         BaseDeDatos.close();
         Intent intent = new Intent(v.getContext(), Main3Activity.class);
         startActivityForResult(intent, 0);
     } else {
         et2.setError("Numero de control no registrado");
     }
 }else {
     et1.setError("Ingrese usuario");
     et2.setError("Ingrese numero de control");
 }


    }
}


