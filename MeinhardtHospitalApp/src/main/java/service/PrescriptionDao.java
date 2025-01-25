package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Prescription;

@Service
public class PrescriptionDao {
	@Autowired // spring dependency injection
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Prescription> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Prescription").getResultList();
	}
	
	@Transactional
	public Prescription getPrescriptionById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Prescription.class, id);
	}
	
	@Transactional
    public void savePrescription(Prescription prescription) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(prescription);
    }
	
	@Transactional
	public Prescription updatePrescription(int id, Prescription newPrescription) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Prescription existingPrescription = currentSession.get(Prescription.class, id);
	    if (existingPrescription != null) {
	        existingPrescription.setName(newPrescription.getName());
	        existingPrescription.setDosage(newPrescription.getDosage());
	        existingPrescription.setRegisterDate(newPrescription.getRegisterDate());
	        existingPrescription.setExpiryDate(newPrescription.getExpiryDate());
	        existingPrescription.setQuantity(newPrescription.getQuantity());
	        currentSession.saveOrUpdate(existingPrescription);
	        return existingPrescription;
	    } else {
	        return null;
	    }
	}

	
}