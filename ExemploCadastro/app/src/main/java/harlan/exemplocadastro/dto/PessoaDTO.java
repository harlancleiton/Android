package harlan.exemplocadastro.dto;

public class PessoaDTO {
    private String nome;
    private String cpf;
    public PessoaDTO(String nome, String cpf){
        setNome(nome);
        setCpf(cpf);
    }

    public String exibir(){
        return getNome()+"\t\t\t\t\t"+getCpf();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
