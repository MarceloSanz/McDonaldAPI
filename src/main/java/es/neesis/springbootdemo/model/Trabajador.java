package es.neesis.springbootdemo.model;

public class Trabajador {
    private int idTrabajador;
    private String nombre;
    private String cargo;
    private String dni;
    public Trabajador(){

    }

    public Trabajador(int idTrabajador, String nombre, String cargo, String dni) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.cargo = cargo;
        this.dni = dni;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
