package springPackage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springPackage.models.Personx;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional(readOnly=false)
public class RoleStorage implements RoleDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public RoleStorage(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Collection<Personx> values() {
        return (List<Personx>) this.hibernateTemplate.find("FROM Personx");
    }

    @Override
    public int add(Personx user) {
        return (int) this.hibernateTemplate.save(user);
    }

    @Override
    public void edit(Personx user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Personx get(int id) {
        return null;
    }

    @Override
    public Personx findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
