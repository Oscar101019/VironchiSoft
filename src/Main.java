
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.smartcardio.ATR;
import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.Normalizer;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.Date;

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
    Button GuardarBtn;
    TextArea textAreaProb;
    TextArea textAreaPlanesD;
    TextArea textAreaPlanesT;
    TextArea textAreaInstrucciones;
    private BorderPane root,root1,rootCM,rootCE,rootC,rootM,rootABAJOCM,rootLogin;
    private final int SIZE = 60;
    Stage window;
    Scene scene,sceneAgregar, sceneCitaM, sceneCitaE,sceneACliente,sceneAMascota,sceneLogin;                    //M=Medica       E=Estetica

    @Override
    public void start(Stage stage) {
        System.out.println("start");
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
        rootABAJOCM = new BorderPane();
        rootLogin = new BorderPane();

        rootLogin.setCenter(CentroLogin());

        root.setCenter(CentroPrincipal());
        root.setTop(BotonesArribaPrincipal());

        root1.setTop(BotonesArribaPrincipal());
        root1.setCenter(BtnAbajoAgendarCita());

        rootCM.setTop(BotonesArribaPrincipal());
        rootCM.setCenter(CentroCM());
        rootCM.setRight(DerechaCM());


        //rootCM.setBottom(BtnAtras());

       // rootC.setBottom(BtnHome());
        System.out.println("initUi");
        rootC.setCenter(DatosCliente());
        //System.out.println("initUi");
        rootC.setTop(BotonesArribaPrincipal());
       //rootCE.setBottom(BtnHome());

      //  rootM.setBottom(BtnHome());
        rootM.setCenter(DatosMascota());
        rootM.setTop(BotonesArribaPrincipal());

        rootCE.setCenter(CitaEstetica());
        rootCE.setTop(BotonesArribaPrincipal());

        sceneLogin = new Scene(rootLogin,500,700);
        sceneLogin.getStylesheets().add("Estilo.css");
        scene = new Scene(root,1150, 700 );
       scene.getStylesheets().add("Estilo.css");


        sceneAgregar = new Scene (root1,1150, 700);
        sceneAgregar.getStylesheets().add("Estilo.css");
        sceneCitaM =new Scene (rootCM,1150,700 );
        sceneCitaM.getStylesheets().add("Estilo.css");
        sceneCitaE =new Scene (rootCE,1150,700 );
        sceneCitaE.getStylesheets().add("Estilo.css");

        sceneACliente =new Scene (rootC,1150,700 );
        sceneACliente.getStylesheets().add("Estilo.css");
        sceneAMascota = new Scene (rootM,1150,700);
        sceneAMascota.getStylesheets().add("Estilo.css");
        stage.setTitle("VironchiSoft");

        stage.setScene(sceneLogin);
        stage.show();
    }


    //Parte de abajo con botones de ventana Cita Medica
    private  void BtnHome(Button button) {

        button.setOnAction( e-> window.setScene(scene));

    }



    //Parte de la derecha de ventana Cita Medica
    private  VBox DerechaCM() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(0,50,0,0));
        root.setAlignment(Pos.TOP_LEFT);


        Button RegresarBtn = new Button("Regresar");
        RegresarBtn.setOnAction( e-> window.setScene(scene));

        Label lblProblemasTemp =new Label ("LISTA DE PROBLEMAS (TEMPORAL)");
        Label lblPlanesD=new Label ("PLANES DIAGNOSTICOS");
        Label lblPlanesT =new Label ("PLANES TERAPEUTICOS");
        Label lblInstrucciones =new Label ("INSTRUCCIONES CLIENTE");

        textAreaProb = new TextArea();
        textAreaPlanesD = new TextArea();
        textAreaPlanesT = new TextArea();
        textAreaInstrucciones = new TextArea();

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







        root.getChildren().addAll(gridpane,GuardarBtn,RegresarBtn);

        return  root;
    }



    //Parte centro ventana Principal
    private HBox CentroPrincipal() {
        HBox root = new HBox(0);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(1,8,7,4));
        gridpane.setHgap(0);
        gridpane.setVgap(0);
        //javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("logoVironchi2.png"));

        Label lblPrueba = new Label("");
        Label lbl = new Label("Bienvenido a VironchiSoft");
      //  lblPrueba.setGraphic(new ImageView(image));

        gridpane.add(lblPrueba, 10,20);
        root.getChildren().addAll(lbl,gridpane);


                return root;

    }



    private VBox CentroLogin() {

        VBox root = new VBox(5);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,60,80,0));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.setAlignment(Pos.CENTER);
 javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("logoVironchi.png"));
         Label lblUsuario = new Label("Usuario");
        Label lblContraseña = new Label("Contraseña");
        TextField UsuarioTxt = new TextField ("");
        TextField ContraseñaTxt  = new TextField ("");
