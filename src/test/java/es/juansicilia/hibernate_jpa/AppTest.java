package es.juansicilia.hibernate_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.juansicilia.entities.SimpleObject;
import es.juansicilia.utils.EntityManagerUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private EntityManager em;



	   public void testAutoIncrement()
	   {
		  em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      transaction.begin();

	      SimpleObject object0 = new SimpleObject();
	      SimpleObject object1 = new SimpleObject();

	      // IDs start as null
	      Assert.assertEquals( null, object0.getId());
	      Assert.assertEquals( null, object1.getId());

	      em.persist(object0);
	      em.persist(object1);

	      transaction.commit();

	      System.out.println("Object 0");
	      System.out.println("Generated ID is: " + object0.getId());
	      System.out.println("Generated Version is: " + object0.getVersion());

	      System.out.println("Object 1");
	      System.out.println("Generated ID is: " + object1.getId());
	      System.out.println("Generated Version is: " + object1.getVersion());

	      Assert.assertEquals( 1l, object0.getId());
	      Assert.assertEquals( 2l, object1.getId());
	      em.close();
	   }
}
