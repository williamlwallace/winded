package seng202.group8.gui.home_displayer;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seng202.group8.services.statistics_service.StatisticsService;
import seng202.group8.user.User;

import java.applet.AppletContext;
import java.io.IOException;
import java.net.*;

public class HomeController {

    @FXML
    private Label healthText;

    @FXML
    private Button cardio;

    @FXML
    private Button brad;

    @FXML
    private Button tach;

    @FXML
    private Label bmiText;

    @FXML
    private Label run;

    @FXML
    private Label walk;

    @FXML
    private Label bike;

    @FXML
    private Label all;

    @FXML
    private Label calories;

    /**
     * Sets the page up when the user first goes into the Home page
     */
    public void setup() {
        statsService = user.getStatsService();
        statsService.updateHomeStats(user);
        statsService.setHealthStatus();
        healthText.setText(statsService.getHealthStatus());
        bmiText.setText(user.getBMIString());
        run.setText(String.format("%.1f", statsService.getKmRunTotal()) + " km's");
        walk.setText(String.format("%.1f", statsService.getkmWalkTotal()) + " km's");
        bike.setText(String.format("%.1f", statsService.getKmBikedTotal()) + " km's");
        all.setText(String.format("%.1f", statsService.getKmTotal()) + " km's");
        calories.setText(String.format("%.1f", statsService.getCaloriesBurnedTotal()) + " calories burned");
    }

    public void searchCardio() {
        this.host.showDocument("https://www.google.com/search?q=Cardiovascular+Mortality");
    }

    public void searchBrad() {
        this.host.showDocument("https://www.google.com/search?q=bradycardia");
    }

    public void searchTach() {
        this.host.showDocument("https://www.google.com/search?q=Tachicardic");
    }

    public void setHostServices(HostServices host) {
        this.host = host;
    }

    /**
     * Variables used for navigation of data and the stage object
     */
    private User user;
    private Stage primaryStage;
    private StatisticsService statsService;
    private HostServices host;

    /**
     * Gets the current user using the page
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user for the page
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the primary stage
     * @return the primary stage object
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Sets the primary Stage variable
     * @param primaryStage a stage variable to be passed in
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
