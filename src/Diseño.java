
import com.sun.javafx.scene.SceneHelper;
import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by juven on 29/3/2017.
 */
public class Diseño {
    public BorderPane root, root1, rootCM, rootCE, rootC, rootM, rootABAJOCM, rootLogin, rootBuscar, rootBuscarCliente, rootInventario,root4, rootVentas, rootModificarInv, rootAgregarInv;
    public Stage window;
    public Scene scene, sceneAgregar, sceneCitaM, sceneCitaE, sceneACliente, sceneAMascota, sceneLogin, sceneBuscar, sceneBuscarCliente, sceneInvetario, sceneVentas, sceneModificarInv, sceneAgregarInv;                    //M=Medica       E=Estetica

    Funciones funcion = new Funciones();
    Validacion validar = new Validacion();
    Eventos evento =new Eventos();

    Button GuardarBtn;
    TextArea textAreaProb;
    TextArea textAreaPlanesD;
    TextArea textAreaPlanesT;
    TextArea textAreaInstrucciones;
    PreparedStatement pst = null;
    Connection con;
 
    //VARIABLES GLOBALES PARA CLIENTE Y MASCOTA DESDE LA BASE DE DATOS
    //CLIENTE
    String idCliente=null, nombreCliente="", direccionCliente="", telefonoCliente="", sexoCliente="";
    //MASCOTA
    String idMascota = "", nombreMascota="", especieMascota = "", razaMascota = "", sexoMascota = "", descripcionMascota = "";
 String nombreProducto="", cantidad="",precio="";

    TextField idClienteTxt = new TextField();
    TextField nombreClienteTxt = new TextField();
    TextField DireccionClienteTxt = new TextField();
    TextField TelefonoClienteTxt = new TextField();
    ComboBox ComboSexoCliente = new ComboBox();
    Label lblNombreCliente = new Label();
    Label lblNombreClienteCM = new Label();
    Label lblNombreMascotaCM = new Label();

    public void initUI(Stage stage) {

        window = stage;
        root = new BorderPane();
        root1 = new BorderPane();
        rootCM = new BorderPane();
        rootCE = new BorderPane();
        rootC = new BorderPane();
        rootM = new BorderPane();
        rootABAJOCM = new BorderPane();
        rootLogin = new BorderPane();
        rootBuscar = new BorderPane();
        rootBuscarCliente = new BorderPane();
        rootInventario = new BorderPane();
        rootVentas = new BorderPane();
        rootModificarInv = new BorderPane();
        rootAgregarInv = new BorderPane();

        rootLogin.setCenter(CentroLogin());
        root.setCenter(CentroPrincipal());
        root.setTop(BotonesArribaPrincipal());

        rootBuscar.setTop(BotonesArribaPrincipal());
        rootBuscar.setCenter(CentroBuscar());

        root1.setTop(BotonesArribaPrincipal());
        root1.setCenter(BtnAbajoAgendarCita());

        rootCM.setTop(BotonesArribaPrincipal());
        rootCM.setCenter(CentroCM());

        rootCM.setRight(DerechaCM());

        System.out.println("initUi");
        rootC.setCenter(DatosClienteCentro());

        rootC.setTop(BotonesArribaPrincipal());

       rootM.setCenter(DatosMascota());
        rootM.setTop(BotonesArribaPrincipal());

        rootCE.setCenter(CitaEstetica());
        rootCE.setTop(BotonesArribaPrincipal());

        rootInventario.setTop(BotonesArribaPrincipal());
        rootInventario.setCenter(CentroInventario());
        rootAgregarInv.setTop(BotonesArribaPrincipal());
        rootAgregarInv.setCenter(CentroAgregarInv());
        rootModificarInv.setTop(BotonesArribaPrincipal());
        rootModificarInv.setCenter(CentroModificarInv());

        rootVentas.setTop(BotonesArribaPrincipal());
        rootVentas.setCenter(CentroVentas());


        sceneLogin = new Scene(rootLogin, 1150, 700);
        scene = new Scene(root, 1150, 700);
        sceneBuscar = new Scene(rootBuscar, 1150, 700);
        sceneBuscarCliente = new Scene(rootBuscarCliente, 100, 100);
        sceneAgregar = new Scene(root1, 1150, 700);
        sceneCitaM = new Scene(rootCM, 1150, 700);
        sceneCitaE = new Scene(rootCE, 1150, 700);
        sceneACliente = new Scene(rootC, 1150, 700);
        sceneAMascota = new Scene(rootM, 1150, 700);
        sceneInvetario = new Scene(rootInventario, 1150, 700);
        sceneVentas = new Scene(rootVentas, 1150, 700);
        sceneAgregarInv = new Scene(rootAgregarInv, 1150, 700);
        sceneModificarInv = new Scene(rootModificarInv, 1150, 700);

        sceneLogin.getStylesheets().add("Estilo.css");
        scene.getStylesheets().add("Estilo.css");
        sceneBuscar.getStylesheets().add("Estilo.css");
        sceneBuscarCliente.getStylesheets().add("Estilo.css");
        sceneAgregar.getStylesheets().add("Estilo.css");
        sceneCitaM.getStylesheets().add("Estilo.css");
        sceneCitaE.getStylesheets().add("Estilo.css");
        sceneACliente.getStylesheets().add("Estilo.css");
        sceneAMascota.getStylesheets().add("Estilo.css");
        sceneInvetario.getStylesheets().add("Estilo.css");
        sceneVentas.getStylesheets().add("Estilo.css");
        sceneModificarInv.getStylesheets().add("Estilo.css");
        sceneAgregarInv.getStylesheets().add("Estilo.css");


        evento.Mensaje(scene);
        evento.Cerrar(window);
        evento.PantallaCompleta(window);
        evento.cambiar(scene,sceneBuscar,sceneInvetario,sceneVentas,window);
        stage.setTitle("VironchiSoft");

        stage.setScene(sceneLogin);
        stage.show();
    //    stage.setFullScreen(false);

        stage.centerOnScreen();


    }




