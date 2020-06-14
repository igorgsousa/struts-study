package br.com.igorgsousa.config.plugins;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

public class HibernatePlugin implements PlugIn {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	private static Class clazz = HibernatePlugin.class;

	public static final String KEY_NAME = clazz.getName();

	@Override
	public void init(ActionServlet servlet, ModuleConfig modConfig) throws ServletException {

		try {

			this.entityManagerFactory = Persistence.createEntityManagerFactory("default_entity_manager");
			this.entityManager = this.entityManagerFactory.createEntityManager(); // Retrieve an application managed
																					// entity manager
			// save the Hibernate session factory into serlvet context
			servlet.getServletContext().setAttribute(KEY_NAME, this.entityManager);

		} catch (MappingException e) {
			throw new ServletException();
		} catch (HibernateException e) {
			throw new ServletException();
		}

	}

	@Override
	public void destroy() {
		try {
			this.entityManagerFactory.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}