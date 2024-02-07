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
		
		int option =0;
		while (option != 6) {
		
			try {
				System.out.println("Digite uma opção: 1- Listar produtos; 2- Buscar produto; 3- Cadastrar produto; 4- Atualizar produto; 5 - Excluir produto; 6 - sair;");
				option = in.nextInt();
			}
			catch (NumberFormatException e) {
				System.out.println("Erro, digite apenas números.");
			} 
			
			switch (option) {
				case 1:
					System.out.println("1- Listar produtos:");
				
					break;
				case 2:
					System.out.println("2- Buscar produto:");
				
					break;
				case 3:
					System.out.println("3- Cadastrar produto:");
				
					break;
				case 4:
					System.out.println("4- Atualizar produto:");
				
					break;
				case 5:
					System.out.println("5 - Excluir produto:");
				
					break;					
				
				default:
					break;
			}
		}	
	}

}
