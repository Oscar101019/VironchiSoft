
import com.sun.javafx.scene.SceneHelper;
import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by juven on 29/3/2017.
 */
public class Diseño {
    public BorderPane root,root1,rootCM,rootCE,rootC,rootM,rootABAJOCM,rootLogin,rootBuscar,rootBuscarCliente,rootInventario,rootProveedores,rootModificarInv,rootAgregarInv;
    public Stage window;
    public Scene scene,sceneAgregar, sceneCitaM, sceneCitaE,sceneACliente,sceneAMascota,sceneLogin,sceneBuscar,sceneBuscarCliente,sceneInvetario,sceneProveedores,sceneModificarInv,sceneAgregarInv;                    //M=Medica       E=Estetica

    Funciones funcion =new Funciones();
    Validacion validar = new Validacion();

    Button GuardarBtn;
    TextArea textAreaProb;
    TextArea textAreaPlanesD;
    TextArea textAreaPlanesT;
    TextArea textAreaInstrucciones;

    public  void initUI(Stage stage) {

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
        rootProveedores = new BorderPane();
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

        rootProveedores.setTop(BotonesArribaPrincipal());


        sceneLogin = new Scene(rootLogin, 500, 700);
        scene = new Scene(root, 1150, 700);
        sceneBuscar = new Scene(rootBuscar, 1150, 700);
        sceneBuscarCliente = new Scene(rootBuscarCliente, 100, 100);
        sceneAgregar = new Scene(root1, 1150, 700);
        sceneCitaM = new Scene(rootCM, 1150, 700);
        sceneCitaE = new Scene(rootCE, 1150, 700);
        sceneACliente = new Scene(rootC, 1150, 700);
        sceneAMascota = new Scene(rootM, 1150, 700);
        sceneInvetario = new Scene(rootInventario, 1150, 700);
        sceneProveedores = new Scene(rootProveedores, 1150, 700);
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
        sceneProveedores.getStylesheets().add("Estilo.css");
        sceneModificarInv.getStylesheets().add("Estilo.css");
        sceneAgregarInv.getStylesheets().add("Estilo.css");


        stage.setTitle("VironchiSoft");
        stage.setScene(sceneLogin);
        stage.show();
        stage.centerOnScreen();


    }


    public HBox DatosClienteCentro() {

        HBox root = new HBox(5);
        root.setPadding(new Insets(0, 0, 0, 0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);


        Button AgregarMascotaBtn = new Button("Agregar Mascota");
        Button GuardarClienteBtn = new Button("Guardar Cliente");
        Button AtrasBtn = new Button("Atras");

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "H",
                        "M"
                );
        // ComboBox ComboHM =new ComboBox(options);

        ComboBox ComboHM = new ComboBox();
        ComboHM.getItems().addAll("H", "M");
        ComboHM.setValue("-");

        Label lblIDCLIENTE = new Label("ID Cliente");
        Label lblNombre = new Label("Nombre:");
        Label lblDireccion = new Label("Direccion:");
        Label lblTelefono = new Label("Telefono:");
        Label lblSexo = new Label(" Sexo:");

        TextField IDCLIENTETxt = new TextField();
        TextField NombreTxt = new TextField();
        TextField DireccionTxt = new TextField();
        TextField TelefonoTxt = new TextField();
        TextField SexoTxt = new TextField();

        GuardarClienteBtn.setAlignment(Pos.CENTER);

          GuardarClienteBtn.setOnAction(e -> funcion.DatosCliente(NombreTxt,DireccionTxt,TelefonoTxt,ComboHM));

        gridpane.add(lblNombre, 0, 30);
        gridpane.add(NombreTxt, 1, 30);

        gridpane.add(lblDireccion, 0, 31);
        gridpane.add(DireccionTxt, 1, 31);

        gridpane.add(lblTelefono, 0, 32);
        gridpane.add(TelefonoTxt, 1, 32);

        gridpane.add(lblSexo, 0, 33);
        gridpane.add(ComboHM, 1, 33);

        gridpane.add(AgregarMascotaBtn, 1, 40);
        gridpane.add(GuardarClienteBtn, 1, 38);
        gridpane.add(AtrasBtn, 2, 40);
          AgregarMascotaBtn.setOnAction( e -> window.setScene(sceneAMascota));
        AtrasBtn.setOnAction( e -> window.setScene(sceneBuscar));


        System.out.println("SceneDatosCliente()");


        root.getChildren().addAll(gridpane);
        return root;
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

        return root;
    }

