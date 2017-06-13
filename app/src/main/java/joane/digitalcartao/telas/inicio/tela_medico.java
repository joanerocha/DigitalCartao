package joane.digitalcartao.telas.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import joane.digitalcartao.MainActivity;
import joane.digitalcartao.Paciente;
import joane.digitalcartao.R;
import joane.digitalcartao.telas.busca.*;
import joane.digitalcartao.telas.cadastro.*;

import java.util.List;

public class tela_medico extends AppCompatActivity {
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medico);
        b = getIntent().getExtras();
        TextView nomeDele = (TextView) findViewById(R.id.medicoMedicoNomeDele);
        nomeDele.setText("Sou o médico "+b.getString("nome"));
    }
    public void voltarTelaInicial(View view){
        Intent voltarTelainicial = new Intent(this, MainActivity.class);
        startActivity(voltarTelainicial);
        finish();
    }

    public void cadastrarPaciente(View view) {
        Intent cadastrarPaciente = new Intent(this, cadastro_paciente.class);
        cadastrarPaciente.putExtra("nomeM", b.getString("nome"));
        startActivity(cadastrarPaciente);
    }
    public void buscarPaciente(View view){
        Intent buscar = new Intent(this, buscarPaciente.class);
        buscar.putExtra("nomeM", b.getString("nome"));
        startActivity(buscar);
    }
//    public void cadastrarEnfermeiro(View view){
//        Intent cadastrarEnfermeiro = new Intent(this, cadastro_enfermeiro.class);
//        startActivity(cadastrarEnfermeiro);
//        finish();
//    }
//    public void buscarEnfermeiro(View view){
//        Intent buscar = new Intent(this, buscarEnfermeiro.class);
//        startActivity(buscar);
//        finish();
//    }
}
