package es.juansicilia.hibernate_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import es.juansicilia.entities.SimpleObject;
import es.juansicilia.utils.EntityManagerUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	
	final static Logger logger = Logger.getLogger(App.class);
	
	
    public static void main( String[] args )
    {
    	EntityManager em;
    	em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    SimpleObject object0 = null;
	    SimpleObject object1 = null;
	    object0 = new SimpleObject();
	    object1 = new SimpleObject();
	    object0.setVersion(1);
	    object1.setVersion(2);
	    em.merge(object0);
	    em.merge(object1);
	    transaction.commit();
	    em.close();
    	
    	logger.debug("Is running!");
        System.out.println( "Hello World!" );
    }
}