    public VBox DatosClienteCentro() {
        VBox rootMaster =new VBox(20);
        rootMaster.setAlignment(Pos.CENTER);


        VBox root = new VBox(45);

        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,0,0,0));
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        gridpane.setAlignment(Pos.CENTER);


        Label lblTitulo = new Label("CLIENTE");

        Button GuardarClienteBtn = new Button("Guardar Cliente");


        ComboSexoCliente.getItems().addAll("Hombre", "Mujer");
        ComboSexoCliente.setValue("-");

        Label lblIDCLIENTE = new Label("ID Cliente");
        Label lblNombre = new Label("Nombre:");
        Label lblDireccion = new Label("Direccion:");
        Label lblTelefono = new Label("Telefono:");
        Label lblSexo = new Label(" Sexo:");

        validar.SoloLetras(nombreClienteTxt);
        validar.LetrasCaracterEspecial(DireccionClienteTxt);


        gridpane.add(lblNombre, 0, 2);
        gridpane.add(nombreClienteTxt, 1, 2);

        gridpane.add(lblDireccion, 0, 3);
        gridpane.add(DireccionClienteTxt, 1, 3);

        gridpane.add(lblTelefono, 0, 4);
        gridpane.add(TelefonoClienteTxt, 1, 4);

        gridpane.add(lblSexo, 0, 5);
        gridpane.add(ComboSexoCliente, 1, 5);

        //gridpane.add(GuardarClienteBtn, 1, 6);
        GuardarClienteBtn.setOnAction(e -> funcion.DatosCliente(nombreClienteTxt, DireccionClienteTxt, TelefonoClienteTxt, ComboSexoCliente));

        System.out.println("SceneDatosCliente()");
            root.getChildren().addAll(lblTitulo,gridpane,GuardarClienteBtn);




        VBox rootM = new VBox(25);
        HBox root2M = new HBox(220);
        GridPane gridpanem = new GridPane();
        gridpanem.setPadding(new Insets(0,0,0,0));
        gridpanem.setHgap(10);
        gridpanem.setVgap(5);
        rootM.setPadding(new Insets(0, 0, 0, 0));
        root2M.setAlignment(Pos.CENTER);
        rootM.setAlignment(Pos.CENTER);
        gridpanem.setAlignment(Pos.CENTER);

        Button GuardarMascotaBtn = new Button("Guardar Mascota");
        Button CitaMBtn = new Button("Cita Medica");
        Button CitaEBtn = new Button("Cita Estetica");
        Button AtrasBtn = new Button("Atras");


        Label lblTituloM = new Label(" MASCOTA");
        lblTitulo.setStyle("-fx-font-size: 20");
        Label lblNombreMascota = new Label("Nombre:");
        Label lblEspecie = new Label("Especie:");
        Label lblRaza = new Label("Raza:");
        Label lblSexoM = new Label("Sexo:");
        Label lblEdad = new Label("Edad:");


        TextField NombreMascotaTxt = new TextField();

        TextField EdadTxt = new TextField();

        validar.SoloLetras(nombreClienteTxt);
        validar.SoloNumeros(EdadTxt);

        ComboBox ComboHMmascota =new ComboBox();
        ComboHMmascota.getItems().addAll("Hembra", "Macho");
        ComboHMmascota.setValue("-");
        ObservableList<String> especie =
                FXCollections.observableArrayList(
                        "Canino",
                        "Gatos"
                );
        ChoiceBox ComboEspecie = new ChoiceBox();


        ComboBox ComboRaza = new ComboBox();
        //ComboRaza.setPrefHeight(100);
        ComboRaza.setPrefWidth(220);
        ComboEspecie.getItems().addAll(especie);
        idClienteTxt.setVisible(false);
        ComboEspecie.setValue("-");
        ComboEspecie.getSelectionModel().selectedItemProperty().addListener((v, OldValue, newValue) -> cambiarDatoCombo(ComboEspecie, ComboRaza));
        gridpanem.add(idClienteTxt, 1, 1);
        gridpanem.add(lblNombreMascota, 0, 2);
        gridpanem.add(NombreMascotaTxt, 1, 2);

        gridpanem.add(lblEspecie, 0, 3);
        gridpanem.add(ComboEspecie, 1, 3);

        gridpanem.add(lblRaza, 0, 4);
        gridpanem.add(ComboRaza, 1, 4);

        gridpanem.add(lblSexoM, 0, 5);
        gridpanem.add(ComboHMmascota, 1, 5);

        gridpanem.add(lblEdad, 0, 6);
        gridpanem.add(EdadTxt, 1, 6);


        CitaMBtn.setOnAction(e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction(e -> window.setScene(sceneCitaE));
        GuardarMascotaBtn.setOnAction(e ->{
            try {
                funcion.DatosCliente(nombreClienteTxt, DireccionClienteTxt, TelefonoClienteTxt, ComboSexoCliente);
                Connection conn = dc.Connect();
                nombreCliente = nombreClienteTxt.getText();
                rs = conn.createStatement().executeQuery("select id_Cliente from Cliente WHERE Nombre ='" + nombreCliente + "'");
                while(rs.next()) {
                    idCliente = rs.getString(1);
                }//FIN WHILE
                }catch(SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se pudo agregar el nuevo cliente");
            }
            funcion.DatosMascota(idCliente, NombreMascotaTxt, ComboEspecie, ComboRaza, ComboHMmascota, EdadTxt);

        });
        AtrasBtn.setOnAction(e -> window.setScene(sceneBuscar));

        //root2M.getChildren().addAll(GuardarMascotaBtn, AtrasBtn);
        rootM.getChildren().addAll(lblTituloM,gridpanem,GuardarMascotaBtn);






        Label lblPrincipal = new Label("FORMULARIO PARA AGREGAR UN CLIENTE Y/O MASCOTA");
         lblPrincipal.setStyle("-fx-font-size: 24");
            root2M.getChildren().addAll(root,rootM);

            javafx.scene.image.Image agregar = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/plus.png"));
            GuardarClienteBtn.setGraphic(new ImageView(agregar));
            GuardarMascotaBtn.setGraphic(new ImageView(agregar));
        javafx.scene.image.Image atras = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/back.png"));
        AtrasBtn.setGraphic(new ImageView(atras));


            rootMaster.getChildren().addAll(lblPrincipal,root2M,AtrasBtn);
        return rootMaster;
    }


    public VBox DerechaCM() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(0, 50, 0, 0));
        root.setAlignment(Pos.TOP_LEFT);


        Button RegresarBtn = new Button("Atras");
        RegresarBtn.setOnAction(e -> window.setScene(sceneBuscar));

        Label lblProblemasTemp = new Label("LISTA DE PROBLEMAS (TEMPORAL)");
        Label lblPlanesD = new Label("PLANES DIAGNOSTICOS");
        Label lblPlanesT = new Label("PLANES TERAPEUTICOS");
        Label lblInstrucciones = new Label("INSTRUCCIONES CLIENTE");

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

        gridpane.add(lblProblemasTemp, 0, 3);
        gridpane.add(textAreaProb, 0, 4);

        gridpane.add(lblPlanesD, 0, 5);
        gridpane.add(textAreaPlanesD, 0, 6);

        gridpane.add(lblPlanesT, 0, 7);
        gridpane.add(textAreaPlanesT, 0, 8);

        gridpane.add(lblInstrucciones, 0, 9);
        gridpane.add(textAreaInstrucciones, 0, 10);


        root.getChildren().addAll(gridpane, GuardarBtn, RegresarBtn);
