package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.InsuranceDAO;
import utng.datos.SickDAO;
import utng.modelo.Insurance;
import utng.modelo.Sick;

@ManagedBean(name="sickBean") 
@SessionScoped
public class SickBean implements Serializable{
    private List<Sick> sicks;
    private Sick sick;
    private List<Insurance> insurances;
    public SickBean(){
        sick = new Sick();
        sick.setInsurance(new Insurance());
    }

    public List<Sick> getSicks() {
        return sicks;
    }
    public void setSicks(List<Sick> sicks) {
        this.sicks = sicks;
    }
    public Sick getSick() {
        return sick;
    }
    public void setSick(Sick sick) {
        this.sick = sick;
    }
    public List<Insurance >getInsurances() {
        return insurances;
    }
    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }
    
     public String listar(){
        SickDAO dao = new SickDAO();
        try {
            sicks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sicks";
    }
    
    public String eliminar(){
         SickDAO dao = new SickDAO();
        try {
            dao.delete(sick);
            sicks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        sick= new Sick();
        sick.setInsurance(new Insurance());
        try {
            insurances= new InsuranceDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    
    public String guardar(){
       SickDAO dao = new SickDAO();
        try {
            if(sick.getIdSick()!= 0){
                dao.update(sick);
            }else {
                dao.insert(sick);
            }
            sicks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Sick sick){
        this.sick=sick;
        try {
           insurances = new InsuranceDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
    
    public String login(){
        sick = new SickDAO().login(this.sick);
        if(sick != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sick",sick);
            return "Correcto";
        }else {
            sick = new Sick();
            return "Incorrecto";
        }
    }
    
    
}
