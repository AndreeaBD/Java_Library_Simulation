public abstract class Client {
    private String nume;
    private int cod;
    private int nrCartiImprumutate = 0;
    private String dataRetur = "-";
    
    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    
    public void setNrCartiImprumutate(int nrCartiImprumutate) {
        this.nrCartiImprumutate = nrCartiImprumutate;
    }
    
    public void setDataRetur(String dataRetur) {
        this.dataRetur = dataRetur;
    }
    
    public String getNume() {
        return nume;
    }
    
    public int getNrCartiImprumutate() {
        return nrCartiImprumutate;
    }
    
    public String getDataRetur() {
        return dataRetur;
    }
    
    public int getCod() {
        return cod;
    }
    
    public void imprumuta() {
        nrCartiImprumutate ++;
    }
    
    @Override
    public String toString() {
        return "Client: " + nume + ", cod: " + cod + ", carti diferite imprumutate in total: " 
        + nrCartiImprumutate + ", data retur carte imprumutata: " + dataRetur;
    }
}