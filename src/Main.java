
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



public class Main extends Application {

    Diseño diseño =new Diseño();
    @Override
    public void start(Stage stage) {
        System.out.println("start");
        diseño.initUI(stage);
    }




    public static void main(String[] args) {

        System.out.println("Main");
        launch(args);
    }
}