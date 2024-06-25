public class Prestamo {

    private Libro libro;
    private String cliente;
    private String identificacion;
    private int dias;

    public Prestamo(Libro libro, String cliente, String identificacion, int dias) {
        this.libro = libro;
        this.cliente = cliente;
        this.identificacion = identificacion;
        this.dias = dias;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String toString() {
        return "LIBRO: " + libro.getTitulo() + "  - CLIENTE: " + cliente + "  - ID CLIENTE: " + identificacion+ "  - DIAS: " + dias+ "  - MULTA: " + calcularMulta(dias);
    }

    // Método para calcular la multa
    public int calcularMulta(int dias) {
        if (dias > 7) {
            int diasAtraso = dias - 7;
            return diasAtraso * 1000;
        }
        return 0;
    }


}
