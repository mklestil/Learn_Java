package at.mklestil.tableviewexample;

import at.mklestil.tableviewexample.control.MyController;
import at.mklestil.tableviewexample.view.MyView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MyView view = new MyView();
        MyController controller = new MyController(view);
        Scene scene = new Scene(view.getRoot(), 550, 450);
        stage.setTitle("TableView Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}