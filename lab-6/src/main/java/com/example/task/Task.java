package com.example.task;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Task extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private double pencilSize = 5.0; // Initial pencil size
    private double lastX = -1;
    private double lastY = -1;

    private void draw(Canvas canvas, GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Draw text
        gc.setLineWidth(5);
        gc.setStroke(Color.BLACK);
        gc.strokeText("KHPI", 10, 100);
        gc.setStroke(Color.WHITE);

    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(500, 200);
        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(new Font("Arial", 100));

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new
                EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        double x = e.getX();
                        double y = e.getY();
                        gc.setLineWidth(pencilSize);
                        gc.strokeLine(e.getX() - 1, e.getY() - 1, x, y);
                        lastX = x;
                        lastY = y;
//                        gc.clearRect(e.getX() - 1, e.getY() - 1, 2, 2);
                    }
                });
// Повернення переднього фону при подвійному кліці
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new
                EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        if (t.getClickCount() == 3) {
                            draw(canvas, gc);
                        }
                    }
                });

        draw(canvas, gc);

        // Create a Label and Slider for pencil size
        Slider sizeSlider = new Slider(1, 20, pencilSize);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(5);

        // Add an event handler to update the pencil size
        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            pencilSize = newValue.doubleValue();
        });

        Pane root = new Pane();
        root.getChildren().addAll(canvas, sizeSlider);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Drawing on a Canvas");
        stage.show();
    }
}
