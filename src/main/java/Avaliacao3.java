import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial 3
 * @author Fernando
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String caminho, conta;
        List<Lancamento> lista = new ArrayList<>();
        Object erro;
        
        System.out.println("Digite o caminho completo do arquivo: ");
        caminho = scanner.next();
        
        ProcessaLancamentos lancamentos = new ProcessaLancamentos(caminho);
        lista = lancamentos.getLancamentos();
        
        System.out.println("Digite o número da conta: ");
        
        while(!scanner.hasNextInt()) {
                erro = scanner.next();
                System.out.print("Por favor, informe um valor numérico");
        }
        
        while(Integer.parseInt(scanner.toString()) != 0) {
            Integer numerodeconta = scanner.nextInt();
            int indice;
            boolean encontrado = false;
            
            for(int i=0; i< lista.size(); i++) {
                if(lista.get(i).getConta() == numerodeconta) {
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado)
                System.out.print("Conta inexistente");
            else
                exibeLancamentosConta(lista, numerodeconta);

            
            while(!scanner.hasNextInt()) {
                erro = scanner.next();
                System.out.print("Por favor, informe um valor numérico");
                System.out.println("Digite o número da conta: ");
            }
        }
        while(!scanner.hasNextInt()) {
            erro = scanner.next();
            System.out.print("Por favor, informe um valor numérico");
        }
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
  
        for(int i=0; i< lancamentos.size(); i++) {
            if(lancamentos.get(i).getConta() == conta) {
                System.out.println(lancamentos.get(i).toString());
            }
        }
 
    }
}