Button AccederBtn = new Button("Acceder");
        Button CerrarBtn = new Button("Cerrar");


         Label lblPrueba = new Label("");
    lblPrueba.setGraphic(new ImageView(image));

        Label lblBienvenida = new Label("Bienvenido a VironchiSoft");



        // gridpane.add(lblBienvenida,1,0);
        gridpane.add(lblUsuario,15,15);
        gridpane.add(UsuarioTxt,16,15);
        gridpane.add(lblContraseña,15,16);
        gridpane.add(ContraseñaTxt,16,16);
        gridpane.add(AccederBtn,15,17);
        gridpane.add(CerrarBtn,16,17);
        CerrarBtn.setOnAction( e-> window.close());
       AccederBtn.setOnAction( e-> window.setScene(scene));

root2.getChildren().addAll(AccederBtn,CerrarBtn);
        root.getChildren().addAll(lblBienvenida,lblPrueba, gridpane,root2);


        return root;

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
    private  VBox CentroCM() {



        VBox root = new VBox(5);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);
        HBox hBox = new HBox (5);
        hBox.setPadding(new Insets(15,0,0,0));
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox (3);
        hBox2.setPadding(new Insets(15,0,0,0));
        hBox2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        Label lblIDMASCOTA = new Label("ID MASCOTA:");
        Label lblIDADEUDO = new Label("ID ADEUDO:");
        Label lbl1 = new Label( "APARIENCIA GENERAL");
        Label lbl2 = new Label( "PIEL");
        Label lbl3= new Label( "MUSCULOSQUELETO");
        Label lbl4 = new Label( "CIRCULATORIO");
        Label lbl5 = new Label( "DIGESTIVO");
        Label lbl6 = new Label( "RESPIRATORIO");
        Label lbl7 = new Label( "GENITOURINARIO");
        Label lbl8 = new Label( "OJOS");
        Label lbl9 = new Label( "OIDOS");
        Label lbl10 = new Label( "SISTEMA NERVIOSO");
        Label lbl11 = new Label( "GANGLIOS");
        Label lbl12 = new Label( "MUCOSAS");

        Label lblFecha =new Label ("Fecha: ");
        Label lblTemperatura =new Label ("Temperatura: ");
        Label lblPeso =new Label ("Peso: ");
        TextField FechaTxt = new TextField ();
        TextField TemperaturaTxt = new TextField ();
        TextField PesoTxt = new TextField ();


        TextField txtIDMASCOTA = new TextField();
        TextField txtIDADEUDO = new TextField();
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

        txtIDMASCOTA.setPrefColumnCount(10);
        txtIDADEUDO.setPrefColumnCount(10);

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


        ToggleGroup group1 = new ToggleGroup();
        RadioButton Nor1Rbtn = new RadioButton("Normal");
        Nor1Rbtn.setToggleGroup(group1);
        Nor1Rbtn.setSelected(true);
        RadioButton Anor1Rbtn = new RadioButton("Anormal");
        Anor1Rbtn.setToggleGroup(group1);

        ToggleGroup group2 = new ToggleGroup();
        RadioButton Nor2Rbtn = new RadioButton("Normal");
        Nor2Rbtn.setToggleGroup(group2);
        Nor2Rbtn.setSelected(true);
        RadioButton Anor2Rbtn = new RadioButton("Anormal");
        Anor2Rbtn.setToggleGroup(group2);

        ToggleGroup group3 = new ToggleGroup();
        RadioButton Nor3Rbtn = new RadioButton("Normal");
        Nor3Rbtn.setToggleGroup(group3);
        Nor3Rbtn.setSelected(true);
        RadioButton Anor3Rbtn = new RadioButton("Anormal");
        Anor3Rbtn.setToggleGroup(group3);

        ToggleGroup group4 = new ToggleGroup();
        RadioButton Nor4Rbtn = new RadioButton("Normal");
        Nor4Rbtn.setToggleGroup(group4);
        Nor4Rbtn.setSelected(true);
        RadioButton Anor4Rbtn = new RadioButton("Anormal");
        Anor4Rbtn.setToggleGroup(group4);

        ToggleGroup group5 = new ToggleGroup();
        RadioButton Nor5Rbtn = new RadioButton("Normal");
        Nor5Rbtn.setToggleGroup(group5);
        Nor5Rbtn.setSelected(true);
        RadioButton Anor5Rbtn = new RadioButton("Anormal");
        Anor5Rbtn.setToggleGroup(group5);

        ToggleGroup group6 = new ToggleGroup();
        RadioButton Nor6Rbtn = new RadioButton("Normal");
        Nor6Rbtn.setToggleGroup(group6);
        Nor6Rbtn.setSelected(true);
        RadioButton Anor6Rbtn = new RadioButton("Anormal");
        Anor6Rbtn.setToggleGroup(group6);

        ToggleGroup group7 = new ToggleGroup();
        RadioButton Nor7Rbtn = new RadioButton("Normal");
        Nor7Rbtn.setToggleGroup(group7);
        Nor7Rbtn.setSelected(true);
        RadioButton Anor7Rbtn = new RadioButton("Anormal");
        Anor7Rbtn.setToggleGroup(group7);

        ToggleGroup group8 = new ToggleGroup();
        RadioButton Nor8Rbtn = new RadioButton("Normal");
        Nor8Rbtn.setToggleGroup(group8);
        Nor8Rbtn.setSelected(true);
        RadioButton Anor8Rbtn = new RadioButton("Anormal");
        Anor8Rbtn.setToggleGroup(group8);

        ToggleGroup group9 = new ToggleGroup();
        RadioButton Nor9Rbtn = new RadioButton("Normal");
        Nor9Rbtn.setToggleGroup(group9);
        Nor9Rbtn.setSelected(true);
        RadioButton Anor9Rbtn = new RadioButton("Anormal");
        Anor9Rbtn.setToggleGroup(group9);

        ToggleGroup group10 = new ToggleGroup();
        RadioButton Nor10Rbtn = new RadioButton("Normal");
        Nor10Rbtn.setToggleGroup(group10);
        Nor10Rbtn.setSelected(true);
        RadioButton Anor10Rbtn = new RadioButton("Anormal");
        Anor10Rbtn.setToggleGroup(group10);

        ToggleGroup group11 = new ToggleGroup();
        RadioButton Nor11Rbtn = new RadioButton("Normal");
        Nor11Rbtn.setToggleGroup(group11);
        Nor11Rbtn.setSelected(true);
        RadioButton Anor11Rbtn = new RadioButton("Anormal");
        Anor11Rbtn.setToggleGroup(group11);

        ToggleGroup group12 = new ToggleGroup();
        RadioButton Nor12Rbtn = new RadioButton("Normal");
        Nor12Rbtn.setToggleGroup(group12);
        Nor12Rbtn.setSelected(true);
        RadioButton Anor12Rbtn = new RadioButton("Anormal");
        Anor12Rbtn.setToggleGroup(group12);


        /*CheckBox NorBox=new CheckBox("Normal");
        CheckBox NorBox2=new CheckBox("Normal");
        CheckBox NorBox3=new CheckBox("Normal");
        CheckBox NorBox4=new CheckBox("Normal");
        CheckBox NorBox5=new CheckBox("Normal");
        CheckBox NorBox6=new CheckBox("Normal");
        CheckBox NorBox7=new CheckBox("Normal");
        CheckBox NorBox8=new CheckBox("Normal");
        CheckBox NorBox9= new CheckBox("Normal");
        CheckBox NorBox10=new CheckBox("Normal");
        CheckBox NorBox11=new CheckBox("Normal");
        CheckBox NorBox12= new CheckBox("Normal");*/


        GuardarBtn = new Button("Guardar");



