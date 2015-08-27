package by.gormit.dao;

import by.gormit.pojos.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Gormit on 26.08.2015.
 * Interface works with methods unique to User-entity
 */
public interface UserDao extends Dao<User> {

    List<User> getList(int firstResult, int maxResult, String sort);
    int getCount();
    void save(InputStream fileContent);
}
