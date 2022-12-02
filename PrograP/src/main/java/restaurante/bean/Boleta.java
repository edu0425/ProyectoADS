
package restaurante.bean;

public class Boleta {
    private int idboleta;
    private int cantidad;
    private double precio;
    private double subtotal;
    private int idelemento;
    private int idarchivo;
    private String nomelemento;
    private int PrecioSuma;
    private double PrecioFinal;
    private int PrecioTotal;

    public Boleta(int idboleta, int cantidad, double precio, double subtotal, int idelemento , int idarchivo) {
        this.idboleta = idboleta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.idelemento = idelemento;
        this.idarchivo = idarchivo;
    }
    
    

    public Boleta() {
        
    }

    public Boleta(int idelemento, String nomelemento, int cantidad, int precio, int subtotal) {
       this.idelemento = idelemento;
       this.nomelemento = nomelemento;
       this.cantidad = cantidad;
       this.precio = precio;
       this.subtotal = subtotal;
    }

    public int getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(int idboleta) {
        this.idboleta = idboleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(int idelemento) {
        this.idelemento = idelemento;
    }

    public int getIdarchivo() {
        return idarchivo;
    }

    public void setIdarchivo(int idarchivo) {
        this.idarchivo = idarchivo;
    }

    public String getNomelemento() {
        return nomelemento;
    }

    public void setNomelemento(String nomelemento) {
        this.nomelemento = nomelemento;
    }

    public int getPrecioSuma() {
        return PrecioSuma;
    }

    public void setPrecioSuma(int PrecioSuma) {
        this.PrecioSuma = PrecioSuma;
    }

    public double getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioFinal(double PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(int PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }
    
    
    
    
}
