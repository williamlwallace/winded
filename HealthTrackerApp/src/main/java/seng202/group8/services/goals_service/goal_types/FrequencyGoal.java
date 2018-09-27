package seng202.group8.services.goals_service.goal_types;

import seng202.group8.data_entries.Data;
import seng202.group8.data_entries.DataType;
import seng202.group8.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author lfa69
 */
public class FrequencyGoal extends Goal {

    private Integer timesToPerformActivity;
    private Integer timesCurrentlyPerformedActivity;
    private DataType dataType;

    public FrequencyGoal(User user, String description, GoalType goalType, DataType dataType, Integer timesToPerformActivity, LocalDateTime targetDate) {
        super(user, description, goalType);
        setTargetDate(targetDate);
        this.timesToPerformActivity = timesToPerformActivity;
        this.dataType = dataType;
        this.timesCurrentlyPerformedActivity = 0;
    }

// Uncomment to see what is failing, I mainly need a DataType and a function in each Data subclass to retrieve the distance covered
    /**
     *
     * Sieves through the data logged by the user and retrieves the number of times an activity type was performed
     * If the the activity type has been performed as many times as required then the goal is completed.
     */
    public void checkIsCompleted() {
        ArrayList<Data> sameTypeData = getUser().getUserActivities().retrieveSameTypeActivities(dataType, getStartDate());

        if (timesToPerformActivity <= sameTypeData.size()) {
            setIsCompleted(true);
        }
        timesCurrentlyPerformedActivity = sameTypeData.size();
    }

    /**
     *
     * @return the timesToPerform parameter
     */
    public Integer getTimesToPerformActivity() {
        return timesToPerformActivity;
    }

    /**
     *
     * @param timesToPerformActivity a new Integer value for timesToPerformActivity parameter
     */
    public void setTimesToPerformActivity(Integer timesToPerformActivity) {
        this.timesToPerformActivity = timesToPerformActivity;
    }

    public Integer getTimesCurrentlyPerformedActivity() {
        return timesCurrentlyPerformedActivity;
    }

    public void setTimesCurrentlyPerformedActivity(Integer timesCurrentlyPerformedActivity) {
        this.timesCurrentlyPerformedActivity = timesCurrentlyPerformedActivity;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void calculateProgress() {
        ArrayList<Data> sameTypeData = getUser().getUserActivities().retrieveSameTypeActivities(dataType, getStartDate());
        setProgress((double) 1 - (timesToPerformActivity - sameTypeData.size()) / timesToPerformActivity);
    }

    public void calculateTarget() {
        setTarget((double) timesToPerformActivity);
    }

    public void calculateCurrent() {
        ArrayList<Data> sameTypeData = getUser().getUserActivities().retrieveSameTypeActivities(dataType, getStartDate());
        setCurrent((double) sameTypeData.size());
    }

}
