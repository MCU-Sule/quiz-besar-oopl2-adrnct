package com.quiz2pbo_1972008;

import com.quiz2pbo_1972008.DAO.AnggotaDao;
import com.quiz2pbo_1972008.DAO.BukuDao;
import com.quiz2pbo_1972008.DAO.PeminjamanDao;
import com.quiz2pbo_1972008.Model.AnggotaEntity;
import com.quiz2pbo_1972008.Model.BukuEntity;
import com.quiz2pbo_1972008.Model.PeminjamanEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class mainViewController implements Initializable {
    @FXML
    private ComboBox<BukuEntity> comboBook;
    @FXML
    private ComboBox<AnggotaEntity> comboMember;
    @FXML
    private TableView<PeminjamanEntity> tablePinjam;
    @FXML
    private TableColumn<PeminjamanEntity, String> col1;
    @FXML
    private TableColumn<PeminjamanEntity, String> col2;
    @FXML
    private TableColumn<PeminjamanEntity, String> col3;
    @FXML
    private TableColumn<PeminjamanEntity, String> col4;
    @FXML
    private TableColumn<PeminjamanEntity, String> col5;
    @FXML
    private TextField txtId;
    @FXML
    private DatePicker txtBorrow;
    @FXML
    private DatePicker txtReturn;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnReset;
//    private bookController controllerBook;
//    private memberController contollerMember;
//    private PeminjamanDao peminjamanDao =new PeminjamanDao();
//    private ObservableList<PeminjamanEntity> peminjamans;

    private BukuDao bukuDao= new BukuDao();
    private ObservableList<PeminjamanEntity> peminjamans;
    private ObservableList<BukuEntity> bukus= (ObservableList<BukuEntity>) bukuDao.showData();
    private bookController controllerBook;
    private memberController controllerMember;
    private PeminjamanDao peminjamanDao;

    private AnggotaDao anggotaDao= new AnggotaDao();
    private ObservableList<AnggotaEntity> anggotas= (ObservableList<AnggotaEntity>) anggotaDao.showData();

    public ObservableList<BukuEntity> getBukus(){
        return bukus;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        comboBook.setItems(bukus);
        comboMember.setItems(anggotas);
        peminjamans = (ObservableList<PeminjamanEntity>) peminjamanDao.showData();
        tablePinjam.setItems(peminjamans);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getAnggotaByAnggotaId().toString()));
        col3.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getBukuByBukuId().toString()));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPinjam())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPengembalian())));
    }


    public void showMemberManagement(ActionEvent actionEvent) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberManagement.fxml"));
        Parent root = loader.load();
        memberController membercontroller = loader.getController();
        membercontroller.setController(this);

        stage.initModality(Modality.WINDOW_MODAL);
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Show Member");
        stage.show();
    }

    public void showBookManagement(ActionEvent actionEvent) {
    }

    public void savePressed(ActionEvent actionEvent) {
        if (txtId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setContentText("Mohon isi Semua Data");
            alert.showAndWait();
        }else {
            PeminjamanEntity peminjamanEntity = new PeminjamanEntity();
            peminjamanEntity.setId(Integer.parseInt(txtId.getText()));
            peminjamanEntity.setTanggalPinjam(Date.valueOf(txtBorrow.getValue()));
            peminjamanEntity.setTanggalPengembalian(Date.valueOf(txtReturn.getValue()));
            peminjamanEntity.setAnggotaByAnggotaId(comboMember.getValue());
            peminjamanEntity.setBukuByBukuId(comboBook.getValue());

            PeminjamanDao pDao = new PeminjamanDao();
            pDao.addData(peminjamanEntity);
            peminjamans.clear();
            peminjamans.addAll(pDao.showData());
            tablePinjam.refresh();
        }
    }

    public void updatePressed(ActionEvent actionEvent) {
        PeminjamanEntity selected;
        selected = tablePinjam.getSelectionModel().getSelectedItem();

        selected.setTanggalPinjam(Date.valueOf(txtBorrow.getValue()));
        selected.setTanggalPengembalian(Date.valueOf(txtReturn.getValue()));
        selected.setAnggotaByAnggotaId(comboMember.getValue());
        selected.setBukuByBukuId(comboBook.getValue());

        PeminjamanDao peminjamanDao  =new PeminjamanDao();
        peminjamanDao.updateData(selected);

        ObservableList<PeminjamanEntity> pList = (ObservableList<PeminjamanEntity>) peminjamanDao.showData();
        tablePinjam.setItems(pList);
        tablePinjam.refresh();
    }

    public void deletePressed(ActionEvent actionEvent) {
        PeminjamanEntity selected;
        selected = tablePinjam.getSelectionModel().getSelectedItem();
        PeminjamanDao pDao = new PeminjamanDao();
        pDao.delData(selected);
        ObservableList<PeminjamanEntity> iList = (ObservableList<PeminjamanEntity>) pDao.showData();
        tablePinjam.setItems(iList);
    }

    public void resetPressed(ActionEvent actionEvent) {
        txtId.setText("");

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        txtId.setDisable(false);
        btnSave.setDisable(false );
    }
}
