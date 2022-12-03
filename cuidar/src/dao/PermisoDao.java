package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;
	
public class PermisoDao {

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
	
	public Permiso traerPermiso(int id) throws HibernateException {
		Permiso permiso = null;
		try {
			this.iniciaOperacion();
			String query = "from Permiso as p inner join fetch p.rodado as r inner join fetch p.persona as per where p.idPermiso = " + id;
			permiso = (Permiso) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return permiso;
	}

}
