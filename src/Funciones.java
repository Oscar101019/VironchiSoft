import javafx.scene.control.*;

import java.sql.*;
import java.time.LocalDate;

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
        String sexo = "";
        if(Sexo.getValue().toString() == "Hombre"){
            sexo = "H";
        }
        if(Sexo.getValue().toString() == "Mujer"){
            sexo = "M";
        }


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

    public void DatosMascota( String idCliente,TextField Nombre, ChoiceBox Especie, ComboBox Raza, ComboBox Sexo, TextField Descripcion) {
        String idcliente = idCliente;
        String nombre = Nombre.getText();
        String especie = Especie.getValue().toString();
        String raza = Raza.getValue().toString();
        String sexo = "";
        if (Sexo.getValue().toString() == "Hembra"){
            sexo = "H";
        }
        if (Sexo.getValue().toString() == "Macho"){
            sexo = "M";
        }
        String descripcion = Descripcion.getText();

        if (Nombre.getText().length() != 0 && Especie.getValue().toString().length() != 0 && Raza.getValue().toString().length() != 0 && Sexo.getValue().toString() != "-" && Descripcion.getText().length() != 0) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
                Statement statement = connection.createStatement();
                ResultSet insertar = statement.executeQuery("insert into mascota (id_Cliente,Nombre,Especie,Raza,Sexo,Descripcion) values('" + idcliente + "','" + nombre + "','" + especie + "','" + raza + "','" + sexo + "','" + descripcion + "')");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //validar.CampoVacioMascota(Nombre, Especie, Raza, Sexo, Descripcion);
        }
    }

    /*public void eventoguardarmascota(TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza, TextField Sexo, TextField Descripcion){
         DatosMascota(Integer.parseInt(IDCLIENTE.getText()),Nombre.getText(),Especie.getText(),Raza.getText(),Sexo.getText(),Descripcion.getText());
    }*/

    public void guardarCitaA(String Fecha, String Temperatura, String Peso, RadioButton Norbox, RadioButton AnorBox, String DesAG, RadioButton NorBox2, RadioButton AnorBox2, String DesPiel, RadioButton Norbox3, RadioButton AnorBox3, String DesME, RadioButton NorBox4, RadioButton AnorBox4, String DesCircu, RadioButton Norbox5, RadioButton AnorBox5, String DesRes,
                             RadioButton Norbox6, RadioButton AnorBox6, String DesDige, RadioButton Norbox7, RadioButton Anorbox7, String DesGU, RadioButton Norbox8, RadioButton AnorBox8, String DesOjos, RadioButton Norbox9, RadioButton AnorBox9, String DesOidos, RadioButton Norbox10, RadioButton AnorBox10, String DesSN, RadioButton Norbox11, RadioButton AnorBox11, String DesGanglios, RadioButton Norbox12, RadioButton AnorBox12, String DesMucosa, String PlanesDiagnostico, String ProblemasTemporal,
                             String PlanesTerapeuticos, String InstruccionesCliente, String IDMASCOTA, String IDADEUDO) {
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

        String APG = DesAG;
        String CIR = DesCircu;
        String DIJ = DesDige;
        String GAN = DesGanglios;
        String MES = DesME;
        String MUC = DesMucosa;
        String OID = DesOidos;
        String OJO = DesOjos;
        String PIL = DesPiel;
        String RES = DesRes;
        String SNE = DesSN;

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
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
            Statement statement = connection.createStatement();

            if (Norbox.isSelected()) {
                N1 = "N";
            }

            if (AnorBox.isSelected()) {
                N1 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + APG + "','APG')");
            }

            if (NorBox2.isSelected()) {
                N2 = "N";
            }


            if (AnorBox2.isSelected()) {
                N2 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + PIL + "','PIL')");
            }


            if (Norbox3.isSelected()) {
                N3 = "N";
            }

            if (AnorBox3.isSelected()) {
                N3 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + MES + "','MES')");
            }

            if (NorBox4.isSelected()) {
                N4 = "N";
            }


            if (AnorBox4.isSelected()) {
                N4 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + CIR + "','CIR')");
            }

            if (Norbox5.isSelected()) {
                N5 = "N";
            }

            if (AnorBox5.isSelected()) {
                N5 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + DIJ + "','DIJ')");

            }

            if (Norbox6.isSelected()) {
                N6 = "N";
            }


            if (AnorBox6.isSelected()) {
                N6 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + RES + "','RES')");
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

            if (AnorBox8.isSelected()) {
                N8 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + OJO + "','OJO')");
            }

            if (Norbox9.isSelected()) {
                N9 = "N";
            }

            if (AnorBox9.isSelected()) {
                N9 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + OID + "','OID')");
            }

            if (Norbox10.isSelected()) {
                N10 = "N";
            }


            if (AnorBox10.isSelected()) {
                N10 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + SNE + "','SNE')");
            }

            if (Norbox11.isSelected()) {
                N11 = "N";
            }

            if (AnorBox11.isSelected()) {
                N11 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + GAN + "','GAN')");
            }

            if (Norbox12.isSelected()) {
                N12 = "N";
            }


            if (AnorBox12.isSelected()) {
                N12 = "A";
                ResultSet insertar = statement.executeQuery("INSERT INTO detalle_citas values("+ 1 + ",'" + MUC + "','MUC')");
            }



            ResultSet insertar = statement.executeQuery("insert into citamed(Fecha,Temperatura,Peso,Apariencia_G,Piel,MusculoEsqueleto,Circulatorio,Respiratorio,Digestivo,GenitoUrinario,Ojos,Oidos,SistemaNervioso,Ganglios,Mucosa,ProblemasTemporal,PlanesTerapeuticos,InstruccionesCli,ID_Mascota,ID_Adeudo,PlanesDiagnostico) " +
                    "values ('" + Fecha + "','" + Temperatura + "','" + Peso + "','" + N1 + "','" + N2 +
                    "','" + N3 + "','" + N4 + "','" + N5 + "','" + N6 + "','" + N7 + "','" + N8 + "','" + N9 + "','" +
                    N10 + "','" + N11 + "','" + N12 + "','" + ProblemasTemporal + "','" + PlanesTerapeuticos + "','" + InstruccionesCliente + "'," +
                    IDMASCOTA + "," + IDADEUDO + ",'"+ PlanesDiagnostico + "')");

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }

    public void eventoguardarcitaA(LocalDate Fecha, TextField Temperatura, TextField Peso, RadioButton Norbox, RadioButton AnorBox, TextArea AparienciaGeneral, RadioButton Norbox2, RadioButton AnorBox2, TextArea Piel, RadioButton Norbox3, RadioButton AnorBox3,
                                   TextArea MuscoloEesqueleto, RadioButton Norbox4, RadioButton AnorBox4, TextArea Circulatorio, RadioButton Norbox5, RadioButton AnorBox5, TextArea Respiratorio,
                                   RadioButton Norbox6, RadioButton AnorBox6, TextArea Digestivo, RadioButton Norbox7, RadioButton AnorBox7, TextArea GenitoUrinario,
                                   RadioButton Norbox8, RadioButton AnorBox8, TextArea Ojos, RadioButton Norbox9, RadioButton AnorBox9, TextArea Oidos,
                                   RadioButton Norbox10, RadioButton AnorBox10, TextArea SistemaNervioso, RadioButton Norbox11, RadioButton AnorBox11, TextArea Ganglios,
                                   RadioButton Norbox12, RadioButton AnorBox12, TextArea Mucosas, TextArea PlanesDiagnostico, TextArea ProblemasTemporal, TextArea PlanesTerapeuticos, TextArea IntruccionesCliente,
                                   String id_Mascota, String id_Adeudo,String id_Cita) {


        guardarCitaA(
                Fecha.toString(), Temperatura.getText(), Peso.getText(),
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
                IntruccionesCliente.getText(), id_Mascota, id_Adeudo);
    }


