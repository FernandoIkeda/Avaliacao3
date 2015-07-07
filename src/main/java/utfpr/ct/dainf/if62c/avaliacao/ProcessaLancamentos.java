package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Fernando
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo.getAbsoluteFile()));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
    
    private String getNextLine() throws IOException {
        String linha = reader.readLine();
        return linha;
    }
    
    private Lancamento processaLinha(String linha) {
        Integer conta;
        int ano, mes, dia;
        Date data = new Date();
        String descricao;
        Double valor;
        conta = Integer.valueOf(linha.substring(0,5));
        ano = Integer.parseInt(linha.substring(6,9));
        mes = Integer.parseInt(linha.substring(10,11));
        dia = Integer.parseInt(linha.substring(12,13));
        data.setYear(ano);
        data.setMonth(mes);
        data.setDate(dia);
        descricao = linha.substring(14,73);
        valor = (Double.parseDouble(linha.substring(74))/100);
        
        Lancamento lancamen = new Lancamento(conta, data, descricao, valor);
        return lancamen;
    }
    
    private Lancamento getNextLancamento() throws IOException {
        String linha = getNextLine();
        if(linha == null)
        return null;
        else{
        Lancamento lancamen = processaLinha(linha);
        return lancamen;
        }
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        Lancamento lanc = getNextLancamento();
        ArrayList<Lancamento> lista = new ArrayList<>();
        while(lanc != null){
        lista.add(lanc);
        }
        LancamentoComparator c = new LancamentoComparator();
        Collections.sort(lista, c);
        reader.close();
        return lista;
    }    
}