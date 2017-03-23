
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.smartcardio.ATR;
import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.text.Normalizer;

/**
 * ZetCode JavaFX tutorial
 *
 * This program places five labels into
 * the BorderPane's five areas.
 *
 * Author: Jan Bodnar
 * Website: zetcode.com
 * Last modified: June 2015
 */

/*class MyLabel extends Label {


    public MyLabel(String text) {
        super(text);

        setAlignment(Pos.BASELINE_CENTER);
    }
}*/

public class Main extends Application {

    private BorderPane root,root1,rootCM,rootCE,rootC,rootM;
    private final int SIZE = 60;
    Stage window;
    Scene scene,sceneAgregar, sceneCitaM, sceneCitaE,sceneACliente,sceneAMascota;                    //M=Medica       E=Estetica

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {
        window =stage;
        root = new BorderPane();
        root1= new BorderPane();
        rootCM =new BorderPane();
        rootCE =new BorderPane();
        rootC= new BorderPane();
        rootM = new BorderPane();

        root.setCenter(CentroPrincipal());
        root.setTop(BotonesArribaPrincipal());

        root1.setTop(BotonesArribaPrincipal());
        root1.setCenter(BtnAbajoAgendarCita());

        rootCM.setTop(BotonesArribaPrincipal());
        rootCM.setCenter(CentroCM());
        rootCM.setRight(DerechaCM());

        //rootCM.setBottom(BtnAtras());

       // rootC.setBottom(BtnHome());
        rootC.setCenter(DatosCliente());
        rootC.setTop(BotonesArribaPrincipal());
       //rootCE.setBottom(BtnHome());

      //  rootM.setBottom(BtnHome());
        rootM.setCenter(DatosMascota());
        rootM.setTop(BotonesArribaPrincipal());

        rootCE.setCenter(CitaEstetica());
        rootCE.setTop(BotonesArribaPrincipal());


        scene = new Scene(root, 1150, 700);
        sceneAgregar = new Scene (root1,1150, 700);
        sceneCitaM =new Scene (rootCM,1150,700 );
        sceneCitaE =new Scene (rootCE,1150,700 );

        sceneACliente =new Scene (rootC,1150,700 );
        sceneAMascota = new Scene (rootM,1150,700);
        stage.setTitle("VironchiSoft");

        stage.setScene(scene);
        stage.show();
    }


    //Parte de abajo con botones de ventana Cita Medica
    private  void BtnHome(Button button) {

        button.setOnAction( e-> window.setScene(scene));

    }



    //Parte de la derecha de ventana Cita Medica
    private  HBox DerechaCM() {

        HBox root = new HBox(10);
        root.setPadding(new Insets(0,100,0,0));
        root.setAlignment(Pos.TOP_LEFT);


        Label lblProblemasTemp =new Label ("LISTA DE PROBLEMAS (TEMPORAL)");
        Label lblPlanesD=new Label ("PLANES DIAGNOSTICOS");
        Label lblPlanesT =new Label ("PLANES TERAPEUTICOS");
        Label lblInstrucciones =new Label ("INSTRUCCIONES CLIENTE");

        TextArea textAreaProb = new TextArea();
        TextArea textAreaPlanesD = new TextArea();
        TextArea textAreaPlanesT = new TextArea();
        TextArea textAreaInstrucciones = new TextArea();

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(15);

        textAreaProb.setPrefRowCount(3);
        textAreaProb.setPrefWidth(20);
        textAreaPlanesD.setPrefRowCount(3);
        textAreaPlanesD.setPrefWidth(20);
        textAreaPlanesT.setPrefRowCount(3);
        textAreaPlanesT.setPrefWidth(20);
        textAreaInstrucciones.setPrefRowCount(3);
        textAreaInstrucciones.setPrefWidth(20);

        gridpane.add(lblProblemasTemp,0,3);
        gridpane.add(textAreaProb,0,4);

        gridpane.add (lblPlanesD, 0,5);
        gridpane.add(textAreaPlanesD,0,6);

        gridpane.add (lblPlanesT, 0,7);
        gridpane.add(textAreaPlanesT,0,8);

        gridpane.add (lblInstrucciones, 0,9);
        gridpane.add(textAreaInstrucciones,0,10);







        root.getChildren().addAll(gridpane);

        return  root;
    }



    //Parte centro ventana Principal
    private Label CentroPrincipal() {

        Label lbl = new Label("Bienvenido a VironchiSoft");
        lbl.setStyle("-fx-font-weight: bold");
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(4*SIZE));
        lbl.prefWidthProperty().bind(root.widthProperty().subtract(2*SIZE));

