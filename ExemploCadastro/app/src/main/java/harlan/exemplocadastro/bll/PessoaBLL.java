package harlan.exemplocadastro.bll;

public class PessoaBLL {
    public static boolean validarCpf(String cpf) throws Exception{
        if (cpf.length()==11)
            return true;
        else
            throw new Exception("CPF invalido digitado");
    }
}