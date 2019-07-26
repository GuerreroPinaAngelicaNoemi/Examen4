package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    Switch s1, s2, s3, s4, s5;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        s1 = (Switch) findViewById(R.id.s1);
        s2 = (Switch) findViewById(R.id.s2);
        s3 = (Switch) findViewById(R.id.s3);
        s4 = (Switch) findViewById(R.id.s4);

    }

    public void cargar(View v) {
        AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
            Toast.makeText(Main4Activity.this, "Ingrese ALgun profesor", Toast.LENGTH_SHORT).show();
        } else {
            if ((s1.isChecked() == true)) {
                String Sandra = s1.getText().toString();

                ContentValues opcion2 = new ContentValues();
                opcion2.put("datos1", Sandra);

                BaseDeDatos.insert("alumno", null, opcion2);
                BaseDeDatos.close();
                Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

                Intent intent3 = new Intent(v.getContext(), Main5Activity.class);
                startActivityForResult(intent3, 0);

                /*}else{
                    if((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                        String Sandra=s1.getText().toString();
                        String Layonet=s2.getText().toString();
                        String Jose=s3.getText().toString();
                        String Belem=s4.getText().toString();
                        String Nestor=s5.getText().toString();
                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                        j.putExtra("datos1", Sandra);
                        j.putExtra("datos2", Layonet);
                        j.putExtra("datos3", Jose);
                        j.putExtra("datos4", Belem);

                        startActivity(j);
                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                        startActivityForResult(intent4, 0);
                    }
                    else{
                        if((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                            String Sandra=s1.getText().toString();
                            String Layonet=s2.getText().toString();
                            String Jose=s3.getText().toString();
                            String Belem=s4.getText().toString();
                            String Nestor=s5.getText().toString();
                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                            j.putExtra("datos1", Sandra);
                            j.putExtra("datos2", Layonet);
                            j.putExtra("datos3", Jose);
                            j.putExtra("datos5", Nestor);
                            startActivity(j);
                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                            startActivityForResult(intent4, 0);
                        }else{
                            if((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                String Sandra=s1.getText().toString();
                                String Layonet=s2.getText().toString();
                                String Jose=s3.getText().toString();
                                String Belem=s4.getText().toString();
                                String Nestor=s5.getText().toString();
                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                j.putExtra("datos1", Sandra);
                                j.putExtra("datos2", Layonet);
                                j.putExtra("datos4", Belem);
                                j.putExtra("datos5", Nestor);
                                startActivity(j);
                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                startActivityForResult(intent4, 0);
                            }else{
                                if((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                    String Sandra=s1.getText().toString();
                                    String Layonet=s2.getText().toString();
                                    String Jose=s3.getText().toString();
                                    String Belem=s4.getText().toString();
                                    String Nestor=s5.getText().toString();
                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                    j.putExtra("datos1", Sandra);
                                    j.putExtra("datos3",Jose);
                                    j.putExtra("datos4", Belem);
                                    j.putExtra("datos5", Nestor);
                                    startActivity(j);
                                }else {
                                    if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                        String Sandra=s1.getText().toString();
                                        String Layonet=s2.getText().toString();
                                        String Jose=s3.getText().toString();
                                        String Belem=s4.getText().toString();
                                        String Nestor=s5.getText().toString();
                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                        j.putExtra("datos2", Layonet);
                                        j.putExtra("datos3", Jose);
                                        j.putExtra("datos4", Belem);
                                        startActivity(j);

                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                        startActivityForResult(intent4, 0);
                                    } else {
                                        if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                            String Sandra=s1.getText().toString();
                                            String Layonet=s2.getText().toString();
                                            String Jose=s3.getText().toString();
                                            String Belem=s4.getText().toString();
                                            String Nestor=s5.getText().toString();
                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                            j.putExtra("datos2", Layonet);
                                            j.putExtra("datos3", Jose);
                                            j.putExtra("datos5", Nestor);
                                            startActivity(j);
                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                            startActivityForResult(intent4, 0);
                                        } else {
                                            if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                                String Sandra=s1.getText().toString();
                                                String Layonet=s2.getText().toString();
                                                String Jose=s3.getText().toString();
                                                String Belem=s4.getText().toString();
                                                String Nestor=s5.getText().toString();
                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                j.putExtra("datos2", Layonet);
                                                j.putExtra("datos4", Belem);
                                                j.putExtra("datos5", Nestor);
                                                startActivity(j);
                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                startActivityForResult(intent4, 0);
                                            } else {
                                                if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                                    String Sandra=s1.getText().toString();
                                                    String Layonet=s2.getText().toString();
                                                    String Jose=s3.getText().toString();
                                                    String Belem=s4.getText().toString();
                                                    String Nestor=s5.getText().toString();
                                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                    j.putExtra("datos3", Jose);
                                                    j.putExtra("datos4", Belem);
                                                    j.putExtra("datos5", Nestor);
                                                    startActivity(j);
                                                    Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                    startActivityForResult(intent4, 0);
                                                } else {
                                                    if ((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                        String Sandra=s1.getText().toString();
                                                        String Layonet=s2.getText().toString();
                                                        String Jose=s3.getText().toString();
                                                        String Belem=s4.getText().toString();
                                                        String Nestor=s5.getText().toString();
                                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                        j.putExtra("datos1", Sandra);
                                                        j.putExtra("datos2", Layonet);
                                                        j.putExtra("datos3", Jose);
                                                        startActivity(j);
                                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                        startActivityForResult(intent4, 0);
                                                    } else {
                                                        if ((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                                            String Sandra=s1.getText().toString();
                                                            String Layonet=s2.getText().toString();
                                                            String Jose=s3.getText().toString();
                                                            String Belem=s4.getText().toString();
                                                            String Nestor=s5.getText().toString();
                                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                            j.putExtra("datos1", Sandra);
                                                            j.putExtra("datos2", Layonet);
                                                            j.putExtra("datos4", Belem);
                                                            startActivity(j);
                                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                            startActivityForResult(intent4, 0);
                                                        } else {
                                                            if ((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                                                String Sandra=s1.getText().toString();
                                                                String Layonet=s2.getText().toString();
                                                                String Jose=s3.getText().toString();
                                                                String Belem=s4.getText().toString();
                                                                String Nestor=s5.getText().toString();
                                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                j.putExtra("datos1", Sandra);
                                                                j.putExtra("datos2", Layonet);
                                                                j.putExtra("datos5", Nestor);
                                                                startActivity(j);
                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                startActivityForResult(intent4, 0);
                                                            } else {
                                                                if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                                                    String Sandra=s1.getText().toString();
                                                                    String Layonet=s2.getText().toString();
                                                                    String Jose=s3.getText().toString();
                                                                    String Belem=s4.getText().toString();
                                                                    String Nestor=s5.getText().toString();
                                                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                    j.putExtra("datos1", Sandra);
                                                                    j.putExtra("datos3", Jose);
                                                                    j.putExtra("datos4", Belem);
                                                                    startActivity(j);
                                                                    Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                    startActivityForResult(intent4, 0);
                                                                } else {
                                                                    if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                                                        String Sandra=s1.getText().toString();
                                                                        String Layonet=s2.getText().toString();
                                                                        String Jose=s3.getText().toString();
                                                                        String Belem=s4.getText().toString();
                                                                        String Nestor=s5.getText().toString();
                                                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                        j.putExtra("datos1", Sandra);
                                                                        j.putExtra("datos3", Jose);
                                                                        j.putExtra("datos5", Nestor);
                                                                        startActivity(j);
                                                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                        startActivityForResult(intent4, 0);
                                                                    } else {
                                                                        if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                                                            String Sandra=s1.getText().toString();
                                                                            String Layonet=s2.getText().toString();
                                                                            String Jose=s3.getText().toString();
                                                                            String Belem=s4.getText().toString();
                                                                            String Nestor=s5.getText().toString();
                                                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                            j.putExtra("datos1", Sandra);
                                                                            j.putExtra("datos4", Belem);
                                                                            j.putExtra("datos5", Nestor);
                                                                            startActivity(j);
                                                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                            startActivityForResult(intent4, 0);
                                                                        } else {
                                                                            if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                String Sandra=s1.getText().toString();
                                                                                String Layonet=s2.getText().toString();
                                                                                String Jose=s3.getText().toString();
                                                                                String Belem=s4.getText().toString();
                                                                                String Nestor=s5.getText().toString();
                                                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                j.putExtra("datos2", Layonet);
                                                                                j.putExtra("datos3", Jose);
                                                                                startActivity(j);
                                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                startActivityForResult(intent4, 0);
                                                                            } else {
                                                                                if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                                                                    String Sandra=s1.getText().toString();
                                                                                    String Layonet=s2.getText().toString();
                                                                                    String Jose=s3.getText().toString();
                                                                                    String Belem=s4.getText().toString();
                                                                                    String Nestor=s5.getText().toString();
                                                                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                    j.putExtra("datos2", Layonet);
                                                                                    j.putExtra("datos4", Belem);
                                                                                    startActivity(j);
                                                                                    Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                    startActivityForResult(intent4, 0);
                                                                                } else {
                                                                                    if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                                                                        String Sandra=s1.getText().toString();
                                                                                        String Layonet=s2.getText().toString();
                                                                                        String Jose=s3.getText().toString();
                                                                                        String Belem=s4.getText().toString();
                                                                                        String Nestor=s5.getText().toString();
                                                                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                        j.putExtra("datos2", Layonet);
                                                                                        j.putExtra("datos5", Nestor);
                                                                                        startActivity(j);
                                                                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                        startActivityForResult(intent4, 0);
                                                                                    } else {
                                                                                        if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == true)) {
                                                                                            String Sandra=s1.getText().toString();
                                                                                            String Layonet=s2.getText().toString();
                                                                                            String Jose=s3.getText().toString();
                                                                                            String Belem=s4.getText().toString();
                                                                                            String Nestor=s5.getText().toString();
                                                                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                            j.putExtra("datos4", Belem);
                                                                                            j.putExtra("datos5", Nestor);
                                                                                            startActivity(j);
                                                                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                            startActivityForResult(intent4, 0);
                                                                                        } else {
                                                                                            if ((s1.isChecked() == true) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                                String Sandra=s1.getText().toString();
                                                                                                String Layonet=s2.getText().toString();
                                                                                                String Jose=s3.getText().toString();
                                                                                                String Belem=s4.getText().toString();
                                                                                                String Nestor=s5.getText().toString();
                                                                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                j.putExtra("datos1", Sandra);
                                                                                                j.putExtra("datos2", Layonet);
                                                                                                startActivity(j);
                                                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                startActivityForResult(intent4, 0);
                                                                                            } else {
                                                                                                if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                                    String Sandra=s1.getText().toString();
                                                                                                    String Layonet=s2.getText().toString();
                                                                                                    String Jose=s3.getText().toString();
                                                                                                    String Belem=s4.getText().toString();
                                                                                                    String Nestor=s5.getText().toString();
                                                                                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                    j.putExtra("datos1", Sandra);
                                                                                                    j.putExtra("datos3", Jose);
                                                                                                    startActivity(j);

                                                                                                    Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                    startActivityForResult(intent4, 0);
                                                                                                } else {
                                                                                                    if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                                                                                        String Sandra=s1.getText().toString();
                                                                                                        String Layonet=s2.getText().toString();
                                                                                                        String Jose=s3.getText().toString();
                                                                                                        String Belem=s4.getText().toString();
                                                                                                        String Nestor=s5.getText().toString();
                                                                                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                        j.putExtra("datos1", Sandra);
                                                                                                        j.putExtra("datos4", Belem);
                                                                                                        startActivity(j);
                                                                                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                        startActivityForResult(intent4, 0);
                                                                                                    } else {
                                                                                                        if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                                                                                            String Sandra=s1.getText().toString();
                                                                                                            String Layonet=s2.getText().toString();
                                                                                                            String Jose=s3.getText().toString();
                                                                                                            String Belem=s4.getText().toString();
                                                                                                            String Nestor=s5.getText().toString();
                                                                                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                            j.putExtra("datos1", Sandra);
                                                                                                            j.putExtra("datos5", Nestor);
                                                                                                            startActivity(j);
                                                                                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                            startActivityForResult(intent4, 0);
                                                                                                        } else {
                                                                                                            if ((s1.isChecked() == true) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                                                String Sandra=s1.getText().toString();
                                                                                                                String Layonet=s2.getText().toString();
                                                                                                                String Jose=s3.getText().toString();
                                                                                                                String Belem=s4.getText().toString();
                                                                                                                String Nestor=s5.getText().toString();
                                                                                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                                j.putExtra("datos1", Sandra);
                                                                                                                startActivity(j);
                                                                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                startActivityForResult(intent4, 0);
                                                                                                            } else {
                                                                                                                if ((s1.isChecked() == false) && (s2.isChecked() == true) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                                                    String Sandra=s1.getText().toString();
                                                                                                                    String Layonet=s2.getText().toString();
                                                                                                                    String Jose=s3.getText().toString();
                                                                                                                    String Belem=s4.getText().toString();
                                                                                                                    String Nestor=s5.getText().toString();
                                                                                                                    Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                                    j.putExtra("datos2", Layonet);
                                                                                                                    startActivity(j);
                                                                                                                    Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                    startActivityForResult(intent4, 0);
                                                                                                                } else {
                                                                                                                    if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == true) && (s4.isChecked() == false) && (s5.isChecked() == false)) {
                                                                                                                        String Sandra=s1.getText().toString();
                                                                                                                        String Layonet=s2.getText().toString();
                                                                                                                        String Jose=s3.getText().toString();
                                                                                                                        String Belem=s4.getText().toString();
                                                                                                                        String Nestor=s5.getText().toString();
                                                                                                                        Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                                        j.putExtra("datos3", Jose);
                                                                                                                        startActivity(j);
                                                                                                                        Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                        startActivityForResult(intent4, 0);
                                                                                                                    } else {
                                                                                                                        if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == true) && (s5.isChecked() == false)) {
                                                                                                                            String Sandra=s1.getText().toString();
                                                                                                                            String Layonet=s2.getText().toString();
                                                                                                                            String Jose=s3.getText().toString();
                                                                                                                            String Belem=s4.getText().toString();
                                                                                                                            String Nestor=s5.getText().toString();
                                                                                                                            Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                                            j.putExtra("datos4", Belem);
                                                                                                                            startActivity(j);
                                                                                                                            Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                            startActivityForResult(intent4, 0);
                                                                                                                        } else {
                                                                                                                            if ((s1.isChecked() == false) && (s2.isChecked() == false) && (s3.isChecked() == false) && (s4.isChecked() == false) && (s5.isChecked() == true)) {
                                                                                                                                String Sandra=s1.getText().toString();
                                                                                                                                String Layonet=s2.getText().toString();
                                                                                                                                String Jose=s3.getText().toString();
                                                                                                                                String Belem=s4.getText().toString();
                                                                                                                                String Nestor=s5.getText().toString();
                                                                                                                                Intent j=new Intent(Main4Activity.this,Main5Activity.class);
                                                                                                                                j.putExtra("datos5", Nestor);
                                                                                                                                startActivity(j);
                                                                                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                                startActivityForResult(intent4, 0);
                                                                                                                            } else {
                                                                                                                                Toast.makeText(Main4Activity.this, "Cargando", Toast.LENGTH_LONG).show();
                                                                                                                                Intent intent4 = new Intent(v.getContext(), Main5Activity.class);
                                                                                                                                startActivityForResult(intent4, 0);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }}}}}}

        }
});/*/


            }
        }

    }
        public void borra (View v){
            System.exit(0);
        }
    }

