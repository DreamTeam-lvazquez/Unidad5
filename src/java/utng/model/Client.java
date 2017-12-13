package utng.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_client")
    private Long idClient;
    @Column(name="name_client", length=10)
    private String nameClient;
    @Column(length=40)
    private String password;
    @ManyToOne()
    @JoinColumn(name="id_rol")
    private Rol rol;

    public Client(Long idClient, String nameClient, String password, Rol rol) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.password = password;
        this.rol = rol;
    }

   

    public Client() {
        this.idClient=0L;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
    
}