evento.foco(textAreaProb,textAreaPlanesD,textAreaPlanesT,textAreaInstrucciones);
        return root;
    }



    Button btn = new Button("Actualizar");

    TableView<TablaMostrarCitas> table = new TableView<TablaMostrarCitas>();
    /*
    private final ObservableList<TablaMostrarCitas> datos = FXCollections.observableArrayList(
            new TablaMostrarCitas("Brian", "Firulais", "Cita Médica", "2017-03-12")
    );
    */

    TableView<TablaInventarios> tablaInventarios = new TableView<TablaInventarios>();
    ObservableList<TablaInventarios> datosInventarios;

    public VBox CentroPrincipal() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(0, 20, 0, 20));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(1, 8, 7, 4));
        gridpane.setHgap(0);
        gridpane.setVgap(0);


        Label lbl = new Label("Bienvenido a VironchiSoft");
        DropShadow sombra = new DropShadow();
        sombra.setOffsetX(6.0f);
        sombra.setOffsetY(5.0f);
        sombra.setColor(Color.rgb(10, 10, 10, 1));
        lbl.setEffect(sombra);

 
        root.getChildren().addAll(lbl,gridpane);
 
        TableColumn columnaCliente = new TableColumn("Cliente");
        columnaCliente.setCellValueFactory(
                new PropertyValueFactory<TablaMostrarCitas, String>("cliente")

        );

        TableColumn columnaMascota = new TableColumn("Mascota");
        columnaMascota.setCellValueFactory(
                new PropertyValueFactory<TablaMostrarCitas, String>("mascota")
        );
        TableColumn columnaTipoCita = new TableColumn("Tipo de Cita");
        columnaTipoCita.setCellValueFactory(
                new PropertyValueFactory<TablaMostrarCitas, String>("tipocita")
        );
        TableColumn columnaFecha = new TableColumn("Fecha");
        columnaFecha.setCellValueFactory(
                new PropertyValueFactory<TablaMostrarCitas, String>("fecha")
        );
        columnaCliente.setPrefWidth(200);
        columnaFecha.setPrefWidth(200);
        columnaTipoCita.setPrefWidth(200);
        columnaMascota.setPrefWidth(200);

        //table.setItems(datos);
        table.setItems(eventoMostrardatosEnTabla(datos));
        table.getColumns().addAll(
                columnaCliente,
                columnaMascota,
                columnaTipoCita,
                columnaFecha
        );

        btn.setOnAction(e -> actualizarDatos());

        //VBox vbox = new VBox();
        root.getChildren().addAll(table, btn);

        // scene.getRoot()).getChildren().addAll(root);


        return root;

    }

    public void actualizarDatos(){
        table.setItems(eventoMostrardatosEnTabla( datos));
    }

    public void actualizarDatosInventario(){
        tablaInventarios.setItems(eventoMostrardatosEnTablaInventarios( datos)); 
    }

    DbConnection dc = new DbConnection();
    ObservableList<TablaMostrarCitas> datos;

 
    public ObservableList eventoMostrardatosEnTabla( ObservableList data){
 
        try {
            Connection conn = dc.Connect();
             data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("select * from vw_tabla_inicio");
            while (rs.next()) {
                //get string from db,whichever way
 
                data.add(new TablaMostrarCitas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
 
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        return data;
    }

    public ObservableList eventoMostrardatosEnTablaInventarios(ObservableList data){
        try {
            Connection conn = dc.Connect();
           data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("select * from vw_buscar_prod");
            while (rs.next()) {
                data.add(new TablaInventarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        return data;
    }

    ObservableList<TablaInventarios> datosInventarioEspecifico;

    //Para retornar la lisa observable con los datos del inventario
    public ObservableList eventoMoverDatosAListaObservable_InventarioEspecifico(ObservableList data, String inventario){
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("select Nombre,CantidadPorUnidad,PrecioUnitario,UnidadesAlmacenadas from vw_buscar_prod where Inventario='"+inventario+"';");
            while (rs.next()) {
                data.add(new TablaInventarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }//While

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }//catch
        return data;
    }//eventoMostrarDatosInventarios



    public VBox CentroInventario() {

        VBox root = new VBox(30);
        root.setPadding(new Insets(0, 30, 0, 30));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 0, 0, 0));
        gridpane.setHgap(5);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);

        //ComboBox ComboInv = new ComboBox();
        //ComboInv.getItems().addAll("Inventario1", "Inventario2", "Invetario3");
        ChoiceBox ComboInv = new ChoiceBox();
        ComboInv.getItems().addAll("Todo","Medicamentos","Insumos","Productos Tienda");

        ComboInv.getSelectionModel().selectedItemProperty().addListener((v, OldValue, newValue) -> cambiarDeInventario(ComboInv));

        Button CerrarBtn = new Button("Cerrar");
        Button AgregarBtn = new Button("Agregar");
        Button ModicarBtn = new Button("Modificar");
 Label lblTituloInv = new Label("Inventario");
        Button ActualizarBtn = new Button("Actualizar");
        javafx.scene.image.Image agregar = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/pencil.png"));
        AgregarBtn.setGraphic(new ImageView(agregar));
        javafx.scene.image.Image cerrar = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/minimimiga.png"));
        CerrarBtn.setGraphic(new ImageView(cerrar));
        javafx.scene.image.Image modificar = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/configuration2.png"));
        ModicarBtn.setGraphic(new ImageView(modificar));


        TableColumn columnaNombre = new TableColumn("Nombre");
        columnaNombre.setCellValueFactory(
                new PropertyValueFactory<TablaInventarios, String>("nombre")
        );
        TableColumn columnaCantidadUnidad = new TableColumn("Cantidad por unidad");
        columnaCantidadUnidad.setCellValueFactory(
                new PropertyValueFactory<TablaInventarios, String>("cantidad_unidad")
        );
        TableColumn columnaPrecioUnidad = new TableColumn("Precio por unidad");
        columnaPrecioUnidad.setCellValueFactory(
                new PropertyValueFactory<TablaInventarios, String>("precio_unidad")
        );
        TableColumn columnaUnidadMedicion = new TableColumn("Unidad de Medicion");
        columnaUnidadMedicion.setCellValueFactory(
                new PropertyValueFactory<TablaInventarios, String>("unidad_medicion")
        );
        columnaNombre.setPrefWidth(150);
        columnaPrecioUnidad.setPrefWidth(230);
        columnaCantidadUnidad.setPrefWidth(250);
        columnaUnidadMedicion.setPrefWidth(230);
        //tablaInventarios.setItems(eventoMostrardatosEnTabla("select * from vw_buscar_prod",datosInventarios));
        tablaInventarios.setItems(eventoMostrardatosEnTablaInventarios(datosInventarios));
        tablaInventarios.getColumns().addAll(
                columnaNombre,
                columnaCantidadUnidad,
                columnaPrecioUnidad,
                columnaUnidadMedicion
        );


        ActualizarBtn.setOnAction(e->actualizarDatosInventario());





        CerrarBtn.setOnAction( e-> window.close());
        ModicarBtn.setOnAction( e-> window.setScene(sceneModificarInv));
        AgregarBtn.setOnAction( e-> window.setScene(sceneAgregarInv));
        root2.getChildren().addAll(AgregarBtn,ModicarBtn,CerrarBtn, ActualizarBtn);
        root.getChildren().addAll(ComboInv,tablaInventarios,gridpane,root2);
 

        return root;

    }

     
    public VBox CentroModificarInv() {



        VBox root = new VBox(30);
        root.setPadding(new Insets(0, 0, 0, 50));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 0, 0, 0));
        gridpane.setHgap(10);
        gridpane.setVgap(15);
        gridpane.setAlignment(Pos.CENTER);

        ComboBox Comboproducto =new ComboBox();

 
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
            Statement statement = connection.createStatement();
            ResultSet buscarcombo = statement.executeQuery("Select Nombre FROM producto ");
            String arr = null;
            while (buscarcombo.next()) {
                String extraccioncombo = buscarcombo.getString("Nombre");
                arr = extraccioncombo.replace("\n", ",");
                Comboproducto.getItems().addAll(extraccioncombo);
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button CerrarBtn = new Button("Cerrar");
        Button RegresarBtn = new Button("Regresar");
        Button GuardarBtn = new Button("Guardar");
        Button EliminarBtn = new Button("Eliminar");


        Label lblProducto = new Label("Producto:");
        Label lblPrecioCosto = new Label("Precio/Costo:");
        Label lblPrecioVenta = new Label("Precio/Venta:");
        Label lblCantidadAc = new Label("Cantidad Actual");
        Label lblAgregar = new Label("Agregar:");
        Label lblMinimo = new Label("Minimo:");
        Label lblUnidad = new Label("Unidad de medida:");
        Label lblTitulo= new Label("Selecciona el inventario y el producto para modificarlo");
        lblTitulo.setStyle("-fx-font-size: 20");

        TextField PrecioCostoTxt = new TextField();
        TextField PrecioVentaTxt = new TextField();
        TextField CantidadActualTxt = new TextField();
        TextField AgregarTxt = new TextField();
        TextField MinitmoTxt = new TextField();

        TextField CantidadPorUnidad = new TextField();


        ComboBox ComboUnidad = new ComboBox();
        ComboUnidad.getItems().addAll("Kilogramo (kg)", "Gramo (g)","Miligramo (mg)","Microgramo (mcg)","Litro (lt)","Decilitro (dl)","Mililitro (ml)");


        ComboBox ComboAgregar = new ComboBox();
        ComboAgregar.getItems().addAll("Caja(s)","Pieza(s)","Frasco(s)");

        ChoiceBox ComboInv = new ChoiceBox();
        ComboInv.getItems().addAll("Selecciona...","Medicamentos","Insumos","Productos Tienda");


gridpane.add(lblProducto,1,1);
        gridpane.add(ComboInv,2,1);
        gridpane.add(Comboproducto,3,1);

        gridpane.add(lblUnidad,1,2);
        gridpane.add(CantidadPorUnidad ,2,2);
        gridpane.add(ComboUnidad,3,2);
        gridpane.add(lblPrecioCosto, 1, 3);
        gridpane.add(PrecioCostoTxt, 2, 3);

        gridpane.add(lblPrecioVenta, 5, 1);
        gridpane.add(PrecioVentaTxt, 6, 1);


        gridpane.add(lblCantidadAc, 1, 4);
        gridpane.add(CantidadActualTxt, 2, 4);
        gridpane.add(lblAgregar, 1, 5);
        gridpane.add(AgregarTxt, 2, 5);
        gridpane.add(ComboAgregar, 3, 5);


        gridpane.add(lblMinimo, 5, 2);
        gridpane.add(MinitmoTxt, 6, 2);

        CerrarBtn.setOnAction( e-> window.close());
        RegresarBtn.setOnAction( e-> window.setScene(sceneInvetario));
        root2.getChildren().addAll(GuardarBtn,EliminarBtn,RegresarBtn,CerrarBtn);
        root.getChildren().addAll(lblTitulo,gridpane,root2);
        GuardarBtn.setOnAction(event -> funcion.ModificarProducto(Comboproducto,PrecioCostoTxt,CantidadActualTxt,AgregarTxt));
        EliminarBtn.setOnAction(event -> funcion.EliminarProducto(Comboproducto));
 

        return root;

    }

    public VBox CentroAgregarInv() {

        VBox root = new VBox(70);
        root.setPadding(new Insets(0, 0, 0, 50));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 0, 0, 0));
        gridpane.setHgap(10);
        gridpane.setVgap(15);
        gridpane.setAlignment(Pos.CENTER);

        ComboBox Comboproducto = new ComboBox();
        Comboproducto.getItems().addAll("Producto1", "Producto2", "Producto3");

        Button CerrarBtn = new Button("Cerrar");
        Button RegresarBtn = new Button("Regresar");
        Button GuardarBtn = new Button("Guardar");
        Button EliminarBtn = new Button("Eliminar");



        Label lblProducto = new Label("Producto:");
        Label lblPrecioCosto = new Label("Precio Costo:");
        Label lblPrecioVenta = new Label("Precio de Venta:");
        Label lblCantidadAc = new Label("Cantidad Actual");
        Label lblAgregar = new Label("Agregar");
        Label lblMinimo = new Label("Minimo en existencia");
        Label lblUnidad = new Label("Unidad de medida");
        Label lblTitulo= new Label("Introduce los datos del producto a agregar");
        lblTitulo.setStyle("-fx-font-size: 20");
        TextField ProductoTxt = new TextField();
        TextField PrecioCostoTxt = new TextField();
        TextField PrecioVentaTxt = new TextField();
        TextField CantidadActualTxt = new TextField();
        CantidadActualTxt.setPromptText("0");
        TextField AgregarTxt = new TextField();
        TextField MinitmoTxt = new TextField();
        TextField CantidadPorUnidad = new TextField();
        ComboBox ComboUnidad = new ComboBox();
        ComboUnidad.getItems().addAll("Kilogramo (kg)", "Gramo (g)","Miligramo (mg)","Microgramo (mcg)","Litro (lt)","Decilitro (dl)","Mililitro (ml)");

        ComboBox ComboAgregar = new ComboBox();
        ComboAgregar.getItems().addAll("Caja(s)","Pieza(s)","Frasco(s)");

        ChoiceBox ComboInv = new ChoiceBox();
        ComboInv.getItems().addAll("Selecciona...","Medicamentos","Insumos","Productos Tienda");

        gridpane.add(lblProducto, 1, 1);
        gridpane.add(ProductoTxt, 2, 1);
        gridpane.add(ComboInv,3,1);
        gridpane.add(lblUnidad,1,2);
        gridpane.add(CantidadPorUnidad ,2,2);
        gridpane.add(ComboUnidad,3,2);
        gridpane.add(lblPrecioCosto, 1, 3);
        gridpane.add(PrecioCostoTxt, 2, 3);

        gridpane.add(lblPrecioVenta, 5, 1);
        gridpane.add(PrecioVentaTxt, 6, 1);


        gridpane.add(lblCantidadAc, 1, 4);
        gridpane.add(CantidadActualTxt, 2, 4);
        gridpane.add(lblAgregar, 1, 5);
        gridpane.add(AgregarTxt, 2, 5);
        gridpane.add(ComboAgregar, 3, 5);


        gridpane.add(lblMinimo, 5, 2);
        gridpane.add(MinitmoTxt, 6, 2);

        CerrarBtn.setOnAction(e -> window.close());
        RegresarBtn.setOnAction(e -> window.setScene(sceneInvetario));
        root2.getChildren().addAll(GuardarBtn, EliminarBtn, RegresarBtn, CerrarBtn);
        root.getChildren().addAll(lblTitulo,gridpane, root2);

        GuardarBtn.setOnAction(e -> funcion.GuardarProducto(ProductoTxt,PrecioCostoTxt,CantidadActualTxt,AgregarTxt));

        return root;

    }

    private TextField txtBuscarCliente;
    private TableColumn<TablaBusqueda, String> columnaNombreCliente;
    private TableColumn<TablaBusqueda, String> columnaNombreMascota;
    private TableColumn<TablaBusqueda, String> columnaTelefono;
    private TableColumn<TablaBusqueda, String> columnaDireccion;

    final TableView<TablaBusqueda> tablaBuscarCliente = new TableView<>();
    final ObservableList<TablaBusqueda> datosBuscarCliente = FXCollections.observableArrayList();
