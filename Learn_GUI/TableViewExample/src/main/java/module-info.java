module at.mklestil.tableviewexample {
    requires javafx.controls;
    requires javafx.fxml;
    opens at.mklestil.tableviewexample.model to javafx.base;

    opens at.mklestil.tableviewexample to javafx.fxml;
    exports at.mklestil.tableviewexample;


}