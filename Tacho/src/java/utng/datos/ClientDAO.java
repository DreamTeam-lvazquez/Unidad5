package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Client;

public class ClientDAO  extends DAO<Client>{

    public ClientDAO() {
        super(new Client());
    }
    public Client getOneById(Client client) throws HibernateException {
        return super.getOneById(client.getIdClient()); 
    }
    public Client login (Client client){
        List<String> parametros= new ArrayList<String>();
        List<Object>valores= new ArrayList<Object>();
        parametros.add("nameClient");
        parametros.add("password");
        valores.add(client.getNameClient());
        valores.add(client.getPassword());
        client= query("SELECT u FROM "
                +modelo.getClass().getName()
                +" u WHERE u.nameClient =:nameClient "
                +"AND u.password=:password",
                        parametros, valores);
        return client;
    }
    
}