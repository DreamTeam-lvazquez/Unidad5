
package utng.manejador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.modelo.Client;


@ManagedBean
@SessionScoped
public class PlantillaBean implements Serializable{
    public void checkLogin(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Client client = (Client)context.getExternalContext().getSessionMap().get("client");
            if(client == null){
                context.getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
