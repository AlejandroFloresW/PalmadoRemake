package uca.edu.palmado;

public class Pokemons {
    private String id, nombre, descripcion;
    private int idImg;

    public Pokemons(String id, String nombre, String descripcion, int idImg) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idImg = idImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}