package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.Admin;
import java.util.List;

@Service
public class AdminDao {
    @Autowired // spring dependency injection
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Admin> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Admin").getResultList();
    }
    
    @Transactional
    public Admin getAdminById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Admin.class, id);
    }
    
    @Transactional
    public void saveAdmin(Admin admin) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(admin);
    }
    
    @Transactional
    public Admin getAdminByUsername(String username, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Admin> query = currentSession.createQuery("from Admin where username=:username and password=:password", Admin.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.uniqueResult();
    }
}