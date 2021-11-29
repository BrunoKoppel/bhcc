package employeemanager;

/**Classes needed to build the Menu */
import javafx.collections.FXCollections;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.sql.*;


/**Classes needed to build the com box */
import javafx.scene.control.ComboBox;

/**Classes needed to build the table view */
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**Others */

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
 

public  class SearchPane extends BorderPane{
    
   protected final ObservableList<Employee> data =FXCollections.observableArrayList();
            
    /**Create a menu bar*/
    private MenuBar menuBar=new MenuBar();
    protected Menu mainMenu=new Menu("Main menu");
    protected MenuItem addEmployee=new MenuItem("Add Employee");
    protected MenuItem deleteEmployee=new MenuItem("Delete Employee");
    protected MenuItem updateEmployee=new MenuItem("Update Employee");
    protected MenuItem help=new MenuItem("Help");
    protected MenuItem exit =new MenuItem("Exit");
    
    /**List All button */
    
    protected Button listAllButton =new Button("List all employees in the System");
    
    /** Create a combo box*/
    protected ComboBox<String> comboBoxSearch=new ComboBox<>();
    
    
    /**Create a a search field */
    protected TextField searchField =new TextField();
    
    
    /**Create table view and table columns*/
    protected TableView <Employee>table =new TableView();
    protected TableColumn idCol=new TableColumn("Id");
    protected TableColumn firstNameCol =new TableColumn("First name");
    protected TableColumn lastNameCol=new TableColumn("Last name");
    protected TableColumn middleNameCol=new TableColumn("Middle name");
    protected TableColumn positionCol=new TableColumn("Position");
    protected TableColumn salaryCol=new TableColumn("Salary");
    
    /**Create title label */
    private Label searchLabel =new Label("Search");
    
    /**Create a VBox */
    private HBox searchBox=new HBox();
    private VBox vbox=new VBox();
    
    
    /**Default constructor  */
    public SearchPane()
    {
        
        /**Set the menu properties  */
        menuBar.setStyle("-fx-background-color:rgb(205,205,205);");
        mainMenu.setStyle("-fx-font-size:12;"+"-fx-font-family:calibri;");
        
        menuBar.getMenus().add(mainMenu);
        mainMenu.getItems().addAll(addEmployee,deleteEmployee,updateEmployee,help,exit);
        
        searchLabel.setStyle("-fx-text-fill:black;"+"-fx-font-family:Arial;"+"-fx-font-size:13;");
        
        
        /**Set the  table view properties */
        table.getColumns().addAll(idCol,firstNameCol,middleNameCol,lastNameCol,positionCol,salaryCol);
        firstNameCol.setMinWidth(100);
        lastNameCol.setMinWidth(100);
        middleNameCol.setMinWidth(100);
        positionCol.setMinWidth(100);
        salaryCol.setMinWidth(150);
        idCol.setMinWidth(50);
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                    middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        
        table.setItems(data);
       
        
        /**Set the search field properties */
        searchField.setStyle("-fx-background:yellow;");
        searchField.setPrefWidth(200);
        
        
        /**HBox properties */
        searchBox.setSpacing(10);
        searchBox.setPadding(new Insets(10,100,0,0));
        
        searchBox.getChildren().addAll(comboBoxSearch,searchField,listAllButton);
        
        
        /**Set combo box properties */
        comboBoxSearch.getItems().addAll("Id","First name","Middle name","Last name","Position","Salary");
        comboBoxSearch.setPrefWidth(150);
        comboBoxSearch.setValue("Id");
        
        
        /**HBox properties */
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(searchLabel,searchBox,table);
        
       
        
        /**Border pane*/
        setTop(menuBar);
        setCenter(vbox);
    
       
   }
    
    
    
}
