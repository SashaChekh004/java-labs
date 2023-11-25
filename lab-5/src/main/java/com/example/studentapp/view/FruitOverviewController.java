package com.example.studentapp.view;

import com.example.studentapp.MainApp;
import com.example.studentapp.model.Fruit;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FruitOverviewController {
    @FXML
    private TableView<Fruit> fruitTable;
    @FXML
    private TableColumn<Fruit, String> nameColumn;
    @FXML
    private TableColumn<Fruit, String> amountColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label priceLabel;
    //Посилання на головну програму
    private MainApp mainApp;

    /**
     * Конструктор.
     * Конструктор викликається раніше методом initialize().
     */
    public FruitOverviewController() {
    }

    /**
     * Ініціалізація класу-контролера. Цей метод викликається автоматично
     * після того, як файл fxml буде завантажений.
     */
    @FXML
    private void initialize() {
// Ініціалізація таблиці адресатів із двома стовпцями.
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nameProperty());
        amountColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
// Очищення додаткової інформації про фрукт.
        showPersonDetails(null);
// Слухаємо зміни вибору і при зміні відображаємо
        // додаткову інформацію про фрукт.

        fruitTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }


    /**
     * Викликається головним додатком, який дає він посилання.
     *
     * @parammainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
// Додавання до таблиці даних із спостережуваного списку
        fruitTable.setItems(mainApp.getFruitData());
    }

    /**
     * Заповнює всі текстові поля, показуючи подробиці про студента.
     * Якщо вказаний студент = null, всі текстові поля очищаються.
     *
     * @paramperson – студент типу Person або null
     */
    private void showPersonDetails(Fruit fruit) {
        if (fruit != null) {
// Заповнюємо позначки інформацією з об'єкта fruit.
            nameLabel.setText(fruit.getName());
            amountLabel.setText(String.valueOf(fruit.getAmount()));
            priceLabel.setText(String.valueOf(fruit.getPrice()));
        } else {
// Якщо Person = null, то забираємо весь текст.
            nameLabel.setText("");
            amountLabel.setText("");
            priceLabel.setText("");
        }
    }

    /**
     * Викликається, коли користувач натискає на кнопку видалення.
     */
    @FXML
    private void handleDeleteFruit() {
        // not implemented
    }

    /**
     * Викликається, коли користувач клацає по кнопці New...
     * Відкриває діалогове вікно із додатковою інформацією нового студента.
     */
    @FXML
    private void handleNewFruit() {
        // not implemented
    }

    /**
     * Викликається, коли користувач клацне по кнопка Edit...
     * Відкриває діалогове вікно для зміни вибраного фрукта.
     */
    @FXML
    private void handleEditFruit() {
        // not implemented
    }


}