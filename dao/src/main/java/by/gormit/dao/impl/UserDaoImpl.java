package by.gormit.dao.impl;

import by.gormit.dao.UserDao;
import by.gormit.pojos.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gormit on 26.08.2015.
 * Class works with methods unique to User-entity implements UserDao interface
 *
 * I have no idea how to make update method, because in CSV file we have no ID column(Primary Key), and the otherwise value can be repeat
 */
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);


    public UserDaoImpl() {
    }

    /**
     * Method getList get from DB list of Users with pagination and sorting
     * @param firstResult with rows begin
     * @param maxResult how many rows view
     * @param sort parametrs of sort
     * @return List of Users with pagination and sorting
     */
    @Override
    public List<User> getList(int firstResult, int maxResult, String sort) {

        String query = "SELECT * FROM user " + sort + " limit " + firstResult + ", " + maxResult;
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setMail(resultSet.getString("mail"));
                user.setPhoneNumber(resultSet.getString("phone"));
                users.add(user);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
        return users;
    }

    /**
     * Method get count all rows from BD
     * @return int count rows
     */
    @Override
    public int getCount() {
        int lastPage = 0;
        try {
            String query = "SELECT count(*) FROM user";
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                lastPage = resultSet.getInt("count(*)");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return lastPage;
    }

    /**
     * Method save in DB data get from file
     * @param fileContent data from file
     */
    @Override
    public synchronized void save(InputStream fileContent) {
        BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
        String line;

        try {
            Connection connection = DaoImpl.getConnection();
            PreparedStatement preparedStatement = null;
            while ((line = br.readLine()) != null){
                String[] value = line.split(";"); //separator
                String sql = "INSERT INTO user (name, surname, login, mail, phone)"
                        + " values ('" + value[0] + "', '" + value[1] + "', '" + value[2] + "', '" + value[3] + "', '" + value[4] + "')";
                if (connection != null) {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                }

            }
            if (null != preparedStatement){
                preparedStatement.close();
            }
            if (null != connection){
                connection.close();
            }
        } catch (IOException e) {
            logger.error("IOException" + e);
        } catch (SQLException e) {
            logger.error("SQLException" + e);
        }
    }
}
