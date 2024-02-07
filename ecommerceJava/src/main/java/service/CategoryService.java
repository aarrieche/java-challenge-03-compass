package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Category;

public class CategoryService {

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("ecommerce");

    public static void listCategories() {
        EntityManager em = enf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Category p");
        @SuppressWarnings("unchecked")
        List<Category> categories = query.getResultList();

        em.getTransaction().commit();

        for (Category category : categories) {
            System.out.println(category);
        }

        em.close();
    }

}
