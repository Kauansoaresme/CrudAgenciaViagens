package crud;

import java.util.Scanner;

import br.com.crud.dao.VooDAO;
import br.com.crud.model.Voo;

public class VooCRUD {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		VooDAO vooDAO = new VooDAO();
		
		int escolha = 0, id = 0;
		
		String origem = "",destino = "";
				
		do {
			
			System.out.println("========================= OPÇÕES =============================");
			System.out.println("1-CRIAR 2-CONSULTAR 3- ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
			escolha = entrada.nextInt();
			entrada.nextLine();
			
			switch (escolha) {
			
			case 1:
				System.out.println("========================= CRIAR =============================");
				System.out.println("Origem: ");
				origem = entrada.nextLine();
				System.out.println("Destino: ");
				destino = entrada.nextLine();

				
				Voo voo1 = new Voo(origem,destino);
				
				vooDAO.create(voo1); 
				break;
			case 2:
				System.out.println("========================= CONSULTA =============================");
				for(Voo c : vooDAO.read()) {
					System.out.println(c.toString());
				}
				vooDAO.read();
				break;
			case 3:
				System.out.println("========================= ATUALIZAR =============================");
				System.out.println("ID:");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Origem");
				origem = entrada.nextLine();
				System.out.println("Destino");
				destino = entrada.nextLine();

				Voo voo2 = new Voo(id, origem, destino);
				
				vooDAO.update(voo2); 
				break;
			case 4:
				System.out.println("===================== DELETAR ==========================");
				System.out.println("ID");
				id = entrada.nextInt();
				entrada.nextLine();
				
				vooDAO.delete(id);
				break;
			case 5:
				System.out.println("===================== CONSULTA POR ID ==========================");
				System.out.println("ID");
				id = entrada.nextInt();
				entrada.nextLine();
				
				Voo voo3 = vooDAO.readById(id);
				
				System.out.println(voo3.toString());
				
				vooDAO.readById(id);
				break;
			default:
				
				break;
			}
			
		}while (escolha != 0);
		
		System.out.println("VOLTE SEMPRE!");
		entrada.close();

	}

}