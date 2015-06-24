package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cl.cnr.aplicacion.capa_aplicacion_ejemplo.dao.DAOProducto;
import cl.cnr.aplicacion.capa_aplicacion_ejemplo.entities.Categoria;


@RequestScoped
@Named("categoriaConverter")
public class CategoriaConverter implements Converter{

	@Inject
	private DAOProducto productoDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if(value == null){
			return null;
		}
		return productoDao.obtenerCategoriaPorId(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if(value == null){
			return "0";
		}
		return ((Categoria) value).getId().toString();
	}

}