hBox.getChildren().addAll(lblFecha,FechaTxt,lblPeso,PesoTxt,lblTemperatura,TemperaturaTxt);



        gridpane.add(lbl1,0,0);
        gridpane.add(Nor1Rbtn,1,0);
        gridpane.add(Anor1Rbtn,2,0);
        gridpane.add(textArea1, 3, 0);


      gridpane.add(lbl2,0,1);
        gridpane.add(Nor2Rbtn,1,1);
        gridpane.add(Anor2Rbtn,2,1);
        gridpane.add(textArea2, 3, 1);

        gridpane.add(lbl3,0,2);
        gridpane.add(Nor3Rbtn,1,2);
        gridpane.add(Anor3Rbtn,2,2);
        gridpane.add(textArea3, 3, 2);

        gridpane.add(lbl4,0,3);
        gridpane.add(Nor4Rbtn,1,3);
        gridpane.add(Anor4Rbtn,2,3);
        gridpane.add(textArea4, 3, 3);

        gridpane.add(lbl5,0,4);
        gridpane.add(Nor5Rbtn,1,4);
        gridpane.add(Anor5Rbtn,2,4);
        gridpane.add(textArea5, 3, 4);

        gridpane.add(lbl6,0,5);
        gridpane.add(Nor6Rbtn,1,5);
        gridpane.add(Anor6Rbtn,2,5);
        gridpane.add(textArea6, 3, 5);

        gridpane.add(lbl7,0,6);
        gridpane.add(Nor7Rbtn,1,6);
        gridpane.add(Anor7Rbtn,2,6);
        gridpane.add(textArea7, 3, 6);

        gridpane.add(lbl8,0,7);
        gridpane.add(Nor8Rbtn,1,7);
        gridpane.add(Anor8Rbtn,2,7);
        gridpane.add(textArea8, 3, 7);

        gridpane.add(lbl9,0,8);
        gridpane.add(Nor9Rbtn,1,8);
        gridpane.add(Anor9Rbtn,2,8);
        gridpane.add(textArea9, 3, 8);

        gridpane.add(lbl10,0,9);
        gridpane.add(Nor10Rbtn,1,9);
        gridpane.add(Anor10Rbtn,2,9);
        gridpane.add(textArea10, 3, 9);

        gridpane.add(lbl11,0,10);
        gridpane.add(Nor11Rbtn,1,10);
        gridpane.add(Anor11Rbtn,2,10);
        gridpane.add(textArea11, 3, 10);

        gridpane.add(lbl12,0,11);
        gridpane.add(Nor12Rbtn,1,11);
        gridpane.add(Anor12Rbtn,2,11);
        gridpane.add(textArea12, 3, 11);



