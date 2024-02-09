package application;

import java.util.Scanner;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
  
            int option = 0;
            while (option != 7) {
                try {
                    System.out.println("Digite uma opção: 1- Listar produtos; 2- Buscar produto; 3- Cadastrar produto; 4- Atualizar produto; 5 - Excluir produto; 6 - Listar categorias; 7 - sair;");
                    option = in.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Erro, digite apenas números.");
                    in.nextLine();
                }

                switch (option) {
                    case 1:
                        System.out.println("1- Listar produtos:");
                     
                        service.ProductService.listProduct();
                     
                        break;
                    case 2:
                        System.out.println("2- Buscar produto:");
                        break;
                    case 3:
                        System.out.println("3- Cadastrar produto:");
                        System.out.println("Digite o nome do produto:");
                        String productName = in.next();
                        System.out.println("Digite a descrição do produto:");
                        String productDescription = in.next();
                        System.out.println("Digite o valor do produto:");
                        double productValue = in.nextDouble();
                        System.out.println("Digite a quantidade do produto:");
                        int productQuantity = in.nextInt();
                        System.out.println("Digite o ID da categoria do produto:");
                        int categoryId = in.nextInt();
                        Category category = CategoryService.findCategoryById(categoryId);
                        if (category != null) {
                            Product product = new Product(productName, productDescription, productValue, productQuantity, category);
                            ProductService.createProducts(product);
                        } else {
                            System.out.println("Categoria não encontrada.");
                        }
                        break;
                    case 4:
                        System.out.println("4- Atualizar produto:");
                        break;
                    case 5:
                        System.out.println("5 - Excluir produto:");
                        break;
                    case 6:
                        System.out.println("5 - Listar categorias:");
                        CategoryService.listCategories();
                        break;
                    case 7:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } finally {
            in.close();
        }
        
    }
}
