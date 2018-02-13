package harlan.biblioteca.DTO;


import harlan.biblioteca.Data;

public class AutorDTO {
    private String nome;
    private String nacionalidade;
    private String principalObra;
    private int idade;
    private Data dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPrincipalObra() {
        return principalObra;
    }

    public void setPrincipalObra(String principalObra) {
        this.principalObra = principalObra;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
