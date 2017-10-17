/*
 * Application: Agenda Builder
 * Tier: Front-End GUI (Isolated)
 * Version: 0.2
 * Date: 10.17.2017
 *
 */

package agendabuildergui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sun
 */
public class AgendaBuilderGUI extends Application {
    
    BorderPane outerBorderPane;
    BorderPane innerBorderPane;
    GridPane contentGridPane;
    Members members;
    
    private static final String GUI_STYLE = "-fx-padding: 10;-fx-border-style: solid inside;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-radius: 5;";
    private static final String GUI_COLOR_BLACK = "-fx-border-color: black;";
    private static final String GUI_COLOR_BLUE = "-fx-border-color: blue;";
    private static final String GUI_COLOR_RED = "-fx-border-color: red;";
    
    public static final String MEETINGROLES [] = { "temp", "Toastmaster", "Speaker 1", "Speaker 2", "General Evaluator", "Evaluator 1", "Evaluator 2", 
                                     "Grammarian", "Timer", "Squawker", "UmCounter", "TT Master", "One Min TM", "Humor Master"};
  
    // PORT TO: Library Methods -> Refactor to ArrayList<Label>
    public Label [] createLabels() {
        Label [] labels = new Label[14];
        for (int x=0; x<14; x++)
            labels[x] = new Label(MEETINGROLES[x]);        
        return labels;
    }
        
    // Libary Method
    public ObservableList<String> getMemberSet() {
        return FXCollections.observableArrayList(members.getMemberList());
    }
  
    // Library Method
    public ComboBox createMemberSetSingleComboBox() {
        ComboBox memberVals = new ComboBox(getMemberSet());
        return memberVals;
    }
            
