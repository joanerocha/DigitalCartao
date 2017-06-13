package joane.digitalcartao;

/**
 * Created by Aluno on 28/11/2016.
 */
public class Vacina {

        public Vacina() {

        }

        public Vacina(String nome, int dose, String tipo) {

            this.nome = nome;
            this.dose = dose;
            this.tipo = tipo;
            this.id = 0;
        }

        private long id;
        private String nome;
        private int dose;
        private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dose=" + dose +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