/////////////////////////////////////////////////////// VENTAS

    private TextField txtBuscarProducto;
    private TableColumn<TablaProductosVenta, String> columnaNombreProducto;
    private TableColumn<TablaProductosVenta, String> columnaPrecioUnidadProducto;
    private TableColumn<TablaProductosVenta, String>  columnaCantidad;

     TableView<TablaProductosVenta> tablaProductosVenta = new TableView<>();
     ObservableList<TablaProductosVenta> datosBuscarProductos = FXCollections.observableArrayList();
///////////////////////////////////////////////////////////////////////////////////////////////////////

    private TableColumn<TablaProductosVenta, String> columnaNombreProductoVenta;
    private TableColumn<TablaProductosVenta, String> columnaPrecio;
    private TableColumn<TablaProductosVenta, String>  columnaCantidaVenta;

  TableView<TablaProductosVenta> tablaProductosCobrar = new TableView<>();
  //  final ObservableList<TablaProductosCobrar> datosBuscarProductos = FXCollections.observableArrayList();

    ObservableList<TablaProductosVenta> datosVenta = FXCollections.observableArrayList();

public void llenarTabla(){
    tablaProductosCobrar.setItems(moverDatosTablaVentas(nombreProducto,cantidad,precio));
}
public ObservableList moverDatosTablaVentas(String nombreProducto,String cantidad,String precio){
    datosVenta.add(new TablaProductosVenta(nombreProducto,cantidad,precio));
    return datosVenta;
}
public void limpiartabla(){
    datosVenta.clear();
}


   /* public ObservableList eventoBuscarCliente(ObservableList data){
        try{
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("select * from vistaBuscarCliente");
            while (rs.next()) {
                data.add(new TablaBusqueda(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch (SQLException ex) {
            System.err.println("No se pudo mostrar la tabla"+ex);
        }
        return data;
    }//FIN BUSCAR CLIENTE*/
   ResultSet rs;
   public void actualizarTabla(){
        datosBuscarCliente.clear();
        try{
            Connection conn = dc.Connect();
            String query = "SELECT * FROM vistaBuscarCliente";
            rs = conn.createStatement().executeQuery(query);
            while(rs.next()){
                datosBuscarCliente.add(new TablaBusqueda(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
                tablaBuscarCliente.setItems(datosBuscarCliente);
            }//FIN WHILE
            rs.close();
        }catch (SQLException ex){
            System.err.println("No se pudo mostrar la tabla");
        }
    }
    public void actualizarTablaProducto(){
        datosBuscarProductos.clear();
        try{
            Connection conn = dc.Connect();
            String query = "SELECT * FROM producto";
            rs = conn.createStatement().executeQuery(query);
            while(rs.next()){
                datosBuscarProductos.add(new TablaProductosVenta(
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)

                ));
                tablaProductosVenta.setItems(datosBuscarProductos);
            }//FIN WHILE
            rs.close();
        }catch (SQLException ex){
            System.err.println("No se pudo mostrar la tabla");
        }
    }

    public VBox CentroBuscar() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        HBox root3 = new HBox(10);
        root3.setPadding(new Insets(0, 0, 0, 30));
        root3.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 0, 0, 0));
        gridpane.setHgap(5);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);




        txtBuscarCliente = new TextField("");
        txtBuscarCliente.setPromptText("Puede realizar una busqueda por Cliente o por Mascota");
        //BuscarClienteTxt.getOnKeyPressed();
        Button AgregarClienteBtn = new Button("Agregar Cliente");
        Button AgregarMascotaBtn = new Button("Agregar Mascota");
        Button BuscarClienteBtn = new Button("Historial");
        Button AccederBtn = new Button("Acceder");
        Button CerrarBtn = new Button("Cerrar");
        Button CitaMBtn = new Button("Cita Medica");
        Button CitaEBtn = new Button("Cita Estetica");


        Label lblBienvenida = new Label("Busca o agrega un Cliente o Mascota");
        lblBienvenida.setStyle("-fx-font-size: 20");
        Label lblCliente = new Label("Buscar por:");

        //TABLA BUSCAR CLIENTE

        columnaNombreCliente = new TableColumn<>("Cliente");
        columnaNombreMascota = new TableColumn<>("Mascota");
        columnaTelefono = new TableColumn<>("Telefono");
        columnaDireccion = new TableColumn<>("Dirección");

        columnaNombreCliente.setCellValueFactory(cellData -> cellData.getValue().nombreClienteProperty());
        columnaNombreMascota.setCellValueFactory(cellData -> cellData.getValue().nombreMascotaProperty());
        columnaTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        columnaDireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());

        tablaBuscarCliente.getColumns().addAll(
                columnaNombreCliente,
                columnaNombreMascota,
                columnaTelefono,
                columnaDireccion
        );
        actualizarTabla();
        //FILTRAR DATOS EN LA TABLA
        FilteredList<TablaBusqueda> filteredData = new FilteredList<>(datosBuscarCliente, e -> true);
        txtBuscarCliente.setOnKeyPressed(e ->{
            txtBuscarCliente.textProperty().addListener((observableValue, oldValue, newValue) ->{
                filteredData.setPredicate((Predicate<? super TablaBusqueda>) user->{
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if(user.getNombreCliente().contains(newValue)){
                        return true;
                    }else if(user.getNombreMascota().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList<TablaBusqueda> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tablaBuscarCliente.comparatorProperty());
            tablaBuscarCliente.setItems(sortedData);
        });
        //TAMAÑO DE COLUMNA

        columnaNombreCliente.setPrefWidth(200);
        columnaNombreMascota.setPrefWidth(125);
        columnaTelefono.setPrefWidth(125);
        columnaDireccion.setPrefWidth(200);
        //FIN DE LA TABLA PARA BUSCAR CLIENTE

        //TOMAR DATOS AL HACER CLIC EN LA TABLA
        tablaBuscarCliente.setOnMouseClicked(event -> {
            try{
                Connection conn = dc.Connect();
                TablaBusqueda tablaBusqueda = (TablaBusqueda) tablaBuscarCliente.getSelectionModel().getSelectedItem();
                nombreCliente = String.valueOf(tablaBusqueda.getNombreCliente());
                nombreMascota = String.valueOf(tablaBusqueda.getNombreMascota());
                rs = conn.createStatement().executeQuery("select * from Cliente WHERE Nombre ='"+nombreCliente+"'");

                while(rs.next()){
                    idCliente = rs.getString(1);
                    nombreCliente = rs.getString(2);
                    direccionCliente = rs.getString(3);
                    telefonoCliente = rs.getString(4);
                    sexoCliente = rs.getString(5);
                }//FIN WHILE

                rs = conn.createStatement().executeQuery("SELECT * FROM MASCOTA WHERE id_Cliente ='"+idCliente+"'"
                                                            +"AND Nombre ='"+nombreMascota+"'");
                while(rs.next()){
                    idMascota = rs.getString(1);
                    nombreMascota = rs.getString(3);
                    especieMascota = rs.getString(4);
                    razaMascota = rs.getString(5);
                    sexoMascota = rs.getString(6);
                    descripcionMascota = rs.getString(7);
                }//FIN WHILE
            }catch(SQLException ex){
                System.err.println("No se pudo realizar la consulta");
            }
            finally {
                idClienteTxt.setText(idCliente);
                nombreClienteTxt.setText(nombreCliente);
                lblNombreClienteCM.setText(nombreCliente+"                ");
                lblNombreCliente.setText(nombreCliente);
                lblNombreMascotaCM.setText(nombreMascota+"                ");
                DireccionClienteTxt.setText(direccionCliente);
                TelefonoClienteTxt.setText(telefonoCliente);
                ComboSexoCliente.setValue(sexoCliente);
            }

        });

        //FIN PARA TOMAR DATOS AL HACER CLIC EN LA TABLA

        gridpane.add(txtBuscarCliente,3,1);
        gridpane.add(tablaBuscarCliente,3,2);



        AgregarMascotaBtn.setOnAction(e ->{
            if(idCliente == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atención!");
                alert.setHeaderText("No se ha elegido ningun cliente");
                alert.setContentText("Para agregar una mascota primero debe seleccionar a un cliente");
                alert.showAndWait();
            }
            if(idCliente != null) {
                window.setScene(sceneAMascota);
            }
            });
        AgregarClienteBtn.setOnAction(e ->{window.setScene(sceneACliente);
                                      nombreClienteTxt.setText("");
                                      DireccionClienteTxt.setText("");
                                      TelefonoClienteTxt.setText("");
                                      });
        CerrarBtn.setOnAction(e -> window.close());
        AccederBtn.setOnAction(e -> window.setScene(scene));
        CitaMBtn.setOnAction(e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction(e -> window.setScene(sceneCitaE));


          root2.getChildren().addAll(BuscarClienteBtn,AgregarClienteBtn,AgregarMascotaBtn);
        root3.getChildren().addAll(CitaMBtn,CitaEBtn);
        root.getChildren().addAll(lblBienvenida, gridpane, root2,root3);

       // root.getChildren().addAll(tablaBuscarCliente, gridpane, root2);


        return root;

    }//Fin centro buscar



    public VBox CentroLogin() {

        VBox root = new VBox(5);
        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        DropShadow sombra = new DropShadow();
        sombra.setOffsetX(6.0f);
        sombra.setOffsetY(5.0f);
        sombra.setColor(Color.rgb(10, 10, 10, 1));


        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 60, 80, 0));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.setAlignment(Pos.CENTER);
        javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("logoVironchi.png"));
        Label lblUsuario = new Label("Usuario");
        Label lblContraseña = new Label("Contraseña");
        TextField UsuarioTxt = new TextField("");

        TextField ContraseñaTxt = new TextField("");
        Button AccederBtn = new Button("Acceder");
        Button CerrarBtn = new Button("Cerrar");


        Label lblPrueba = new Label("");
        lblPrueba.setGraphic(new ImageView(image));

        Label lblBienvenida = new Label("Bienvenido a VironchiSoft");
        lblBienvenida.setStyle("-fx-font-size:18");
        lblPrueba.setEffect(sombra);
        lblBienvenida.setEffect(sombra);

        // gridpane.add(lblBienvenida,1,0);
        gridpane.add(lblUsuario, 15, 15);
        gridpane.add(UsuarioTxt, 16, 15);
        gridpane.add(lblContraseña, 15, 16);
        gridpane.add(ContraseñaTxt, 16, 16);
        gridpane.add(AccederBtn, 15, 17);
        gridpane.add(CerrarBtn, 16, 17);


        CerrarBtn.setOnAction(e -> window.close());

        AccederBtn.setOnAction(e -> window.setScene(scene));

        root2.getChildren().addAll(AccederBtn, CerrarBtn);
        root.getChildren().addAll(lblBienvenida, lblPrueba, gridpane, root2);


        return root;

    }

    public VBox CentroVentas() {

        VBox root = new VBox(20);
        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.TOP_CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0, 0, 0, 30));
        root2.setAlignment(Pos.CENTER);

        HBox root3 = new HBox(10);
        root3.setPadding(new Insets(0, 0, 0, 60));
        root3.setAlignment(Pos.CENTER_LEFT);

        HBox root4 = new HBox(10);
        root4.setPadding(new Insets(0, 0, 0, 0));
        root4.setAlignment(Pos.CENTER);

        txtBuscarProducto = new TextField("");
        txtBuscarProducto.setPromptText("Producto");
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0, 60, 80, 0));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.setAlignment(Pos.CENTER);

        Label Ventalbl =new Label("MODULO DE VENTA");
        Label Cantidadlbl =new Label("Cantidad");
        Label NombreProductolbl =new Label("Buscar:");

        Button Agregarbtn = new Button (" Agrega");
        Button Cancelarbtn = new Button (" Cancelar"); //Borrar la tabla
        Button GenerarTicketbtn = new Button ("Cobrar");
        Button Eliminarbtn = new Button (" Eliminar");
         Spinner<Integer> spinner = new Spinner<Integer>();
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        spinner.setPrefWidth(55);
        spinner.setPrefHeight(20);
        spinner.setValueFactory(valueFactory);
        int a =spinner.getValue();
