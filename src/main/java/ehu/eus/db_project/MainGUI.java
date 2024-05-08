package ehu.eus.db_project;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


public class MainGUI {

    private Window mainWin;

    private Stage stage;
    private Scene scene;

    public Window getMainWindow() { return mainWin; }

    public class Window {
        Controller c;
        Parent ui;

        public Controller getController(){
            return c;
        }

    }

    public void showMain() {
        setupScene(mainWin.ui, "MainTitle", 1200, 700);
    }

    private void setupScene(Parent ui, String title, int width, int height) {
        if (scene == null) {
            scene = new Scene(ui, width, height);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
        }
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(ResourceBundle.getBundle("Etiquetas", Locale.getDefault()).getString(title));
        scene.setRoot(ui);
        stage.show();
    }

    public MainGUI getMainGUI(){
        return this;
    }

}
