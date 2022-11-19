package sample;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class order {

    void placeOrder(String productId)
    {
        if(Main.emailId.equals(""))
        {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Login");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Login First to Place Order!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else
        {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Order");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your Order is Placed!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
    }
}
