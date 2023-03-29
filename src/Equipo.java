public class Equipo {
    public String nombre;
    public int goles;

    public Equipo(String nombre, int resultado) {
        this.nombre = nombre;
        this.goles = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGoles() {
        return goles;
    }

}
