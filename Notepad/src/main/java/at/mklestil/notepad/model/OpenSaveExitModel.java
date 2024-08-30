package at.mklestil.notepad.model;

import at.mklestil.notepad.view.MainWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpenSaveExitModel {
    public OpenSaveExitModel(Menu menu, MainWindow view) {
        ArrayList<MenuItem> menu1 = new ArrayList<MenuItem>(menu.getItems());

        //Open
        menu1.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //open fileChooser
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(view.getRoot().getScene().getWindow());
                view.getTextArea().setText("Test Open");
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(selectedFile));

                    /*The loop reads the file line by line
                    and appends each read line to the StringBuilder
                    */
                    String line;
                    StringBuilder content = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    // show in textarea
                    view.getTextArea().setText(content.toString());
                } catch (Exception e) {

                } finally {
                    //close BufferedReader
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        //Exit
        menu1.getLast().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               //Exit
                Platform.exit();
            }
        });

    }
}
