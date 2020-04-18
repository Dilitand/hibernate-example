package springPackage.config;

import org.springframework.stereotype.Component;

import java.util.Collection;

public interface Storage<T> {

    public Collection<T> values();

    public int add(final T user);

    public void edit(final T user);

    public void delete(final int id);

    public T get(final int id);

    public T findByLogin(final String login) ;

    public int generateId();

    public void close();
}
