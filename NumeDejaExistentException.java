public class NumeDejaExistentException extends Exception {
    public NumeDejaExistentException() {
        super("Clientul cu acest nume exista deja in baza de date a bibliotecii!");
    }
}