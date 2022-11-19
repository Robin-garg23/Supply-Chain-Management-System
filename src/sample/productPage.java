package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;

public class productPage {
    ListView<HBox> products;

    AnchorPane showProducts() throws Exception{
        ObservableList<HBox> productsList = FXCollections.observableArrayList();
        AnchorPane pane = new AnchorPane();

        products = new ListView<>();
        ResultSet rs = Main.connect.executeQuery("Select * from product");
        while(rs.next())
        {
            Label name = new Label();
            Label price = new Label();
            Label productID = new Label();
            name.setMinWidth(100);
            price.setMinWidth(100);
            productID.setMinWidth(50);
            HBox productDetails = new HBox();
            Button buyButton = new Button();
            buyButton.setText("Buy");
            buyButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    order place = new order();
                    place.placeOrder(productID.getText());
                }
            });
            productID.setText(""+rs.getInt("productID"));
            name.setText(rs.getString("productName"));
            price.setText(""+rs.getString("price"));
            productDetails.getChildren().addAll(productID,name,price,buyButton);
            productsList.add(productDetails);
        }
        products.setItems(productsList);
        products.prefWidth(500);
        products.maxHeight(500);
        pane.getChildren().add(products);
        pane.minWidth(500);
        pane.prefWidth(500);
        pane.setLayoutX(100);
        pane.setLayoutY(100);
        return pane;
    }
}
