package joane.digitalcartao;

import com.orm.SugarContext;
import com.orm.SugarRecord;

/**
 * Created by Aluno on 28/11/2016.
 */
public class Paciente extends SugarRecord {
    private long idPaciente;
    private String nomePaciente;
    private String sus;
    private int cpf;
    private String email;
    private String senha;

    public Paciente() {
    }

    public Paciente(String nomePaciente, String sus, int cpf, String email, String senha) {
        this.nomePaciente = nomePaciente;
        this.sus = sus;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id =" + idPaciente +
                ", nome ='" + nomePaciente + '\'' +
                ", sus =" + sus +
                ", cpf =" + cpf +
                ", email ='" + email + '\'' +
                ", senha ='" + senha + '\'' +
                '}';
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

