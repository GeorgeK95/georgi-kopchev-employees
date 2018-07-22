package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.app.EmployeesApp;
import sample.model.Couple;
import sample.model.Person;
import sample.service.WorkProcessService;
import sample.service.api.IWorkProcessService;

import java.io.File;

import static sample.util.Constants.ZERO;

public class Main extends Application {

    public static final String TEXT_FILES = "Text Files";
    public static final String TXT = "*.txt";
    public static final String EMPLOYEES_APP_NAME = "Employees App";
    public static final String ADDRESS_BOOK = "Address Book";
    public static final Font ARIAL = new Font("Arial", 20);
    public static final String EMPLOYEE_ID_1 = "Employee ID #1";
    public static final String FIRST_EMPLOYEE_ID = "firstEmployeeId";
    public static final String EMPLOYEE_ID_2 = "Employee ID #2";
    public static final String SECOND_EMPLOYEE_ID = "secondEmployeeId";
    public static final String PROJECT_ID_BIG = "Project ID";
    public static final String PROJECT_ID_SMALL = "projectId";
    public static final String DAYS_WORKED = "daysWorked";
    public static final String SELECT_FILE = "Select File";
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int MIN_WIDTH = 100;
    public static final int MIN_WIDTH_2 = 200;
    public static final int SPACING = 5;
    public static final int TOP = 10;
    public static final int LEFT = 10;
    private TableView table;
    private IWorkProcessService service;

    private EmployeesApp employeesApp;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.initializeDependencies();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(TEXT_FILES, TXT)
        );

        primaryStage.setTitle(EMPLOYEES_APP_NAME);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        final Label label = new Label(ADDRESS_BOOK);
        label.setFont(ARIAL);

        TableColumn firstEmployeeIdCol = new TableColumn(EMPLOYEE_ID_1);
        firstEmployeeIdCol.setMinWidth(MIN_WIDTH);
        firstEmployeeIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(FIRST_EMPLOYEE_ID));

        TableColumn secondEmployeeIdCol = new TableColumn(EMPLOYEE_ID_2);
        secondEmployeeIdCol.setMinWidth(MIN_WIDTH);
        secondEmployeeIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(SECOND_EMPLOYEE_ID));

        TableColumn projectIdCol = new TableColumn(PROJECT_ID_BIG);
        projectIdCol.setMinWidth(MIN_WIDTH_2);
        projectIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(PROJECT_ID_SMALL));

        TableColumn daysWorked = new TableColumn(DAYS_WORKED);
        projectIdCol.setMinWidth(MIN_WIDTH_2);
        projectIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(DAYS_WORKED));

        table.getColumns().addAll(firstEmployeeIdCol, secondEmployeeIdCol, projectIdCol, daysWorked);

        Button button = new Button(SELECT_FILE);
        button.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                String pesho1 = "Pesho";
                String pesho2 = "Peshov";
                String email = "pesho@abv.bg";

                ObservableList<Couple> data = FXCollections.observableArrayList(employeesApp.findLongestWorkingCouple());

                table.setItems(data);
            }
        });

        final VBox vbox = new VBox(button);
        vbox.setSpacing(SPACING);
        vbox.setPadding(new Insets(TOP, ZERO, ZERO, LEFT));
        vbox.getChildren().addAll(label, table);

        Scene scene = new Scene(new Group());

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDependencies() {
        this.service = new WorkProcessService();
        this.employeesApp = new EmployeesApp(service);
        table = new TableView();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
