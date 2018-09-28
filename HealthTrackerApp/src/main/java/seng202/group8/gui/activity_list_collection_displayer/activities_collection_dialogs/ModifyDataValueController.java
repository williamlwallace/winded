package seng202.group8.gui.activity_list_collection_displayer.activities_collection_dialogs;

import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seng202.group8.activity_collection.ActivityList;
import seng202.group8.data_entries.Data;
import seng202.group8.gui.activity_list_collection_displayer.ActivitiesCollectionController;
import seng202.group8.user.User;

import java.util.ArrayList;

public class ModifyDataValueController {

    private int activityListIndex;
    private int dataIndex;
    private User user;
    private Stage stage;
    private ActivitiesCollectionController activitiesCollectionController;
    private Data dataValue;
    private ActivityList currentActivityList;



    @FXML
    private ChoiceBox activitiesChoiceBox;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private JFXToggleButton newActivityListToggle;

    @FXML
    private TextField newActivityListName;



    public void initialSetUp() {
        setDataValue();
        setChoiceBox();
        descriptionTextField.setText(dataValue.getTitle());
        newActivityListName.setText(currentActivityList.getTitle());
        newActivityListName.setVisible(false);
    }

    public void toggleButtonListener() {
        if (newActivityListToggle.isSelected()) {
            newActivityListName.setVisible(true);
        } else {
            newActivityListName.setVisible(false);
        }
    }

    public void setChoiceBox() {
        ArrayList<String> activitiesChoice = new ArrayList<>();
        activitiesChoice.add("Walk");
        activitiesChoice.add("Run");
        activitiesChoice.add("Hike");
        activitiesChoice.add("Climb");
        activitiesChoice.add("Bike");
        activitiesChoice.add("Swim");
        activitiesChoice.add("Water Sport");
        ObservableList<String> observableList = FXCollections.observableList(activitiesChoice);
        activitiesChoiceBox.setItems(observableList);
        switch(dataValue.getDataType()) {
            case WALK:
                activitiesChoiceBox.setValue("Walk");
                break;
            case RUN:
                activitiesChoiceBox.setValue("Run");
                break;
            case HIKE:
                activitiesChoiceBox.setValue("Hike");
                break;
            case CLIMB:
                activitiesChoiceBox.setValue("Climb");
                break;
            case BIKE:
                activitiesChoiceBox.setValue("Bike");
                break;
            case SWIM:
                activitiesChoiceBox.setValue("Swim");
                break;
            default:
                activitiesChoiceBox.setValue("Water Sport");
                break;
        }
    }


    public void setDataValue() {
        this.currentActivityList = user.getUserActivities().getActivityListCollection().get(activityListIndex);
        this.dataValue = this.currentActivityList.getActivity(dataIndex);
    }

    public void exitButtonListener() {
        stage.close();
    }


    public int getActivityListIndex() {
        return activityListIndex;
    }

    public void setActivityListIndex(int activityListIndex) {
        this.activityListIndex = activityListIndex;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ActivitiesCollectionController getActivitiesCollectionController() {
        return activitiesCollectionController;
    }

    public void setActivitiesCollectionController(ActivitiesCollectionController activitiesCollectionController) {
        this.activitiesCollectionController = activitiesCollectionController;
    }
}