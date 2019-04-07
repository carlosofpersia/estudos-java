package br.com.bo;

import java.io.Serializable;
import java.util.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

import br.com.entities.Eventos;

public class GerenciarEventos implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7718277712864309921L;

	public void salvarEvento( String evento, Date dataHora ) {
		try {

			/***********/
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addClass(br.com.entities.Eventos.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
			Session s = sf.openSession();
			/***********/

			Transaction tx = s.beginTransaction();

			Eventos ev = new Eventos();
			ev.setEvento(evento);
			ev.setDataHora(new Date());
			s.saveOrUpdate(ev);

			tx.commit();
			s.close();

			System.out.println("Success: Sucesso ao incluir evento");

		} catch (Exception x ) {
			System.out.println("Error: Erro ao incluir evento");
		}
	}

	public List<br.com.entities.Eventos> listarEventos()
    {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addClass(br.com.entities.Eventos.class);

		ServiceRegistry registro = new StandardServiceRegistryBuilder()
				.applySettings( configuration.getProperties() ).build();

		SessionFactory sf = configuration.buildSessionFactory(registro);
		Session sess = sf.openSession();

		try {
			sess.beginTransaction();
			@SuppressWarnings("unchecked")
			List<br.com.entities.Eventos> eventos = (List<br.com.entities.Eventos>) sess.createQuery("from br.com.entities.Eventos").list();

			System.out.println(eventos.size());

			sess.getTransaction().commit();

			return eventos;
		}
		catch (HibernateException e)
		{
			e.getMessage();
			System.err.println("Hibernate Exception" + e.getMessage());
			throw new RuntimeException(e.getMessage());
		} catch (Throwable ex) {

			//List<Eventos> eventos = new ArrayList<Eventos>();

            System.err.println("A fábrica de sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex.getMessage());
        }
		finally
		{
			if (sess != null)
			{
				try
				{
					sess.close();
				}
				catch (HibernateException e)
				{
					System.err.println("Hibernate Exception" + e.getMessage());
					throw new RuntimeException(e);
				}
			}
		}
		
		
    }
}
