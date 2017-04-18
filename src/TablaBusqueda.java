import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by titab on 14/04/2017.
 */
public class TablaBusqueda {
    private final SimpleStringProperty nombreCliente;
    private final SimpleStringProperty nombreMascota;
    private final SimpleStringProperty telefono;
    private final SimpleStringProperty direccion;

    public TablaBusqueda(String nombreCliente, String nombreMascota, String telefono, String direccion){
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
        this.nombreMascota = new SimpleStringProperty(nombreMascota);
        this.telefono = new SimpleStringProperty(telefono);
        this.direccion = new SimpleStringProperty(direccion);
    }//Fin constructor

    public String getNombreCliente() {
        return nombreCliente.get();
    }

    public StringProperty nombreClienteProperty() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente.set(nombreCliente);
    }

    public String getNombreMascota() { return nombreMascota.get();}

    public StringProperty nombreMascotaProperty() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {this.nombreMascota.set(nombreMascota);}

    public String getTelefono() {
        return telefono.get();
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {this.direccion.set(direccion);}
}//FIN CLASE
