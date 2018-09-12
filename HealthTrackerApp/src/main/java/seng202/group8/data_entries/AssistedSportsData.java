package seng202.group8.data_entries;

import seng202.group8.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class AssistedSportsData extends Data {
    public AssistedSportsData(String newTitle, DataType dataType, ArrayList<LocalDateTime> newDateTimes,
                              ArrayList<CoordinateData> newCoordinatesList, ArrayList<Integer> newHeartRateList, User theCurrentUser) {
        super(newTitle, dataType, newDateTimes, newCoordinatesList, newHeartRateList, theCurrentUser);
    }

    public abstract double getConsumedCalories();

    public abstract ArrayList<Double> getConsumedCaloriesBetweenPoints();
}
//
//
//    public AssistedSportsData(String newTitle, DataType dataType, ArrayList<Double> newCoordinatesList, ArrayList<Integer> newHeartRateList) {
//        super(newTitle, dataType, newCoordinatesList, newHeartRateList);
//    }
//
//    abstract double getConsumedCalories(String activityType);
//}
