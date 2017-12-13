/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Paola
 */

@Entity
@Table(name="saucer")
public class Saucer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_saucer")
    private Long idSaucer;
    @Column(name="name", length=10)
    private String name;
    @Column(name="price", length=10)
    private int price;
    @Column(name="chef", length=10)
    private String chef;
    @ManyToOne()
    @JoinColumn(name="id_ingredient")
    private Ingredient ingredient;
    @ManyToOne()
    @JoinColumn(name="id_drink")
    private Drink drink;

    public Saucer(Long idSaucer, String name, int price, String chef, Ingredient ingredient, Drink drink) {
        this.idSaucer = idSaucer;
        this.name = name;
        this.price = price;
        this.chef = chef;
        this.ingredient = ingredient;
        this.drink = drink;
    }

   
        
  
    public Saucer() {
        this.idSaucer=0L;
    }

    public Long getIdSaucer() {
        return idSaucer;
    }

    public void setIdSaucer(Long idSaucer) {
        this.idSaucer = idSaucer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    
    

    

    

    
    
}