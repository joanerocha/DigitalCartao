package joane.digitalcartao;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Aluno on 28/11/2016.
 */
@Table
public class Medico extends SugarRecord {
    private long idMedico;
    private String nomeMedico;
    private String crm;
    private String email;
    private String senha;

    public Medico() {

    }

    public Medico(String nomeMedico, String crm, String email, String senha) {
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.email = email;
        this.senha = senha;
    }

//    public long getIdMedico() {
//        return idMedico;
//    }
//
//    public void setIdMedico(long idMedico) {
//        this.idMedico = idMedico;
//    }

    public String getNomeMedico() {
        return nomeMedico;
    }

//    public void setNomeMedico(String nomeMedico) {
//        this.nomeMedico = nomeMedico;
//    }

    public String getCrm() {
        return crm;
    }

//    public void setCrm(String crm) {
//        this.crm = crm;
//    }

    public String getSenha() {
        return senha;
    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico=" + idMedico +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", crm='" + crm + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
