package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class Main extends Application {
    public static DatabaseConnection connect;
    public static Group root;
    public static String emailId;

    @Override
    public void start(Stage primaryStage) throws Exception{
        emailId = "";
        connect = new DatabaseConnection();
        root = new Group();
        header head = new header();
        productPage products = new productPage();
        AnchorPane productPane = products.showProducts();
        root.getChildren().addAll(head.root,productPane);
        primaryStage.setTitle("SupplyChain");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->{
            try {
                connect.con.close();
            }
            catch (Exception x)
            {
                x.printStackTrace();
            }
            System.out.println("Exited");
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}
