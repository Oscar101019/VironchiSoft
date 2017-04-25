import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by juven on 24/4/2017.
 */
public class TablaProductosCobrar {

    private final StringProperty nombre;
    private final StringProperty precio_unidad;
    private final StringProperty unidad_medida;

    public TablaProductosCobrar(String nombre, String precio_unidad, String unidad_medida) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio_unidad = new SimpleStringProperty(precio_unidad);
        this.unidad_medida = new SimpleStringProperty(unidad_medida);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getPrecio_unidad() {
        return precio_unidad.get();
    }

    public StringProperty precio_unidadProperty() {
        return precio_unidad;
    }

    public void setPrecio_unidad(String precio_unidad) {
        this.precio_unidad.set(precio_unidad);
    }

    public String getUnidad_medida() {
        return unidad_medida.get();
    }

    public StringProperty unidad_medidaProperty() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida.set(unidad_medida);
    }
}
