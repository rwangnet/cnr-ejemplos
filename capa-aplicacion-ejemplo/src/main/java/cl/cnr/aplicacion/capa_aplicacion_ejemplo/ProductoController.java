package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import java.util.List;

import javax.ejb.Local;

import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Categoria;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Producto;

@Local
public interface ProductoController {
	public List<Producto> listar();

	public Producto detalle(Producto productoDefecto);

	public String guardar();

	public String eliminar();

	public List<Categoria> produceCategorias();
}
