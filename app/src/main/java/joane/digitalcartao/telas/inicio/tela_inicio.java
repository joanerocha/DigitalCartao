package joane.digitalcartao.telas.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import joane.digitalcartao.CartaoVacina;
import joane.digitalcartao.MainActivity;
import joane.digitalcartao.R;

public class tela_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }
    public void voltarTelaInicial(View view){
        Intent voltarTelainicial = new Intent(this, MainActivity.class);
        startActivity(voltarTelainicial);
    }
    public void telaMedico(View view){
        Intent telaMedico = new Intent(this, tela_medico.class);
        startActivity(telaMedico);
    }
    public void cartaoVacina(View view){
        Intent cartaoVacina = new Intent(this, CartaoVacina.class);
        startActivity(cartaoVacina);
    }
}
