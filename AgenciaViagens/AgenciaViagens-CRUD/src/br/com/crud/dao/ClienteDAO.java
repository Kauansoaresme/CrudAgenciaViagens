package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;

public class ClienteDAO {

	//create
	public void create(Cliente cliente) {
		
		String sql = "insert into Cliente (nome, cpf, celular, email, senha) values (?, ?, ? ,? , ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getCelular());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSenha());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace ();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	
	//read
	public List<Cliente> read() {
		List<Cliente> cliente = new ArrayList<Cliente>();
		String sql = "SELECT * FROM Cliente;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
						
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente clientes = new Cliente();
				
				clientes.setId(rset.getInt("id_cliente"));
				clientes.setNome(rset.getString("nome"));
				clientes.setCpf(rset.getString("cpf"));
				clientes.setCelular(rset.getString("celular"));
				clientes.setEmail(rset.getString("email"));
				clientes.setSenha(rset.getString("senha"));
				
				cliente.add(clientes);
				
			}
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		return cliente;
	}
	
	//update
	public void update(Cliente cliente) {
		
String sql = "UPDATE Cliente SET nome = ?, cpf = ?, celular = ?, email = ?, senha = ? WHERE id_cliente = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {
						
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getCelular());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSenha());
			pstm.setInt(6,  cliente.getId());
			
			pstm.execute();
		
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	}
	
	//delete
	public void delete(int id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
						
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		
	}
	
	//readById
	public Cliente readById(int id) {
		
		Cliente cliente = new Cliente();
		
	String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
						
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setCelular(rset.getString("celular"));
			cliente.setEmail(rset.getString("email"));
			cliente.setSenha(rset.getString("senha"));
			
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		return cliente;
	}
}