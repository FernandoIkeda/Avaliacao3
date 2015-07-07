package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Fernando
 */
public class LancamentoComparator <T extends Lancamento> implements Comparator {
    LancamentoComparator(){}
    
    public int compare(T o1, T o2){
        if(o1.getConta() < o2.getConta())
            return -1;
        else if(o1.getConta() > o2.getConta())
            return 1;
        else if(o1.getData().before(o2.getData()))
            return -1;
        else if(o1.getData().after(o2.getData()))
            return 1;
        else return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
       return 0;
    }
}