package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import cl.cnr.aplicacion.capa_aplicacion_ejemplo.dao.DAOProducto;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Categoria;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Producto;

@Stateful
@RequestScoped
@Named("pcontroller")
public class ProductoControllerImpl implements ProductoController {

	@Inject
	private Logger log;

	@Inject
	private FacesContext facesContext;

	@Inject
	private DAOProducto productoDao;

	@Inject
	@HttpParam("producto_id")
	private String id;
	
	private Producto producto;

	@Override
	@Produces
	@Named("productos")
	public List<Producto> listar() {
		log.info("getProductos(): Recuperamos el listado de productos");
		return productoDao.obtenerProductos();
	}
	
	@Produces
	@Named("producto")
	@Override
	public Producto detalle(@New Producto productoDefecto) {
		log.info("getProducto(): Recuperamos de la BD el producto con ID: " + id);

		try {
			Integer productoId = Integer.valueOf(id);
			this.producto = productoDao.obtenerProductoPorId(productoId);
		} catch(NumberFormatException e) {
			this.producto = productoDefecto;
		}

		return this.producto;
	}

	@Override
	public String guardar() {
		if (producto.getId() != null && producto.getId() > 0) {
			facesContext.addMessage(null, new FacesMessage("Producto "
					+ producto.getDescripcion() + " ha sido actualizado!"));
		} else {
			facesContext.addMessage(null, new FacesMessage("Nuevo Producto "
					+ producto.getDescripcion() + " ha sido creado!"));
		}

		productoDao.guardarProducto(producto);

		return "home.xhtml?faces-redirect=true";
	}

	@Override
	public String eliminar() {
		Integer productoId = Integer.valueOf(id);
		if (productoId != null && productoId.intValue() > 0) {
			producto = productoDao.obtenerProductoPorId(productoId.intValue());
			productoDao.eliminarProducto(producto);
			facesContext.addMessage(null, new FacesMessage("Producto: "
					+ producto.getDescripcion() + " ha sido eliminado!"));
		}
		return "eliminar";
	}

	@Produces
	@Named("categorias")
	@Override
	public List<Categoria> produceCategorias() {
		// TODO Auto-generated method stub
		return productoDao.obtenerCategorias();
	}

}
