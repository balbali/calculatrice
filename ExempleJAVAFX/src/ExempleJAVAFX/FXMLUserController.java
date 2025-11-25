package ExempleJAVAFX;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLUserController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private TableView<DetailsUtilisateur> tableUser;
    
    @FXML
    private TableColumn<DetailsUtilisateur, String> columnName;
    
    @FXML
    private TableColumn<DetailsUtilisateur, String> columnEmail;
    
    @FXML
    private TableColumn<DetailsUtilisateur, String> columnDepartment;
    
    @FXML
    private Button btnLoad;
    
    private ObservableList<DetailsUtilisateur> data;
    private DbConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DbConnection();
        
        // Configuration des colonnes
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM user_info");
            
            while (rs.next()) {
                data.add(new DetailsUtilisateur(
                    rs.getString("name"),
                    rs.getString("email"), 
                    rs.getString("department")
                ));
            }
            
            tableUser.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLUserController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erreur: " + ex.getMessage());
        }
    }
}