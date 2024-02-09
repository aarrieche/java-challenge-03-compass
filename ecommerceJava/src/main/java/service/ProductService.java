package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Product;

public class ProductService {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("ecommerce");

    public static void listProducts() {
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
    
    public static void createProducts(Product product) {
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
    
    public static Product searchProductByName(String productName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            // JPQL query to select a product by name
            Query query = em.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class);
            query.setParameter("nome", productName);
            Product product = (Product) query.getSingleResult();
            em.getTransaction().commit();
            return product;
        } catch (NoResultException e) {
            System.out.println("Não encontrado produto com nome '" + productName + "'.");
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public static void updateProduct(Long productId, String newName, String newDescription, double newValue, int newQuantity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, productId);
            if (product != null) {
                if (newName != null) product.setName(newName);
                if (newDescription != null) product.setDescription(newDescription);
                if (newValue != 0) product.setValue(newValue);
                if (newQuantity != 0) product.setQuantity(newQuantity);
                em.getTransaction().commit();
                System.out.println("Produto com ID " + productId + " atualizado com sucesso.");
            } else {
                System.out.println("Produto com ID  " + productId + " não encontrado.");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public static void deleteProduct(Long productId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, productId);
            if (product != null) {
                em.remove(product);
                em.getTransaction().commit();
                System.out.println("Produto com ID  " + productId + " deletado com sucesso.");
            } else {
                System.out.println("Produto com ID  " + productId + " não encontrado.");
            }
        } finally {
            em.close();
            emf.close();
        }
    }


    
}
