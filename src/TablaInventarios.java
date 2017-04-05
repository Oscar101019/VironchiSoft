import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by cristobalvega on 4/5/17.
 */
public class TablaInventarios {

    private final StringProperty nombre;
    private final StringProperty cantidad_unidad;
    private final StringProperty precio_unidad;
    private final StringProperty unidad_medida;

    public TablaInventarios(String nombre, String cantidad_unidad, String precio_unidad, String unidad_medida) {
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad_unidad = new SimpleStringProperty(cantidad_unidad);
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

    public String getCantidad_unidad() {
        return cantidad_unidad.get();
    }

    public StringProperty cantidad_unidadProperty() {
        return cantidad_unidad;
    }

    public void setCantidad_unidad(String cantidad_unidad) {
        this.cantidad_unidad.set(cantidad_unidad);
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
