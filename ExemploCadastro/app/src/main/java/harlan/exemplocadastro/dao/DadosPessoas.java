package harlan.exemplocadastro.dao;

import java.util.ArrayList;
import harlan.exemplocadastro.dto.PessoaDTO;

public class DadosPessoas {
    static ArrayList <PessoaDTO> arrayListPessoas=new ArrayList<PessoaDTO>();

    public static void armazenarDados(PessoaDTO dadosPessoas){
        arrayListPessoas.add(dadosPessoas);
    }
    public static String listarDados(){
        String lista="Nome\t\t\t\tCPF";
        for (PessoaDTO array:arrayListPessoas)
            lista = lista + "\n" + array.exibir();
        return lista;
    }
}