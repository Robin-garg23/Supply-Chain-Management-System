package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class Main extends Application {
    public static DatabaseConnection connect;
    public static Group root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        connect = new DatabaseConnection();
        System.out.println(connect.executeQuery("Select * from Product"));
        ResultSet rs =  connect.executeQuery("Select * from Product");
        while(rs.next()){
            System.out.println(rs.getString("productname"));
//            rs.add(new Product(rs.getInt("pid"), rs.getString("name"), rs.getDouble("price")));
////                System.out.println(rs.getInt("pid") + " " +
////                        rs.getString("name") + " " +
////                        rs.getDouble("price")
////                );
        }
        rs.close();
        root = new Group();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("header.fxml")));
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
        productPage products = new productPage();
        products.showProducts();
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
