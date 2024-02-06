package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import domain.Category;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int option=0;

		Category c1 = new Category(1, "aluminum");
		System.out.println(c1);

		String url = "jdbc:postgresql://localhost:5432/Ecommerce";
        String user = "PostgresSQL";
        String password = "1234";
  
		while (option != 6) {
		
			try {
				System.out.println("Digite uma opção: 1- Listar produtos; 2- Buscar produto; 3- Cadastrar produto; 4- Atualizar produto; 5 - Excluir produto; 6 - sair;");
				option = in.nextInt();
				switch (option) {
					case 1:
						String sql = "SELECT * FROM products";
						while (rs.next()) {
							try (
								Connection conn = DriverManager.getConnection(url, user, password);
								
								Statement stmt = conn.createStatement();
								
								ResultSet rs = stmt.executeQuery(sql)
							) {
								while (rs.next()) {
									int id = rs.getInt("id");
									String name = rs.getString("name");
									System.out.println("ID: " + id + ", Name: " + name);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						break;
					case 2:
						try (
      			            Connection conn = DriverManager.getConnection(url, user, password);
							PreparedStatement pstmt = conn.prepareStatement(sql)
						) {
						pstmt.setString(1, productName);
							
							try (ResultSet rs = pstmt.executeQuery()) {
								
								if (rs.next()) {
									int id = rs.getInt("id");
									String name = rs.getString("name");
									String description = rs.getString("description");
									double value = rs.getDouble("value");
									int quantity = rs.getInt("quantity");
									int categoryId = rs.getInt("Categories_id");
									
									System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description + ", Value: " + value + ", Quantity: " + quantity + ", Category ID: " + categoryId);
								} else {
									System.out.println("Nenhum produto encontrado com o nome '" + productName + "'.");
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case 3:
						
						break;
					case 4:
						
						break;
					case 5:
						
						break;					
					
					default:
						break;
				}

			}
			catch (NumberFormatException e) {
				System.out.println("Erro, digite apenas números.");
			}
		}
		in.close();

	}
}
