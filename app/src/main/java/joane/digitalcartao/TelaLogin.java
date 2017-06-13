package joane.digitalcartao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import joane.digitalcartao.telas.cadastro.*;
import joane.digitalcartao.telas.inicio.*;
import joane.digitalcartao.telas.busca.*;

import java.util.List;


public class TelaLogin extends AppCompatActivity {
    EditText login;
    EditText senha;
//    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        login = (EditText) findViewById(R.id.loginLogin);
        senha = (EditText) findViewById(R.id.senhaLogin);

        SugarContext.init(this);

//        b = getIntent().getExtras();
//        TextView nomeDele = (TextView) findViewById(R.id.medicoMedicoNomeDele);
//        nomeDele.setText("Sou o médico ");//+b.getString("nome"));
    }

    public void cadastrarMedico(View view) {
        Intent cadastrarMedico = new Intent(this, cadastro_medico.class);
        startActivity(cadastrarMedico);
    }

    public void logar(View view) {
        String lgin = login.getText().toString();
        String pass = senha.getText().toString();
        Boolean flagP = true;
        Boolean flagM = true;

        if (lgin.length() == 15) {
            Paciente pacient = new Paciente();
            List<Paciente> listaPacient = pacient.listAll(Paciente.class);

            for (Paciente paciente : listaPacient) {
                if (paciente.getSus().equals(lgin)) {
                    if (paciente.getSenha().equals(pass)) {
                        flagP = false;
                        Intent vacina = new Intent(this, CartaoVacina.class);
                        startActivity(vacina);
                        finish();
                    }
                }
            }
            if (flagP) {
                Toast.makeText(TelaLogin.this, "Paciente não cadastrado!", Toast.LENGTH_SHORT).show();
            }
        } else {

            Medico m = new Medico();
            List<Medico> listaMedico = m.listAll(Medico.class);

            for (Medico medico : listaMedico) {
                if (medico.getCrm().equals(lgin)) {
                    if (medico.getSenha().equals(pass)) {
                        flagM = false;
                        Intent passartelaMedico = new Intent(this, tela_medico.class);
                        passartelaMedico.putExtra("nome", medico.getNomeMedico());
                        startActivity(passartelaMedico);
                       // finish();
                    }
                }
            }
            if (flagM) {
                Toast.makeText(TelaLogin.this, "Médico não cadastrado!", Toast.LENGTH_SHORT).show();
            }
        }
        // crm 12
        // sus 15
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
