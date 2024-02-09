package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Product;

public class ProductService {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("ecommerce");

    public static void listProduct() {
        EntityManager em = enf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Product p");
        @SuppressWarnings("unchecked")
        List<Product> products = query.getResultList();

        em.getTransaction().commit();

        for (Product product : products) {
            System.out.println(product);
        }

        em.close();
    }
    
    public static void createProduct(Product product) {
        EntityManager em = enf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(product);
            transaction.commit();
            System.out.println("Produto criado com sucesso.");
            
        {
            em.close();
        }
    }
    
}
