package at.mklestil.widgetprogramicon.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MyView {
    private Group root = new Group();
    private ImageView imageViewDock;

    private final String[] icons = {"home.png", "browser.png", "ide.png", "mail.png", "textfile.png" };

    public MyView() {

        Image image = new Image(getClass().getResourceAsStream("/images/Dock.png"));
        //Dock
        imageViewDock = new ImageView(image);
        imageViewDock.setTranslateX(12);
        imageViewDock.setTranslateY(100);

        root.getChildren().add(imageViewDock);
    }

    public Group getRoot() {
        return root;
    }

    public ImageView getImageViewDock() {
        return imageViewDock;
    }
}
