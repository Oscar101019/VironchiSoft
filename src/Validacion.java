import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import sun.security.krb5.internal.crypto.Des;

import java.awt.*;
import java.awt.Button;
import java.sql.*;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;

/**
 * Created by juven on 29/3/2017.
 */
public class Validacion {
    public void CampoVacioCliente(TextField Nombre, TextField Telefono, TextField Direccion, ComboBox Sexo) {
        if (Nombre.getText().length() == 0) {
            Toolkit.getDefaultToolkit().beep();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Warning Dialog");
            alert.setContentText("Falta nombre");

            alert.showAndWait();


            if (Direccion.getText().length() == 0) {
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
    public void CampoVacioMascota(TextField IDCLIENTE, TextField Nombre, ChoiceBox Especie, ComboBox Raza, ComboBox Sexo, TextField Descripcion) {
        if (IDCLIENTE.getText().toString() == "-") {
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
                if (Especie.getValue().toString().length() == 0) {
                    Toolkit.getDefaultToolkit().beep();

                    Alert alert3 = new Alert(Alert.AlertType.WARNING);
                    alert3.setTitle("Advertencia");
                    alert3.setHeaderText("Warning Dialog");
                    alert3.setContentText("Falta Telefono");

                    alert3.showAndWait();
                    if (Raza.getValue().toString().length() == 0) {
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

    public void CampoVacioCitaEstetica(TextField Fecha, ComboBox Tamaño, TextField Descripcion, TextField Precio) {
        if (Fecha.getText().length() == 0) {
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


    public void popUp2(TextField Precio, TextField Descripcion){

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Confirmacion");






        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);

        javafx.scene.control.Button AceptarBtn = new javafx.scene.control.Button("Guardar");
        javafx.scene.control.Button CancelarBtn = new javafx.scene.control.Button("Cancelar");
        ButtonType loginButtonType = new ButtonType("Aceptar");
        loginButtonType = ButtonType.OK;
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

Label lblPrecio =new Label("Precio");
lblPrecio.setStyle("-fx-text-fill: white");
        Label lblDes =new Label("Descripcion");
        Label lblCon =new Label("Confirmacion");
        lblCon.setStyle("-fx-font-size: 40");
        lblCon.setStyle("-fx-text-fill: white");
        lblDes.setStyle("-fx-text-fill: white");
        Precio.setPromptText("$");
        Descripcion.setPromptText("...");
grid.add(lblCon,0,0);
        grid.add(lblPrecio, 0, 1);

        grid.add(Precio, 1, 1);
        grid.add(lblDes, 0, 2);
        grid.add(Descripcion, 1, 2);

// Enable/Disable login button depending on whether a username was entered.

// Do some validation (using the Java 8 lambda syntax).


        dialog.getDialogPane().setContent(grid);
    dialog.getDialogPane().setStyle("-fx-background-color: #034f84;");





        Optional<ButtonType> result = dialog.showAndWait();

Funciones f = new Funciones();
if (result.get() == loginButtonType) {
     f.GuardarDatosAdeudoM(Descripcion,Precio);

        }



    }
}