    Button btn = new Button("Actualizar");

    TableView<TablaMostrarCitas> table = new TableView<TablaMostrarCitas>();
    /*
    private final ObservableList<TablaMostrarCitas> datos = FXCollections.observableArrayList(
            new TablaMostrarCitas("Brian","Firulais","Cita Médica","2017-03-12")
    );
    */

    TableView<TablaInventarios> tablaInventarios = new TableView<TablaInventarios>();
    ObservableList<TablaInventarios> datosInventarios =  FXCollections.observableArrayList();

    public VBox CentroPrincipal() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(0,20,0,20));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(1,8,7,4));
        gridpane.setHgap(0);
        gridpane.setVgap(0);


        Label lbl = new Label("Bienvenido a VironchiSoft");
        DropShadow sombra= new DropShadow();
        sombra.setOffsetX(6.0f);
        sombra.setOffsetY(5.0f);
        sombra.setColor(Color.rgb(10,10,10,1));
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

        //table.setItems(datos);
        table.setItems(eventoMostrardatosEnTabla(datos));
        table.getColumns().addAll(
                columnaCliente,
                columnaMascota,
                columnaTipoCita,
                columnaFecha
        );

        btn.setOnAction(e->actualizarDatos());

        //VBox vbox = new VBox();
        root.getChildren().addAll(table,btn);

        // scene.getRoot()).getChildren().addAll(root);


        return root;

    }
    public void actualizarDatos(){
        table.setItems(eventoMostrardatosEnTabla( datos));
    }

    public void actualizarDatosInventario(){
        tablaInventarios.setItems(eventoMostrardatosEnTablaInventarios( datos));
        System.out.println("Hola desdew actualizar Datos Inventario");
    }

    DbConnection dc = new DbConnection();
    ObservableList<TablaMostrarCitas> datos = FXCollections.observableArrayList();

    public ObservableList eventoMostrardatosEnTabla( ObservableList data){
        try {
            Connection conn = dc.Connect();
            //data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("select * from vw_tabla_inicio");
            while (rs.next()) {
                //get string from db,whichever way
                 data.add(new TablaMostrarCitas(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4) ));
                 //datosInventarios.add(new TablaInventarios(rs.getString(1),"Hola,","Gola","Hola" ));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        return data;
    }

    public ObservableList eventoMostrardatosEnTablaInventarios(ObservableList data){
        try {
            Connection conn = dc.Connect();
            //data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("select * from vw_buscar_prod");
            while (rs.next()) {
                //get string from db,whichever way
                //datos.add(new TablaMostrarCitas(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4) ));
                data.add(new TablaInventarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        return data;
    }




    public VBox CentroInventario() {

        VBox root = new VBox(50);
        root.setPadding(new Insets(0,0,0,50));
        root.setAlignment(Pos.CENTER_LEFT);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,0,0,0));
        gridpane.setHgap(5);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);

        ComboBox ComboInv =new ComboBox();
        ComboInv.getItems().addAll("Inventario1", "Inventario2","Invetario3");

        Button CerrarBtn = new Button("Cerrar");
        Button AgregarBtn = new Button("Agregar");
        Button ModicarBtn = new Button("Modificar");
        Button ActualizarBtn = new Button("Actualizar");
        //Rectangle rectangle = new Rectangle(900,400);

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

        //tablaInventarios.setItems(eventoMostrardatosEnTabla("select * from vw_buscar_prod",datosInventarios));
        tablaInventarios.setItems(eventoMostrardatosEnTablaInventarios(datosInventarios));
        tablaInventarios.getColumns().addAll(
                columnaNombre,
                columnaCantidadUnidad,
                columnaPrecioUnidad,
                columnaUnidadMedicion
        );

        ActualizarBtn.setOnAction(e->actualizarDatosInventario());



        //gridpane.add(rectangle ,0,0);
         //gridpane.add(tablaInventarios,0,0);


        CerrarBtn.setOnAction( e-> window.close());
        ModicarBtn.setOnAction( e-> window.setScene(sceneModificarInv));
        AgregarBtn.setOnAction( e-> window.setScene(sceneAgregarInv));
        root2.getChildren().addAll(AgregarBtn,ModicarBtn,CerrarBtn,tablaInventarios,ActualizarBtn);
        root.getChildren().addAll(ComboInv,gridpane,root2);

        return root;

    }
    public VBox CentroModificarInv() {

        VBox root = new VBox(70);
        root.setPadding(new Insets(0,0,0,50));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,0,0,0));
        gridpane.setHgap(10);
        gridpane.setVgap(15);
        gridpane.setAlignment(Pos.CENTER);

        ComboBox Comboproducto =new ComboBox();
        Comboproducto.getItems().addAll("Producto1", "Producto2","Producto3");

        Button CerrarBtn = new Button("Cerrar");
        Button RegresarBtn = new Button("Regresar");
        Button GuardarBtn = new Button("Guardar");
        Button EliminarBtn = new Button("Eliminar");


        Label lblProducto = new Label("Prudcto:");
        Label lblPrecioCosto = new Label("Precio/Costo:");
        Label lblPrecioVenta= new Label ("Precio Venta:");
        Label lblCantidadAc= new Label ("Cantidad Actual");
        Label lblAgregar= new Label ("Agregar");
        Label lblMinimo= new Label ("Minimo");

        TextField PrecioCostoTxt = new TextField();
        TextField PrecioVentaTxt = new TextField();
        TextField CantidadActualTxt = new TextField();
        TextField AgregarTxt = new TextField();
        TextField MinitmoTxt = new TextField();




        gridpane.add(lblPrecioCosto,1,4);
        gridpane.add(PrecioCostoTxt,2,4);

        gridpane.add(lblPrecioVenta,5,4);
        gridpane.add(PrecioVentaTxt,6,4);


        gridpane.add(lblCantidadAc,1,10);
        gridpane.add(CantidadActualTxt,2,10);
            gridpane.add(lblAgregar,3,10);
        gridpane.add(AgregarTxt,4,10);

        gridpane.add(lblMinimo,5,10);
        gridpane.add(MinitmoTxt,6,10);

        CerrarBtn.setOnAction( e-> window.close());
        RegresarBtn.setOnAction( e-> window.setScene(sceneInvetario));
        root2.getChildren().addAll(GuardarBtn,EliminarBtn,RegresarBtn,CerrarBtn);
        root.getChildren().addAll(lblProducto,Comboproducto,gridpane,root2);

        return root;

    }
    public VBox CentroAgregarInv() {

        VBox root = new VBox(70);
        root.setPadding(new Insets(0,0,0,50));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,0,0,0));
        gridpane.setHgap(10);
        gridpane.setVgap(15);
        gridpane.setAlignment(Pos.CENTER);

        ComboBox Comboproducto =new ComboBox();
        Comboproducto.getItems().addAll("Producto1", "Producto2","Producto3");

        Button CerrarBtn = new Button("Cerrar");
        Button RegresarBtn = new Button("Regresar");
        Button GuardarBtn = new Button("Guardar");
        Button EliminarBtn = new Button("Eliminar");


        Label lblProducto = new Label("Prudcto:");
        Label lblPrecioCosto = new Label("Precio/Costo:");
        Label lblPrecioVenta= new Label ("Precio Venta:");
        Label lblCantidadAc= new Label ("Cantidad Actual");
        Label lblAgregar= new Label ("Agregar");
        Label lblMinimo= new Label ("Minimo");
        TextField ProductoTxt = new TextField();
        TextField PrecioCostoTxt = new TextField();
        TextField PrecioVentaTxt = new TextField();
        TextField CantidadActualTxt = new TextField();
        TextField AgregarTxt = new TextField();
        TextField MinitmoTxt = new TextField();



        gridpane.add(lblProducto,1,1);
        gridpane.add(ProductoTxt,2,1);
        gridpane.add(lblPrecioCosto,1,4);
        gridpane.add(PrecioCostoTxt,2,4);

        gridpane.add(lblPrecioVenta,5,4);
        gridpane.add(PrecioVentaTxt,6,4);


        gridpane.add(lblCantidadAc,1,10);
        gridpane.add(CantidadActualTxt,2,10);
        gridpane.add(lblAgregar,3,10);
        gridpane.add(AgregarTxt,4,10);

        gridpane.add(lblMinimo,5,10);
        gridpane.add(MinitmoTxt,6,10);

        CerrarBtn.setOnAction( e-> window.close());
        RegresarBtn.setOnAction( e-> window.setScene(sceneInvetario));
        root2.getChildren().addAll(GuardarBtn,EliminarBtn,RegresarBtn,CerrarBtn);
        root.getChildren().addAll(gridpane,root2);

        return root;

    }
    public VBox CentroBuscar() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(0,0,0,0));
        gridpane.setHgap(5);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);


        TextField BuscarClienteTxt = new TextField ("");
        TextField BuscarMascotaTxt  = new TextField ("");
        Button AgregarClienteBtn = new Button("Agregar Cliente");
        Button AgregarMascotaBtn = new Button("Agregar Mascota");
        Button BuscarClienteBtn = new Button("Buscar Cliente");
        Button BuscarMascotaBtn = new Button("Buscar Mascota");
        Button AccederBtn = new Button("Acceder");
        Button CerrarBtn = new Button("Cerrar");
        Button CitaMBtn =new Button( "Cita Medica");
        Button CitaEBtn = new Button( "Cita Estetica");


        Label lblBienvenida = new Label("Busca o agrega un Cliente o Mascota");
        Label lblCliente = new Label("Cliente:");
        Label lblMascota = new Label("Mascota:");


        gridpane.add(lblCliente,14,15);
        gridpane.add(BuscarClienteTxt,15,15);
        gridpane.add(BuscarClienteBtn,16,15);
        gridpane.add(AgregarClienteBtn,17,15);

        gridpane.add(lblMascota,14,16);
        gridpane.add(BuscarMascotaTxt,15,16);
        gridpane.add(BuscarMascotaBtn,16,16);
        gridpane.add(AgregarMascotaBtn,17,16);
        gridpane.add(CitaMBtn,16,18);
        gridpane.add(CitaEBtn,17,18);

        AgregarMascotaBtn.setOnAction( e-> window.setScene(sceneAMascota));
        AgregarClienteBtn.setOnAction( e-> window.setScene(sceneACliente));
        CerrarBtn.setOnAction( e-> window.close());
        AccederBtn.setOnAction( e-> window.setScene(scene));
        CitaMBtn.setOnAction( e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction( e -> window.setScene(sceneCitaE));







        //   root2.getChildren().addAll(AccederBtn,CerrarBtn);
        root.getChildren().addAll( lblBienvenida,gridpane,root2);


        return root;

    }
    public VBox CentroLogin() {

        VBox root = new VBox(5);
        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);

        HBox root2 = new HBox(10);
        root2.setPadding(new Insets(0,0,0,30));
        root2.setAlignment(Pos.CENTER);

        DropShadow sombra= new DropShadow();
        sombra.setOffsetX(6.0f);
        sombra.setOffsetY(5.0f);
        sombra.setColor(Color.rgb(10,10,10,1));


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

   lblPrueba.setEffect(sombra);
       lblBienvenida.setEffect(sombra);

        // gridpane.add(lblBienvenida,1,0);
        gridpane.add(lblUsuario,15,15);
        gridpane.add(UsuarioTxt,16,15);
        gridpane.add(lblContraseña,15,16);
        gridpane.add(ContraseñaTxt,16,16);
        gridpane.add(AccederBtn,15,17);
        gridpane.add(CerrarBtn,16,17);


        CerrarBtn.setOnAction( e->window.close());

        AccederBtn.setOnAction( e-> window.setScene(scene));

        root2.getChildren().addAll(AccederBtn,CerrarBtn);
        root.getChildren().addAll(lblBienvenida,lblPrueba, gridpane,root2);


        return root;

    }
    public  HBox BtnAbajoAgendarCita() {

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
    public HBox BotonesArribaPrincipal () {
        HBox root = new HBox(5);
        root.setPadding(new Insets(5,0,0,0));
        root.setAlignment(Pos.TOP_CENTER);

        DropShadow sombra= new DropShadow();
        sombra.setOffsetX(2.5f);
        sombra.setOffsetY(2.5f);
        sombra.setColor(Color.rgb(10,10,30,0.2));


        Button CitaBtn = new Button("MOSTRAR CITA");
        Button ACitaBtn = new Button("AGENDAR CITA");
        Button InvBtn = new Button("INVENTARIO");
        Button ProvBtn = new Button("PROVEEDORES");
        Button MasBtn = new Button( "+");
       CitaBtn.setEffect(sombra);
        InvBtn.setEffect(sombra);
        ProvBtn.setEffect(sombra);
        MasBtn.setEffect(sombra);
        ACitaBtn.setEffect(sombra);

        root.getChildren().addAll(CitaBtn, ACitaBtn, InvBtn, ProvBtn,MasBtn);
        ACitaBtn.setOnAction( e -> window.setScene (sceneBuscar));
        CitaBtn.setOnAction( e-> window.setScene(scene));
        InvBtn.setOnAction(e->window.setScene(sceneInvetario));
        ProvBtn.setOnAction(e->window.setScene(sceneProveedores));


        return root;
    }
    public VBox DatosMascota() {

        VBox root = new VBox(25);
        HBox root2 = new HBox (5);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(1));
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        root.setPadding(new Insets(0,0,40,250));
        root.setAlignment(Pos.TOP_CENTER);


        Button GuardarMascotaBtn= new Button( "Guardar Mascota");
        Button CitaMBtn =new Button( "Cita Medica");
        Button CitaEBtn = new Button( "Cita Estetica");
        Button AtrasBtn= new Button( "Atras");


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

        /*
        ObservableList<String> caninos =
                FXCollections.observableArrayList(
                        "Chihuaha",
                        "SALCHICHA"
                );

        ObservableList<String> gatuno =
                FXCollections.observableArrayList(
                        "Persa",
                        "Rashado"
                );
                */
        ObservableList<String> especie =
                FXCollections.observableArrayList(
                        "Canino",
                        "Gatos"
                );
        ChoiceBox ComboEspecie =new ChoiceBox();

        ComboBox ComboRaza = new ComboBox();
        ComboEspecie.getItems().addAll(especie);

        ComboEspecie.setValue("-");
        ComboEspecie.getSelectionModel().selectedItemProperty().addListener((v,OldValue,newValue) -> cambiarDatoCombo(ComboEspecie,ComboRaza));



        gridpane.add(lblTitulo,1,20);

        gridpane.add(lblIDCLIENTE,0,29);
        gridpane.add(IDCLIENTETxt,1,29);

        gridpane.add(lblNombre,0,30);
        gridpane.add(NombreTxt,1,30);

        gridpane.add(lblEspecie,0,31);
        gridpane.add(ComboEspecie,1,31);

        gridpane.add(lblRaza,0,32);
        gridpane.add(ComboRaza,1,32);

        gridpane.add(lblSexo,0,33);
        gridpane.add(ComboHM,1,33);

        gridpane.add(lblEdad,0,34);
        gridpane.add(EdadTxt,1,34);


        CitaMBtn.setOnAction( e -> window.setScene(sceneCitaM));
        CitaEBtn.setOnAction( e -> window.setScene(sceneCitaE));
        GuardarMascotaBtn.setOnAction(e -> funcion.DatosMascota(IDCLIENTETxt,NombreTxt,ComboEspecie,ComboRaza,ComboHM,EdadTxt));
        AtrasBtn.setOnAction( e -> window.setScene(sceneBuscar));
        root2.getChildren().addAll(GuardarMascotaBtn,CitaMBtn,CitaEBtn,AtrasBtn);
        root.getChildren().addAll(gridpane,root2);
        return root;
    }
    public void cambiarDatoCombo(ChoiceBox ComboEspecie, ComboBox ComboRaza) {
        

        if (ComboEspecie.getValue().toString() == "Canino") {
            ObservableList<String> caninos =
                    FXCollections.observableArrayList(
                            "Chihuaha",
                            "SALCHICHA"
                    );


            ComboRaza.setItems(caninos);

        }//if

        if(ComboEspecie.getValue().toString() == "Gatos"){
            ObservableList<String> gatuno =
                    FXCollections.observableArrayList(
                            "Persa",
                            "Rashado"
                    );
            ComboRaza.setItems(gatuno);

        }//if

    }//CambiarDatoCombo
    public HBox CitaEstetica() {

        HBox root = new HBox(5);

        root.setPadding(new Insets(0,0,0,0));
        root.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);


        Button GuardarCitaBtn= new Button( "Guardar Cita");
        Button AtrasBtn= new Button( "Atras");
       AtrasBtn.setOnAction( e -> window.setScene(sceneBuscar));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "C",
                        "M",
                        "G"
                );
        ComboBox ComboTam =new ComboBox();
        ComboTam.getItems().addAll("C", "M","G");
        ComboTam.setValue("-");

        Label lblFecha = new Label("Fecha:");
        Label lblTamaño =new Label("Tamaño Mascota");
        Label lblDes=new Label("Descripcion:");
        Label lblPrecio=new Label("Precio:");

        TextField FechaTxt = new TextField();
        TextField TamañoTxt = new TextField();
        TextField DesTxt = new TextField();
        TextField PrecioTxt = new TextField();

        gridpane.add(lblFecha,0,30);
        gridpane.add(FechaTxt,1,30);

        gridpane.add(lblTamaño,0,31);
        gridpane.add(ComboTam,1,31);

        gridpane.add(lblDes,0,32);
        gridpane.add(DesTxt,1,32);
        gridpane.add(lblPrecio,0,33);
        gridpane.add(PrecioTxt,1,33);





        gridpane.add(GuardarCitaBtn,1,40);

        gridpane.add(AtrasBtn,2,40);

       GuardarCitaBtn.setOnAction(e -> validar.CampoVacioCitaEstetica(FechaTxt,ComboTam,DesTxt,PrecioTxt));




        root.getChildren().addAll(gridpane);
        return root;
    }
    public  VBox CentroCM() {



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
       Anor1Rbtn.setOnAction(e->funcion.cambiarModo(Anor1Rbtn,textArea1));
        Anor2Rbtn.setOnAction(e->funcion.cambiarModo(Anor2Rbtn,textArea2));
        Anor3Rbtn.setOnAction(e->funcion.cambiarModo(Anor3Rbtn,textArea3));
        Anor4Rbtn.setOnAction(e->funcion.cambiarModo(Anor4Rbtn,textArea4));
        Anor5Rbtn.setOnAction(e->funcion.cambiarModo(Anor5Rbtn,textArea5));
        Anor6Rbtn.setOnAction(e->funcion.cambiarModo(Anor6Rbtn,textArea6));
        Anor7Rbtn.setOnAction(e->funcion.cambiarModo(Anor7Rbtn,textArea7));
        Anor8Rbtn.setOnAction(e->funcion.cambiarModo(Anor8Rbtn,textArea8));
        Anor9Rbtn.setOnAction(e->funcion.cambiarModo(Anor9Rbtn,textArea9));
        Anor10Rbtn.setOnAction(e->funcion.cambiarModo(Anor10Rbtn,textArea10));
        Anor11Rbtn.setOnAction(e->funcion.cambiarModo(Anor11Rbtn,textArea11));
        Anor12Rbtn.setOnAction(e->funcion.cambiarModo(Anor12Rbtn,textArea12));



        root.getChildren().addAll(hBox,gridpane,hBox2);
        java.util.Date fecha = new java.util.Date();
        long fechasistema = fecha.getTime();
        java.sql.Date fechasql2 = new java.sql.Date(fechasistema);
        String fechasql  = fechasql2.toString();
        FechaTxt.setText(fechasql);
        TextField PrecioTxt = new TextField();
        TextField DescripcionTxt = new TextField();


        ;

        /*GuardarBtn.setOnAction(event -> funcion.eventoguardarcitaA(FechaTxt, TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn, textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn, Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7, Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn, textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12, textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, txtIDMASCOTA, txtIDADEUDO));*/
        GuardarBtn.addEventHandler(ActionEvent.ACTION ,(e) -> funcion.eventoguardarcitaA(FechaTxt, TemperaturaTxt, PesoTxt, Nor1Rbtn, Anor1Rbtn, textArea1, Nor2Rbtn, Anor2Rbtn, textArea2, Nor3Rbtn, Anor3Rbtn, textArea3, Nor4Rbtn, Anor4Rbtn, textArea4, Nor5Rbtn, Anor5Rbtn, textArea5, Nor6Rbtn, Anor6Rbtn, textArea6, Nor7Rbtn, Anor7Rbtn, textArea7, Nor8Rbtn, Anor8Rbtn, textArea8, Nor9Rbtn, Anor9Rbtn, textArea9, Nor10Rbtn, Anor10Rbtn, textArea10, Nor11Rbtn, Anor11Rbtn, textArea11, Nor12Rbtn, Anor12Rbtn, textArea12, textAreaPlanesD, textAreaProb, textAreaPlanesT, textAreaInstrucciones, txtIDMASCOTA, txtIDADEUDO));
        GuardarBtn.addEventHandler(ActionEvent.ACTION ,(e) -> validar.popUp2(PrecioTxt,DescripcionTxt));


      /*  GuardarBtn.setOnAction(event -> funcion.eventoguardarcitaA(textArea1,textArea2,textArea3,textArea4,textArea5,textArea7,textArea8,textArea9,textArea10,textArea11,textArea12,
                textAreaProb,textAreaPlanesT,textAreaInstrucciones,txtIDMASCOTA,txtIDADEUDO));*/



        /*GuardarBtn.setOnAction(e->validar.popUp2(PrecioTxt,DescripcionTxt));*/







        return  root;
    }
}

