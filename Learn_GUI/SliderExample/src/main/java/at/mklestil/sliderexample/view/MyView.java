package at.mklestil.sliderexample.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyView {

    private GridPane root;
    private Slider opacitySlider;
    private Slider sepiaSlider;
    private Slider scaleSlider;
    private Label opacityValue;
    private Label sepiaValue;
    private Label scaleValue;

    public MyView() {
        root = new GridPane();

        //Image
        if(getClass().getResourceAsStream("/Images/image.png") != null){
            Image image = new Image(getClass().getResourceAsStream("/Images/image.png"));
            ImageView imageView = new ImageView(image);
            root.add(imageView, 0, 0);
        }

        root.add(getOpacityBox(), 0, 1);
        root.add(getSepiaBox(), 0, 2);
        root.add(getScaleBox(), 0, 3);

        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
    }

    public GridPane getRoot() {
        return root;
    }

    public HBox getOpacityBox(){
        HBox opacityBox = new HBox();

        Label opacityLabel = new Label("Opacity Level");
        opacitySlider = new Slider(0,1,1);
        opacityValue = new Label(Double.toString(opacitySlider.getValue()));
        opacityBox.getChildren().addAll(opacityLabel, opacitySlider, opacityValue);

        return  opacityBox;
    }

    public HBox getSepiaBox(){
        HBox sepiaBox = new HBox(5);

        Label sepiaLabel = new Label("Sepia Level");
        sepiaSlider = new Slider(0,1,1);
        sepiaValue = new Label(Double.toString(sepiaSlider.getValue()));
        sepiaBox.getChildren().addAll(sepiaLabel, sepiaSlider, sepiaValue);
        return  sepiaBox;
    }

    public HBox getScaleBox(){
        HBox scaleBox = new HBox(5);

        Label scaleLabel = new Label("Scaling Level");
        scaleSlider = new Slider(0,1,1);
        scaleValue = new Label(Double.toString(scaleSlider.getValue()));
        scaleBox.getChildren().addAll(scaleLabel, scaleSlider, scaleValue);
        return  scaleBox;
    }

    public Slider getOpacitySlider() {
        return opacitySlider;
    }

    public Slider getSepiaSlider() {
        return sepiaSlider;
    }

    public Slider getScaleSlider() {
        return scaleSlider;
    }

    public Label getOpacityValue() {
        return opacityValue;
    }

    public Label getSepiaValue() {
        return sepiaValue;
    }

    public Label getScaleValue() {
        return scaleValue;
    }
}
