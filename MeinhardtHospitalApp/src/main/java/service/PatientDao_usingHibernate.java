package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import java.util.List;

@Service
public class PatientDao_usingHibernate {
	@Autowired // spring dependency injection
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Patient> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Patient").getResultList();
	}
	
	@Transactional
    public void savePatient(Patient patient) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(patient);
    }
	
	@Transactional
	public Patient getPatientByEmail(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Patient> query = currentSession.createQuery("from Patient where email=:email and password=:password", Patient.class);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    return query.uniqueResult();
	}
	
	@Transactional
	public Patient getPatientById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Patient.class, id);
	}
	
	@Transactional
	public List<Appointment> findAppointmentsByPatientId(int patientId) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    return currentSession.createQuery("from Appointment where patient.id = :patientId", Appointment.class)
	                         .setParameter("patientId", patientId)
	                         .getResultList();
	}
}
