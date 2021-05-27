package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "viajes")
public class viaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private Long id;
	
	
	@Column (name= "id_Cliente")
	private Long id_Cliente;
	@Column (name="id_Piloto")
	private Long id_Piloto;
	@Column (name ="origen")
	private String origen;
	@Column (name= "destino")
	private String destino;
	@Column (name= "estado")
	private String estado;
	@Column (name= "monto")
	private int monto;
	

	public Long getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(Long id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public Long getId_Piloto() {
		return id_Piloto;
	}
	public void setId_Piloto(Long id_Piloto) {
		this.id_Piloto = id_Piloto;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	} 
	
	
	
	
}
