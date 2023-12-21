package crud;

import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;

public class ClienteCRUD {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int escolha = 0, id = 0;
		
		String nome = "",cpf = "",celular = "", email = "", senha = "";
				
		do {
			
			System.out.println("========================= OPÇÕES =============================");
			System.out.println("1-CRIAR 2-CONSULTAR 3- ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
			escolha = entrada.nextInt();
			entrada.nextLine();
			
			switch (escolha) {
			
			case 1:
				System.out.println("========================= CRIAR =============================");
				System.out.println("Nome: ");
				nome = entrada.nextLine();
				System.out.println("CPF: ");
				cpf = entrada.nextLine();
				System.out.println("Celular: ");
				celular = entrada.nextLine();
				System.out.println("Email: ");
				email = entrada.nextLine();
				System.out.println("Senha: ");
				senha = entrada.nextLine();
				
				Cliente cliente1 = new Cliente(nome,cpf,celular, email, senha);
				
				clienteDAO.create(cliente1); 
				break;
			case 2:
				System.out.println("========================= CONSULTA =============================");
				for(Cliente c : clienteDAO.read()) {
					System.out.println(c.toString());
				}
				clienteDAO.read();
				break;
			case 3:
				System.out.println("========================= ATUALIZAR =============================");
				System.out.println("ID:");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Nome");
				nome = entrada.nextLine();
				System.out.println("CPF");
				cpf = entrada.nextLine();
				System.out.println("Celular");
				celular = entrada.nextLine();
				System.out.println("Email");
				email = entrada.nextLine();
				System.out.println("Senha");
				senha = entrada.nextLine();
				
				Cliente cliente2 = new Cliente(id, nome, cpf, celular, email, senha);
				
				clienteDAO.update(cliente2); 
				break;
			case 4:
				System.out.println("===================== DELETAR ==========================");
				System.out.println("ID");
				id = entrada.nextInt();
				entrada.nextLine();
				
				clienteDAO.delete(id);
				break;
			case 5:
				System.out.println("===================== CONSULTA POR ID ==========================");
				System.out.println("ID");
				id = entrada.nextInt();
				entrada.nextLine();
				
				Cliente cliente3 = clienteDAO.readById(id);
				
				System.out.println(cliente3.toString());
				
				clienteDAO.readById(id);
				break;
			default:
				
				break;
			}
			
		}while (escolha != 0);
		
		System.out.println("VOLTE SEMPRE!");
		entrada.close();

	}

}
