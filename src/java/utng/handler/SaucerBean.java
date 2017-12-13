/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.DrinkDAO;
import utng.datos.IngredientDAO;
import utng.datos.SaucerDAO;
import utng.modelo.Ingredient;
import utng.modelo.Saucer;
import utng.modelo.Drink;

/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
public class SaucerBean implements Serializable {
    
    private List<Saucer> saucers;
    private Saucer saucer;
    private List<Ingredient> ingredients;
    private List<Drink> drinks;
    public SaucerBean(){
        saucer = new Saucer();
        saucer.setIngredient(new Ingredient());
         saucer.setDrink(new Drink());
    }

    public List<Saucer> getSaucers() {
        return saucers;
    }

    public void setSaucers(List<Saucer> saucers) {
        this.saucers = saucers;
    }

    public Saucer getSaucer() {
        return saucer;
    }

    public void setSaucer(Saucer saucer) {
        this.saucer = saucer;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

   
    
    public String listar(){
        SaucerDAO dao = new SaucerDAO();
        try {
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Saucers";
    }
    
    public String eliminar(){
         SaucerDAO dao = new SaucerDAO();
        try {
            dao.delete(saucer);
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";//no me queda claro si este es es lo que devuelve 
    }
    
    public String iniciar(){
        saucer= new Saucer();
       saucer.setIngredient(new Ingredient());
          saucer.setDrink(new Drink());
        try{
            ingredients=new IngredientDAO().getAll();
            drinks=new DrinkDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
        return "Iniciar";
    }
    
    public String guardar(){
        SaucerDAO dao = new SaucerDAO();
        try {
            if(saucer.getIdSaucer()!= 0){
                dao.update(saucer);
            }else {
                dao.insert(saucer);
            }
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Saucer saucer){
        this.saucer=saucer;
        try{
            ingredients = new IngredientDAO().getAll();
            drinks = new DrinkDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Editar";
    }
    
    
        
}
    
    
    
