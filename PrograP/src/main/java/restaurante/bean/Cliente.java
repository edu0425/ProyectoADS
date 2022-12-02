
package restaurante.bean;

public class Cliente {
    private int idcliente;
    private int numero;
    private String nombre;

    public Cliente( String nombre,int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public Cliente() {
  
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
    
}
