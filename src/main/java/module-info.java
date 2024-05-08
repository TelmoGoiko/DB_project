module ehu.eus.db_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens ehu.eus.db_project to javafx.fxml;
    exports ehu.eus.db_project;
}