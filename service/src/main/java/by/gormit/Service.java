package by.gormit;

import by.gormit.dao.impl.UserDaoImpl;
import by.gormit.pojos.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Gormit on 26.08.2015.
 * Magic :) Service class for work with Dao and Web
 * I do not make the base interface and classes,
 * because we have only few methods,
 * but it not very good practice
 */
public class Service {

    /**
     * Method send to UserDaoImpl a current page, how many rows must be on page and sort values
     * @param currentPage it is a curren page
     * @param countRows how many rows must be on page
     * @param sort sort values
     * @return List of Users with pagination and sorting
     */
    public List<User> getList(int currentPage, int countRows, String sort) {
        int firstResult = (currentPage - 1) * countRows;
        return new UserDaoImpl().getList(firstResult, countRows, sort);
    }

    /**
     * Get from UserDaoImpl count all rows from DB
     * @return count rows
     */
    public int getCount() {
        return new UserDaoImpl().getCount();
    }

    /**
     * Method send a datd from file to UserDaoImpl
     * @param fileContent data from file
     */
    public  void save(InputStream fileContent) {
        new UserDaoImpl().save(fileContent);
    }
}
