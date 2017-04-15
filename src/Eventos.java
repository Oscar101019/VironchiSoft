import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

/**
 * Created by juven on 13/4/2017.
 */
public class Eventos {

    public void Mensaje(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.Q)) {
                System.out.println("Prueba");
            }
        });
    }
    public void Cerrar(Stage stage) {
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.C)) {
                stage.close();
            }
        });
    }
    public void PantallaCompleta(Stage stage) {
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.F11)) {
                stage.setFullScreen(true);
            }
        });
    }
    public void foco (TextArea textArea1,TextArea textArea2,TextArea textArea3,TextArea textArea4) {
        textArea1.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.TAB)) {
              textArea2.requestFocus();
                System.out.println("1-");
            }
        });
        textArea2.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.TAB)) {
                textArea3.requestFocus();
                System.out.println("-2");
            }
        });
        textArea3.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.TAB)) {
                textArea4.requestFocus();
                System.out.println("3");
            }
        });
    }
    public void cambiar (Scene scene1,Scene scene2, Scene scene3,Scene scene4,Stage stage) {
        scene1.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.RIGHT)) {
                stage.setScene(scene2);
                System.out.println("cambio");
            }
        });
        scene2.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.RIGHT)) {
                stage.setScene(scene3);
                System.out.println("-25");
            }
        });
        scene3.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.RIGHT)) {
                stage.setScene(scene4);
                System.out.println("433");
            }
        });
        scene4.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                stage.setScene(scene3);
                System.out.println("343");
            }
        });
        scene3.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                stage.setScene(scene2);
                System.out.println("3");
            }
        });
        scene2.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                stage.setScene(scene1);
                System.out.println("23");
            }
        });
    }






}
