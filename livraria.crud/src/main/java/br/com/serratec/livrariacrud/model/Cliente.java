package br.com.serratec.livrariacrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Integer idade;
	
	@NotNull
	private String sexo;
	
	@NotNull
	private String estadoCivil;
	
	@NotNull
	private String profissao;
	
	@NotNull
	private Integer cpfOuCnpj;
	
	public Cliente(
			Long id, 
			String nome, 
			Integer idade, 
			String sexo, 
			String estadoCivil,
			String profissao,
			Integer cpfOuCnpj) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.profissao = profissao;
		this.cpfOuCnpj = cpfOuCnpj;
	}

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
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public Integer getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	
	public void setCpfOuCnpj(Integer cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
}