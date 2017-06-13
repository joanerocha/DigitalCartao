package joane.digitalcartao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Aluno on 06/10/2016.
 */
public class PacienteAdapter extends BaseAdapter{
//    public void addPaciente(View view){
//        ArrayList<String> paciente = new ArrayList<String> ();
//        paciente.add("Lary");
//        paciente.add("Iris");
//        paciente.add("Wash");
//        paciente.add("Arthur");
//    }




    private Context context;
    ArrayList<Paciente> pacientes;

    public PacienteAdapter(Context context) {
        super();
        this.context = context;
        pacientes = (ArrayList<Paciente>) Paciente.listAll(Paciente.class);
    }

    @Override
    public int getCount() {
        return pacientes.size();
    }

    @Override
    public String getItem(int position) {
        return pacientes.get(position).getNomePaciente();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.infla_paciente, parent, false);
        TextView t = (TextView) view.findViewById(R.id.nome_paciente);
        Paciente paciente = (Paciente) pacientes.get(position);
        t.setText(paciente.getNomePaciente());
        return view;

//        LayoutInflater inflater = LayoutInflater.from(context);
//        View v = (View) inflater.inflate(R.layout.infla_paciente, parent , false);
//        TextView busca = (TextView) v.findViewById(R.id.nome_paciente);
//
//        busca.setText(pacientes.get(position).getNomePaciente());
//        return v;
    }
}

