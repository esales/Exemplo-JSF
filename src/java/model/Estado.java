package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado implements Serializable{
    @Id
    private String sigla;
    
    @Column(name = "descricao")
    private String nome;
    
    public Estado(){
        
    }
    
    public Estado(String sigla, String nome){
        this.sigla = sigla;
        this.nome = nome;
    }
    
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
