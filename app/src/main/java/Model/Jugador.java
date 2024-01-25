package Model;


public class Jugador
{
    long id;
    String nombre;
    String apellidos;
    int equipo;

    public Jugador(long id, String nombre, String apellidos, int equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
}