package crud;

import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.dao.PassagemDAO;
import br.com.crud.dao.VooDAO;
import br.com.crud.model.Cliente;
import br.com.crud.model.Voo;
import br.com.crud.model.Passagem;

public class PassagemCRUD {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		PassagemDAO passagemDAO = new PassagemDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		VooDAO vooDAO = new VooDAO();
		
		int escolha = 0, id = 0, id_cliente = 0; 
		
		
		do {
			
			System.out.println("\n============================== OPÇÕES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			escolha = entrada.nextInt();
			entrada.nextLine();
			
			switch (escolha) {
			case 1:
				System.out.println("\n============================== CRIAR =================================\n");
				System.out.println("Classe:");
				String classe = entrada.nextLine();
				System.out.println("Preço:");
				double preco = entrada.nextDouble();
				entrada.nextLine();
				System.out.println("ID Cliente:");
				id_cliente = entrada.nextInt();
				entrada.nextLine();
				System.out.println("ID Voo:");
				int id_voo = entrada.nextInt();
				entrada.nextLine();
				
				Cliente cliente1 = clienteDAO.readById(id_cliente);
				Voo voo1 = vooDAO.readById(id_voo);
				
				
				Passagem passagem1 = new Passagem(classe, preco, cliente1, voo1);
				
				
				passagemDAO.create(passagem1);
				break;
			case 2:
				System.out.println("\n============================== CONSULTAR =================================\n");
				for (Passagem c : passagemDAO.read()) {
					
					System.out.println(c.toString());
					
				}
				
				break;
			case 3:
				System.out.println("\n============================== ATUALIZAR =================================\n");
				System.out.println("ID:");
				id = entrada.nextInt();
				entrada.nextLine();				
				System.out.println("Classe:");
				classe = entrada.nextLine();
				System.out.println("Preço:");
				preco = entrada.nextDouble();
				entrada.nextLine();
				System.out.println("ID Cliente:");
				int id_cliente2 = entrada.nextInt();
				entrada.nextLine();
				System.out.println("ID Voo:");
				int id_voo2 = entrada.nextInt();
				entrada.nextLine();
				
				Cliente cliente2 = clienteDAO.readById(id_cliente2);
				Voo voo2 = vooDAO.readById(id_voo2);
				
				
				Passagem passagem2 = new Passagem(id, classe ,preco, cliente2, voo2);
				
				passagemDAO.update(passagem2);
				break;
			case 4:
				System.out.println("\n============================== DELETAR =================================\n");
				System.out.println("ID:");
				id = entrada.nextInt();
				entrada.nextLine();
				
				passagemDAO.delete(id);
				break;
			case 5:
				System.out.println("===================== CONSULTA POR ID ==========================");
				System.out.println("ID:");
				id = entrada.nextInt();
				entrada.nextLine();
				
				Passagem passagem3 = passagemDAO.readById(id);
				
				System.out.println(passagem3.toString());
				break;
			default:
				System.out.println(escolha != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (escolha != 0);
		
		System.out.println("Até mais!");
		entrada.close();
	}

}