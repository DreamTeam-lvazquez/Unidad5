package utng.datos;

import org.hibernate.HibernateException;
import utng.datos.DAO;
import utng.modelo.Module;


public class ModuleDAO extends DAO<Module> {

    public ModuleDAO() {
        super(new Module());
    }

    
    public Module getOneById(Module module) throws HibernateException {
        return super.getOneById(module.getIdModule()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
