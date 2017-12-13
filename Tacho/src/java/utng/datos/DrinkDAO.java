package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Drink;


public class DrinkDAO extends DAO<Drink> {
     public DrinkDAO() {
        super(new Drink());
    }

    public Drink getOneById(Drink drink) throws HibernateException {
        return super.getOneById(drink.getIdDrink()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
