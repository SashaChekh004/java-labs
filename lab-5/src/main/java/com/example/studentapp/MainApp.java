package com.example.studentapp;

import com.example.studentapp.model.Fruit;
import com.example.studentapp.model.Person;
import com.example.studentapp.view.FruitOverviewController;
import com.example.studentapp.view.PersonEditDialogController;
import com.example.studentapp.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        //Як зразок додаємо деякі дані
        personData.add(new Person("Петро", "П'яточкін"));
        personData.add(new Person("Іван", "Зайців"));
        personData.add(new Person("Катерина", "Васильченка"));
        personData.add(new Person("Ольга", "Жук"));
        personData.add(new Person("Людміла", "Алексєєва"));
        personData.add(new Person("Даніл", "Кац"));
        personData.add(new Person("Євген", "Васнецов"));
        personData.add(new Person("Дмитро", "Жуликів"));
        personData.add(new Person("Мрат", "Алібов"));
        personData.add(new Person("Martin", "Mueller"));

        //////////////////////

        fruitData.add(new Fruit("Киви", 10, 2.3));
        fruitData.add(new Fruit("Мандарин", 13, 1d));
        fruitData.add(new Fruit("Какао", 77, 555.123));
    }

    /**
     * Повертає дані у вигляді спостережуваного списку студентів.
     *
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("StudentGroupApp");

        initRootLayout();
//        initRootLayout2();
        showPersonOverview();
    }

    /**
     * Ініціалізує кореневий макет.
     */
    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо кореневий макет з файлу fxml.
        fxmlLoader.setLocation(getClass().getResource("/studentapp/view/RootLayout.fxml"));
        try {
            rootLayout = fxmlLoader.load();
//Відображаємо сцену, яка містить кореневий макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Показує у кореневому макеті відомості про студентів.
     */
    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо відомості про студентів.
        fxmlLoader.setLocation(MainApp.class.getResource("/studentapp/view/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = fxmlLoader.load();
// Поміщаємо відомості про студентів до центру кореневого макета.
            rootLayout.setCenter(personOverview);
            //Даємо контролеру доступ до головної програми.
            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Повертає головну сцену.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Відкриває діалогове вікно зміни даних зазначеного студента.
     * Якщо користувач натиснув OK, то зміни зберігаються у наданому
     * об'єкт студента і повертається значення true.
     *
     * @paramperson – об'єкт студента, який треба змінити
     * @returntrue, якщо користувач натиснув OK, інакше false.
     */
    public boolean showPersonEditDialog(Person person) {
        try {
// Завантажуємо файл fxml і створюємо нову сцену для діалогового вікна.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/studentapp/view/PersonEditDialog.fxml"));
            AnchorPane page = loader.load();
//Створюємо діалогове вікно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
// Передаємо студента до контролера.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
// Відображаємо діалогове вікно та чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /////////////////////////// ФРУКТИ

    private final ObservableList<Fruit> fruitData = FXCollections.observableArrayList();

    public ObservableList<Fruit> getFruitData() {
        return fruitData;
    }

    public boolean showFruitDialog() {
        try {
// Завантажуємо файл fxml і створюємо нову сцену для діалогового вікна.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/studentapp/view/FruitOverview.fxml"));
            AnchorPane page = loader.load();
//Створюємо діалогове вікно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Fruit Info");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
// Передаємо студента до контролера.
            FruitOverviewController controller = loader.getController();
            controller.setMainApp(this);
// Відображаємо діалогове вікно та чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getSecondaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
