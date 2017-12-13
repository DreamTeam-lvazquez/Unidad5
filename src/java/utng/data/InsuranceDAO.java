package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Insurance;


public class InsuranceDAO extends DAO<Insurance> {
     public InsuranceDAO() {
        super(new Insurance());
    }

    public Insurance getOneById(Insurance insurance) throws HibernateException {
        return super.getOneById(insurance.getIdInsurance()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
