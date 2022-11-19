package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;


public class HeaderController {
    @FXML
    TextField searchtext;

    @FXML
    Button loginbutton;

    @FXML
    Label mailid;

    @FXML
    public void initialize() {
        if(!Main.emailId.equals("")){
            loginbutton.setOpacity(0);
            mailid.setText(Main.emailId);
        }

        System.out.println("second");
    }
    @FXML
    public void search(MouseEvent event) throws IOException{

    }
    @FXML
    public void login(MouseEvent event) throws IOException{
        AnchorPane role = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(role);
    }
}
