
import javafx.application.Application;

import javafx.stage.Stage;



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