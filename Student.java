public class Student extends Client {
    private String facultate;
    private int anStudiu;
    
    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }
    
    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }
    
    public String getFacultate() {
        return facultate;
    }
    
    public int getAnStudiu() {
        return anStudiu;
    }
}