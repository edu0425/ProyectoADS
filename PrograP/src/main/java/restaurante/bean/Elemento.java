
package restaurante.bean;

public class Elemento {
    private int idelemento;
    private String elemento;
    private int precio;

    public Elemento(int idelemento, String elemento, int precio) {
        this.idelemento = idelemento;
        this.elemento = elemento;
        this.precio = precio;
    }

    public Elemento() {
     
    }

    public int getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(int idelemento) {
        this.idelemento = idelemento;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