hBox2.getChildren().addAll(lblIDMASCOTA,txtIDMASCOTA,lblIDADEUDO,txtIDADEUDO);
        Anor1Rbtn.setOnAction(e->cambiarModo(Anor1Rbtn,textArea1));
        Anor2Rbtn.setOnAction(e->cambiarModo(Anor2Rbtn,textArea2));
        Anor3Rbtn.setOnAction(e->cambiarModo(Anor3Rbtn,textArea3));
        Anor4Rbtn.setOnAction(e->cambiarModo(Anor4Rbtn,textArea4));
        Anor5Rbtn.setOnAction(e->cambiarModo(Anor5Rbtn,textArea5));
        Anor6Rbtn.setOnAction(e->cambiarModo(Anor6Rbtn,textArea6));
        Anor7Rbtn.setOnAction(e->cambiarModo(Anor7Rbtn,textArea7));
        Anor8Rbtn.setOnAction(e->cambiarModo(Anor8Rbtn,textArea8));
        Anor9Rbtn.setOnAction(e->cambiarModo(Anor9Rbtn,textArea9));
        Anor10Rbtn.setOnAction(e->cambiarModo(Anor10Rbtn,textArea10));
        Anor11Rbtn.setOnAction(e->cambiarModo(Anor11Rbtn,textArea11));
        Anor12Rbtn.setOnAction(e->cambiarModo(Anor12Rbtn,textArea12));



    root.getChildren().addAll(hBox,gridpane,hBox2);
        java.util.Date fecha = new java.util.Date();
        long fechasistema = fecha.getTime();
        java.sql.Date fechasql2 = new java.sql.Date(fechasistema);
        String fechasql  = fechasql2.toString();
        FechaTxt.setText(fechasql);

        GuardarBtn.setOnAction(event -> eventoguardarcitaA(FechaTxt,TemperaturaTxt,PesoTxt,Nor1Rbtn,Anor1Rbtn,textArea1,Nor2Rbtn,Anor2Rbtn,textArea2,Nor3Rbtn,Anor3Rbtn,textArea3,Nor4Rbtn,Anor4Rbtn,textArea4,Nor5Rbtn,Anor5Rbtn,textArea5,Nor6Rbtn,Anor6Rbtn,textArea6,Nor7Rbtn,Anor7Rbtn,textArea7,Nor8Rbtn,Anor8Rbtn,textArea8,Nor9Rbtn,Anor9Rbtn,textArea9,Nor10Rbtn,Anor10Rbtn,textArea10,Nor11Rbtn,Anor11Rbtn,textArea11,Nor12Rbtn,Anor12Rbtn,textArea12,textAreaPlanesD,textAreaProb,textAreaPlanesT,textAreaInstrucciones,txtIDMASCOTA,txtIDADEUDO));
       /* GuardarBtn.setOnAction(event -> eventoguardarcitamedica(textArea1,textArea2,textArea3,textArea4,textArea5,textArea7,textArea8,textArea9,textArea10,textArea11,textArea12,
                textAreaProb,textAreaPlanesT,textAreaInstrucciones,txtIDMASCOTA,txtIDADEUDO));*/

