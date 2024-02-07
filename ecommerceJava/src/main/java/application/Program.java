package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Category;

public class Program {

	public static void main(String[] args) {
		
		Category c1 = new Category(null, "aluminum");

		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("ecommerce");
		EntityManager em = enf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		
		System.out.println(c1);
		System.out.println("Teste");
		
	}

}
