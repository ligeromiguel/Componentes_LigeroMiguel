/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_ligeromiguel;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author Miguel
 */
public class Temporizador extends HBox {

    private Timeline timeline;
    private int segundos;
    private IntegerProperty seg;

    @FXML
    private Label labelTime;

    public Temporizador(int seconds) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        seg = new SimpleIntegerProperty(segundos);
        
        this.segundos=seconds;

        labelTime.textProperty().bind(seg.asString());
        seg.set(segundos);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(segundos + 1), new KeyValue(seg, 0)));
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public IntegerProperty getSegundos() {
        return seg;
    }

    public void setSegundos(IntegerProperty segundos) {
        this.seg = segundos;
    }

    public Label getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(Label labelTime) {
        this.labelTime = labelTime;
    }

    public void playTime() {
        timeline.playFromStart();
    }

}