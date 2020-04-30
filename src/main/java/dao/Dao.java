package dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Dao {

    public void save(Object o);

    public void update(Object o);
    public List getListFromQuery(String query);
}
