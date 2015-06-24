package cl.cnr.aplicacion.capa_aplicacion_ejemplo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Categoria;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Producto;

@Stateless
@Named("productoDao")
public class DAOProductoImpl implements DAOProducto {

	@Inject
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> obtenerProductos() {
		return entityManager.createQuery("from Producto").getResultList();
	}

	@Override
	public Producto obtenerProductoPorId(Integer _id) {
		return entityManager.find(Producto.class, _id);
	}

	@Override
	public void guardarProducto(Producto producto) {
		if (producto.getId() != null && producto.getId() > 0) {
			entityManager.merge(producto);
		} else {
			entityManager.persist(producto);
		}

	}

	@Override
	public void eliminarProducto(Producto producto) {
		entityManager.remove(producto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> obtenerCategorias() {
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria obtenerCategoriaPorId(int _id) {
		return entityManager.find(Categoria.class, _id);
	}

}
