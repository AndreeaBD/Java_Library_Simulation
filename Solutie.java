import java.util.*;

public class Solutie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(t1);
        t2.start();
        
        while(true) {
            System.out.println("\nIntroduceti comanda: (A - afisare lista comenzi)");
            String comanda = scanner.nextLine();
            String[] cuvant = comanda.split("\\s+");
            
            switch(cuvant[0]) {
                case "exit": System.out.println("La revedere!");
                             System.exit(0);
                case "A": System.out.println("adaugaStudent(String nume, int cod, int anStudiu)\n" +
                                             "adaugaProfesor(String nume, int cod, String materiePredata)\n" +
                                             "afiseazaClienti()\n" +
                                             "afiseazaStudenti()\n" + 
                                             "adaugaCarte(String titlu, String autor, int cod, String gen, int nrPagini)\n" +
                                             "afiseazaCarti()\n" +
                                             "afiseazaCartiDisponibile()\n" +
                                             "cautaCarte(String titlu)\n" +
                                             "filtreazaCartiDupaGen(String gen)\n" +
                                             "sorteazaCarti()\n" +
                                             "sorteazaClienti()\n" +
                                             "celMaiFidelCititor()\n" +
                                             "imprumutaCarte(int cod, String numeClient)\n" +
                                             "returneazaCarte(int cod, String numeClient)\n" +
                                             "stergeCarte(String titlu)\n" +
                                             "stergeClient(String nume)\n" +
                                             "arePenalitati(String nume)\n" +
                                             "verificareIstoricCarte(String titlu)\n" +
                                             "-------------------------------------------------\n");
                                             break;
                case "adaugaStudent": try{
                                          Student s = new Student();
                                          s.setNume(cuvant[1]);
                                          s.setCod(Integer.parseInt(cuvant[2]));
                                          s.setAnStudiu(Integer.parseInt(cuvant[3]));
                                          Biblioteca.getInstance().adaugaClient(s);
                                          System.out.println("A fost adaugat un student.");
                                     } catch (NumeDejaExistentException e) {
                                         System.out.println(e.getMessage());
                                     }
                                      break;
                case "adaugaProfesor": try {
                                           Profesor p = new Profesor();
                                           p.setNume(cuvant[1]);
                                           p.setCod(Integer.parseInt(cuvant[2]));
                                           p.setMateriePredata(cuvant[3]);
                                           Biblioteca.getInstance().adaugaClient(p);
                                           System.out.println("A fost adaugat un profesor.");
                                      } catch (NumeDejaExistentException e) {
                                           System.out.println(e.getMessage());
                                      }
                                      break;
                case "afiseazaClienti": Biblioteca.getInstance().afiseazaClienti();
                                        break;
                case "afiseazaStudenti": Biblioteca.getInstance().afiseazaStudenti();
                                        break;
                case "adaugaCarte": Carte c = new Carte();
                                    c.setTitlu(cuvant[1]);
                                    c.setAutor(cuvant[2]);
                                    c.setCod(Integer.parseInt(cuvant[3]));
                                    c.setGen(cuvant[4]);
                                    c.setNrPagini(Integer.parseInt(cuvant[5]));
                                    Biblioteca.getInstance().adaugaCarte(c);
                                    System.out.println("A fost adaugata o carte.");
                                    break;
                case "afiseazaCarti": Biblioteca.getInstance().afiseazaCarti();
                                      break;
                case "afiseazaCartiDisponibile": Biblioteca.getInstance().afiseazaCartiDisponibile();
                                                 break;
                case "cautaCarte": Biblioteca.getInstance().cautaCarte(cuvant[1]);
                                   break;
                case "filtreazaCartiDupaGen": Biblioteca.getInstance().filtreazaCartiDupaGen(cuvant[1]);
                                              break;
                case "sorteazaCarti": Biblioteca.getInstance().sorteazaCarti();
                                      break;
                case "sorteazaClienti": Biblioteca.getInstance().sorteazaClienti();
                                        break;
                case "celMaiFidelCititor": Biblioteca.getInstance().celMaiFidelCititor();
                                           break;
                case "imprumutaCarte": try {
                                           Biblioteca.getInstance().imprumutaCarte(Integer.parseInt(cuvant[1]), cuvant[2]);
                                       } catch (NumarMaximCartiException e) {
                                           System.out.println(e.getMessage());
                                       } catch (CarteIndisponibilaException e) {
                                           System.out.println(e.getMessage());
                                           System.out.println("Introduceti alt cod.");
                                       }
                                       break;
                case "returneazaCarte": try {
                                            Biblioteca.getInstance().returneazaCarte(Integer.parseInt(cuvant[1]), cuvant[2]);
                                        } catch (CarteIndisponibilaException e) {
                                            System.out.println(e.getMessage());
                                           System.out.println("Introduceti alt cod.");
                                        }
                                        break;
                case "stergeCarte": Biblioteca.getInstance().stergeCarte(cuvant[1]);
                                    break;
                case "stergeClient": Biblioteca.getInstance().stergeClient(cuvant[1]);
                                     break;
                case "arePenalitati": Biblioteca.getInstance().arePenalitati(cuvant[1]);
                                      break;
                case "verificareIstoricCarte": try {
                                                    Biblioteca.getInstance().verificareIstoricCarte(cuvant[1]);
                                               } catch (CarteIndisponibilaException e) {
                                                    System.out.println(e.getMessage());
                                                    System.out.println("Introduceti alt cod.");
                                               }
                                               break; 
                default: System.out.println("Comanda invalida!");
            }
        }
    }
}