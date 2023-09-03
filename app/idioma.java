public class idioma {

    private String Nombre;
    private String Saludo;

    public idioma(String nombre, String saludo) {
        Nombre = nombre;
        Saludo = saludo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getSaludo() {
        return Saludo;
    }

    public void setSaludo(String saludo) {
        Saludo = saludo;
    }
}
