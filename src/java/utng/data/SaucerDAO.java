/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

import utng.modelo.Saucer;

/**
 *
 * @author Orlando
 */
public class SaucerDAO extends DAO<Saucer> {
    public SaucerDAO() {
        super(new Saucer());
    }

    
    public Saucer getOneById(Saucer saucer) throws HibernateException {
        return super.getOneById(saucer.getIdSaucer()); //To change body of generated methods, choose Tools | Templates.
    }
     public Saucer login (Saucer saucer){
        List<String> parametros= new ArrayList<String>();
        List<Object>valores= new ArrayList<Object>();
        parametros.add("name");
        parametros.add("price");
        parametros.add("chef");
        valores.add(saucer.getName());
        valores.add(saucer.getPrice());
        valores.add(saucer.getChef());
       saucer = query("SELECT u FROM "
                +modelo.getClass().getName()
                +" u WHERE u.name =:name "
                +"AND u.price=:price"+   "AND u.chef=:chef",
                        parametros, valores);
        return saucer;
    }
    
    
    
}
