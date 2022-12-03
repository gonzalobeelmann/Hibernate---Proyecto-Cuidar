package dao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Localidad;
import datos.Ubicacion;

public class LugarDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}	

	private void manejaExcepcion(HibernateException he) throws HibernateException{		
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Ubicacion traerUbicacion(int id) throws HibernateException {
		Ubicacion ubicacion = null;
		try {
			this.iniciaOperacion();
			ubicacion = session.get(Ubicacion.class, id);
		} finally {
			session.close();
		}
		return ubicacion;
	}
	
	public Localidad traerLocalidad(int id) throws HibernateException {
		Localidad localidad = null;
		try {
			this.iniciaOperacion();
			localidad = session.get(Localidad.class, id);
		} finally {
			session.close();
		}
		return localidad;
	}
	
	
	
}
