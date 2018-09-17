package java_sqlite_db;

import java.sql.*;

public class SQLiteJDBC {


    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:winded.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertUser(Connection connection, Integer id, String name, Double weight, Double height, Integer age, String sex) {

        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, weight);
            preparedStatement.setDouble(4, height);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, sex);

            String find = "SELECT * from user where user_id=?";
            PreparedStatement findStatement = connection.prepareStatement(find);
            findStatement.setInt(1, id);
            ResultSet results = findStatement.executeQuery();
            if (results.next()) {
                System.out.println("User Tuple already exists");
            } else {
                // Print out the result of the insert statement, 0 means nothing has been inserted
                System.out.println("Rows added to user: " + preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet selectAllUsers(Connection connection) {
        assert null != connection;
        System.out.println("Get all tuples");
        ResultSet resultSet = null;
        try {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM user");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public ResultSet getUser(Connection connection, Integer userID) {
        assert null != connection && null != userID;
        ResultSet resultSet = null;
        System.out.println("Get User with id: " + userID );
        String find = "SELECT * FROM user WHERE user_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(find);
            statement.setInt(1, userID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public void deleteUser(Connection connection, Integer userID) {
        String sql = "DELETE FROM user WHERE user_id=?";
        try {
            System.out.println("Deleting User with id = " + userID);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateUser(Connection connection,  Integer userId, String name, Double weight, Double height, Integer age, String sex) {
        assert null != connection && null != userId && null != name && null != weight && null != height && null != age && null != sex;

        String update = "UPDATE user SET name = ? ,"
                + "weight = ? ,"
                + "height = ? ,"
                + "age = ? ,"
                + "sex = ? "
                + "WHERE user_id = ?";

        try {
            System.out.println("Updating User with id: " + userId);
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, weight);
            preparedStatement.setDouble(3,height);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, sex);
            preparedStatement.setInt(6, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void insertCoordinate(Connection connection, Double latitude, Double longitude, Double elevation, Integer dataId){
        String sql = "INSERT INTO CoOrdinate VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, latitude);
            preparedStatement.setDouble(2, longitude);
            preparedStatement.setDouble(3, elevation);
            preparedStatement.setInt(4, dataId);

            System.out.println("Rows added to Co-Ordinate: " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertHeartRate(Connection connection, Integer HeartRate, Integer dataId) {
        String sql = "INSERT INTO Heartrate VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, HeartRate);
            preparedStatement.setInt(2, dataId);

            System.out.println("Rows added to Heartrate: " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertActivityTime(Connection connection, Integer dataId, String dateTime) {
        String sql = "INSERT INTO Activity_Time VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dataId);
            preparedStatement.setString(2, dateTime);

            System.out.println("Rows added to Activity_Time: " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(Connection connection, Integer dataId, Integer userId, String dataType, String parentListTitle, String parentListDatetime) {
        String sql = "INSERT INTO Data VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dataId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, dataType);
            preparedStatement.setString(4, parentListTitle);
            preparedStatement.setString(5, parentListDatetime);



            String find = "SELECT * from Data where data_id=?";
            PreparedStatement findStatement = connection.prepareStatement(find);
            findStatement.setInt(1, dataId);
            ResultSet results = findStatement.executeQuery();
            if (results.next()) {
                System.out.println("Data Tuple already exists");
            } else {
                // Print out the result of the insert statement, 0 means nothing has been inserted
                System.out.println("Rows added to Data:" + preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertActivityList(Connection connection, String title, String datetime, Integer userId) {
        String sql = "INSERT INTO Activity_List VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, datetime);
            preparedStatement.setInt(3, userId);

            String find = "SELECT * from Activity_List where title=? AND date=?";
            PreparedStatement findStatement = connection.prepareStatement(find);
            findStatement.setString(1, title);
            findStatement.setString(2, datetime);
            ResultSet results = findStatement.executeQuery();
            if (results.next()) {
                System.out.println("Activity_List Tuple already exists");
            } else {
                // Print out the result of the insert statement, 0 means nothing has been inserted
                System.out.println("Rows added to Activity List:" + preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertActivityCollection(Connection connection, Integer userId, String title) {
        String sql = "INSERT INTO Activity_Collection VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, title);

            String find = "SELECT * from Activity_Collection where user_id=?";
            PreparedStatement findStatement = connection.prepareStatement(find);
            findStatement.setInt(1, userId);
            ResultSet results = findStatement.executeQuery();
            if (results.next()) {
                System.out.println("Activity_Collection Tuple already exists");
            } else {
                // Print out the result of the insert statement, 0 means nothing has been inserted
                System.out.println("Rows added to Activity Collection:" + preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deleteAllData(Connection connection) {
        try {
            String sql = "DELETE FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DELETE FROM Activity_Collection";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DELETE FROM Activity_List";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DELETE FROM Data";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DELETE FROM CoOrdinate";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DELETE FROM Heartrate";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        SQLiteJDBC newDataBaseJDBC = new SQLiteJDBC();
        Connection conn = connect();
        newDataBaseJDBC.deleteAllData(conn);
        newDataBaseJDBC.insertUser(conn, 1, "Jack", 77.0, 183.0, 19, "MALE");
        newDataBaseJDBC.insertUser(conn, 2, "John", 89.0, 193.0, 25, "MALE");
        newDataBaseJDBC.updateUser(conn, 2, "Jonathon", 90.0, 200.0, 26, "FEMALE");
        ResultSet allUsers2 = newDataBaseJDBC.selectAllUsers(conn);
        ResultSet oneUser2 = newDataBaseJDBC.getUser(conn, 1);
        try {
            while (allUsers2.next()) {
                System.out.println(allUsers2.getInt("user_id") +  "\t" +
                        allUsers2.getString("name") + "\t" +
                        allUsers2.getDouble("weight") + "\t" +
                        allUsers2.getDouble("height") + "\t" +
                        allUsers2.getInt("age") + "\t" +
                        allUsers2.getString("sex"));

            }
            //if (conn != null) {
            //    conn.close();
            //}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("-----------------------------------------------------------------------");

        //now try adding data
        newDataBaseJDBC.insertActivityCollection(conn, 1, "Jack's Activity collection");
        newDataBaseJDBC.insertActivityList(conn, "Runs", "2018-09-10/11:00", 1);
        newDataBaseJDBC.insertActivityList(conn, "Walks", "2018-09-10/11:00", 1);
        newDataBaseJDBC.insertData(conn, 1,1, "RUN","Runs", "2018-09-10/11:00");
        newDataBaseJDBC.insertData(conn, 2,1, "RUN","Runs", "2018-10-10/11:00");
        newDataBaseJDBC.insertCoordinate(conn, 30.2553368, 97.83891084, 239.5, 1);
        newDataBaseJDBC.insertCoordinate(conn, 30.2553368, 197.83891084, 239.5, 2);
        newDataBaseJDBC.insertHeartRate(conn, 250, 1);
        newDataBaseJDBC.insertHeartRate(conn, 250, 2);
        newDataBaseJDBC.insertActivityTime(conn, 1,"2018-12-10/10:33");
        newDataBaseJDBC.insertActivityTime(conn, 2,"2018-12-10/10:34");


        newDataBaseJDBC.insertActivityCollection(conn, 2, "Jonathon's Activity collection");
        newDataBaseJDBC.insertActivityList(conn, "Runs", "2018-09-10/10:38", 2);
        newDataBaseJDBC.insertData(conn, 3,2, "RUN","Runs", "2018-09-10/10:38");
        newDataBaseJDBC.insertData(conn, 4,2, "RUN","Runs", "2018-10-10/10:38");
        newDataBaseJDBC.insertCoordinate(conn, 30.2553368, 97.83891084, 239.5, 3);
        newDataBaseJDBC.insertCoordinate(conn, 30.2553368, 197.83891084, 239.5, 4);
        newDataBaseJDBC.insertHeartRate(conn, 250, 3);
        newDataBaseJDBC.insertHeartRate(conn, 250, 4);
        newDataBaseJDBC.insertActivityTime(conn, 3,"2018-12-10/10:33");
        newDataBaseJDBC.insertActivityTime(conn, 4,"2018-12-10/10:34");

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
