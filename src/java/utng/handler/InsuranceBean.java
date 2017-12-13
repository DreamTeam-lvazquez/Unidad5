package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.InsuranceDAO;
import utng.modelo.Insurance;

@ManagedBean
@SessionScoped
public class InsuranceBean implements Serializable{
    private List<Insurance> insurances;
    private Insurance insurance;
    public InsuranceBean(){}

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    
    
    public String listar(){
        InsuranceDAO dao = new InsuranceDAO();
        try {
            insurances=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Insurances";
    }
    
    public String eliminar(){
        InsuranceDAO dao = new InsuranceDAO();
        try {
            dao.delete(insurance);
            insurances=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
       insurance= new Insurance();
        return "Iniciar";
    }
    
    public String guardar(){
        InsuranceDAO dao = new InsuranceDAO();
        try {
            if(insurance.getIdInsurance()!= 0){
                dao.update(insurance);
            }else {
                dao.insert(insurance);
            }
            insurances=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Insurance insurance){
        this.insurance=insurance;
        return "Editar";
    }
    
}