///Tabla Mostrar Productos
        columnaNombreProducto = new TableColumn<>("Producto");
        columnaCantidad = new TableColumn<>("Unidad ");
        columnaPrecioUnidadProducto = new TableColumn<>("Precio");

        columnaNombreProducto.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        columnaCantidad.setCellValueFactory(cellData -> cellData.getValue().precio_unidadProperty());
        columnaPrecioUnidadProducto.setCellValueFactory(cellData -> cellData.getValue().unidad_medidaProperty());
/////TAMAÑO
        tablaProductosVenta.getColumns().addAll(
                columnaNombreProducto,
                columnaCantidad,
                columnaPrecioUnidadProducto
        );
        columnaNombreProducto.setPrefWidth(120);
        columnaCantidad.setPrefWidth(120);
        columnaPrecioUnidadProducto.setPrefWidth(120);
       tablaProductosVenta.setPrefSize(450,180);
        actualizarTablaProducto();
/////////////Buscar producto
        FilteredList<TablaProductosVenta> filteredData= new FilteredList<>(datosBuscarProductos, e -> true);
        txtBuscarProducto.setOnKeyPressed(e ->{
            txtBuscarProducto.textProperty().addListener((observableValue, oldValue, newValue) ->{
                filteredData.setPredicate((Predicate<? super TablaProductosVenta>) user->{
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if(user.getNombre().contains(newValue)){
                        return true;
                    }else if(user.getPrecio_unidad().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList<TablaProductosVenta> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tablaProductosVenta.comparatorProperty());
            tablaProductosVenta.setItems(sortedData);
        });
/////////////////////////////Tomar datos
        tablaProductosVenta.setOnMouseClicked(event -> {
            try{
                Connection conn = dc.Connect();
                TablaProductosVenta tablaBusqueda = (TablaProductosVenta) tablaProductosVenta.getSelectionModel().getSelectedItem();
                nombreProducto = String.valueOf(tablaBusqueda.getNombre());

                rs = conn.createStatement().executeQuery("select * from producto WHERE Nombre ='"+nombreProducto+"'");


                while(rs.next()){
                    nombreProducto = rs.getString(5);
                    cantidad = rs.getString(6);
                    precio = rs.getString(7);

                }
            }catch(SQLException ex){
                System.err.println("No se pudo realizar la consulta");
            }
            finally {
              System.err.print(nombreProducto+"\n");
                System.err.print(cantidad+"\n");
                System.err.print(precio+"\n");
                System.err.print("\n"+a+"\n");
            }

        });

//////////////////////////////////////////////////////////////////////////////////////////////////


        ///Tabla Productos agregados
        columnaNombreProductoVenta = new TableColumn<>("Producto");
        columnaPrecio = new TableColumn<>("Cantidad ");
        columnaCantidaVenta = new TableColumn<>("Precio");

        columnaNombreProductoVenta.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        columnaPrecio.setCellValueFactory(cellData -> cellData.getValue().precio_unidadProperty());
        columnaCantidaVenta.setCellValueFactory(cellData -> cellData.getValue().unidad_medidaProperty());
/////TAMAÑO
        tablaProductosCobrar.getColumns().addAll(
                columnaNombreProductoVenta,
                columnaPrecio,
                columnaCantidaVenta
        );
        columnaNombreProductoVenta.setPrefWidth(120);
        columnaPrecio.setPrefWidth(120);
        columnaCantidaVenta.setPrefWidth(120);
        tablaProductosCobrar.setPrefSize(450,320);
        ////////////////////////// TOMAR VALORES





///////////////////ACOMODO
gridpane.add(Cantidadlbl,2,6);
        gridpane.add(spinner,3,6);
        gridpane.add(NombreProductolbl,0,6);
        gridpane.add(txtBuscarProducto,1,6);
gridpane.add(Agregarbtn,4,6);
root4.getChildren().addAll(GenerarTicketbtn,Cancelarbtn);
root3.getChildren().addAll(tablaProductosCobrar,Eliminarbtn);
        root2.getChildren().addAll(gridpane,tablaProductosVenta);
root.getChildren().addAll(Ventalbl,root2,root3,root4);

Agregarbtn.setOnAction(e -> llenarTabla());
Eliminarbtn.setOnAction(e -> limpiartabla());

        return root;

    }




    public  HBox BtnAbajoAgendarCita() {
 

        HBox root = new HBox(10);
        root.setPadding(new Insets(250, 50, 20, 50));
        root.setAlignment(Pos.TOP_CENTER);


        Button CitaMBtn = new Button("Cita Medica");
        Button CitaEBtn = new Button("Cita Estetica");
        Button AgregarCliente = new Button("Agregar cliente");

        CitaMBtn.setOnAction(e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction(e -> window.setScene(sceneCitaE));
        AgregarCliente.setOnAction(e -> window.setScene(sceneACliente));

        Label lbl = new Label("Agregar Cita");
        lbl.setStyle("-fx-font-weight: bold");
       /* lbl.prefHeightProperty().bind(root.heightProperty().subtract(2*SIZE));
        lbl.prefWidthProperty().bind(root.widthProperty().subtract(2*SIZE));*/


        root.getChildren().addAll(lbl, AgregarCliente);

        return root;
    }
 
    public HBox BotonesArribaPrincipal () {
 
        HBox root = new HBox(5);
        root.setPadding(new Insets(5, 0, 0, 0));
        root.setAlignment(Pos.TOP_CENTER);

        DropShadow sombra = new DropShadow();
        sombra.setOffsetX(2.5f);
        sombra.setOffsetY(2.5f);
        sombra.setColor(Color.rgb(10, 10, 30, 0.2));

        javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/archive.png"));
        javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/clock.png"));
        javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/delivery1.png"));
         javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/basket.png"));
         javafx.scene.image.Image image5 = new javafx.scene.image.Image(getClass().getResourceAsStream("Recursos/configuration2.png"));
        Button CitaBtn = new Button("MOSTRAR CITA"); //
        Button ACitaBtn = new Button("AGENDAR CITA");
        Button InvBtn = new Button("INVENTARIO");
        Button ProvBtn = new Button("VENTAS");
        Button MasBtn = new Button("+");
        CitaBtn.setEffect(sombra);
        InvBtn.setEffect(sombra);
        ProvBtn.setEffect(sombra);
        MasBtn.setEffect(sombra);
        ACitaBtn.setEffect(sombra);
        CitaBtn.setGraphic(new ImageView(image1));
         ACitaBtn.setGraphic(new ImageView(image2));
         InvBtn.setGraphic(new ImageView(image3));
         ProvBtn.setGraphic(new ImageView(image4));
         MasBtn.setGraphic(new ImageView(image5));
        root.getChildren().addAll(CitaBtn, ACitaBtn, InvBtn, ProvBtn, MasBtn);
        ACitaBtn.setOnAction(e -> window.setScene(sceneBuscar));
        CitaBtn.setOnAction(e -> window.setScene(scene));
        InvBtn.setOnAction(e -> window.setScene(sceneInvetario));
        ProvBtn.setOnAction(e -> window.setScene(sceneVentas));
        //btn.setOnAction(e -> actualizarDatos());





        return root;
    }

    public VBox DatosMascota() {

        VBox rootM = new VBox(25);
        HBox root2M = new HBox(220);
        GridPane gridpanem = new GridPane();
        gridpanem.setPadding(new Insets(0,0,0,0));
        gridpanem.setHgap(10);
        gridpanem.setVgap(5);
        rootM.setPadding(new Insets(0, 0, 0, 0));
        root2M.setAlignment(Pos.CENTER);
        rootM.setAlignment(Pos.CENTER);
        gridpanem.setAlignment(Pos.CENTER);

        Button GuardarMascotaBtn = new Button("Guardar Mascota");
        Button CitaMBtn = new Button("Cita Medica");
        Button CitaEBtn = new Button("Cita Estetica");
        Button AtrasBtn = new Button("Atras");


        Label lblTituloM = new Label(" MASCOTA");
       // lblTitulo.setStyle("-fx-font-size: 20");
        Label lblNombreMascota = new Label("Nombre:");
        Label lblEspecie = new Label("Especie:");
        Label lblRaza = new Label("Raza:");
        Label lblSexoM = new Label("Sexo:");
        Label lblEdad = new Label("Edad:");
        Label lblCliente = new Label("Cliente:");


        TextField NombreMascotaTxt = new TextField();

        TextField EdadTxt = new TextField();

        validar.SoloLetras(nombreClienteTxt);
        validar.SoloNumeros(EdadTxt);

        ComboBox ComboHMmascota =new ComboBox();
        ComboHMmascota.getItems().addAll("Hembra", "Macho");
        ComboHMmascota.setValue("-");
        ObservableList<String> especie =
                FXCollections.observableArrayList(
                        "Canino",
                        "Gatos"
                );
        ChoiceBox ComboEspecie = new ChoiceBox();


        ComboBox ComboRaza = new ComboBox();
        //ComboRaza.setPrefHeight(100);
        ComboRaza.setPrefWidth(220);
        ComboEspecie.getItems().addAll(especie);
        idClienteTxt.setVisible(false);
        ComboEspecie.setValue("-");
        ComboEspecie.getSelectionModel().selectedItemProperty().addListener((v, OldValue, newValue) -> cambiarDatoCombo(ComboEspecie, ComboRaza));
        gridpanem.add(lblCliente, 0, 1);
        gridpanem.add(lblNombreCliente, 1, 1);

       // gridpanem.add(lblNombreMascota, 0, 2);
        gridpanem.add(NombreMascotaTxt, 1, 2);

        gridpanem.add(lblEspecie, 0, 3);
        gridpanem.add(ComboEspecie, 1, 3);

        gridpanem.add(lblRaza, 0, 4);
        gridpanem.add(ComboRaza, 1, 4);

        gridpanem.add(lblSexoM, 0, 5);
        gridpanem.add(ComboHMmascota, 1, 5);

        gridpanem.add(lblEdad, 0, 6);
        gridpanem.add(EdadTxt, 1, 6);


        CitaMBtn.setOnAction(e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction(e -> window.setScene(sceneCitaE));
        GuardarMascotaBtn.setOnAction(e -> funcion.DatosMascota(idCliente,NombreMascotaTxt, ComboEspecie, ComboRaza, ComboHMmascota, EdadTxt));
        AtrasBtn.setOnAction(e -> window.setScene(sceneBuscar));

        //root2M.getChildren().addAll(GuardarMascotaBtn, AtrasBtn);
        rootM.getChildren().addAll(lblTituloM,gridpanem,GuardarMascotaBtn,AtrasBtn);
return rootM;


    }

    public void cambiarDeInventario(ChoiceBox ComboInventario ){

        if (ComboInventario.getValue().toString() == "Todo"){
            tablaInventarios.setItems(eventoMostrardatosEnTablaInventarios(datosInventarios));
        }//if

        if(ComboInventario.getValue().toString() == "Medicamentos"){
            tablaInventarios.setItems(eventoMoverDatosAListaObservable_InventarioEspecifico(datosInventarioEspecifico,"Medicamentos"));
        }//If

        if(ComboInventario.getValue().toString() == "Insumos"){
            tablaInventarios.setItems(eventoMoverDatosAListaObservable_InventarioEspecifico(datosInventarioEspecifico,"Insumos"));
        }//If

        if(ComboInventario.getValue().toString() == "Productos Tienda"){
            tablaInventarios.setItems(eventoMoverDatosAListaObservable_InventarioEspecifico(datosInventarioEspecifico,"Productos Tienda"));
        }//If
    }

    public void cambiarDatoCombo(ChoiceBox ComboEspecie, ComboBox ComboRaza) {
    ComboEspecie.setStyle("-fx-text-fill: black;");

        if (ComboEspecie.getValue().toString() == "Canino") {
            ObservableList<String> caninos =
                    FXCollections.observableArrayList("Beagle","Boxer",
                            "Bull Terrier","Bulldog ingles",
                            "Caniche","Chihuahua","Cocker Ingles",
                            "Collie","Dalmata","Doberman",
                            "Golden Retriever","Gran Danes",
                            "Husky Siberiano","Labrador",
                            "Pasto Aleman","Pastor Belga",
                            "Pekinés","Pinscher","Pit Bull",
                            "Rottweiler","San Bernardo","Schnauzer",
                            "Weste","Yorkshire Terrier","Criollo","Otro..."
                    );

            ComboRaza.setItems(caninos);

        }

        if (ComboEspecie.getValue().toString() == "Gatos") {
            ObservableList<String> gatuno =
                    FXCollections.observableArrayList(
                            "Persa",
                            "Bengala","Burmes","Ragdoll","Sphynx","Sagrado de Birmania",
                            "Ocicat","Mau egipcio","Angora turco","Gato tonkines","Bommbay",
                            "Bobtail japones","Gato max","Signapura","Showshoe","Cymric","Criollo","Otro..."
                    );
            ComboRaza.setItems(gatuno);

 
        }//if

    }//CambiarDatoCombo
 
    public HBox CitaEstetica() {

        HBox root = new HBox(5);

        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);


        Button GuardarCitaBtn = new Button("Guardar Cita");
        Button AtrasBtn = new Button("Atras");
        AtrasBtn.setOnAction(e -> window.setScene(sceneBuscar));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "C",
                        "M",
                        "G"
                );
        ComboBox ComboTam = new ComboBox();
        ComboTam.getItems().addAll("C", "M", "G");
        ComboTam.setValue("-");

        Label lblFecha = new Label("Fecha:");
        Label lblTamaño = new Label("Tamaño Mascota");
        Label lblDes = new Label("Descripcion:");
        Label lblPrecio = new Label("Precio:");

       // TextField FechaTxt = new TextField();
        DatePicker FechaTxt = new DatePicker();
        FechaTxt.setValue(LocalDate.now());
        String obtenerFecha = "";
        TextField DesTxt = new TextField();
        TextField PrecioTxt = new TextField();

        gridpane.add(lblFecha, 0, 30);
        gridpane.add(FechaTxt, 1, 30);

        gridpane.add(lblTamaño, 0, 31);
        gridpane.add(ComboTam, 1, 31);

        gridpane.add(lblDes, 0, 32);
        gridpane.add(DesTxt, 1, 32);
        gridpane.add(lblPrecio, 0, 33);
        gridpane.add(PrecioTxt, 1, 33);


        gridpane.add(GuardarCitaBtn, 1, 40);

        gridpane.add(AtrasBtn, 2, 40);

        GuardarCitaBtn.setOnAction(e -> validar.CampoVacioCitaEstetica(FechaTxt, ComboTam, DesTxt, PrecioTxt));


        root.getChildren().addAll(gridpane);
        return root;
    }
 
    public  VBox CentroCM() {
 


        VBox root = new VBox(2);
        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5, 0, 0, 0));
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(3);
        hBox2.setPadding(new Insets(0, 0, 0, 38));
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox0 = new HBox(10);
        hBox0.setPadding(new Insets(0, 0, 0,0 ));
        hBox0.setAlignment(Pos.CENTER);
        hBox0.setStyle("-fx-background-color: skyblue");

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

       // Label lblIDMASCOTA = new Label("ID MASCOTA:");
        // Label lblIDADEUDO = new Label("ID ADEUDO:");
        Label lbl1 = new Label("APARIENCIA GENERAL");
        Label lbl2 = new Label("PIEL");
        Label lbl3 = new Label("MUSCULOSQUELETO");
        Label lbl4 = new Label("CIRCULATORIO");
        Label lbl5 = new Label("DIGESTIVO");
        Label lbl6 = new Label("RESPIRATORIO");
        Label lbl7 = new Label("GENITOURINARIO");
        Label lbl8 = new Label("OJOS");
        Label lbl9 = new Label("OIDOS");
        Label lbl10 = new Label("SISTEMA NERVIOSO");
        Label lbl11 = new Label("GANGLIOS");
        Label lbl12 = new Label("MUCOSAS");

        Label lblCliente =new Label("Cliente:");
        lblCliente.setStyle("-fx-text-fill:  white");
        Label lblMascota =new Label("Mascota:");
        lblMascota.setStyle("-fx-text-fill:  white");
            hBox0.getChildren().addAll(lblCliente,lblNombreClienteCM,lblMascota,lblNombreMascotaCM );

        Label lblFecha = new Label("Fecha: ");
        Label lblTemperatura = new Label("Temperatura: ");
        Label lblPeso = new Label("Peso: ");
     //   TextField FechaTxt = new TextField();
        DatePicker FechaTxt = new DatePicker();
        FechaTxt.setValue(LocalDate.now());
        TextField TemperaturaTxt = new TextField();
        TextField PesoTxt = new TextField();


        TextField txtIDMASCOTA = new TextField();
        TextField txtIDADEUDO = new TextField();
        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();
        TextArea textArea3 = new TextArea();
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


        GuardarBtn = new Button("Guardar");


        hBox.getChildren().addAll(lblFecha, FechaTxt, lblPeso, PesoTxt, lblTemperatura, TemperaturaTxt);


        gridpane.add(lbl1, 0, 0);
        gridpane.add(Nor1Rbtn, 1, 0);
        gridpane.add(Anor1Rbtn, 2, 0);
        gridpane.add(textArea1, 3, 0);


        gridpane.add(lbl2, 0, 1);
        gridpane.add(Nor2Rbtn, 1, 1);
        gridpane.add(Anor2Rbtn, 2, 1);
        gridpane.add(textArea2, 3, 1);

        gridpane.add(lbl3, 0, 2);
        gridpane.add(Nor3Rbtn, 1, 2);
        gridpane.add(Anor3Rbtn, 2, 2);
        gridpane.add(textArea3, 3, 2);

        gridpane.add(lbl4, 0, 3);
        gridpane.add(Nor4Rbtn, 1, 3);
        gridpane.add(Anor4Rbtn, 2, 3);
        gridpane.add(textArea4, 3, 3);

        gridpane.add(lbl5, 0, 4);
        gridpane.add(Nor5Rbtn, 1, 4);
        gridpane.add(Anor5Rbtn, 2, 4);
        gridpane.add(textArea5, 3, 4);

        gridpane.add(lbl6, 0, 5);
        gridpane.add(Nor6Rbtn, 1, 5);
        gridpane.add(Anor6Rbtn, 2, 5);
        gridpane.add(textArea6, 3, 5);

        gridpane.add(lbl7, 0, 6);
        gridpane.add(Nor7Rbtn, 1, 6);
        gridpane.add(Anor7Rbtn, 2, 6);
        gridpane.add(textArea7, 3, 6);

        gridpane.add(lbl8, 0, 7);
        gridpane.add(Nor8Rbtn, 1, 7);
        gridpane.add(Anor8Rbtn, 2, 7);
        gridpane.add(textArea8, 3, 7);

        gridpane.add(lbl9, 0, 8);
        gridpane.add(Nor9Rbtn, 1, 8);
        gridpane.add(Anor9Rbtn, 2, 8);
        gridpane.add(textArea9, 3, 8);

        gridpane.add(lbl10, 0, 9);
        gridpane.add(Nor10Rbtn, 1, 9);
        gridpane.add(Anor10Rbtn, 2, 9);
        gridpane.add(textArea10, 3, 9);

        gridpane.add(lbl11, 0, 10);
        gridpane.add(Nor11Rbtn, 1, 10);
        gridpane.add(Anor11Rbtn, 2, 10);
        gridpane.add(textArea11, 3, 10);

        gridpane.add(lbl12, 0, 11);
        gridpane.add(Nor12Rbtn, 1, 11);
        gridpane.add(Anor12Rbtn, 2, 11);
        gridpane.add(textArea12, 3, 11);


       // hBox2.getChildren().addAll(lblIDMASCOTA, txtIDMASCOTA, lblIDADEUDO, txtIDADEUDO);
        Anor1Rbtn.setOnAction(e -> funcion.cambiarModo(Anor1Rbtn, textArea1));
        Anor2Rbtn.setOnAction(e -> funcion.cambiarModo(Anor2Rbtn, textArea2));
        Anor3Rbtn.setOnAction(e -> funcion.cambiarModo(Anor3Rbtn, textArea3));
        Anor4Rbtn.setOnAction(e -> funcion.cambiarModo(Anor4Rbtn, textArea4));
        Anor5Rbtn.setOnAction(e -> funcion.cambiarModo(Anor5Rbtn, textArea5));
        Anor6Rbtn.setOnAction(e -> funcion.cambiarModo(Anor6Rbtn, textArea6));
        Anor7Rbtn.setOnAction(e -> funcion.cambiarModo(Anor7Rbtn, textArea7));
        Anor8Rbtn.setOnAction(e -> funcion.cambiarModo(Anor8Rbtn, textArea8));
        Anor9Rbtn.setOnAction(e -> funcion.cambiarModo(Anor9Rbtn, textArea9));
        Anor10Rbtn.setOnAction(e -> funcion.cambiarModo(Anor10Rbtn, textArea10));
        Anor11Rbtn.setOnAction(e -> funcion.cambiarModo(Anor11Rbtn, textArea11));
        Anor12Rbtn.setOnAction(e -> funcion.cambiarModo(Anor12Rbtn, textArea12));


        root.getChildren().addAll(hBox0,hBox, gridpane, hBox2);
      /*  java.util.Date fecha = new java.util.Date();
        long fechasistema = fecha.getTime();
        java.sql.Date fechasql2 = new java.sql.Date(fechasistema);
        String fechasql = fechasql2.toString();
        FechaTxt.setText(fechasql);
        */
      TextField PrecioTxt = new TextField();
        TextField DescripcionTxt = new TextField();


        /*GuardarBtn.setOnAction(event -> funcion.eventoguardarcitaA(FechaTxt, TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn, textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn, Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7, Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn, textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12, textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, txtIDMASCOTA, txtIDADEUDO));*/


       //APLICAR CAMBIOS DE DATE PICKER
        //GuardarBtn.addEventHandler(ActionEvent.ACTION ,(e) -> funcion.eventoguardarcitaA(FechaTxt, TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn, textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn, Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7, Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn, textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12, textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, txtIDMASCOTA, txtIDADEUDO));
        //GuardarBtn.addEventHandler(ActionEvent.ACTION ,(e) -> validar.popUp2(PrecioTxt,DescripcionTxt));


 
     //   GuardarBtn.setOnAction(event -> funcion.eventoguardarcitaA(FechaTxt, TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn, textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn, Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7, Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn, textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12, textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, txtIDMASCOTA, txtIDADEUDO));
 
      /*  GuardarBtn.setOnAction(event -> funcion.eventoguardarcitaA(textArea1,textArea2,textArea3,textArea4,textArea5,textArea7,textArea8,textArea9,textArea10,textArea11,textArea12,
                textAreaProb,textAreaPlanesT,textAreaInstrucciones,txtIDMASCOTA,txtIDADEUDO));*/


 
        TextField PrecioTxt1 = new TextField();
        TextField DescripcionTxt1 = new TextField();
        GuardarBtn.setOnAction(e ->{
            String id_Adeudo="";
            String id_CitaMedica = "";
            validar.popUp2(PrecioTxt1, DescripcionTxt1, idCliente);
            //OBTENER ID DEL ADEUDO
            try {
                Connection conn = dc.Connect();
                rs = conn.createStatement().executeQuery("select MAX(Id_Adeudo) from Adeudo");
                while (rs.next()) {
                    id_Adeudo = rs.getString(1);
                }//FIN WHILE
            }catch(SQLException ex){
                System.out.println("No se pudo obtener el ID :v");
            }
            finally {
                funcion.eventoguardarcitaA(FechaTxt.getValue(), TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn,
                                           textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn,
                                           Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7,
                                           Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn,
                                           textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12,
                                           textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, idMascota, id_Adeudo, id_CitaMedica);
            }
            });
 

        return root;

    }
}

