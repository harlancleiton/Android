package bll;

import java.lang.Exception;

public class Media{
    public static double calcularMedia(double nota1, double nota2, double nota3, double nota4) throws Exception{
        double media, notaMinima=4;
        if (nota1<notaMinima || nota2<notaMinima || nota3<notaMinima || nota4<notaMinima){
            throw new Exception("Nota(s) abaixo do valor mínimo (4,0). Aluno reprovado.");
        }
        else{
            media = (nota1 + nota2 + nota3 + nota4) / 4;
        }
        return media;
    }
}