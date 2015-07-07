import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Fernando
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String arquivo;
        
        System.out.println("Digite o caminho completo do arquivo: ");
        arquivo = scanner.next();
        ProcessaLancamentos pl = new ProcessaLancamentos(arquivo);
        
        ArrayList<Lancamento> lancamentos = (ArrayList<Lancamento>) pl.getLancamentos();
        do{
            String contaS = scanner.next();
            Integer conta = Integer.valueOf(contaS);

            if(conta == 0){
                break;
            }

            if(conta == null){
                System.out.println("Por favor, informe um valor numérico");
                continue;
            }

            if(lancamentos.indexOf(conta)==-1){
                System.out.println("Conta inexistente");
                continue;
            }

            exibeLancamentosConta(lancamentos, conta);
        }while(true);
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        Integer i = lancamentos.indexOf(conta);
        if(i== -1){
            return;
        }
        
        Lancamento lancamen = lancamentos.get(i);
        
        while(lancamen.getConta() == conta){
            System.out.println(lancamen);
            lancamen = lancamentos.get(++i);
        }
    }
 
}