import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Login {
    private JLabel imagen;
    private JLabel lblTitulo;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JFrame FrameLogin;
    private  List<Usuario> usuarios;
    private List<Bibliotecario> bibliotecarios;



    public Login(ArrayList<Usuario> usuarios, ArrayList<Bibliotecario> bibliotecarios) {
        this.usuarios = usuarios;
        this.bibliotecarios = bibliotecarios;
        //this.bibliotecarios = bibliotecarios != null ? bibliotecarios : new ArrayList<>();

        inicializarUsuarios();
        inicializarBibliotecarios();
        inicializarComponentes();
        configurarComponentes();
        configurarListeners();
        mostrarFrame();


    }

    private void inicializarUsuarios() {
        //usuarios = new ArrayList<>(); //Se crea una array para guardar los usuarios en ella
        // Agrega usuarios a la lista

        usuarios.add(new Usuario("Juan", "1234"));

    }
    private void inicializarBibliotecarios(){
        //bibliotecarios = new ArrayList<>();
        if (bibliotecarios == null) {
            bibliotecarios = new ArrayList<>();
        }

        bibliotecarios.add(new Bibliotecario("Victor", "1234"));

    }



    private void inicializarComponentes() {
        FrameLogin = new JFrame("Login Frame");
        imagen = new JLabel();
        lblTitulo = new JLabel("BIENVENIDO");
        txtUser = new JTextField("USUARIO");
        txtPassword = new JPasswordField();
        btnLogin = new JButton("LOGIN");
    }

    private void configurarComponentes() {
        FrameLogin.setSize(500, 500);
        Color colorFondo = new Color(210, 211, 215);
        FrameLogin.getContentPane().setBackground(colorFondo);
        FrameLogin.setLayout(null);
        FrameLogin.setUndecorated(true);  // quitar los bordes de el frame, si te parece que no se ve bien lo quitas
        FrameLogin.setLocationRelativeTo(null);

        // Se crea un objeto ImageIcon para el icono de la ventana
        ImageIcon icon = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\loginIcono.png");
        FrameLogin.setIconImage(icon.getImage());
        // Se crea un objeto JLabel para la imagen de la ventana
        imagen.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\biblioteca-log.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        imagen.setBounds(200, 30, 200, 100);
        FrameLogin.add(imagen);

        lblTitulo.setBounds(187, 150, 200, 50);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(66, 148, 255));
        FrameLogin.add(lblTitulo);

        txtUser.setBounds(160, 250, 180, 40);
        txtUser.setBorder(BorderFactory.createEmptyBorder());
        txtUser.setHorizontalAlignment(JTextField.CENTER);
        txtUser.setFont(new Font("Arial", Font.BOLD, 14));
        txtUser.selectAll();
        FrameLogin.add(txtUser);

        txtPassword.setBounds(160, 300, 180, 40);
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        txtPassword.setHorizontalAlignment(JTextField.CENTER);
        txtPassword.setEchoChar('*'); // Muestra asteriscos en lugar de los caracteres reales
        txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
        FrameLogin.add(txtPassword);

        btnLogin.setBounds(165, 400, 175, 50);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(66, 148, 255));
        btnLogin.setBorder(BorderFactory.createEtchedBorder());
        FrameLogin.add(btnLogin);
    }


    private void configurarListeners() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText();  // Obtiene el texto del campo de texto
                String password = new String(txtPassword.getPassword()); // Obtiene el texto del campo de contraseña

                // se hace un bucle sobre la lista de usuarios que recorra toda el array hasta encontrar una coincidencia
                Usuario usuarioExistente = usuarios.stream()
                        .filter(usuario -> usuario.getUsername().equals(username) && usuario.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);
                Bibliotecario bibliotecarioExistente = bibliotecarios.stream()
                        .filter(bibliotecario -> bibliotecario.getUsername().equals(username) && bibliotecario.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);
                if (usuarioExistente   != null) {
                    // Usuario encontrado, iniciar sesión
                    JOptionPane.showMessageDialog(null, "Bienvenido, Usuario " + username, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    Interfaz interfaz = new Interfaz((ArrayList<Usuario>) usuarios, (ArrayList<Bibliotecario>) bibliotecarios);
                    interfaz.desactivarBotonUsuarios();
                    interfaz.mostrarInterfaz();
                    FrameLogin.dispose();
                } else if (bibliotecarioExistente != null) {
                    // Bibliotecario encontrado, iniciar sesión
                    JOptionPane.showMessageDialog(null, "Bienvenido, Bibliotecario " + username, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    Interfaz interfaz = new Interfaz((ArrayList<Usuario>) usuarios, (ArrayList<Bibliotecario>) bibliotecarios);
                    interfaz.mostrarInterfaz();
                    FrameLogin.dispose();
                } else {
                    // Usuario no encontrado, mostrar mensaje de error
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }


    public void mostrarFrame() {
        FrameLogin.setVisible(true);
        FrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }
