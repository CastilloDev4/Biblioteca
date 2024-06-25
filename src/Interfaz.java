import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Interfaz {

    public static JFrame FrameInterfaz;
    private JPanel panelLateral;
    private JPanel panelSuperior;
    public JLabel lblmenu, lblLibreria, lblUser, lblGenero, lblImagenLibro, lblNombreLibro, lblEstadoLibro, lblLibrosPrestamos, lblClientePrestamos, lblClienteIdentificacion, lblDiasPrestados;
    public JLabel lblLibrosPrestados, lblClientesConMora;
    public JTextField txtClientePrestamos, txtDiasPrestados, txtClienteIdentificacion;
    private JLabel lblImgUser, lblImgPrestamo;
    public static JTextField txtUser, txtPassword;
    private JComboBox<String> cbTipoUsuario;
    private JButton btnCrearUser, btnCrearPrestamo;
    private JButton btnLibros, btnReportes, btnPrestamos, btnUsuarios, btnLiquidarMora, btnRetornarLibro;
    private JPopupMenu menuLog;
    private JMenuItem logOut, closeApp;
    private CardLayout cardLayout;//Renombrar?
    private JPanel panelContenedor;
    private JPanel panelLibros, panelReportes, panelPrestamos, panelUsuarios;
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> librosPrestamos;
    private ArrayList<Prestamo> clientesConMora;
    private JComboBox<String> cbGenero, cbLibrosPrestamos, cbClientesConMora;
    private JPanel librosPanel;
    private JList<String> listaLibros, listaPrestamos;
    private JScrollPane scrollPaneLibros, scrollPaneLibrosPrestados;
    public DefaultListModel<String> model;
    public DefaultListModel<String> modeloLista;
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Bibliotecario> bibliotecarios;







    public Interfaz(ArrayList<Usuario> usuarios, ArrayList<Bibliotecario> bibliotecarios) {
        this.usuarios = usuarios;
        this.bibliotecarios = bibliotecarios;

        inicializarComponentes();
        configurarComponentes();
        configurarListeners();


    }

    private void inicializarComponentes() {
        FrameInterfaz = new JFrame("Biblioteca");
        panelLateral = new JPanel();
        panelSuperior = new JPanel();
        lblmenu = new JLabel();
        lblLibreria = new JLabel();
        lblUser = new JLabel();
        btnLibros = new JButton("Libros");
        btnReportes = new JButton("Reportes");
        btnPrestamos = new JButton("Prestamos");
        btnUsuarios = new JButton("Usuarios");
        menuLog = new JPopupMenu();
        logOut = new JMenuItem("Cerrar Sesion");
        closeApp = new JMenuItem("Cerrar Aplicacion");
        cardLayout = new CardLayout();
        panelContenedor = new JPanel();
        panelLibros = new JPanel();
        panelReportes = new JPanel();
        panelPrestamos = new JPanel();
        panelUsuarios = new JPanel();
        libros = new ArrayList<>();
        cbGenero = new JComboBox<>();
        librosPanel = new JPanel(new GridLayout(0,3));
        lblGenero = new JLabel("Selecciona el genero:");
        listaLibros = new JList<>();
        scrollPaneLibros = new JScrollPane(listaLibros);
        scrollPaneLibrosPrestados = new JScrollPane(listaPrestamos);
        model = new DefaultListModel<>();
        lblImagenLibro = new JLabel();
        lblNombreLibro = new JLabel();
        lblEstadoLibro = new JLabel();
        lblImgUser = new JLabel();
        txtPassword = new JTextField();
        txtUser = new JTextField();
        cbTipoUsuario = new JComboBox<>();
        cbLibrosPrestamos = new JComboBox<>();
        btnCrearUser = new JButton("CREAR USUARIO");
        usuarios = new ArrayList<>();
        lblLibrosPrestamos = new JLabel("Selecciona el libro a prestar:");
        lblClientePrestamos = new JLabel("Nombre del cliente:");
        txtClientePrestamos = new JTextField();
        lblClienteIdentificacion = new JLabel("Numero de identificación:");
        txtClienteIdentificacion = new JTextField();
        lblDiasPrestados = new JLabel("Dias a prestar:");
        txtDiasPrestados = new JTextField();
        btnCrearPrestamo = new JButton("PRESTAR LIBRO");
        modeloLista = new DefaultListModel<>();
        listaPrestamos = new JList<>(modeloLista);
        librosPrestamos = new ArrayList<>();
        lblLibrosPrestados = new JLabel("Libros Prestados:");
        lblClientesConMora = new JLabel("Clientes con mora:");
        cbClientesConMora = new JComboBox<>();
        clientesConMora = new ArrayList<>();
        btnLiquidarMora = new JButton("LIQUIDAR MORA");
        btnRetornarLibro = new JButton("RETORNAR LIBRO");
        lblImgPrestamo = new JLabel();


    }


    private void configurarComponentes() {
        //Configuracion de Frame
        FrameInterfaz.setSize(1200, 650);
        Color colorFondo = new Color(255, 255, 255);
        FrameInterfaz.getContentPane().setBackground(colorFondo);
        FrameInterfaz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FrameInterfaz.setLayout(null);
        FrameInterfaz.setLocationRelativeTo(null);
        FrameInterfaz.setResizable(false);

        //Dedclaracion de Objetos de tipo libro

        // TERROR
        Libro TerrorIt = new Libro("IT", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Terror1.png"), "Disponible", "Terror");
        Libro terorHillHouse = new Libro("THE HAUNTING OF HILL HOUSE", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Terror2.png"), "Disponible", "Terror");
        Libro TerrorDracula = new Libro("DRACULA", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Terror3.png"), "Disponible", "Terror");
        Libro TerrorExorcit = new Libro("THE EXORCIST", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Terror4.png"), "Disponible", "Terror");
        Libro TerrorPetSematary = new Libro("PET SEMATARY", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Terror5.png"), "Disponible", "Terror");
        //INGENIERIA
        Libro IngStructure = new Libro("Structures: Or Why Things Don't Fall Down", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Ing1.png"), "Disponible", "Ingenieria");
        Libro IngToIng = new Libro("TO ENGINEER IS HUMAN", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Ing2.png"), "Disponible", "Ingenieria");
        Libro IngTheDesing = new Libro("THE DESING OF EVERYDAY THINGS", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Ing3.png"), "Disponible", "Ingenieria");
        Libro IngExistential = new Libro("EXISTENTIAL PLEASURES OF ENGINEERING", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Ing4.png"), "Disponible", "Ingenieria");
        Libro IngTheSoul = new Libro("THE SOUL OF A MACHINE", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Ing5.png"), "Disponible", "Ingenieria");
        //CLASICOS
        Libro ClasPride = new Libro("PRIDE AND JUSTICE", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico1.png"), "Disponible", "Clasicos");
        Libro ClasJane = new Libro("JANE EYRE", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico2.png"), "Disponible", "Clasicos");
        Libro ClasMoby = new Libro("MOBY DICK", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico3.png"), "Disponible", "Clasicos");
        Libro ClasPicture = new Libro("THE PICTURE OF DORIAN GREY", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico4.png"), "Disponible", "Clasicos");
        Libro ClasCrime = new Libro("CRIME AND PUNISHMENT", new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico5.png"), "Disponible", "Clasicos");

        // Agregar los objetos a la lista
        libros.add(TerrorIt);
        libros.add(terorHillHouse);
        libros.add(TerrorDracula);
        libros.add(TerrorExorcit);
        libros.add(TerrorPetSematary);


        libros.add(IngStructure);
        libros.add(IngToIng);
        libros.add(IngTheDesing);
        libros.add(IngExistential);
        libros.add(IngTheSoul);

        libros.add(ClasPride);
        libros.add(ClasJane);
        libros.add(ClasMoby);
        libros.add(ClasPicture);
        libros.add(ClasCrime);


        //Ciclo para agregar los libros a el modelo
        for (Libro libro : libros) {
            model.addElement(libro.getTitulo());
        }

        listaLibros.setFont(new Font("Arial", Font.BOLD, 20));
        listaLibros.setModel(model);



        //Configuracion de Panel Lateral
        panelLateral.setBounds(0, 0, 200, 650);
        panelLateral.setBackground(new Color(114, 163, 238));
        panelLateral.setLayout(null);
        FrameInterfaz.add(panelLateral);

        //Configuracion del panel superior
        panelSuperior.setBounds(200, 0, 1000, 100);
        panelSuperior.setBackground(new Color(0, 12, 29));
        panelSuperior.setLayout(null);
        FrameInterfaz.add(panelSuperior);

        //Configuracion del label menu
        ImageIcon iconomenu = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\menu.png");
        Image menuEscaled = iconomenu.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(menuEscaled);
        lblmenu.setIcon(iconoEscalado);
        lblmenu.setBounds(60,50,80,80);
        panelLateral.add(lblmenu);


        //Imagen libreria
        ImageIcon iconoLibreria = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\biblioteca-log.png");
        Image libreriaEscaled = iconoLibreria.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoLibreriaEscalad = new ImageIcon(libreriaEscaled);
        lblLibreria.setIcon(iconoLibreriaEscalad);
        lblLibreria.setBounds(440, 10, 80, 80);
        panelSuperior.add(lblLibreria);


        //Imagen user
        ImageIcon iconoUser = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\usuario.png");
        Image userEscaled = iconoUser.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon iconoUserEscalad = new ImageIcon(userEscaled);
        lblUser.setIcon(iconoUserEscalad);
        lblUser.setBounds(900, 10, 70, 70);
        panelSuperior.add(lblUser);


        //Agregar items al menu
        menuLog.add(logOut);
        menuLog.add(closeApp);

        // Configuracion de botones
        btnLibros.setBounds(25, 180, 150, 60);
        btnLibros.setBackground(new Color(255, 255, 255));
        btnLibros.setFont(new Font("Arial", Font.BOLD, 20));
        panelLateral.add(btnLibros); // Agrega el botón al panel lateral

        btnReportes.setBounds(25, 260, 150, 60);
        btnReportes.setBackground(new Color(255, 255, 255));
        btnReportes.setFont(new Font("Arial", Font.BOLD, 20));
        panelLateral.add(btnReportes); // Agrega el botón al panel lateral

        btnPrestamos.setBounds(25, 340, 150, 60);
        btnPrestamos.setBackground(new Color(255, 255, 255));
        btnPrestamos.setFont(new Font("Arial", Font.BOLD, 20));
        panelLateral.add(btnPrestamos); // Agrega el botón al panel lateral

        btnUsuarios.setBounds(25, 420, 150, 60);
        btnUsuarios.setBackground(new Color(255, 255, 255));
        btnUsuarios.setFont(new Font("Arial", Font.BOLD, 20));
        panelLateral.add(btnUsuarios); // Agrega el botón al panel lateral
        //////


        //Configuracion de panel contenedor
        panelContenedor.setBounds(200, 100, 1000, 550);
        panelContenedor.setLayout(cardLayout);
        FrameInterfaz.add(panelContenedor);

        //agregar paneles al panel contenedor
        panelContenedor.add(panelLibros, "Libros");
        panelContenedor.add(panelReportes, "Reportes");
        panelContenedor.add(panelPrestamos, "Prestamos");
        panelContenedor.add(panelUsuarios, "Usuarios");

        //Configuracion de los paneles
        panelLibros.setBackground(new Color(215, 218, 218));
        panelLibros.setLayout(null);

        panelReportes.setBackground(new Color(215, 218, 218));
        panelReportes.setLayout(null);

        panelPrestamos.setBackground(new Color(215, 218, 218));
        panelPrestamos.setLayout(null);

        panelUsuarios.setBackground(new Color(215, 218, 218));
        panelUsuarios.setLayout(null);

        //Configuracion de los libros
        panelLibros.add(librosPanel, BorderLayout.CENTER);

        //configuracion del cbGenero
        cbGenero.setBounds(25, 100, 150, 40);
        cbGenero.addItem("Todos");
        cbGenero.addItem("Terror");
        cbGenero.addItem("Ingenieria");
        cbGenero.addItem("Clasicos");
        panelLibros.add(cbGenero);


        //CONFIGURACION DE TODO EL BOTON PRESTAMO


        // COMBOBOX ELEGIR LIBRO
        cbLibrosPrestamos.setBounds(225, 25, 150, 30);
        cbLibrosPrestamos.setBorder(BorderFactory.createEmptyBorder());
        cbLibrosPrestamos.addItem("--");

        for(Libro libro : libros) {
            cbLibrosPrestamos.addItem(libro.getTitulo());
        }
        panelPrestamos.add(cbLibrosPrestamos);

        lblLibrosPrestamos.setBounds(10, 30, 300, 20);
        lblLibrosPrestamos.setFont(new Font("Arial", Font.BOLD, 15));
        panelPrestamos.add(lblLibrosPrestamos);

        lblClientePrestamos.setBounds(10, 80, 300, 20);
        lblClientePrestamos.setFont(new Font("Arial", Font.BOLD, 15));
        panelPrestamos.add(lblClientePrestamos);

        txtClientePrestamos.setBounds(165, 75, 250, 30);
        txtClientePrestamos.setBorder(BorderFactory.createEmptyBorder());
        txtClientePrestamos.setFont(new Font("Arial", Font.BOLD, 13));
        txtClientePrestamos.setHorizontalAlignment(JTextField.CENTER);
        panelPrestamos.add(txtClientePrestamos);

        lblClienteIdentificacion.setBounds(10, 130, 300, 20);
        lblClienteIdentificacion.setFont(new Font("Arial", Font.BOLD, 15));
        panelPrestamos.add(lblClienteIdentificacion);

        txtClienteIdentificacion.setBounds(200, 125, 250, 30);
        txtClienteIdentificacion.setBorder(BorderFactory.createEmptyBorder());
        txtClienteIdentificacion.setFont(new Font("Arial", Font.BOLD, 13));
        txtClienteIdentificacion.setHorizontalAlignment(JTextField.CENTER);
        panelPrestamos.add(txtClienteIdentificacion);

        lblDiasPrestados.setBounds(10, 180, 300, 20);
        lblDiasPrestados.setFont(new Font("Arial", Font.BOLD, 15));
        panelPrestamos.add(lblDiasPrestados);

        txtDiasPrestados.setBounds(120, 175, 50, 30);
        txtDiasPrestados.setBorder(BorderFactory.createEmptyBorder());
        txtDiasPrestados.setFont(new Font("Arial", Font.BOLD, 13));
        txtDiasPrestados.setHorizontalAlignment(JTextField.CENTER);
        panelPrestamos.add(txtDiasPrestados);

        btnCrearPrestamo.setBounds(200, 250, 150, 40);
        btnCrearPrestamo.setBackground(new Color(66, 148, 255));
        btnCrearPrestamo.setBorder(BorderFactory.createEtchedBorder());
        panelPrestamos.add(btnCrearPrestamo);




        //Config de label
        lblGenero.setBounds(25, 60, 180, 35);
        lblGenero.setFont(new Font("Arial", Font.BOLD, 15));
        lblGenero.setForeground(Color.BLUE);
        panelLibros.add(lblGenero);

        lblImagenLibro.setBounds(700, 80, 200, 300);
        lblNombreLibro.setBounds(720, 60, 200, 20);
        lblNombreLibro.setFont(new Font("Arial", Font.BOLD, 15));
        lblEstadoLibro.setBounds(700, 390, 200, 20);
        lblEstadoLibro.setFont(new Font("Arial", Font.BOLD, 15));


        panelLibros.add(lblImagenLibro);
        panelLibros.add(lblNombreLibro);
        panelLibros.add(lblEstadoLibro);

        //Config elementos panel Users
        ImageIcon iconoUser2 = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\persona.png");
        Image user2Escaled = iconoUser2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblImgUser.setIcon(new ImageIcon(user2Escaled));
        lblImgUser.setBounds(450, 50, 120, 120);
        panelUsuarios.add(lblImgUser);

        txtUser.setBounds(400, 280, 200, 40);
        txtUser.setBorder(BorderFactory.createEmptyBorder());
        txtUser.setFont(new Font("Arial", Font.BOLD, 20));
        txtUser.setHorizontalAlignment(JTextField.CENTER);


        txtPassword.setBounds(400, 340, 200, 40);
        txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        txtPassword.setHorizontalAlignment(JTextField.CENTER);


        cbTipoUsuario.setBounds(400, 220, 200, 40);
        cbTipoUsuario.addItem("Usuario");
        cbTipoUsuario.addItem("Bibliotecario");

        btnCrearUser.setBounds(430, 400, 140, 40);
        btnCrearUser.setBackground(new Color(66, 148, 255));
        btnCrearUser.setBorder(BorderFactory.createEtchedBorder());

        panelUsuarios.add(txtUser);
        panelUsuarios.add(txtPassword);
        panelUsuarios.add(cbTipoUsuario);
        panelUsuarios.add(btnCrearUser);



        //Configuracion de la lista de libros
        scrollPaneLibros.setBounds(250, 80, 400, 400);

        // Agregar la lista al panel (the scroll pane)
        panelLibros.add(scrollPaneLibros);

        listaPrestamos.setFont(new Font("Arial", Font.BOLD, 13));
        listaPrestamos.setBounds(50, 40, 600, 400);

        panelReportes.add(listaPrestamos);

        lblLibrosPrestados.setBounds(50, 10, 200, 20);
        lblLibrosPrestados.setFont(new Font("Arial", Font.BOLD, 15));
        panelReportes.add(lblLibrosPrestados);

        panelReportes.add(scrollPaneLibrosPrestados);
        scrollPaneLibrosPrestados.setBounds(50, 40, 400, 400);

        lblClientesConMora.setBounds(550, 10, 200, 20);
        lblClientesConMora.setFont(new Font("Arial", Font.BOLD, 15));
        //panelReportes.add(lblClientesConMora);

        cbClientesConMora.setBounds(550, 40, 300, 30);
        //panelReportes.add(cbClientesConMora);

        btnLiquidarMora.setBounds(700, 200, 170, 50);
        btnLiquidarMora.setBackground(new Color(66, 148, 255));
        btnLiquidarMora.setBorder(BorderFactory.createEtchedBorder());
        panelReportes.add(btnLiquidarMora);


        ImageIcon imgPrestamo = new ImageIcon("C:\\Users\\victo\\IdeaProjects\\Biblioteca\\src\\Imagenes\\biblioteca-en-la-nube.png");
        Image imgPrestamoEscalada = imgPrestamo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        panelPrestamos.add(new JLabel(new ImageIcon(imgPrestamoEscalada))).setBounds(600, 100, 200, 200);








    }

    private void configurarListeners() {
        logOut.addActionListener(e -> {
            FrameInterfaz.dispose();
           new Login(usuarios, bibliotecarios);

        });

        closeApp.addActionListener(e -> {
            System.exit(0);
        });


        listaLibros.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String tituloSeleccionado = listaLibros.getSelectedValue();
                Libro libroSeleccionado = libros.stream()
                        .filter(libro -> libro.getTitulo().equals(tituloSeleccionado))
                        .findFirst()
                        .orElse(null);
                if (libroSeleccionado != null) {
                    ImageIcon imageIcon = libroSeleccionado.getPortada();
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // Redimensionar a 200x300
                    imageIcon = new ImageIcon(newimg);
                    lblImagenLibro.setIcon(imageIcon);
                    lblNombreLibro.setText(libroSeleccionado.getTitulo());
                    lblEstadoLibro.setText(libroSeleccionado.getEstado());
                }
            }
        });


        lblUser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLog.show(lblUser, evt.getX(), evt.getY());
            }
        });

        btnLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Libros");
            }
        });

        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Reportes");
            }
        });

        btnPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Prestamos");
            }
        });

        btnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Usuarios");
            }
        });

        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText();
                String password = txtPassword.getText();

                if (cbTipoUsuario.getSelectedItem().equals("Usuario")) {
                    if (!username.isEmpty() && !password.isEmpty()) {
                        Usuario nuevoUsuario = new Usuario(username, password);
                        usuarios.add(nuevoUsuario);
                        JOptionPane.showMessageDialog(FrameInterfaz, "Usuario creado exitosamente");
                        txtUser.setText("");
                        txtPassword.setText("");
                         FrameInterfaz.dispose();
                        new Login(usuarios, bibliotecarios); // Pass the list of users to the new Login instance
                    } else {
                        JOptionPane.showMessageDialog(FrameInterfaz, "Por favor, ingrese un nombre de usuario y una contraseña");
                    }
                } else if (cbTipoUsuario.getSelectedItem().equals("Bibliotecario")) {
                    if (!username.isEmpty() && !password.isEmpty()) {
                        Bibliotecario nuevoBibliotecario = new Bibliotecario(username, password);
                        bibliotecarios.add(nuevoBibliotecario);
                        JOptionPane.showMessageDialog(FrameInterfaz, "Bibliotecario creado exitosamente");
                        txtUser.setText("");
                        txtPassword.setText("");
                        FrameInterfaz.dispose();
                        new Login(usuarios, bibliotecarios); // Pass the list of users to the new Login instance
                    } else {
                        JOptionPane.showMessageDialog(FrameInterfaz, "Por favor, ingrese un nombre de usuario y una contraseña");
                    }
                }
            }
        });

        //filtrado del combobox
        cbGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generoSeleccionado = (String) cbGenero.getSelectedItem();
                DefaultListModel<String> modelFiltrado = new DefaultListModel<>();

                for (Libro libro : libros) {
                    if (libro.getGenero().equals(generoSeleccionado) || generoSeleccionado.equals("Todos")) {
                        modelFiltrado.addElement(libro.getTitulo());
                    }
                }

                listaLibros.setModel(modelFiltrado);
            }
        });



        btnCrearPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String libroSeleccionado = (String) cbLibrosPrestamos.getSelectedItem();
                String cliente = txtClientePrestamos.getText();
                String identificacion = txtClienteIdentificacion.getText();
                String diasPrestadosStr = txtDiasPrestados.getText();

                // Verificar si la identificación contiene solo dígitos
                if (!identificacion.matches("\\d+")) {
                    JOptionPane.showMessageDialog(FrameInterfaz, "Digite valores numericos");
                    return;
                }

                // Verificar si los días prestados son un número válido
                int dias;
                try {
                    dias = Integer.parseInt(diasPrestadosStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FrameInterfaz, "Digite un valor numerico");
                    return;
                }

                // Verificar si la identificación ya está registrada en algún préstamo
                if (librosPrestamos.stream().anyMatch(p -> p.getIdentificacion().equals(identificacion))) {
                    JOptionPane.showMessageDialog(FrameInterfaz, "Esta identificación ya está asociada a otro préstamo");
                    return;
                }

                if (libroSeleccionado.equals("--") || cliente.isEmpty() || identificacion.isEmpty() || dias == 0) {
                    JOptionPane.showMessageDialog(FrameInterfaz, "Por favor, complete todos los campos");
                } else {
                    Libro libro = libros.stream()
                            .filter(l -> l.getTitulo().equals(libroSeleccionado))
                            .findFirst()
                            .orElse(null);
                    if (libro != null && libro.getEstado().equals("Disponible")) {
                        libro.setEstado("Prestado");
                        JOptionPane.showMessageDialog(FrameInterfaz, "Libro prestado con exito");
                        librosPrestamos.add(new Prestamo(libro, cliente, identificacion, dias));

                        modeloLista.clear();
                        for(Prestamo prestamo : librosPrestamos){
                            modeloLista.addElement(prestamo.toString());
                        }
                        listaPrestamos.setModel(modeloLista);

                        txtClientePrestamos.setText("");
                        txtClienteIdentificacion.setText("");
                        txtDiasPrestados.setText("");
                    } else{
                        JOptionPane.showMessageDialog(FrameInterfaz, "El libro no esta disponible");
                        txtClientePrestamos.setText("");
                        txtClienteIdentificacion.setText("");
                        txtDiasPrestados.setText("");
                    }
                }
            }
        });




        btnLiquidarMora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice del elemento seleccionado en la JList
                int selectedIndex = listaPrestamos.getSelectedIndex();
                if (selectedIndex != -1) { // Verificar si se ha seleccionado algún elemento
                    // Obtener el préstamo seleccionado en la lista
                    Prestamo prestamo = librosPrestamos.get(selectedIndex);

                    // Acceder al libro asociado al préstamo
                    Libro libroPrestado = prestamo.getLibro();

                    // Cambiar el estado del libro a Disponible
                    libroPrestado.setEstado("Disponible");

                    // Remover el préstamo de la lista de préstamos
                    librosPrestamos.remove(selectedIndex);

                    // Actualizar el modelo de la JList
                    modeloLista.remove(selectedIndex);
                    listaPrestamos.setModel(modeloLista);

                    JOptionPane.showMessageDialog(FrameInterfaz, "Mora liquidada con éxito y libro devuelto");

                } else {
                    // Si no se ha seleccionado ningún elemento, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(FrameInterfaz, "Seleccione un préstamo para liquidar la mora y devolver el libro.");
                }
            }
        });










    }




    public int calcularMulta(int dias) {
        if (dias > 7) {
            int diasAtraso = dias - 7;
            return diasAtraso * 1000;
        }
        return 0;
    }
    public void desactivarBotonUsuarios() {
        btnUsuarios.setEnabled(false);
    }



    public void mostrarInterfaz() {
        FrameInterfaz.setVisible(true); // Hace visible el JFrame existente
    }

}