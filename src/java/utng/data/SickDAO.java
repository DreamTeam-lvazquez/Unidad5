package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Sick;

public class SickDAO  extends DAO<Sick>{

    public SickDAO() {
        super(new Sick());
    }
    public Sick getOneById(Sick sick) throws HibernateException {
        return super.getOneById(sick.getIdSick()); 
    }
    public Sick login (Sick sick){
        List<String> parametros= new ArrayList<String>();
        List<Object>valores= new ArrayList<Object>();
        parametros.add("nameSick");
        parametros.add("password");
        valores.add(sick.getNameSick());
        valores.add(sick.getPassword());
        sick = query("SELECT u FROM "
                +modelo.getClass().getName()
                +" u WHERE u.nameSick =:nameSick "
                +"AND u.password=:password",
                        parametros, valores);
        return sick;
    }
    
}