package Model;

public class Equipo {
    long id;
    String nombre;
    String estadio;

    public Equipo(long id, String nombre, String estadio) {
        this.id = id;
        this.nombre = nombre;
        this.estadio = estadio;
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

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
}