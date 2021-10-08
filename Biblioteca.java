import java.util.*;
import java.util.Arrays;
import java.time.*;

public class Biblioteca {
    private static Biblioteca instance = null;
    public static int nrCarti = 0;
    
    private Biblioteca() {
        
    }
    
    public static Biblioteca getInstance() {
        if(instance == null) {
            instance = new Biblioteca();
        }
        
        return instance;
    }
    
    private List<Carte> carti = new ArrayList<>();
    private List<Client> clienti = new ArrayList<>();
    
    public void adaugaCarte(Carte c) {
        carti.add(c);
        nrCarti++;
    }
    
    public void afiseazaCarti() {
        if(carti.isEmpty()) {
            System.out.println("Nu exista carti in bibilioteca.");
        } else {
            carti.forEach(System.out::println);
        }
    }
    
    public void stergeCarte(String titlu) {
        for(int i = 0; i < carti.size(); i++) {
            if(carti.get(i).getTitlu().equals(titlu)) {
                carti.remove(i);
            }
        }
    }
    
    public void stergeClient(String nume) {
        for(int i = 0; i < clienti.size(); i++) {
            if(clienti.get(i).getNume().equals(nume)) {
                clienti.remove(i);
            }
        }
    }
    
    public void adaugaClient(Client c) throws NumeDejaExistentException {
        for(Client client : clienti) {
            if(client.getNume().equals(c.getNume())) {
                throw new NumeDejaExistentException();
            }
        }
        
        clienti.add(c);
    }
    
    public void afiseazaClienti() {
        clienti.forEach(System.out::println);
    }
    
    public void afiseazaStudenti() {
        for(Client c : clienti) {
            if(c instanceof Student) {
                System.out.println(c);
            }
        }
    }
    
    public void afiseazaCartiDisponibile() {
        System.out.println("Cartile disponibile spre a fi imprumutate: ");
        for(int i = 0; i < carti.size(); i++) {
            if(carti.get(i).esteDisponibila()) {
                System.out.println(carti.get(i).getTitlu() + " ");
            }
        }
    }
    
    public void cautaCarte(String titlu) {
        for(Carte i : carti) {
            if(i.getTitlu().equals(titlu)) {
                System.out.println(i.toString());
                return;
            }
        }
    }
    
    public void filtreazaCartiDupaGen(String gen) {
        System.out.print("Cartile de gen " + gen + " din biblioteca sunt: ");
        for(Carte i : carti) {
            if(i.getGen().equals(gen)) {
                System.out.println(i.getTitlu() + " ");
            }
        }
    }
    
    public void sorteazaCarti() {
        carti.sort((Carte c1, Carte c2) -> c1.getNrPagini() - c2.getNrPagini());
        carti.forEach(System.out::println);
    }
    
    public void sorteazaClienti() {
        clienti.sort((Client c1, Client c2) -> c1.getNume().compareTo(c2.getNume()));
        clienti.forEach(c -> System.out.println(c.getNume()));
    }
    
    public void imprumutaCarte(int cod, String numeClient) throws CarteIndisponibilaException, NumarMaximCartiException {
        boolean carteDisponibila = false;
        boolean clientulExista = true;
        
        for(int j = 0; j <  clienti.size(); j++) {     
            if(clienti.get(j).getNume().equals(numeClient) && clienti.get(j).getDataRetur() != "-") {
               throw new NumarMaximCartiException();             
            }
        }
        
        for(int i = 0; i < carti.size(); i++) {
            if(carti.get(i).getCod() == cod) {
                if(carti.get(i).esteDisponibila()) {
                    carteDisponibila = true;
                    carti.get(i).imprumuta();
                    nrCarti--;
                    if(!carti.get(i).getProprietari().contains(numeClient)) {
                        clientulExista = false;
                        carti.get(i).adaugaProprietar(numeClient);
                        carti.get(i).cresteNrProprietari();
                    }
                    for(int j = 0; j <  clienti.size(); j++) {     
                        if(clienti.get(j).getNume().equals(numeClient)) {
                            clienti.get(j).setDataRetur(LocalDate.now().plusDays(20).toString());
                            if(clientulExista == false) {
                                clienti.get(j).imprumuta();
                            }    
                        }
                    }
                        
                } else {
                    throw new CarteIndisponibilaException();
                }
            }
        }
                
        if(carteDisponibila == false) {
            throw new CarteIndisponibilaException();
        }
     }
     
    public void returneazaCarte(int cod, String numeClient) throws CarteIndisponibilaException {
        boolean carteDisponibila = false;
        
        for(int i = 0; i < carti.size(); i++) {
            if(carti.get(i).getCod() == cod) {
                carti.get(i).returneaza();
                carteDisponibila = true;
                nrCarti++;
            }
        }
        
        if(carteDisponibila == false) {
            throw new CarteIndisponibilaException();
        }
        
        for(int i = 0; i <  clienti.size(); i++) {
            if(clienti.get(i).getNume().equals(numeClient)) {
                clienti.get(i).setDataRetur("-");
            }
        }
    }
    
    public void arePenalitati(String numeClient) {
        for(Client c : clienti) {
            if(c.getNume().equals(numeClient)) {
                if(c.getDataRetur().compareTo(LocalDate.now().toString()) > 0) {
                    System.out.println("Clientul are penalitati.");
                } else {
                    System.out.println("Clientul nu are penalitati.");
                }
            }
        }
    }
    
    public void celMaiFidelCititor() {
        int max = 0;
        Client celMaiFidel = null;
        
        for(Client c : clienti) {
            if(c.getNrCartiImprumutate() > max) {
                celMaiFidel = c;
            }
        }
        
        if(celMaiFidel == null) {
            System.out.println("Nu a fost imprumutata nicio carte!");
        } else {
            System.out.println(celMaiFidel);
        }
    }
    
    public void verificareIstoricCarte(String titlu) throws CarteIndisponibilaException {
        boolean carteDisponibila = false;
        
        for(int i = 0; i < carti.size(); i++) {
            if(carti.get(i).getTitlu().equals(titlu)) {
                System.out.print("Cartea a avut " + carti.get(i).getNrProprietari() + " proprietari: "+ carti.get(i).getProprietari());
                carteDisponibila = true;
                break;
            }
        }
        
        if(carteDisponibila == false) {
            throw new CarteIndisponibilaException();
        }
    }
}