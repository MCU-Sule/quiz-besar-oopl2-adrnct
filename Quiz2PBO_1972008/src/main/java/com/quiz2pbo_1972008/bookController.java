package com.quiz2pbo_1972008;

import com.quiz2pbo_1972008.DAO.BukuDao;
import com.quiz2pbo_1972008.DAO.PeminjamanDao;
import com.quiz2pbo_1972008.Model.BukuEntity;
import com.quiz2pbo_1972008.Model.PeminjamanEntity;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class bookController implements Initializable {
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtPublisher;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtType;
    @FXML
    private TableView<BukuEntity> tableView;
    private mainViewController controller;
    private ObservableList<BukuEntity> bukus;
    private BukuDao bukuDao;
    public void setController(mainViewController mainViewController) {
        this.controller = mainViewController;
        tableView.setItems(controller.getBukus());

    }

    public void savePressed(ActionEvent actionEvent) {
        if (txtId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setContentText("Mohon isi Semua Data");
            alert.showAndWait();
        }else {
            BukuEntity bukuEntity = new BukuEntity();
            bukuEntity.setId(Integer.parseInt(txtId.getText()));
            bukuEntity.setJudul(txtTitle.getText());
            bukuEntity.setJenisBuku(txtType.getText());
            bukuEntity.setPengarang(txtAuthor.getText());
            bukuEntity.setPenerbit(txtPublisher.getText());
            bukuEntity.setTahunTerbit(txtYear.getText());

            BukuDao bDao = new BukuDao();
            bDao.addData(bukuEntity);
            bukus.clear();
            bukus.addAll(bDao.showData());
            tableView.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
