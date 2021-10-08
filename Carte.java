import java.util.*;

public class Carte {
    private String titlu;
    private String autor;
    private String gen;
    private int nrPagini;
    private int cod;
    private boolean imprumutata = false;
    private int nrProprietari = 0;
    private List<String> proprietari = new ArrayList();
    
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setGen(String gen) {
        this.gen = gen;
    }
    
    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }
    
    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public void cresteNrProprietari() {
        this.nrProprietari++;
    }
    
    public void adaugaProprietar(String nume) {
        proprietari.add(nume);
    }
    
    public int getNrProprietari() {
        return nrProprietari;
    }
    
    public String getProprietari() {
        return proprietari.toString();
    }
    
    public String getTitlu() {
        return titlu;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getGen() {
        return gen;
    }
    
    public int getNrPagini() {
        return nrPagini;
    }
    
    public int getCod() {
        return cod;
    }
    
    public boolean esteDisponibila() {
        return !imprumutata;
    }
    
    public void imprumuta() {
        imprumutata = true;
    }
    
    public void returneaza() {
        imprumutata = false;
    }
    
    @Override
    public String toString() {
        return "Titlu: " + titlu + ", autor: " + autor + ", gen: " + gen + 
                ", numar de pagini: " + nrPagini + ", status: " + (this.esteDisponibila() ? "disponibila." : "imprumutata.");
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        
        if(o instanceof Carte) {
            Carte c = (Carte)o;
            return this.getTitlu().equals(c.getTitlu());
        }
        
        return false;
    }
}