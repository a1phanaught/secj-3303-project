package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.Appointment;
import entity.Doctor;

import java.util.List;

@Service
public class AppointmentDao {
	@Autowired // spring dependency injection
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Appointment> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Appointment").getResultList();
	}
	
	@Transactional
	public Appointment getAppointmentById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Appointment.class, id);
	}
	
	@Transactional
	public void saveAppointment(Appointment appointment) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    currentSession.saveOrUpdate(appointment);
	}
	
	@Transactional
	public void deleteAppointmentById(int id) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Appointment appointment = currentSession.get(Appointment.class, id);
	    if (appointment != null) {
	        currentSession.delete(appointment);
	    }
	}
}
