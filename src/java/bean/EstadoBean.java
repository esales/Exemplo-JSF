package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Estado;
import repositorio.EstadoRepositorio;

@ManagedBean(name = "estadoBean")
@RequestScoped
public class EstadoBean {
    private Estado estado;
    private ArrayList<String> siglas;
    private List<Estado> estados;
    EstadoRepositorio estadoRepositorio = new EstadoRepositorio();

    public EstadoBean() {
        estado = new Estado();
        
        siglas = new ArrayList<String>();
        carregarSiglas();
        
        estados = new ArrayList<Estado>();
        retornaTodos();
        
    }
    
    public String cadastrar(){
        estadoRepositorio.cadastrar(this.estado);
        retornaTodos();
        return "";
    }
    
    public String excluir(){
        estadoRepositorio.excluir(this.estado);
        retornaTodos();
        return "";
    }
    
    public void abrirEditar(){
        
    }
    
    public void carregarSiglas(){
        siglas.add("PE");
        siglas.add("PB");
        siglas.add("BA");
        siglas.add("RN");
        siglas.add("AL");
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the siglas
     */
    public ArrayList<String> getSiglas() {
        return siglas;
    }

    /**
     * @param siglas the siglas to set
     */
    public void setSiglas(ArrayList<String> siglas) {
        this.siglas = siglas;
    }
    
    public void retornaTodos(){        
        this.setEstados(estadoRepositorio.retornaTodos()); 
    }

    /**
     * @return the estados
     */
    public List<Estado> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    
}
