    import javax.swing.*;

    public class Libro {

        private String Titulo;
        private ImageIcon Portada;
        private String Estado;
        private String Genero;


        public Libro(String titulo, ImageIcon portada, String estado, String genero) {
            this.Titulo = titulo;
            this.Portada = portada;
            this.Estado = estado;
            this.Genero = genero;

            System.out.println("C:\\Users\\trivi\\IdeaProjects\\Biblioteca\\src\\Libros\\Clasico1.png" + portada.getDescription());
        }



        public ImageIcon getPortada() {
            return Portada;
        }

        public String getTitulo() {
            return Titulo;
        }

        public String getEstado() {
            return Estado;
        }

        public void setEstado(String estado) {
            Estado = estado;
        }

        public String getGenero() {
            return Genero;
        }


    }
