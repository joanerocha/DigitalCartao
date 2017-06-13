package joane.digitalcartao.telas.cadastro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import joane.digitalcartao.CartaoVacina;
import joane.digitalcartao.Medico;
import joane.digitalcartao.MainActivity;
import joane.digitalcartao.Paciente;
import joane.digitalcartao.R;
import joane.digitalcartao.TelaLogin;
import joane.digitalcartao.telas.inicio.tela_medico;

public class cadastro_medico extends AppCompatActivity {

    EditText nome;
    EditText crm;
    EditText email;
    EditText senhaM;
    EditText csenhaM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medico);

        nome = (EditText) findViewById(R.id.nomeMedico);
        crm = (EditText) findViewById(R.id.crm);
        email = (EditText) findViewById(R.id.emailMedico);
        senhaM = (EditText) findViewById(R.id.senhaM);
        csenhaM = (EditText) findViewById(R.id.csenhaM);
    }

    public void voltarTelaMedico(View view) {
        Intent voltarTelaMedico = new Intent(this, tela_medico.class);
        voltarTelaMedico.putExtra("nome", nome.getText().toString());
        startActivity(voltarTelaMedico);
        finish();
    }

    public Boolean verificaCampo() {
        String nomeMedico = nome.getText().toString();
        String crmMedico = crm.getText().toString();
        String EmailMedico = email.getText().toString();
        String senhaMedico = senhaM.getText().toString();

        if (nomeMedico.equals("") || crmMedico.equals("") || EmailMedico.equals("") || senhaMedico.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificandoCRMExistente() {
        String verificaCRM = crm.getText().toString();
        Boolean flagCRM = true; // era true
        Medico m = new Medico();
        List<Medico> listaMedico = m.listAll(Medico.class);

        for (Medico medico : listaMedico) {
            if (medico.getCrm().equals(verificaCRM)) {
                flagCRM = false; // era false
            }
        }
        return flagCRM;
    }

    private AlertDialog alertaOk;

    public void alertaCadastroMedico(final View view) {
        if (verificaCampo() == false) { // Verifica se os campos estão vazios
            Toast.makeText(cadastro_medico.this, "Preencha os dados", Toast.LENGTH_SHORT).show();  // Mensagem de campos vazios
        } else {
            if (verificandoCRMExistente() == false) {
                Toast.makeText(cadastro_medico.this, "CRM existente!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
            } else {
                if (!senhaM.getText().toString().equals(csenhaM.getText().toString())) { // Verifica se as senhas são diferentes
                    Toast.makeText(cadastro_medico.this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show(); // Mostra Alerta de senhas diferentes
                } else {
                    final AlertDialog.Builder alerta = new AlertDialog.Builder(this); // Finaliza o alerta
                    alerta.setTitle("Confirmação de Cadastro");
                    alerta.setMessage("Médico cadastrado com sucesso!");
                    alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            voltarTelaMedico(view);
                        }
                    });
                    alertaOk = alerta.create();
                    alertaOk.show();
                    Medico m = new Medico(nome.getText().toString(), crm.getText().toString(), email.getText().toString(), senhaM.getText().toString());
                    Medico.save(m); // salvar
                }
            }
        }
    }
}
