package cl.cnr.aplicacion.capa_aplicacion_ejemplo;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProducerResources {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;
    
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    @HttpParam
    public String produceHttpParam(InjectionPoint ip) {
        String name = ip.getAnnotated().getAnnotation(HttpParam.class).value();
        if ("".equals(name)) name = ip.getMember().getName();

        return FacesContext.getCurrentInstance().getExternalContext()
        .getRequestParameterMap()
        .get(name);
    }
    
    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	facesContext.getExternalContext().getFlash().setKeepMessages(true);
        return facesContext;
    }
}