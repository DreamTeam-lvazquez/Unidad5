package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="drink")
public class Drink implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_drink")
    private Long idDrink;
    @Column(length=30)
    private String name;
   
    

    public Drink() {
        this.idDrink=0L;
    }

    public Long getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(Long idDrink) {
        this.idDrink = idDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
}
