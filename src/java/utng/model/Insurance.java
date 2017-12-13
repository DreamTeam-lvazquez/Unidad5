package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_insurance")
    private Long idInsurance;
    @Column(length=30)
    private String name;
   
    

    public Insurance() {
        this.idInsurance=0L;
    }

    public Long getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(Long idInsurance) {
        this.idInsurance = idInsurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
