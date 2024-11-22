package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Image image =new Image("Gui oop");
        //ImageView imageView= new ImageView();
        BorderPane borderPane=new BorderPane();
        Label imagetop=new Label("");
        VBox top=new VBox();
        imagetop.setStyle("-fx-border-color:black;-fx-min-width:500px;-fx-min-height:100px;");
        top.getChildren().add(imagetop);
        borderPane.setTop(imagetop);
        Image Banner=new Image("file:C:/Users/Dell/OneDrive/画像/Screenshots 1/gui.png");
        ImageView viewbanner= new ImageView(Banner);
       // viewbanner.setFitWidth(200);
       //viewbanner.setFitHeight(100);
       //viewbanner.setPreserveRatio(true);
        imagetop.setGraphic(viewbanner);

        //top.getChildren().add(imagetop);


        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Button saveButton=new Button("Save");
        HBox button=new HBox();
        button.getChildren().addAll(saveButton);
        button.setAlignment(Pos.BASELINE_CENTER);
gridPane.add(button,3,8);


        Label Namelabel=new Label("Name");
        gridPane.add(Namelabel,0,1);
        TextField Name=new TextField();
        gridPane.add(Name,1,1);
        Label FatherNamelabel=new Label("Father name");
        gridPane.add(FatherNamelabel,0,2);
        TextField FAtherName=new TextField();
        gridPane.add(FAtherName,1,2);
        //gridPane.add(saveButton,0,10);
        Label CNIC=new Label("CNIC");
        gridPane.add(CNIC,0,3);
        TextField cnic=new TextField();
        gridPane.add(cnic,1,3);
        DatePicker dob =new DatePicker();
        Label DOB=new Label("Date of birth");
        gridPane.add(DOB,0,4);
        gridPane.add(dob,1,4);
        Label Gender=new Label("Gender");
        RadioButton Male=new RadioButton("Male");
        RadioButton Female=new RadioButton("Female");
        ToggleGroup Togglebutton=new ToggleGroup();
        Male.setToggleGroup(Togglebutton);
        Female.setToggleGroup(Togglebutton);
        HBox genderbox=new HBox(Male,Female);
        gridPane.add(genderbox,1,5);
        gridPane.add(Gender,0,5);
Label combobox=new Label("ComboBox");
        gridPane.add(combobox,0,6);
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Multan", "Karachi");
        gridPane.add(cityComboBox, 1, 6);

     VBox rightside=new VBox(10);
     rightside.setPadding( new Insets(20));
        Label image=new Label("");
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Open resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Button chose= new Button("File chooser");
        chose.setOnAction(e->{
            File fileselector= fileChooser.showOpenDialog(stage);
            //File savefile=fileChooser.showSaveDialog(stage);
            if (fileselector != null) {
                Image image1 = new Image(fileselector.toURI().toString());
                ImageView imageView = new ImageView(image1);
                imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);
                image.setGraphic(imageView);

                System.out.println("File selected: " + fileselector.getAbsolutePath());
            } else {

                System.out.println("No file selected");
            }
        });

image.setStyle("-fx-border-color:black;-fx-min-width:100px;-fx-min-height:100px;");
rightside.getChildren().add(image);


        rightside.getChildren().add(chose);


      borderPane.setCenter(gridPane);
      borderPane.setRight(rightside);
        ArrayList<String> userDataList=new ArrayList<>();
        saveButton.setOnAction(e -> {
            // Collect data from the form
            String name = Name.getText();
            String fatherName = FAtherName.getText();
            String userCnic = cnic.getText();
            String dateOfBirth = dob.getValue() != null ? dob.getValue().toString() : "Not selected";
            String gender = Male.isSelected() ? "Male" : Female.isSelected() ? "Female" : "Not selected";
            String city = cityComboBox.getValue() != null ? cityComboBox.getValue() : "Not selected";


            userDataList.add("Name: " + name);
            userDataList.add("Father's Name: " + fatherName);
            userDataList.add("CNIC: " + userCnic);
            userDataList.add("Date of Birth: " + dateOfBirth);
            userDataList.add("Gender: " + gender);
            userDataList.add("City: " + city);


            System.out.println("Data saved:");
            for (String data : userDataList) {
                System.out.println(data);
            }

            // Optionally, you can clear the form after saving
            Name.clear();
            FAtherName.clear();
            cnic.clear();
            dob.setValue(null);
            Male.setSelected(false);
            Female.setSelected(false);
            cityComboBox.getSelectionModel().clearSelection();
        });


        Scene scene = new Scene(borderPane, 500, 400);

        stage.setTitle("Data Entry Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}