package joane.digitalcartao.telas.busca;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarContext;
import com.orm.SugarRecord;
import joane.digitalcartao.CartaoVacina;
import joane.digitalcartao.Paciente;
import joane.digitalcartao.PacienteAdapter;
import joane.digitalcartao.R;
import joane.digitalcartao.telas.inicio.tela_medico;

import java.util.ArrayList;
import java.util.List;

public class buscarPaciente extends AppCompatActivity {

//    EditText nomePaciente;
    ListView list;
//    SearchView sv;

    Paciente p = new Paciente();
    List<Paciente> lista = p.listAll(Paciente.class);

    List<String> nomePacientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_paciente);

        SugarContext.init(this);

        //Carrega nome dos pacientes para lista frutas
        for(Paciente p:lista){
            if(p.getNomePaciente()!=null) {
                nomePacientes.add(p.getNomePaciente());
                Log.i("listando", "nome: " + p.getNomePaciente());
            }
        }

        AutoCompleteTextView pacientes = (AutoCompleteTextView) findViewById(R.id.completeFrutas);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomePacientes);
        pacientes.setAdapter(adaptador);

        list = (ListView) findViewById(R.id.listViewPaciente);
        list.setAdapter(new PacienteAdapter(this));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent cartao = new Intent(buscarPaciente.this, CartaoVacina.class);
                startActivity(cartao);
            }
        });
    }





//        sv = (SearchView) findViewById(R.id.nomebusca);
//
//        SearchView searchView = (SearchView) ;
//        searchView.setOnQueryTextListener(this);


//    public void doBuscarPaciente(View view){
//        Paciente p = new Paciente();
//        List<Paciente> lista = p.listAll(Paciente.class);//Busca todos os pacientes
//        for (int i =0 ; i < lista.size(); i++) {
//            Log.i("teste", lista.get(i).toString());
//        }
//    }
//
//    public void voltarTelaMedico(View view) {
//        Intent voltarTelaMedico = new Intent(this, tela_medico.class);
//        startActivity(voltarTelaMedico);
//    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        SugarContext.terminate();
    }
}
