package joane.digitalcartao.telas.cadastro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import joane.digitalcartao.Paciente;
import joane.digitalcartao.R;
import joane.digitalcartao.telas.inicio.tela_medico;

public class cadastro_paciente extends AppCompatActivity {

    EditText nome;
    EditText sus;
    EditText cpf;
    EditText email;
    EditText senha;
    EditText csenha;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);
        b = getIntent().getExtras();
        nome = (EditText) findViewById(R.id.nomePaciente);
        sus = (EditText) findViewById(R.id.sus);
        cpf = (EditText) findViewById(R.id.cpf);
        email = (EditText) findViewById(R.id.emailPaciente);
        senha = (EditText) findViewById(R.id.senha);
        csenha = (EditText) findViewById(R.id.csenha);
    }
//    public void voltarTelaMedico(View view){
//        Intent voltarTelaMedico = new Intent(this, tela_medico.class);
//        startActivity(voltarTelaMedico);
//        finish();
//    }

    public Boolean verificaCampo (){
       // Toast.makeText(cadastro_paciente.this, "Qualquer COISA", Toast.LENGTH_SHORT).show();
        String nomePaciente = nome.getText().toString();
        String susP = sus.getText().toString();
        String cpfP = cpf.getText().toString();
        String EmailPaciente = email.getText().toString();

        if (nomePaciente.equals("") || susP.equals("") || cpfP.equals("") || EmailPaciente.equals(""))   {
            return false;
        }
        return true;
    }


    private AlertDialog alertaOk;
    public void alertaCadastroPaciente (View view){
        if (verificaCampo() == false){
            Toast.makeText(cadastro_paciente.this, "Preencha os dados", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!senha.getText().toString().equals(csenha.getText().toString())){
            Toast.makeText(cadastro_paciente.this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
        }else {
            final AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Confirmação de Cadastro");
            alerta.setMessage("Paciente cadastrado com sucesso!");
            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Intent voltarTelaMedico = new Intent(cadastro_paciente.this, tela_medico.class);
                    voltarTelaMedico.putExtra("nome", b.getString("nomeM"));
                    startActivity(voltarTelaMedico);
                    //voltarTelaMedico(view);
                    finish();
                }
            });
            alertaOk = alerta.create();
            alertaOk.show();

            Paciente p = new Paciente(nome.getText().toString(),  sus.getText().toString(), Integer.parseInt(cpf.getText().toString()), email.getText().toString(), senha.getText().toString());
            p.save(); // salvar
        }

    }
}
