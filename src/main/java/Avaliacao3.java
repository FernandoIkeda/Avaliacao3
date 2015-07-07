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
    System.out.println("Digite o caminho completo do arquivo: ");
    String s = scanner.next();
    ProcessaLancamentos p = new ProcessaLancamentos(s);
    List<Lancamento> lancamentos = p.getLancamentos();
    List<Lancamento> contas;
    
    System.out.println("Digite números de conta: ");
    int i = scanner.nextInt();
    
    while(i!=0){
        contas = Avaliacao3.exibeLancamentosConta(lancamentos,i);
        for(Lancamento l: contas)
        System.out.println(l);
        System.out.println("Digite números de conta: ");
        i = scanner.nextInt();
    }
 }
    public static List<Lancamento> exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
    ArrayList<Lancamento> a = new ArrayList<>();
    for(Lancamento l: lancamentos){
        if (l.getConta() == conta)
            a.add(l);
        }
    if(a == null)
        return null;
    return(a.subList(0, a.size()));
   }
}