return  root;
    }





    public void cambiarModo(RadioButton radioButton,TextArea textArea){
        if (radioButton.isSelected()) {
            textArea.setEditable(true);
        }
        if (!radioButton.isSelected()) {
            textArea.setEditable(false);
        }
    }

    //Botones de la parte de arriba para cambiar de ventanas
    private HBox BotonesArribaPrincipal () {
        HBox root = new HBox(5);
        root.setPadding(new Insets(5,0,0,0));
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
        Label lblIDCLIENTE = new Label("ID CLIENTE:");




        TextField NombreTxt = new TextField();
        TextField EspecieTxt = new TextField();
        TextField RazaTxt = new TextField();
        TextField EdadTxt = new TextField();
        TextField IDCLIENTETxt = new TextField("-");

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "H",
                        "M"
                );
        // ComboBox ComboHM =new ComboBox(options);

        ComboBox ComboHM =new ComboBox();
        ComboHM.getItems().addAll("H", "M");
        ComboHM.setValue("-");

        gridpane.add(lblTitulo,1,20);

        gridpane.add(lblIDCLIENTE,0,29);
        gridpane.add(IDCLIENTETxt,1,29);

        gridpane.add(lblNombre,0,30);
        gridpane.add(NombreTxt,1,30);

        gridpane.add(lblEspecie,0,31);
        gridpane.add(EspecieTxt,1,31);

        gridpane.add(lblRaza,0,32);
        gridpane.add(RazaTxt,1,32);

        gridpane.add(lblSexo,0,33);
        gridpane.add(ComboHM,1,33);

        gridpane.add(lblEdad,0,34);
        gridpane.add(EdadTxt,1,34);

        gridpane.add(GuardarMascotaBtn,1,40);
        gridpane.add(CitaMBtn,5,31);
        gridpane.add(CitaEBtn,5,33);

        CitaMBtn.setOnAction( e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction( e -> window.setScene(sceneCitaE));
        GuardarMascotaBtn.setOnAction(e -> DatosMascota(IDCLIENTETxt,NombreTxt,EspecieTxt,RazaTxt,ComboHM,EdadTxt));

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

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "H",
                        "M"
                );
       // ComboBox ComboHM =new ComboBox(options);

        ComboBox ComboHM =new ComboBox();
        ComboHM.getItems().addAll("H", "M");
        ComboHM.setValue("-");

        Label lblIDCLIENTE = new Label("ID Cliente");
        Label lblNombre = new Label("Nombre:");
        Label lblDireccion =new Label("Direccion:");
        Label lblTelefono=new Label("Telefono:");
        Label lblSexo = new Label (" Sexo:");

        TextField IDCLIENTETxt = new TextField();
        TextField NombreTxt = new TextField();
        TextField DireccionTxt = new TextField();
        TextField TelefonoTxt = new TextField();
        TextField SexoTxt = new TextField();

