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

@Entity
@Table(name="sick")
public class Sick implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_sick")
    private Long idSick;
    @Column(name="name_sick", length=10)
    private String nameSick;
    @Column(length=40)
    private String password;
    @ManyToOne()
    @JoinColumn(name="id_insurance")
    private Insurance insurance;

    public Sick(Long idSick, String nameSick, String password, Insurance insurance) {
        this.idSick = idSick;
        this.nameSick = nameSick;
        this.password = password;
        this.insurance = insurance;
    }

   

   

    public Sick() {
        this.idSick=0L;
    }

    public Long getIdSick() {
        return idSick;
    }

    public void setIdSick(Long idSick) {
        this.idSick = idSick;
    }

    public String getNameSick() {
        return nameSick;
    }

    public void setNameSick(String nameSick) {
        this.nameSick = nameSick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

   
    
    
}
