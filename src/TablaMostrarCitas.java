
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**import javafx.beans.property.StringProperty;
 import javafx.beans.property.SimpleStringProperty;

 /**
 * Created by cristobalvega on 26/03/17.
 * Esta Clase es necesaria para manegar tableView
 *
 */

public class TablaMostrarCitas {

    private final StringProperty cliente;
    private final StringProperty mascota;
    private final StringProperty tipocita;
    private final StringProperty fecha;

    public TablaMostrarCitas(String cliente, String mascota, String tipocita, String  fecha) {
        this.cliente = new SimpleStringProperty(cliente);
        this.mascota = new SimpleStringProperty(mascota);
        this.tipocita = new SimpleStringProperty(tipocita);
        this.fecha = new SimpleStringProperty(fecha);
    }

    public String getCliente() {
        return cliente.get();
    }

    public StringProperty clienteProperty() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente.set(cliente);
    }

    public String getMascota() {
        return mascota.get();
    }

    public StringProperty mascotaProperty() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota.set(mascota);
    }

    public String getTipocita() {
        return tipocita.get();
    }

    public StringProperty tipocitaProperty() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita.set(tipocita);
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

}
