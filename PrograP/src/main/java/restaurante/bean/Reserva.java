
package restaurante.bean;

public class Reserva {
    private int idreserva;
    private int npersonas;
    private String Fecha;
    private String Hora;
    private int idcliente;
    private String nombre;
    private int num;
    

    public Reserva( int npersonas, String Fecha, String Hora, int idcliente) {     
        this.npersonas = npersonas;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.idcliente = idcliente;
    }

    public Reserva() {
      
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getNpersonas() {
        return npersonas;
    }

    public void setNpersonas(int npersonas) {
        this.npersonas = npersonas;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    
    
}
