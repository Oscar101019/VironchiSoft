import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;

/**
 * Created by juven on 29/3/2017.
 */
public class Validacion {
  public void CampoVacioCliente (TextField Nombre, TextField Telefono, TextField Direccion, ComboBox Sexo){
        if(Nombre.getText().length()==0) {
            Toolkit.getDefaultToolkit().beep();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Warning Dialog");
            alert.setContentText("Falta nombre");

            alert.showAndWait();


            if ( Direccion.getText().length() == 0) {
                Toolkit.getDefaultToolkit().beep();

                Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Advertencia");
                alert2.setHeaderText("Warning Dialog");
                alert2.setContentText("Falta Telefono");

                alert2.showAndWait();

                if (Sexo.getValue().toString() == "-") {
                    Toolkit.getDefaultToolkit().beep();

                    Alert alert3 = new Alert(Alert.AlertType.WARNING);
                    alert3.setTitle("Advertencia");
                    alert3.setHeaderText("Warning Dialog");
                    alert3.setContentText("Falta Elegir un Sexo");

                    alert3.showAndWait();
                }
            }
        }
    }
    //TextField IDCLIENTE
   public void CampoVacioMascota (TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza,ComboBox Sexo, TextField Descripcion){
        if(IDCLIENTE.getText().toString() == "-") {
            Toolkit.getDefaultToolkit().beep();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Warning Dialog");
            alert.setContentText("Falta nombre");

            alert.showAndWait();


            if (Nombre.getText().length() == 0) {
                Toolkit.getDefaultToolkit().beep();

                Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Advertencia");
                alert2.setHeaderText("Warning Dialog");
                alert2.setContentText("Falta Telefono");

                alert2.showAndWait();
                if (Especie.getText().length() == 0) {
                    Toolkit.getDefaultToolkit().beep();

                    Alert alert3 = new Alert(Alert.AlertType.WARNING);
                    alert3.setTitle("Advertencia");
                    alert3.setHeaderText("Warning Dialog");
                    alert3.setContentText("Falta Telefono");

                    alert3.showAndWait();
                    if (Raza.getText().length() == 0) {
                        Toolkit.getDefaultToolkit().beep();

                        Alert alert4 = new Alert(Alert.AlertType.WARNING);
                        alert4.setTitle("Advertencia");
                        alert4.setHeaderText("Warning Dialog");
                        alert4.setContentText("Falta Telefono");

                        alert4.showAndWait();

                        if (Sexo.getValue().toString() == "-") {
                            Toolkit.getDefaultToolkit().beep();
                            Alert alert5 = new Alert(Alert.AlertType.WARNING);
                            alert5.setTitle("Advertencia");
                            alert5.setHeaderText("Warning Dialog");
                            alert5.setContentText("Falta Elegir un Sexo");
                            alert5.showAndWait();

                            if (Descripcion.getText().length() == 0) {
                                Toolkit.getDefaultToolkit().beep();
                                Alert alert6 = new Alert(Alert.AlertType.WARNING);
                                alert6.setTitle("Advertencia");
                                alert6.setHeaderText("Warning Dialog");
                                alert6.setContentText("Falta Telefono");

                                alert6.showAndWait();
                            }
                        }
                    }
                }
            }
        }
    }

    public void CampoVacioCitaEstetica (TextField Fecha, ComboBox Tamaño, TextField Descripcion,TextField Precio){
        if(Fecha.getText().length()== 0) {
            Toolkit.getDefaultToolkit().beep();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Warning Dialog");
            alert.setContentText("Falta nombre");

            alert.showAndWait();


            if (Tamaño.getValue().toString() == "-") {
                Toolkit.getDefaultToolkit().beep();
                Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Advertencia");
                alert2.setHeaderText("Warning Dialog");
                alert2.setContentText("Selecciona un tamaño");
                alert2.showAndWait();

                if (Descripcion.getText().length() == 0) {
                    Toolkit.getDefaultToolkit().beep();

                    Alert alert3 = new Alert(Alert.AlertType.WARNING);
                    alert3.setTitle("Advertencia");
                    alert3.setHeaderText("Warning Dialog");
                    alert3.setContentText("Falta Descripcion");

                    alert3.showAndWait();

                    if (Precio.getText().length() == 0) {
                        Toolkit.getDefaultToolkit().beep();

                        Alert alert4 = new Alert(Alert.AlertType.WARNING);
                        alert4.setTitle("Advertencia");
                        alert4.setHeaderText("Warning Dialog");
                        alert4.setContentText("Precio");

                        alert4.showAndWait();



                    }
                }
            }
        }
    }

}
