package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText Et1, Et2, Et3, Et4;
    RadioButton Rb1, Rb2, Rb3;
    RadioGroup Rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button Bt1 = (Button) findViewById(R.id.Bt1);
        Button Bt2 = (Button) findViewById(R.id.Bt2);
        Et1 = (EditText) findViewById(R.id.Et1);
        Et2 = (EditText) findViewById(R.id.Et2);
        Et3 = (EditText) findViewById(R.id.Et3);
        Et4 = (EditText) findViewById(R.id.Et4);
        Rg1=(RadioGroup)findViewById(R.id.RadioGroup1);
        Rb1 = (RadioButton) findViewById(R.id.Rb1);
        Rb2 = (RadioButton) findViewById(R.id.Rb2);
        Rb3 = (RadioButton) findViewById(R.id.Rb3);


        Bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
            }
        });
    }

    public void registro(View v) {
     AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        String usuario = Et4.getText().toString();
        String nombre = Et1.getText().toString();
        String apellido = Et2.getText().toString();
        String nocontrol = Et3.getText().toString();



            if ((Rb1.isChecked() == true) && (Rb2.isChecked() == false) && (Rb3.isChecked() == false)) {

            } else {
                if ((Rb1.isChecked() == false) && (Rb2.isChecked() == true) && (Rb3.isChecked() == false)) {
                } else {
                    if ((Rb1.isChecked() == false) && (Rb2.isChecked() == false) && (Rb3.isChecked() == true)) {

                    } else {
                        if ((Rb1.isChecked() == false) && (Rb2.isChecked() == false) && (Rb3.isChecked() == false)) {
                            Toast.makeText(Main2Activity.this, "Elige la carrera", Toast.LENGTH_LONG).show();
                        } else {
                            if ((Rb1.isChecked() == true) && (Rb2.isChecked() == true) && (Rb3.isChecked() == true)) {
                                Toast.makeText(Main2Activity.this, "Seleccionaste dos campos Ing. Informatica e Ing. Administracion en Gestion Empresarial solo puedes uno, selecciona de nuevo", Toast.LENGTH_SHORT).show();
                            } else {
                                if ((Rb1.isChecked() == true) && (Rb2.isChecked() == false) && (Rb3.isChecked() == true)) {
                                    Toast.makeText(Main2Activity.this, "Seleccionaste dos campos Ing. Informatica e Ing. Civil solo puedes uno, selecciona de nuevo", Toast.LENGTH_SHORT).show();
                                } else {
                                    if ((Rb1.isChecked() == false) && (Rb2.isChecked() == true) && (Rb3.isChecked() == true)) {
                                        Toast.makeText(Main2Activity.this, "Seleccionaste dos campos ng. Administracion en Gestion Empresarial e Ing. Civil solo puedes uno, selecciona de nuevo", Toast.LENGTH_SHORT).show();
                                    }}}}}}}  if(!nombre.isEmpty()&&!usuario.isEmpty()&&!apellido.isEmpty()&&!nocontrol.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("usuario", usuario);
            registro.put("control", nocontrol);
            BaseDeDatos.insert("alumno", null, registro);
            BaseDeDatos.close();
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
            Et1.setText("");
            Et2.setText("");
            Et3.setText("");
            Et4.setText("");
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        } else{
                                    if(nombre.isEmpty())
                                        Et1.setError("Escribe campos");
            if(nombre.isEmpty())
                Et1.setError("Escribe campos");
            if(nombre.isEmpty())
                Et2.setError("Escribe campos");
            if(nombre.isEmpty())
                Et3.setError("Escribe campos");
            if(nombre.isEmpty())
                Et4.setError("Escribe campos");

        }


                                    }
                                }

