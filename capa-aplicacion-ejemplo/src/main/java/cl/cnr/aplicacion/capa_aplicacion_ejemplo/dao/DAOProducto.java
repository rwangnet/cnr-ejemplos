package cl.cnr.aplicacion.capa_aplicacion_ejemplo.dao;

import java.util.List;

import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Categoria;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Producto;

public interface DAOProducto {
	public List<Producto> obtenerProductos();
	public Producto obtenerProductoPorId(Integer _id);
	public void guardarProducto(Producto producto);
	public void eliminarProducto(Producto producto);
	public List<Categoria> obtenerCategorias();
	public Categoria obtenerCategoriaPorId(int id);
}