    @Override
    public void start(Stage primaryStage) {
/*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
*/
        members = new Members();
        
        innerBorderPane = new BorderPane();
        innerBorderPane.setStyle (GUI_STYLE+GUI_COLOR_BLUE);
        
        outerBorderPane = new BorderPane();
        
        contentGridPane = new GridPane();
        contentGridPane.setPadding(new Insets(10,10,10,10));
        contentGridPane.setStyle(GUI_STYLE+GUI_COLOR_RED);
        contentGridPane.setHgap(25);
        contentGridPane.setVgap(25);
        
        Label [] newLabelArray = createLabels();
        
        int meetCount = 5;
        
        ComboBox tempBox;
        String lblWeek = "Week ";
       
        for (int row=0; row<14; ++row) {
            for (int col=0; col<=meetCount; ++col) {                
                if (row==0 && col==0) { continue; }
                else if (row==0 && col>0) { 
                    lblWeek = "Week " + col;
                    contentGridPane.add(new Label(lblWeek), col, row);
                }
                else {
                    switch (col) {
                        case 0:
                            contentGridPane.add(newLabelArray[row], col, row);
                            break;
                        case 1:
                            tempBox = createMemberSetSingleComboBox();
                            tempBox.getSelectionModel().select(row);
                            contentGridPane.add(tempBox, col, row);
                            break;
                        case 2:
                            tempBox = createMemberSetSingleComboBox();
                            tempBox.getSelectionModel().select(row);
                            contentGridPane.add(tempBox, col, row);
                            break;
                        case 3:
                            tempBox = createMemberSetSingleComboBox();
                            tempBox.getSelectionModel().select(row);
                            contentGridPane.add(tempBox, col, row);
                            break;
                        case 4:
                            tempBox = createMemberSetSingleComboBox();
                            tempBox.getSelectionModel().select(row);
                            contentGridPane.add(tempBox, col, row);
                            break;
                        case 5:
                            tempBox = createMemberSetSingleComboBox();
                            tempBox.getSelectionModel().select(row);
                            contentGridPane.add(tempBox, col, row);
                            break;
                        default:
                            break;
                    }
                }        
            }
        }
           
        HBox outerTopHorizBox = new HBox();
        outerTopHorizBox.setSpacing(10);
        outerTopHorizBox.setStyle (GUI_STYLE+GUI_COLOR_BLACK);
        outerTopHorizBox.getChildren().addAll(new Label("TM Monthly Agenda Builder - Outer Top HBox"));
        
        HBox outerBottomHorizBox = new HBox();
        outerBottomHorizBox.setSpacing(10);
        outerBottomHorizBox.setStyle (GUI_STYLE+GUI_COLOR_BLACK);
        outerBottomHorizBox.getChildren().addAll(new Label("Outer Bottom HBox"));
        
        HBox innerTopHorizBox = new HBox();
        innerTopHorizBox.setSpacing(10);
        innerTopHorizBox.setStyle(GUI_STYLE+GUI_COLOR_RED);
        innerTopHorizBox.getChildren().addAll(new Label("Inner Top HBox"));
        
        HBox innerBottomHorizBox = new HBox();
        innerBottomHorizBox.setSpacing(10);
        innerBottomHorizBox.setStyle(GUI_STYLE+GUI_COLOR_RED);
        innerBottomHorizBox.getChildren().addAll(new Label("Inner Bottom HBox"));
        
        VBox outerLeftVertBox = new VBox();
        outerLeftVertBox.setSpacing(10);
        outerLeftVertBox.setStyle(GUI_STYLE+GUI_COLOR_BLACK);
        outerLeftVertBox.getChildren().addAll(new Label("Outer Left VBox"));
        
        VBox outerRightVertBox = new VBox();
        outerRightVertBox.setSpacing(10);
        outerRightVertBox.setStyle(GUI_STYLE+GUI_COLOR_BLACK);
        outerRightVertBox.getChildren().addAll(new Label("Outer Right VBox"));
        
        VBox innerLeftVertBox = new VBox();
        innerLeftVertBox.setSpacing(10);
        innerLeftVertBox.setStyle(GUI_STYLE+GUI_COLOR_RED);
        innerLeftVertBox.getChildren().addAll(new Label("Inner Left VBox"));
        
        VBox innerRightVertBox = new VBox();
        innerRightVertBox.setSpacing(10);
        innerRightVertBox.setStyle(GUI_STYLE+GUI_COLOR_RED);
        innerRightVertBox.getChildren().addAll(new Label("Inner Right VBox"));
        
        
        innerBorderPane.setTop(innerTopHorizBox);
        innerBorderPane.setBottom(innerBottomHorizBox);
        innerBorderPane.setLeft(innerLeftVertBox);
        innerBorderPane.setRight(innerRightVertBox);
        // Pane Center Content
        innerBorderPane.setCenter(contentGridPane);
        
        outerBorderPane.setTop(outerTopHorizBox);
        outerBorderPane.setBottom(outerBottomHorizBox);
        outerBorderPane.setLeft(outerLeftVertBox);
        outerBorderPane.setRight(outerRightVertBox);
        // Pane Center Content
        outerBorderPane.setCenter(innerBorderPane);
        
        
        StackPane root = new StackPane();
        root.getChildren().add(outerBorderPane);
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 1200, 800);
        
        primaryStage.setTitle("Agenda Builder / Analyzer Application - v0.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

    // Library Method
    /*
    public TextField [] createTextFields() {
        TextField [] textFields = new TextField[14];
        for (int x=0; x<14; x++)
            textFields[x] = new TextField("TextField" + x);
        return textFields;
    }
    */
    
    // Library Method
    // may need to use ArrayList as issues with Array of ObservableList<String>
    /*
    public ObservableList<String> [] createMemberSets() {
        Object [] memberSets = new Object[14];
        for (int x=0; x<14; x++) {
            memberSets[x] = FXCollections.observableArrayList(members.getMemberList());
        }
        return (ObservableList<String>[]) memberSets;
    }
    */
    
    // Library Method
    /*
    public ComboBox [] createMemberSetComboBoxes() {
        ComboBox [] memberSetComboBoxes = new ComboBox[14];
        for (int x=0; x<14; x++) {
            memberSetComboBoxes[x] = new ComboBox (FXCollections.observableArrayList(members.getMemberList()));
        }
        return memberSetComboBoxes;
    }
    */
