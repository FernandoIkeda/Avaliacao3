package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;
import java.util.Date;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial 3
 * @author Fernando
 */
public class LancamentoComparator implements Comparator<Lancamento> {

    @Override
    public int compare(Lancamento lancamento1, Lancamento lancamento2) {
        if(compareConta(lancamento1.getConta(), lancamento2.getConta()) == 0) 
            return lancamento1.getData().compareTo(lancamento2.getData());
        else
            return compareConta(lancamento1.getConta(), lancamento2.getConta());
    }
    
    public int compareConta(Integer conta1, Integer conta2) {
        if(conta1 == conta2) 
            return 0;
        else if(conta1 > conta2) 
            return 1;
        else 
            return -1;
        
    }
    
}