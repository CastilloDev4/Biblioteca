import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       ArrayList<Usuario> usuarios = new ArrayList<>(); // Crear una lista de usuarios vacía
        ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();// Crear una lista de bibliotecarios vacía
        Login login = new Login(usuarios, bibliotecarios);
        login.mostrarFrame();

        //new Login(usuarios, bibliotecarios); // Pasar la lista de usuarios y bibliotecarios al constructor de Login
    }
}