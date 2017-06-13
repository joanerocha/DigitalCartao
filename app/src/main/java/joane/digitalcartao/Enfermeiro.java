package joane.digitalcartao;

import com.orm.SugarRecord;

/**
 * Created by Aluno on 28/11/2016.
 */
public class Enfermeiro extends SugarRecord {
    private long idEnfermeiro;
    private String nomeEnfermeiro;
    private String coren;
    private String senha;
    public Enfermeiro() {

    }

    public Enfermeiro(long idEnfermeiro, String nomeEnfermeiro, String coren, String senha) {
        this.idEnfermeiro = idEnfermeiro;
        this.nomeEnfermeiro = nomeEnfermeiro;
        this.coren = coren;
        this.senha = senha;
    }

    public long getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(long idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public String getNomeEnfermeiro() {
        return nomeEnfermeiro;
    }

    public void setNomeEnfermeiro(String nomeEnfermeiro) {
        this.nomeEnfermeiro = nomeEnfermeiro;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "idEnfermeiro=" + idEnfermeiro +
                ", nomeEnfermeiro='" + nomeEnfermeiro + '\'' +
                ", coren='" + coren + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
