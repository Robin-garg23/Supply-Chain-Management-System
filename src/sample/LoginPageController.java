package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;

public class LoginPageController {
    @FXML
    TextField email;
    @FXML
    PasswordField password;

    @FXML
    public void login(MouseEvent event) throws IOException {
        try {
            String query = String.format("Select * from User where emailId = '%s' AND pass = '%s'", email.getText(), password.getText());
            ResultSet rs = Main.connect.executeQuery(query);
            String userType;
            if (rs.next()) {
                System.out.println("sdfv");
                Main.emailId = rs.getString("emailId");
                userType = rs.getString("userType");
                if(userType.equals("Seller"))
                {
                    AnchorPane role = FXMLLoader.load(getClass().getResource("SellerPage.fxml"));
                    Main.root.getChildren().clear();
                    Main.root.getChildren().add(role);
                }
                else{
                    header Header = new header();
                    productPage page = new productPage();
                    AnchorPane products = page.showProducts();
                    Main.root.getChildren().clear();
                    Main.root.getChildren().addAll(Header.root,products);
                }
            }else{
                Dialog<String> dialog = new Dialog<String>();
                dialog.setTitle("Login Failed");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Login Attempt has failed, please try again!");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
