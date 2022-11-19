package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.ResultSet;


public class SellerPageController {
    @FXML
    TextField name;
    @FXML
    TextField price;
    @FXML
    TextField email;

    public void add(MouseEvent event){
        try{
            ResultSet rs = Main.connect.executeQuery("Select max(productId) from product");
            int productId = 0;
            if(rs.next())
                productId = rs.getInt("max(productId)") + 1;
            String query = String.format("Insert Into product values(%s,'%s','%s','%s')",productId,email.getText(), name.getText(),price.getText());
            int response = Main.connect.executeUpdate(query);
            System.out.println(response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
