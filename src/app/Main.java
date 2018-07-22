package app;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import app.core.EmployeesApp;
import app.model.Couple;
import app.service.WorkProcessService;
import app.service.api.IWorkProcessService;

import java.io.File;

import static app.util.Constants.*;

public class Main extends Application {

    private IWorkProcessService service;

    private EmployeesApp employeesApp;

    private TableColumn firstEmployeeIdCol;
    private TableColumn secondEmployeeIdCol;
    private TableColumn projectIdCol;
    private TableColumn daysWorkedCol;
    private TableView table;
    private FileChooser fileChooser;

    @Override
    public void start(Stage primaryStage) {
        this.initializeDependencies();
        this.configurePrimaryStage(primaryStage);
        this.setTableColumns();

        this.setFileChooser();

        final Label label = new Label(ADDRESS_BOOK);
        label.setFont(ARIAL);

        Button button = new Button(SELECT_FILE);
        button.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                ObservableList<Couple> data = FXCollections.observableArrayList(employeesApp.findLongestWorkingCouple());

                table.setItems(data);
            }
        });

        VBox vbox = new VBox(button);
        vbox.setSpacing(SPACING);
        vbox.setPadding(new Insets(TOP, ZERO, ZERO, LEFT));
        vbox.getChildren().addAll(label, this.table);

        Scene scene = new Scene(new Group());

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setFileChooser() {
        this.fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(TEXT_FILES, TXT));
    }

    private void setTableColumns() {
        this.firstEmployeeIdCol = new TableColumn(EMPLOYEE_ID_1);
        firstEmployeeIdCol.setMinWidth(MIN_WIDTH);
        firstEmployeeIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(FIRST_EMPLOYEE_ID));

        this.secondEmployeeIdCol = new TableColumn(EMPLOYEE_ID_2);
        secondEmployeeIdCol.setMinWidth(MIN_WIDTH);
        secondEmployeeIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(SECOND_EMPLOYEE_ID));

        this.projectIdCol = new TableColumn(PROJECT_ID_BIG);
        projectIdCol.setMinWidth(MIN_WIDTH_2);
        projectIdCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(PROJECT_ID_SMALL));

        this.daysWorkedCol = new TableColumn(DAYS_WORKED_BIG);
        daysWorkedCol.setMinWidth(MIN_WIDTH_2);
        daysWorkedCol.setCellValueFactory(new PropertyValueFactory<Couple, String>(DAYS_WORKED_SMALL));

        this.table = new TableView();
        table.getColumns().addAll(firstEmployeeIdCol, secondEmployeeIdCol, projectIdCol, daysWorkedCol);
    }

    private void configurePrimaryStage(Stage primaryStage) {
        primaryStage.setTitle(EMPLOYEES_APP_NAME);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
    }

    private void initializeDependencies() {
        this.service = new WorkProcessService();
        this.employeesApp = new EmployeesApp(service);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
