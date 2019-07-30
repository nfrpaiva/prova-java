package br.com.tokiomarine.prova.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contato {

    public Contato() {
        super();
    }

    public Contato(long id, String nome, String telefone) {
        this.id = id;
        this.nome =  nome;
        this.telefone = telefone;
	}

	@Id
    private Long id;
    private String nome;
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + "]";
    }

    

}