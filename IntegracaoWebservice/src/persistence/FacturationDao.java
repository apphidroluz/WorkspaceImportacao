package persistence;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Facturation;


public class FacturationDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void gravar(Facturation fac) throws Exception{
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(fac);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			HibernateUtil.fechar_conexao(session);

		}
		
	}
	
	
	public List<Facturation> findFact(String Hidro)throws HibernateException,SQLException{
		List<Facturation> lista = null;
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Facturation as f where f.num_medidor= '" + Hidro + "'");
			lista = query.list();
			query.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.fechar_conexao(session);
		}
		
		
		
		return lista;
		
	}
	
	public List<Facturation> findFac(String facturation) throws HibernateException, SQLException {
		List<Facturation> lista = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			lista = session.createQuery("from Facturation as f where f.id_FT= " + facturation).list();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			HibernateUtil.fechar_conexao(session);

		}
		return lista;

	}

}
