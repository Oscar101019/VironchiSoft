import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

/**
 * Created by juven on 29/3/2017.
 */
public class Funciones {
    Validacion validar =new Validacion();
    public void cambiarModo(RadioButton radioButton, TextArea textArea){
        if (radioButton.isSelected()) {
            textArea.setEditable(true);
        }
        if (!radioButton.isSelected()) {
            textArea.setEditable(false);
        }
    }
    public void DatosCliente(TextField Nombre, TextField Direccion, TextField Telefono, ComboBox Sexo){

        String nombre = Nombre.getText();
        String direccion = Direccion.getText();
        String telefono = Telefono.getText();
        String sexo = Sexo.getValue().toString();


        if (Nombre.getText().length()!=0 && Telefono.getText().length() != 0 && Sexo.getValue().toString() != "-") {
            try {

                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
                Statement statement = connection.createStatement();
                ResultSet insertar = statement.executeQuery("insert into cliente (Nombre, Direccion,Telefono,Sexo)values('"+nombre+"','"+direccion+"','"+telefono+"','"+sexo+"') ");
                insertar = statement.executeQuery("insert into adeudo(concepto,Descripcion,CostoTotal) values('M','HOLA',200)");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else { //(NombreTxt.getText().length() == 0 || DireccionTxt.getText().length() == 0 || TelefonoTxt.getText().length() == 0) {
            validar.CampoVacioCliente(Nombre,Direccion,Telefono,Sexo);

        }



    }

   /* public void eventoguardarcliente(TextField Nombre,TextField Direccion, TextField Telefono){
        DatosCliente(Nombre.getText(),Direccion.getText(),Telefono.getText());
    }*/

    public void DatosMascota(TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza, ComboBox Sexo, TextField Descripcion) {
        int IdCliente = Integer.parseInt(IDCLIENTE.getText().toString());
        String nombre = Nombre.getText();
        String especie = Especie.getText();
        String raza = Raza.getText();
        String sexo = Sexo.getValue().toString();
        String descripcion = Descripcion.getText();

        if (IDCLIENTE.getText().toString() != "-" && Nombre.getText().length() != 0 && Especie.getText().length() != 0 && Raza.getText().length() != 0 && Sexo.getValue().toString() != "-" && Descripcion.getText().length() != 0) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
                Statement statement = connection.createStatement();
                ResultSet insertar = statement.executeQuery("insert into mascota (id_Cliente,Nombre,Especie,Raza,Sexo,Descripcion) values(" + IdCliente + ",'" + nombre + "','" + especie + "','" + raza + "','" + sexo + "','" + descripcion + "')");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            validar.CampoVacioMascota(IDCLIENTE, Nombre, Especie, Raza, Sexo, Descripcion);
        }
    }

    /*public void eventoguardarmascota(TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza, TextField Sexo, TextField Descripcion){
         DatosMascota(Integer.parseInt(IDCLIENTE.getText()),Nombre.getText(),Especie.getText(),Raza.getText(),Sexo.getText(),Descripcion.getText());
    }*/

    public void guardarCitaA(String Fecha, String Temperatura, String Peso, RadioButton Norbox, RadioButton AnorBox, String DesAG, RadioButton NorBox2, RadioButton AnorBox2, String DesPiel, RadioButton Norbox3, RadioButton AnorBox3, String DesME, RadioButton NorBox4, RadioButton AnorBox4, String DesCircu, RadioButton Norbox5, RadioButton AnorBox5, String DesRes,
                             RadioButton Norbox6, RadioButton AnorBox6, String DesDige, RadioButton Norbox7, RadioButton Anorbox7, String DesGU, RadioButton Norbox8, RadioButton AnorBox8, String DesOjos, RadioButton Norbox9, RadioButton AnorBox9, String DesOidos, RadioButton Norbox10, RadioButton AnorBox10, String DesSN, RadioButton Norbox11, RadioButton AnorBox11, String DesGanglios, RadioButton Norbox12, RadioButton AnorBox12, String DesMucosa, String PlanesDiagnostico, String ProblemasTemporal,
                             String PlanesTerapeuticos, String InstruccionesCliente, int IDMASCOTA, int IDADEUDO) {
        String N1 = "";
        String N2 = "";
        String N3 = "";
        String N4 = "";
        String N5 = "";
        String N6 = "";
        String N7 = "";
        String N8 = "";
        String N9 = "";
        String N10 = "";
        String N11 = "";
        String N12 = "";


        java.text.SimpleDateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat usuario = new java.text.SimpleDateFormat("dd/MM/yyyy");


        try {
            if (Fecha == usuario.toString()) {
                Fecha = myFormat.format(usuario.parse(Fecha));
            }


        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        try {
            if (Norbox.isSelected()) {
                N1 = "N";
            }

            if (AnorBox.isSelected()) {
                N1 = "A";
            }

            if (NorBox2.isSelected()) {
                N2 = "N";
            }


            if (AnorBox2.isSelected()) {
                N2 = "A";
            }


            if (Norbox3.isSelected()) {
                N3 = "N";
            }

            if (AnorBox3.isSelected()) {
                N3 = "A";
            }

            if (NorBox4.isSelected()) {
                N4 = "N";
            }


            if (AnorBox4.isSelected()) {
                N4 = "A";
            }

            if (Norbox.isSelected()) {
                N5 = "N";
            }

            if (AnorBox5.isSelected()) {
                N5 = "A";

            }

            if (Norbox6.isSelected()) {
                N6 = "N";
            }


            if (AnorBox6.isSelected()) {
                N6 = "A";
            }

            if (Norbox7.isSelected()) {
                N7 = "N";
            }


            if (Anorbox7.isSelected()) {
                N7 = "A";
            }

            if (Norbox8.isSelected()) {
                N8 = "N";
            }

            if (Norbox9.isSelected()) {
                N8 = "N";
            }

            if (AnorBox8.isSelected()) {
                N8 = "A";
            }

            if (Norbox9.isSelected()) {
                N9 = "N";
            }

            if (AnorBox9.isSelected()) {
                N9 = "A";
            }

            if (Norbox10.isSelected()) {
                N10 = "N";
            }


            if (AnorBox10.isSelected()) {
                N10 = "A";
            }

            if (Norbox11.isSelected()) {
                N11 = "N";
            }

            if (AnorBox11.isSelected()) {
                N11 = "A";

            }

            if (Norbox12.isSelected()) {
                N12 = "N";
            }


            if (AnorBox12.isSelected()) {
                N12 = "A";
            }


            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
            Statement statement = connection.createStatement();
            ResultSet insertar = statement.executeQuery("insert into citamed(Fecha,Temperatura,Peso,Apariencia_G,DesAG,Piel,DesPiel,MusculoEsqueleto,DesME,Circulatorio,DesCircu,Respiratorio,DesRes,Digestivo,DesDige,GenitoUrinario,DesGU,Ojos,DesOjos,Oidos,DesOidos,SistemaNervioso,DesSN,Ganglios,DesGanglios,Mucosa,DesMucosa,PlanesDiagnostico,ProblemasTemporal,PlanesTerapeuticos,InstruccionesCli,ID_Mascota,ID_Adeudo) values ('" + Fecha + "','" + Temperatura + "','" + Peso + "','" + N1 + "','" + DesAG + "','" + N2 + "','" + DesPiel + "','" + N3 + "','" + DesME + "','" + N4 + "','" + DesCircu + "','" + N5 + "','" + DesRes + "','" + N6 + "','" + DesDige + "','" + N7 + "','" + DesGU + "','" + N8 + "','" + DesOjos + "','" + N9 + "','" + DesOidos + "','" + N10 + "','" + DesSN + "','" + N11 + "','" + DesGanglios + "','" + N12 + "','" + DesMucosa + "','" + PlanesDiagnostico + "','" + ProblemasTemporal + "','" + PlanesTerapeuticos + "','" + InstruccionesCliente + "'," + IDMASCOTA + "," + IDADEUDO + ")");

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }

    public void eventoguardarcitaA(TextField Fecha, TextField Temperatura, TextField Peso, RadioButton Norbox, RadioButton AnorBox, TextArea AparienciaGeneral, RadioButton Norbox2, RadioButton AnorBox2, TextArea Piel, RadioButton Norbox3, RadioButton AnorBox3,
                                   TextArea MuscoloEesqueleto, RadioButton Norbox4, RadioButton AnorBox4, TextArea Circulatorio, RadioButton Norbox5, RadioButton AnorBox5, TextArea Respiratorio,
                                   RadioButton Norbox6, RadioButton AnorBox6, TextArea Digestivo, RadioButton Norbox7, RadioButton AnorBox7, TextArea GenitoUrinario,
                                   RadioButton Norbox8, RadioButton AnorBox8, TextArea Ojos, RadioButton Norbox9, RadioButton AnorBox9, TextArea Oidos,
                                   RadioButton Norbox10, RadioButton AnorBox10, TextArea SistemaNervioso, RadioButton Norbox11, RadioButton AnorBox11, TextArea Ganglios,
                                   RadioButton Norbox12, RadioButton AnorBox12, TextArea Mucosas, TextArea PlanesDiagnostico, TextArea ProblemasTemporal, TextArea PlanesTerapeuticos, TextArea IntruccionesCliente,
                                   TextField IDMASCOTA, TextField IDADEUDO) {


        guardarCitaA(
                Fecha.getText(), Temperatura.getText(), Peso.getText(),
                Norbox, AnorBox, AparienciaGeneral.getText(),
                Norbox2, AnorBox2, Piel.getText(),
                Norbox3, AnorBox3, MuscoloEesqueleto.getText(),
                Norbox4, AnorBox4, Circulatorio.getText(),
                Norbox5, AnorBox5, Respiratorio.getText(),
                Norbox6, AnorBox6, Digestivo.getText(),
                Norbox7, AnorBox7, GenitoUrinario.getText(),
                Norbox8, AnorBox8, Ojos.getText(),
                Norbox9, AnorBox9, Oidos.getText(),
                Norbox10, AnorBox10, SistemaNervioso.getText(),
                Norbox11, AnorBox11, Ganglios.getText(),
                Norbox12, AnorBox12, Mucosas.getText(),
                PlanesDiagnostico.getText(), ProblemasTemporal.getText(), PlanesTerapeuticos.getText(),
                IntruccionesCliente.getText(), Integer.parseInt(IDMASCOTA.getText()), Integer.parseInt(IDADEUDO.getText()));
    }




}