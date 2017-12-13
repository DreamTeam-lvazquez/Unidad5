package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.DrinkDAO;
import utng.modelo.Drink;

@ManagedBean
@SessionScoped
public class DrinkBean implements Serializable{
    private List<Drink> drinks;
    private Drink drink;
    public DrinkBean(){}
    

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrinks(Drink drink) {
        this.drink = drink;
    }
    
    
    public String listar(){
       DrinkDAO dao = new DrinkDAO();
        try {
            drinks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Drinks";
    }
    
    public String eliminar(){
       DrinkDAO dao = new DrinkDAO();
        try {
            dao.delete(drink);
            drinks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        drink= new Drink();
        return "Iniciar";
    }
    
    public String guardar(){
        DrinkDAO dao = new DrinkDAO();
        try {
            if(drink.getIdDrink()!= 0){
                dao.update(drink);
            }else {
                dao.insert(drink);
            }
            drinks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Drink drink){
        this.drink=drink;
        return "Editar";
    }
    
}


