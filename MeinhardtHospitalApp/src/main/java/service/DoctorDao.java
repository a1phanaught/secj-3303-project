package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.Doctor;
import java.util.List;

@Service
public class DoctorDao {
	@Autowired // spring dependency injection
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Doctor> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Doctor").getResultList();
	}
	
	@Transactional
	public Doctor getDoctorById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Doctor.class, id);
	}
	
	@Transactional
	public void saveDoctor(Doctor doctor) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    currentSession.saveOrUpdate(doctor);
	}
	
	@Transactional
	public Doctor getDoctorByEmail(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Doctor> query = currentSession.createQuery("from Doctor where email=:email and password=:password", Doctor.class);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    return query.uniqueResult();
	}
}
