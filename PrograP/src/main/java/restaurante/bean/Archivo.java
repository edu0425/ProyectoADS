
package restaurante.bean;

public class Archivo {
    private int idarchivo;
    private String fecha;
    private double total;
    private int idcliente;
    private String nombre;
    
    public Archivo( String fecha, double total, int idcliente) {
        this.fecha = fecha;
        this.total = total;
        this.idcliente = idcliente;
    }
    
    public Archivo(){
        
    }
    
    public int getIdarchivo() {
        return idarchivo;
    }

    public void setIdarchivo(int idarchivo) {
        this.idarchivo = idarchivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
