package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
TextView TV1;
RadioButton RB1,RB2;
CheckBox CHK1,CHK2,CHK3,CHK4,CHK5;
Button B1,B2;
    String Estructura;
    String Desarrollo;
    String Tecnologia;
    String Telecomunicaciones;
    String Arquitectura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       TV1=(TextView)findViewById(R.id.TextView) ;
        RB1=(RadioButton) findViewById(R.id.RB1);
        RB2=(RadioButton) findViewById(R.id.RB2);
        CHK1=(CheckBox) findViewById(R.id.CHK1);
        CHK2=(CheckBox) findViewById(R.id.CHK2);
        CHK3=(CheckBox) findViewById(R.id.CHK3);
        CHK4=(CheckBox) findViewById(R.id.CHK4);
        CHK5=(CheckBox) findViewById(R.id.CHK5);
        CHK4=(CheckBox) findViewById(R.id.CHK4);
        B1=(Button)findViewById(R.id.B1);
        B2=(Button)findViewById(R.id.B2);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "Saliendo", Toast.LENGTH_LONG).show();
            System.exit(0);
            }
        });
    }
 public void cargar(View v){
     AdminSQLite admin=new AdminSQLite(this,"administracion",null,1);
     SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
            Estructura = CHK1.getText().toString();
            Desarrollo = CHK2.getText().toString();
            Tecnologia = CHK3.getText().toString();
            Telecomunicaciones = CHK4.getText().toString();
            Arquitectura = CHK5.getText().toString();
            Bundle nombre = getIntent().getExtras();
            String nom = nombre.getString("nombre");
            TV1.setText("Hola" + nom);
            if ((RB1.isChecked() == true) && (RB2.isChecked() == false)) {
            } else {
                if ((RB1.isChecked() == false) && (RB2.isChecked() == true)) {
                } else {
                    if ((RB1.isChecked() == true) && (RB2.isChecked() == true)) {
                        Toast.makeText(Main3Activity.this, "Has seleccionado dos campos en periodo:2019 y 2018, por favor selecciona de nuevo", Toast.LENGTH_LONG).show();
                    } else {
                        if ((RB1.isChecked() == false) && (RB2.isChecked() == false)) {

                            Toast.makeText(Main3Activity.this, "No has seleccionado ningun campo de periodo", Toast.LENGTH_LONG).show();
                          }  else {
                      // if ((CHK1.isChecked() == true)) {

         String materia = TV1.getText().toString();
         if (!materia.isEmpty()) {
             Cursor fila = BaseDeDatos.rawQuery("select nombre,apellido,materia from alumno where control=" + materia, null);
             if (fila.moveToFirst()) {
                 if ((CHK1.isChecked() == true)) {
                 CHK1.setText(fila.getString(0));
                 Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                 startActivityForResult(intent3, 0);
            }
         }}}} }}

                               /* }  else{

                                        if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                            Toast.makeText(Main3Activity.this, "No ingreso ninguna materia, por favor ingrese las materias", Toast.LENGTH_LONG).show();
                                        }
                                    Toast.makeText(this, "ingrese campos", Toast.LENGTH_SHORT).show();

                                    }/*


                                }
                           /*     }else{
                                    if((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                        i.putExtra("dato1", Estructura);
                                        i.putExtra("dato2", Desarrollo);
                                        i.putExtra("dato3", Tecnologia);
                                        i.putExtra("dato4", Telecomunicaciones);

                                        startActivity(i);
                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                        startActivityForResult(intent3, 0);
                                    }
                                    else{
                                        if((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {

                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                            i.putExtra("dato1", Estructura);
                                            i.putExtra("dato2", Desarrollo);
                                            i.putExtra("dato3", Tecnologia);
                                            i.putExtra("dato5", Arquitectura);
                                            startActivity(i);
                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                            startActivityForResult(intent3, 0);
                                        }else{
                                            if((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {
                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                i.putExtra("dato1", Estructura);
                                                i.putExtra("dato2", Desarrollo);

                                                i.putExtra("dato4", Telecomunicaciones);
                                                i.putExtra("dato5", Arquitectura);

                                                startActivity(i);
                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                startActivityForResult(intent3, 0);
                                            }else{
                                                if((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {

                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                    i.putExtra("dato1", Estructura);
                                                    i.putExtra("dato3", Tecnologia);
                                                    i.putExtra("dato4", Telecomunicaciones);
                                                    i.putExtra("dato5", Arquitectura);
                                                    startActivity(i);
                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                    startActivityForResult(intent3, 0);
                                                }else {
                                                    if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                        i.putExtra("dato2", Desarrollo);
                                                        i.putExtra("dato3", Tecnologia);
                                                        i.putExtra("dato4", Telecomunicaciones);
                                                        startActivity(i);
                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                        startActivityForResult(intent3, 0);
                                                    } else {
                                                        if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {
                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);

                                                            i.putExtra("dato2", Desarrollo);
                                                            i.putExtra("dato3", Tecnologia);

                                                            i.putExtra("dato5", Arquitectura);
                                                            startActivity(i);
                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                            startActivityForResult(intent3, 0);
                                                        } else {
                                                            if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {

                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);

                                                                i.putExtra("dato2", Desarrollo);

                                                                i.putExtra("dato4", Telecomunicaciones);
                                                                i.putExtra("dato5", Arquitectura);
                                                                startActivity(i);
                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                startActivityForResult(intent3, 0);
                                                            } else {
                                                                if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {

                                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);

                                                                    i.putExtra("dato3", Tecnologia);
                                                                    i.putExtra("dato4", Telecomunicaciones);
                                                                    i.putExtra("dato5", Arquitectura);
                                                                    startActivity(i);
                                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                    startActivityForResult(intent3, 0);
                                                                } else {
                                                                    if ((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {

                                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                        i.putExtra("dato1", Estructura);
                                                                        i.putExtra("dato2", Desarrollo);
                                                                        i.putExtra("dato3", Tecnologia);
                                                                        startActivity(i);
                                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                        startActivityForResult(intent3, 0);
                                                                    } else {
                                                                        if ((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                            i.putExtra("dato1", Estructura);
                                                                            i.putExtra("dato2", Desarrollo);
                                                                            i.putExtra("dato4", Telecomunicaciones);
                                                                            startActivity(i);
                                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                            startActivityForResult(intent3, 0);
                                                                        } else {
                                                                            if ((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {

                                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                i.putExtra("dato1", Estructura);
                                                                                i.putExtra("dato2", Desarrollo);
                                                                                i.putExtra("dato5", Arquitectura);
                                                                                startActivity(i);
                                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                startActivityForResult(intent3, 0);
                                                                            } else {
                                                                                if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                    i.putExtra("dato1", Estructura);
                                                                                    i.putExtra("dato3", Tecnologia);
                                                                                    i.putExtra("dato4", Telecomunicaciones);
                                                                                    startActivity(i);
                                                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                    startActivityForResult(intent3, 0);
                                                                                } else {
                                                                                    if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {

                                                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                        i.putExtra("dato1", Estructura);
                                                                                        i.putExtra("dato3", Tecnologia);
                                                                                        i.putExtra("dato5", Arquitectura);
                                                                                        startActivity(i);
                                                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                        startActivityForResult(intent3, 0);
                                                                                    } else {
                                                                                        if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {

                                                                                            String Telecomunicaciones = CHK4.getText().toString();
                                                                                            String Arquitectura = CHK5.getText().toString();
                                                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                            i.putExtra("dato1", Estructura);
                                                                                            i.putExtra("dato4", Telecomunicaciones);
                                                                                            i.putExtra("dato5", Arquitectura);
                                                                                            startActivity(i);
                                                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                            startActivityForResult(intent3, 0);
                                                                                        } else {
                                                                                            if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                i.putExtra("dato2", Desarrollo);
                                                                                                i.putExtra("dato3", Tecnologia);
                                                                                                startActivity(i);
                                                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                startActivityForResult(intent3, 0);
                                                                                            } else {
                                                                                                if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                                                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                    i.putExtra("dato2", Desarrollo);
                                                                                                    i.putExtra("dato4", Telecomunicaciones);
                                                                                                    startActivity(i);
                                                                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                    startActivityForResult(intent3, 0);
                                                                                                } else {
                                                                                                    if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {
                                                                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                        i.putExtra("dato2", Desarrollo);
                                                                                                        i.putExtra("dato5", Arquitectura);
                                                                                                        startActivity(i);
                                                                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                        startActivityForResult(intent3, 0);
                                                                                                    } else {
                                                                                                        if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == true)) {
                                                                                                            String Telecomunicaciones = CHK4.getText().toString();
                                                                                                            String Arquitectura = CHK5.getText().toString();
                                                                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                            i.putExtra("dato4", Telecomunicaciones);
                                                                                                            i.putExtra("dato5", Arquitectura);
                                                                                                            startActivity(i);
                                                                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                            startActivityForResult(intent3, 0);
                                                                                                        } else {
                                                                                                            if ((CHK1.isChecked() == true) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                                                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                i.putExtra("dato1", Estructura);
                                                                                                                i.putExtra("dato2", Desarrollo);
                                                                                                                startActivity(i);
                                                                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                startActivityForResult(intent3, 0);
                                                                                                            } else {
                                                                                                                if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                                                                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                    i.putExtra("dato1", Estructura);
                                                                                                                    i.putExtra("dato3", Tecnologia);
                                                                                                                    startActivity(i);
                                                                                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                    startActivityForResult(intent3, 0);
                                                                                                                } else {
                                                                                                                    if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {

                                                                                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                        i.putExtra("dato1", Estructura);
                                                                                                                        i.putExtra("dato4", Telecomunicaciones);
                                                                                                                        startActivity(i);
                                                                                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                        startActivityForResult(intent3, 0);
                                                                                                                    } else {
                                                                                                                        if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {

                                                                                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                            i.putExtra("dato1", Estructura);
                                                                                                                            i.putExtra("dato5", Arquitectura);
                                                                                                                            startActivity(i);
                                                                                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                            startActivityForResult(intent3, 0);
                                                                                                                        } else {
                                                                                                                            if ((CHK1.isChecked() == true) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                                                                                                                ;
                                                                                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                                i.putExtra("dato1", Estructura);
                                                                                                                                startActivity(i);

                                                                                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                startActivityForResult(intent3, 0);
                                                                                                                            } else {
                                                                                                                                if ((CHK1.isChecked() == false) && (CHK2.isChecked() == true) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {
                                                                                                                                    Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                                    i.putExtra("dato2", Desarrollo);
                                                                                                                                    startActivity(i);

                                                                                                                                    Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                    startActivityForResult(intent3, 0);
                                                                                                                                } else {
                                                                                                                                    if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == true) && (CHK4.isChecked() == false) && (CHK5.isChecked() == false)) {

                                                                                                                                        Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                                        i.putExtra("dato3", Tecnologia);
                                                                                                                                        startActivity(i);

                                                                                                                                        Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                        startActivityForResult(intent3, 0);
                                                                                                                                    } else {
                                                                                                                                        if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == true) && (CHK5.isChecked() == false)) {
                                                                                                                                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                                            i.putExtra("dato4", Telecomunicaciones);
                                                                                                                                            startActivity(i);

                                                                                                                                            Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                            startActivityForResult(intent3, 0);
                                                                                                                                        } else {
                                                                                                                                            if ((CHK1.isChecked() == false) && (CHK2.isChecked() == false) && (CHK3.isChecked() == false) && (CHK4.isChecked() == false) && (CHK5.isChecked() == true)) {
                                                                                                                                                Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                                                                                                                                                i.putExtra("dato5", Arquitectura);
                                                                                                                                                startActivity(i);

                                                                                                                                                Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                                startActivityForResult(intent3, 0);
                                                                                                                                            } else {


                                                                                                                                            }Intent intent3 = new Intent(v.getContext(), Main4Activity.class);
                                                                                                                                            startActivityForResult(intent3, 0);
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
                                                }}}}}}}}}}}}/*/
                                }}