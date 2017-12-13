package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.ModuleDAO;
import utng.modelo.Module;

@ManagedBean
@SessionScoped
public class ModuleBean implements Serializable {
    private List<Module>modules;
    private Module module;
    public ModuleBean(){}

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    public String listar(){
        ModuleDAO dao = new ModuleDAO();
        try {
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Modules";
    }
    
    public String eliminar(){
         ModuleDAO dao = new ModuleDAO();
        try {
            dao.delete(module);
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";//no me queda claro si este es es lo que devuelve 
    }
    
    public String iniciar(){
        module= new Module();
        return "Iniciar";
    }
    
    public String guardar(){
        ModuleDAO dao = new ModuleDAO();
        try {
            if(module.getIdModule()!= 0){
                dao.update(module);
            }else {
                dao.insert(module);
            }
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Module module){
        this.module=module;
        return "Editar";
    }
        
}