        return lbl;
    }

    //Parte del centro de ventana Seleccionar Cita medica o Cita estetica
    private  HBox BtnAbajoAgendarCita() {

        HBox root = new HBox(10);
        root.setPadding(new Insets(250,50,20,50));
        root.setAlignment(Pos.TOP_CENTER);


        Button CitaMBtn =new Button( "Cita Medica");
        Button CitaEBtn = new Button( "Cita Estetica");
        Button AgregarCliente = new Button( "Agregar cliente");

        CitaMBtn.setOnAction( e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction( e -> window.setScene(sceneCitaE));
        AgregarCliente.setOnAction( e -> window.setScene(sceneACliente));
        Label lbl = new Label("Agregar Cita");
        lbl.setStyle("-fx-font-weight: bold");
       /* lbl.prefHeightProperty().bind(root.heightProperty().subtract(2*SIZE));
        lbl.prefWidthProperty().bind(root.widthProperty().subtract(2*SIZE));*/



        root.getChildren().addAll(lbl,AgregarCliente);

        return  root;
    }

    //Parte del centro de ventana Cita Medica
    private  HBox CentroCM() {

        HBox root = new HBox(10);
        root.setPadding(new Insets(30,20,0,20));

        root.setAlignment(Pos.TOP_CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(15);
        gridpane.setVgap(10);


        Label lbl1 = new Label( "APARIENCIA GENERAL");
        Label lbl2 = new Label( "PIEL");
        Label lbl3= new Label( "MUSCULOSQUELETO");
        Label lbl4 = new Label( "RESPIRATORIO");
        Label lbl5 = new Label( "DIGESTIVO");
        Label lbl6 = new Label( "RESPIRATORIO");
        Label lbl7 = new Label( "GENITOURINARIO");
        Label lbl8 = new Label( "OJOS");
        Label lbl9 = new Label( "OIDOS");
        Label lbl10 = new Label( "SISTEMA NERVIOSO");
        Label lbl11 = new Label( "GANGLIOS");
        Label lbl12 = new Label( "MUCOSAS");


        TextArea textArea1 = new TextArea();
        TextArea  textArea2 = new TextArea();
        TextArea  textArea3 = new TextArea();
        TextArea textArea4 = new TextArea();
        TextArea textArea5 = new TextArea();
        TextArea textArea6 = new TextArea();
        TextArea textArea7 = new TextArea();
        TextArea textArea8 = new TextArea();
        TextArea textArea9 = new TextArea();
        TextArea textArea10 = new TextArea();
        TextArea textArea11 = new TextArea();
        TextArea textArea12 = new TextArea();



        textArea1.setPrefRowCount(1);
        textArea2.setPrefRowCount(1);
        textArea3.setPrefRowCount(1);
        textArea4.setPrefRowCount(1);
        textArea5.setPrefRowCount(1);
        textArea6.setPrefRowCount(1);
        textArea7.setPrefRowCount(1);
        textArea8.setPrefRowCount(1);
        textArea9.setPrefRowCount(1);
        textArea10.setPrefRowCount(1);
        textArea11.setPrefRowCount(1);
        textArea12.setPrefRowCount(1);

        textArea1.setEditable(false);
        textArea2.setEditable(false);
        textArea3.setEditable(false);
        textArea4.setEditable(false);
        textArea5.setEditable(false);
        textArea6.setEditable(false);
        textArea7.setEditable(false);
        textArea8.setEditable(false);
        textArea9.setEditable(false);
        textArea10.setEditable(false);
        textArea11.setEditable(false);
        textArea12.setEditable(false);




        CheckBox NorBox=new CheckBox("Normal");
        CheckBox NorBox2=new CheckBox("Anormal");
        CheckBox NorBox3=new CheckBox("Normal");
        CheckBox NorBox4=new CheckBox("Normal");
        CheckBox NorBox5=new CheckBox("Normal");
        CheckBox NorBox6=new CheckBox("Normal");
        CheckBox NorBox7=new CheckBox("Normal");
        CheckBox NorBox8=new CheckBox("Normal");
        CheckBox NorBox9= new CheckBox("Normal");
        CheckBox NorBox10=new CheckBox("Normal");
        CheckBox NorBox11=new CheckBox("Normal");
        CheckBox NorBox12= new CheckBox("Normal");

        CheckBox AnorBox =new CheckBox("Anormal");
        CheckBox AnorBox2 =new CheckBox("Anormal");
        CheckBox AnorBox3 =new CheckBox("Anormal");
        CheckBox AnorBox4 =new CheckBox("Anormal");
        CheckBox AnorBox5 =new CheckBox("Anormal");
        CheckBox AnorBox6 =new CheckBox("Anormal");
        CheckBox AnorBox7 =new CheckBox("Anormal");
        CheckBox AnorBox8 =new CheckBox("Anormal");
        CheckBox AnorBox9 =new CheckBox("Anormal");
        CheckBox AnorBox10 =new CheckBox("Anormal");
        CheckBox AnorBox11 =new CheckBox("Anormal");
        CheckBox AnorBox12=new CheckBox("Anormal");


        gridpane.add(lbl1,0,0);
        gridpane.add(NorBox,1,0);
        gridpane.add(AnorBox,2,0);
        gridpane.add(textArea1, 3, 0);


        gridpane.add(lbl2,0,1);
        gridpane.add(NorBox2,1,1);
        gridpane.add(AnorBox2,2,1);
        gridpane.add(textArea2, 3, 1);

        gridpane.add(lbl3,0,2);
        gridpane.add(NorBox3,1,2);
        gridpane.add(AnorBox3,2,2);
        gridpane.add(textArea3, 3, 2);

        gridpane.add(lbl4,0,3);
        gridpane.add(NorBox4,1,3);
        gridpane.add(AnorBox4,2,3);
        gridpane.add(textArea4, 3, 3);

        gridpane.add(lbl5,0,4);
        gridpane.add(NorBox5,1,4);
        gridpane.add(AnorBox5,2,4);
        gridpane.add(textArea5, 3, 4);

        gridpane.add(lbl6,0,5);
        gridpane.add(NorBox6,1,5);
        gridpane.add(AnorBox6,2,5);
        gridpane.add(textArea6, 3, 5);

        gridpane.add(lbl7,0,6);
        gridpane.add(NorBox7,1,6);
        gridpane.add(AnorBox7,2,6);
        gridpane.add(textArea7, 3, 6);

        gridpane.add(lbl8,0,7);
        gridpane.add(NorBox8,1,7);
        gridpane.add(AnorBox8,2,7);
        gridpane.add(textArea8, 3, 7);

        gridpane.add(lbl9,0,8);
        gridpane.add(NorBox9,1,8);
        gridpane.add(AnorBox9,2,8);
        gridpane.add(textArea9, 3, 8);

        gridpane.add(lbl10,0,9);
        gridpane.add(NorBox10,1,9);
        gridpane.add(AnorBox10,2,9);
        gridpane.add(textArea10, 3, 9);

        gridpane.add(lbl11,0,10);
        gridpane.add(NorBox11,1,10);
        gridpane.add(AnorBox11,2,10);
        gridpane.add(textArea11, 3, 10);

        gridpane.add(lbl12,0,11);
        gridpane.add(NorBox12,1,11);
        gridpane.add(AnorBox12,2,11);
        gridpane.add(textArea12, 3, 11);


        AnorBox.setOnAction(e->cambiarModo(AnorBox,textArea1));
        AnorBox2.setOnAction(e->cambiarModo(AnorBox2,textArea2));
        AnorBox3.setOnAction(e->cambiarModo(AnorBox3,textArea3));
        AnorBox4.setOnAction(e->cambiarModo(AnorBox4,textArea4));
        AnorBox5.setOnAction(e->cambiarModo(AnorBox5,textArea5));
        AnorBox6.setOnAction(e->cambiarModo(AnorBox6,textArea6));
        AnorBox7.setOnAction(e->cambiarModo(AnorBox7,textArea7));
        AnorBox8.setOnAction(e->cambiarModo(AnorBox8,textArea8));
        AnorBox9.setOnAction(e->cambiarModo(AnorBox9,textArea9));
        AnorBox10.setOnAction(e->cambiarModo(AnorBox10,textArea10));
        AnorBox11.setOnAction(e->cambiarModo(AnorBox11,textArea11));
        AnorBox12.setOnAction(e->cambiarModo(AnorBox12,textArea12));

        root.getChildren().addAll(gridpane);

        return  root;
    }

    public void cambiarModo(CheckBox checkBox,TextArea textArea){
        if (checkBox.isSelected()) {
            textArea.setEditable(true);
        }
        if (!checkBox.isSelected()) {
            textArea.setEditable(false);
        }
    }

    //Botones de la parte de arriba para cambiar de ventanas
    private HBox BotonesArribaPrincipal () {
        HBox root = new HBox(40);
        root.setPadding(new Insets(5,0,20,0));
        root.setAlignment(Pos.TOP_CENTER);

        Button CitaBtn = new Button("MOSTRAR CITA");
        Button ACitaBtn = new Button("AGENDAR CITA");
        Button InvBtn = new Button("INVENTARIO");
        Button ProvBtn = new Button("PROVEEDORES");
        Button MasBtn = new Button( "+");


        root.getChildren().addAll(CitaBtn, ACitaBtn, InvBtn, ProvBtn,MasBtn);
        ACitaBtn.setOnAction( e -> window.setScene (sceneAgregar));
        CitaBtn.setOnAction( e-> window.setScene(scene));

        return root;
    }

    //Campos de la ventana Agregar citas
    private HBox DatosMascota() {

        HBox root = new HBox(1);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(1));
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        root.setPadding(new Insets(5,0,5,0));
        root.setAlignment(Pos.TOP_CENTER);

        Button GuardarMascotaBtn= new Button( "Guardar Mascota");
        Button CitaMBtn =new Button( "Cita Medica");
        Button CitaEBtn = new Button( "Cita Estetica");
        Label lblTitulo = new Label("FORMULARIO PARA AGREGAR MASCOTA");

        Label lblNombre = new Label("Nombre:");
        Label lblEspecie=new Label("Especie:");
        Label lblRaza = new Label ("Raza:");
        Label lblSexo = new Label ("Sexo:");
        Label lblEdad = new Label ("Edad:");





        TextField NombreTxt = new TextField();
        TextField EspecieTxt = new TextField();
        TextField RazaTxt = new TextField();
        TextField SexoTxt = new TextField();
        TextField EdadTxt = new TextField();



        gridpane.add(lblTitulo,1,20);

        gridpane.add(lblNombre,0,30);
        gridpane.add(NombreTxt,1,30);

        gridpane.add(lblEspecie,0,31);
        gridpane.add(EspecieTxt,1,31);

        gridpane.add(lblRaza,0,32);
        gridpane.add(RazaTxt,1,32);

        gridpane.add(lblSexo,0,33);
        gridpane.add(SexoTxt,1,33);

        gridpane.add(lblEdad,0,34);
        gridpane.add(EdadTxt,1,34);

        gridpane.add(GuardarMascotaBtn,1,40);
        gridpane.add(CitaMBtn,5,31);
        gridpane.add(CitaEBtn,5,33);

        CitaMBtn.setOnAction( e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction( e -> window.setScene(sceneCitaE));


        root.getChildren().addAll(gridpane);
        return root;
    }
    private HBox DatosCliente() {

        HBox root = new HBox(5);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);


        Button AgregarMascotaBtn= new Button( "Agregar Mascota");
        Button GuardarClienteBtn= new Button( "Guardar Cliente");
        Button AtrasBtn= new Button( "Atras");

        Label lblNombre = new Label("Nombre:");
        Label lblDireccion =new Label("Direccion:");
        Label lblTelefono=new Label("Telefono:");
        Label lblSexo = new Label (" Sexo:");

        TextField NombreTxt = new TextField();
        TextField DireccionTxt = new TextField();
        TextField TelefonoTxt = new TextField();
        TextField SexoTxt = new TextField();

GuardarClienteBtn.setAlignment(Pos.CENTER);
        gridpane.add(lblNombre,0,30);
        gridpane.add(NombreTxt,1,30);

        gridpane.add(lblDireccion,0,31);
        gridpane.add(DireccionTxt,1,31);

        gridpane.add(lblTelefono,0,32);
        gridpane.add(TelefonoTxt,1,32);

        gridpane.add(lblSexo,0,33);
        gridpane.add(SexoTxt,1,33);

        gridpane.add(AgregarMascotaBtn,1,40);
        gridpane.add(GuardarClienteBtn,1,38);
        gridpane.add(AtrasBtn,2,40);
        AgregarMascotaBtn.setOnAction( e -> window.setScene(sceneAMascota));
        AtrasBtn.setOnAction( e -> BtnHome(AtrasBtn));
        GuardarClienteBtn.setOnAction(e -> CampoVacio(NombreTxt));
        root.getChildren().addAll(gridpane);
        return root;
    }
    private HBox CitaEstetica() {

        HBox root = new HBox(5);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);


        Button GuardarCitaBtn= new Button( "Guardar Cita");
        Button AtrasBtn= new Button( "Atras");

        Label lblFecha = new Label("Fecha:");
        Label lblTamaño =new Label("Tamaño Mascota");
        Label lblDes=new Label("Telefono:");

        TextField FechaTxt = new TextField();
        TextField TamañoTxt = new TextField();
        TextField DesTxt = new TextField();


        gridpane.add(lblFecha,0,30);
        gridpane.add(FechaTxt,1,30);

        gridpane.add(lblTamaño,0,31);
        gridpane.add(TamañoTxt,1,31);

        gridpane.add(lblDes,0,32);
        gridpane.add(DesTxt,1,32);



        gridpane.add(GuardarCitaBtn,1,40);

        gridpane.add(AtrasBtn,2,40);

        AtrasBtn.setOnAction( e -> BtnHome(AtrasBtn));

        root.getChildren().addAll(gridpane);
        return root;
    }
    private void CampoVacio (TextField textField){
        if(textField.getText().length()==0){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Faltan campos por  rellenar", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }

    }
    public static void main(String[] args) {


        launch(args);
    }
}