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
