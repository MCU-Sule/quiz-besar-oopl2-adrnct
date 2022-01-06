module com.quiz2pbo_1972008 {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires org.hibernate.orm.core;
//    requires java.naming;
//    requires javax.persistence;
//    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.quiz2pbo_1972008 to javafx.fxml;
    exports com.quiz2pbo_1972008;
}