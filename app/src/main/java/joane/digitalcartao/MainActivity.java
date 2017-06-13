package joane.digitalcartao;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orm.SugarContext;

import joane.digitalcartao.R;
import joane.digitalcartao.telas.cadastro.*;
import joane.digitalcartao.telas.busca.*;
import joane.digitalcartao.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SugarContext.init(this);

//        Paciente.deleteAll(Paciente.class);
//        Medico.deleteAll(Medico.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, TelaLogin.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        SugarContext.terminate();
//    }
//        Paciente p = new Paciente();
//
//        List<Paciente> lista = p.listAll(Paciente.class);//Busca todos os pacientes
//        p.findById(Paciente.class, 1); //busca
//        //p.find(Paciente.class,"id = 10",);
//        p.save(); // salvar
//        p.update(); // atualizar
//        p.delete(); // apagar
}