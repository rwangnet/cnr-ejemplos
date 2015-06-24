package cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	private String nombre;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id.toString();
	}

	@Override
	public boolean equals(Object obj) {

		final Categoria other = (Categoria) obj;

		//System.out.println("other.getId(): " + other.getId());
		//System.out.println("this: " + id);
		if (getId().equals(other.getId())) {
			return true;
		}

		return false;
	}
}