public void GuardarDatosAdeudoM(TextField Descripcion, TextField Costo, String Id_Cliente){
    String precio = Costo.getText();
    String descripcion = Descripcion.getText();
    String idCliente = Id_Cliente;
    try {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
        Statement statement = connection.createStatement();
        ResultSet insertar = statement.executeQuery("insert into adeudo(concepto,Descripcion,CostoTotal, Id_Cliente) values('M','"+descripcion+"',"+precio+","+idCliente+")");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void GuardarProducto(TextField Producto,TextField Precio,TextField Cantidad, TextField Agregar){
String producto = Producto.getText();
String precio = Precio.getText();
String cantidad = Cantidad.getText();
String agregar = Agregar.getText();

    try {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
        Statement statement = connection.createStatement();
        ResultSet insertar = statement.executeQuery("insert into producto(ID_Inventario,ID_Proveedor,ID_UnidadMedida,Nombre,PrecioUnitario,CantidadPorUnidad,UnidadesAlmacenadas) values(1,1,1,'"+producto+"','"+precio+"','"+cantidad+"','"+agregar+"')");
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
public void EliminarProducto(ComboBox cmbProducto){
    String cmbproducto = cmbProducto.getValue().toString();
    try {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
        Statement statement = connection.createStatement();
        ResultSet insertar = statement.executeQuery("DELETE FROM producto WHERE Nombre = '"+cmbproducto+"'");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void ModificarProducto(ComboBox cmbProducto,TextField Precio, TextField Cantidad, TextField Agregar ){
    String precio = Precio.getText();
    String cantidad = Cantidad.getText();
    String agregar = Agregar.getText();
    String cmbproducto = cmbProducto.getValue().toString();
    try {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
        Statement statement = connection.createStatement();
        ResultSet insertar = statement.executeQuery("UPDATE producto set PrecioUnitario = "+precio+",CantidadPorUnidad='"+cantidad+"',UnidadesAlmacenadas='"+agregar+"' WHERE Nombre ='"+cmbproducto+"' ");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
/*public String[] BuscarProductos() {
String extraccioncombo[] = {};

    try {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
        Statement statement = connection.createStatement();
        ResultSet buscarcombo = statement.executeQuery("Select Nombre FROM producto ");

        while (buscarcombo.next()) {

            String em = buscarcombo.getString("Nombre");
            String arr = em.replace("\n", ",");
            extraccioncombo =new String[] {buscarcombo.getString("Nombre").concat(buscarcombo.getString("Nombre"))};


        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    for (int i=0; i<extraccioncombo.length;i++){
        System.out.println(extraccioncombo[i]);
    }

return  extraccioncombo;

}*/
}