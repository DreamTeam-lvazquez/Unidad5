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
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ingredient")
    private Long idIngredient;
    @Column(name="name", length=10)
    private String name;
    @Column(name="flavor", length=10)
    private String flavor;
    @Column(name="price", length=10)
    private int price;

    public Ingredient(Long idIngredient, String name, String flavor, int price) {
        this.idIngredient = idIngredient;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    
    
    public Ingredient() {
        this.idIngredient=0L;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   
    
    
    
    
    
}


    
   