GuardarClienteBtn.setAlignment(Pos.CENTER);
GuardarClienteBtn.setOnAction(e -> DatosCliente(NombreTxt,DireccionTxt,TelefonoTxt,ComboHM));

        gridpane.add(lblNombre,0,30);
        gridpane.add(NombreTxt,1,30);

        gridpane.add(lblDireccion,0,31);
        gridpane.add(DireccionTxt,1,31);

        gridpane.add(lblTelefono,0,32);
        gridpane.add(TelefonoTxt,1,32);

        gridpane.add(lblSexo,0,33);
        gridpane.add(ComboHM,1,33);

        gridpane.add(AgregarMascotaBtn,1,40);
        gridpane.add(GuardarClienteBtn,1,38);
        gridpane.add(AtrasBtn,2,40);
        AgregarMascotaBtn.setOnAction( e -> window.setScene(sceneAMascota));
        AtrasBtn.setOnAction( e -> BtnHome(AtrasBtn));


        System.out.println("SceneDatosCliente()");
         /*
        if (NombreTxt.getText().length()!=0 && DireccionTxt.getText().length()!= 0  && TelefonoTxt.getText().length() != 0) {
                System.out.println("If");
                GuardarClienteBtn.setOnAction(event -> DatosCliente(NombreTxt, DireccionTxt, TelefonoTxt));
            }
                else { //(NombreTxt.getText().length() == 0 || DireccionTxt.getText().length() == 0 || TelefonoTxt.getText().length() == 0) {
                    GuardarClienteBtn.setOnAction(e -> CampoVacio(NombreTxt));
                    GuardarClienteBtn.setOnAction(e -> CampoVacio(DireccionTxt));
                    GuardarClienteBtn.setOnAction(e -> CampoVacio(TelefonoTxt));
                    System.out.println("else");
                }

*/

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
        /*GuardarCitaBtn.setOnAction(e -> CampoVacio(FechaTxt));
        GuardarCitaBtn.setOnAction(e->CampoVacio(TamañoTxt));
        GuardarCitaBtn.setOnAction(e->CampoVacio(DesTxt));*/

        AtrasBtn.setOnAction( e -> BtnHome(AtrasBtn));

        root.getChildren().addAll(gridpane);
        return root;
    }


    public void DatosCliente(TextField Nombre,TextField Direccion, TextField Telefono,ComboBox Sexo){

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
            CampoVacio(Nombre,Direccion,Telefono,Sexo);

        }



    }

    /* public void eventoguardarcliente(TextField Nombre,TextField Direccion, TextField Telefono){
        DatosCliente(Nombre.getText(),Direccion.getText(),Telefono.getText());
    }*/

    public void DatosMascota(TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza,ComboBox Sexo, TextField Descripcion){
        int IdCliente = Integer.parseInt(IDCLIENTE.getText().toString());
        String nombre = Nombre.getText();
        String especie = Especie.getText();
        String raza = Raza.getText();
        String sexo = Sexo.getValue().toString();
        String descripcion = Descripcion.getText();

        if (IDCLIENTE.getText().toString()!= "-" && Nombre.getText().length() != 0 && Especie.getText().length() != 0 && Raza.getText().length() != 0 && Sexo.getValue().toString() != "-" && Descripcion.getText().length() != 0 ) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
                Statement statement = connection.createStatement();
                ResultSet insertar = statement.executeQuery("insert into mascota (id_Cliente,Nombre,Especie,Raza,Sexo,Descripcion) values(" + IdCliente + ",'" + nombre + "','" + especie + "','" + raza + "','" + sexo + "','" + descripcion + "')");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            CampoVacioMascota(IDCLIENTE,Nombre,Especie,Raza,Sexo,Descripcion);
        }
    }

    /*public void eventoguardarmascota(TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza, TextField Sexo, TextField Descripcion){
         DatosMascota(Integer.parseInt(IDCLIENTE.getText()),Nombre.getText(),Especie.getText(),Raza.getText(),Sexo.getText(),Descripcion.getText());
    }*/



    public void guardarCitaA(String Fecha,String Temperatura, String Peso, RadioButton Norbox, RadioButton AnorBox, String DesAG, RadioButton NorBox2, RadioButton AnorBox2, String DesPiel, RadioButton Norbox3, RadioButton AnorBox3, String DesME, RadioButton NorBox4, RadioButton AnorBox4, String DesCircu, RadioButton Norbox5, RadioButton AnorBox5, String DesRes,
                             RadioButton Norbox6, RadioButton AnorBox6, String DesDige, RadioButton Norbox7, RadioButton Anorbox7, String DesGU, RadioButton Norbox8, RadioButton AnorBox8, String DesOjos, RadioButton Norbox9, RadioButton AnorBox9, String DesOidos, RadioButton Norbox10, RadioButton AnorBox10, String DesSN, RadioButton Norbox11, RadioButton AnorBox11, String DesGanglios, RadioButton Norbox12, RadioButton AnorBox12, String DesMucosa,String PlanesDiagnostico, String ProblemasTemporal,
                             String PlanesTerapeuticos, String InstruccionesCliente, int IDMASCOTA, int IDADEUDO){
        String N1=""; String N2 =""; String N3 =""; String N4 =""; String N5=""; String N6=""; String N7 = ""; String N8 ="";
        String N9=""; String N10=""; String N11=""; String N12="";





        java.text.SimpleDateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat usuario = new java.text.SimpleDateFormat("dd/MM/yyyy");



        try {
           if(Fecha == usuario.toString()){
               Fecha = myFormat.format(usuario.parse(Fecha));
           }



        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }



        try {
            if(Norbox.isSelected()){
                N1 = "N";
            }

            if (AnorBox.isSelected()) {
                N1 = "A";
            }

            if(NorBox2.isSelected()){
                N2="N";
            }


            if (AnorBox2.isSelected()) {
                N2 = "A";
            }


            if(Norbox3.isSelected()){
                N3="N";
            }

            if (AnorBox3.isSelected()) {
                N3 = "A";
            }

            if(NorBox4.isSelected()){
                N4="N";
            }


            if (AnorBox4.isSelected()) {
                N4 = "A";
            }

            if(Norbox.isSelected()){
                N5="N";
            }

            if (AnorBox5.isSelected()) {
                N5 = "A";

            }

            if(Norbox6.isSelected()){
                N6="N";
            }


            if (AnorBox6.isSelected()) {
                N6 = "A";
            }

            if(Norbox7.isSelected()){
                N7="N";
            }



            if (Anorbox7.isSelected()) {
                N7 = "A";
            }

            if(Norbox8.isSelected()){
                N8 = "N";
            }

            if(Norbox9.isSelected()){
                N8 = "N";
            }

            if (AnorBox8.isSelected()) {
                N8 = "A";
            }

            if(Norbox9.isSelected()){
                N9 = "N";
            }

            if (AnorBox9.isSelected()) {
                N9 = "A";
            }

            if(Norbox10.isSelected()){
                N10 = "N";
            }


            if (AnorBox10.isSelected()) {
                N10 = "A";
            }

            if(Norbox11.isSelected()){
                N11 = "N";
            }

            if (AnorBox11.isSelected()) {
                N11 = "A";

            }

            if(Norbox12.isSelected()){
                N12 = "N";
            }


            if(AnorBox12.isSelected()){
                N12 = "A";
            }


            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
            Statement statement = connection.createStatement();
            ResultSet insertar = statement.executeQuery("insert into citamed(Fecha,Temperatura,Peso,Apariencia_G,DesAG,Piel,DesPiel,MusculoEsqueleto,DesME,Circulatorio,DesCircu,Respiratorio,DesRes,Digestivo,DesDige,GenitoUrinario,DesGU,Ojos,DesOjos,Oidos,DesOidos,SistemaNervioso,DesSN,Ganglios,DesGanglios,Mucosa,DesMucosa,PlanesDiagnostico,ProblemasTemporal,PlanesTerapeuticos,InstruccionesCli,ID_Mascota,ID_Adeudo) values ('"+Fecha+"','"+Temperatura+"','"+Peso+"','"+N1+"','"+DesAG+"','"+N2+"','"+DesPiel+"','"+N3+"','"+DesME+"','"+N4+"','"+DesCircu+"','"+N5+"','"+DesRes+"','"+N6+"','"+DesDige+"','"+N7+"','"+DesGU+"','"+N8+"','"+DesOjos+"','"+N9+"','"+DesOidos+"','"+N10+"','"+DesSN+"','"+N11+"','"+DesGanglios+"','"+N12+"','"+DesMucosa+"','"+PlanesDiagnostico+"','" + ProblemasTemporal + "','" + PlanesTerapeuticos + "','" + InstruccionesCliente + "'," + IDMASCOTA + "," + IDADEUDO + ")");

        } catch(SQLException e){
            e.printStackTrace();




        }

    }




    public void eventoguardarcitaA(TextField Fecha,TextField Temperatura, TextField Peso, RadioButton Norbox, RadioButton AnorBox, TextArea AparienciaGeneral, RadioButton Norbox2, RadioButton AnorBox2, TextArea Piel, RadioButton Norbox3, RadioButton AnorBox3,
                                   TextArea MuscoloEesqueleto, RadioButton Norbox4, RadioButton AnorBox4, TextArea Circulatorio, RadioButton Norbox5, RadioButton AnorBox5, TextArea Respiratorio,
                                   RadioButton Norbox6, RadioButton AnorBox6, TextArea Digestivo, RadioButton Norbox7, RadioButton AnorBox7, TextArea GenitoUrinario,
                                   RadioButton Norbox8, RadioButton AnorBox8, TextArea Ojos, RadioButton Norbox9, RadioButton AnorBox9, TextArea Oidos,
                                   RadioButton Norbox10, RadioButton AnorBox10, TextArea SistemaNervioso, RadioButton Norbox11, RadioButton AnorBox11, TextArea Ganglios,
                                   RadioButton Norbox12, RadioButton AnorBox12, TextArea Mucosas, TextArea PlanesDiagnostico, TextArea ProblemasTemporal, TextArea PlanesTerapeuticos, TextArea IntruccionesCliente,
                                   TextField IDMASCOTA, TextField IDADEUDO){




        guardarCitaA(
                Fecha.getText(),Temperatura.getText(),Peso.getText(),
                Norbox,AnorBox,AparienciaGeneral.getText(),
                Norbox2,AnorBox2,Piel.getText(),
                Norbox3,AnorBox3,MuscoloEesqueleto.getText(),
                Norbox4,AnorBox4,Circulatorio.getText(),
                Norbox5,AnorBox5,Respiratorio.getText(),
                Norbox6,AnorBox6,Digestivo.getText(),
                Norbox7,AnorBox7,GenitoUrinario.getText(),
                Norbox8,AnorBox8,Ojos.getText(),
                Norbox9,AnorBox9,Oidos.getText(),
                Norbox10,AnorBox10,SistemaNervioso.getText(),
                Norbox11,AnorBox11,Ganglios.getText(),
                Norbox12,AnorBox12, Mucosas.getText(),
                PlanesDiagnostico.getText(),ProblemasTemporal.getText(),PlanesTerapeuticos.getText(),
                IntruccionesCliente.getText(),Integer.parseInt(IDMASCOTA.getText()),Integer.parseInt(IDADEUDO.getText()));
    }


    private void CampoVacio (TextField Nombre,TextField Telefono,TextField Direccion, ComboBox Sexo){
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
    private void CampoVacioMascota (TextField IDCLIENTE, TextField Nombre, TextField Especie, TextField Raza,ComboBox Sexo, TextField Descripcion){

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
    public static void main(String[] args) {

        System.out.println("Main");
        launch(args);
    }
}