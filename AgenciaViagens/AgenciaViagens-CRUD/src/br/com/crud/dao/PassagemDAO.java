package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;
import br.com.crud.model.Voo;
import br.com.crud.model.Passagem;

public class PassagemDAO {

	// create
	public void create(Passagem passagem) {

		String sql = "insert into passagem (classe, preco, id_cliente, id_voo) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getClasse());
			pstm.setDouble(2, passagem.getPreco());
			pstm.setInt(3, passagem.getCliente().getId());
			pstm.setInt(4, passagem.getVoo().getId());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// read
	public List<Passagem> read() {
		List<Passagem> passagems = new ArrayList<>();
		String sql = "SELECT * FROM passagem " + "INNER JOIN voo ON passagem.id_voo = voo.id_voo "
				+ "INNER JOIN cliente ON passagem.id_cliente = cliente.id_cliente";

		try (Connection conn = ConnectionFactory.createConnectionToMySQL();
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rset = pstm.executeQuery()) {

			while (rset.next()) {
				Passagem passagem = new Passagem();
				Voo voo = new Voo();
				Cliente cliente = new Cliente();

				passagem.setId(rset.getInt("id_passagem"));
				passagem.setClasse(rset.getString("classe"));
				passagem.setPreco(rset.getDouble("preco"));

				voo.setId(rset.getInt("id_voo"));
				voo.setOrigem(rset.getString("origem"));
				voo.setDestino(rset.getString("destino"));

				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setCelular(rset.getString("celular"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getString("senha"));

				passagem.setVoo(voo);
				passagem.setCliente(cliente);

				passagems.add(passagem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return passagems;
	}

	// update
	public void update(Passagem passagem) {

		String sql = "UPDATE passagem SET classe = ?, preco = ?, id_cliente = ?, id_voo = ? WHERE id_passagem = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getClasse());
			pstm.setDouble(2, passagem.getPreco());
			pstm.setInt(3, passagem.getCliente().getId());
			pstm.setInt(4, passagem.getVoo().getId());
			pstm.setInt(5, passagem.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Passagem WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readbyid
	public Passagem readById(int id) {
		Passagem passagem = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			String sql = "SELECT passagem.*, voo.origem, voo.destino, cliente.* " + "FROM Passagem "
					+ "INNER JOIN Voo ON Passagem.id_voo = Voo.id_voo "
					+ "INNER JOIN Cliente ON Passagem.id_cliente = Cliente.id_cliente "
					+ "WHERE Passagem.id_passagem = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				passagem = new Passagem();
				Voo voo = new Voo();
				Cliente cliente = new Cliente();

				passagem.setId(rset.getInt("id_passagem"));
				passagem.setClasse(rset.getString("classe"));
				passagem.setPreco(rset.getDouble("preco"));

				voo.setId(rset.getInt("id_voo"));
				voo.setOrigem(rset.getString("origem"));
				voo.setDestino(rset.getString("destino"));

				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setCelular(rset.getString("celular"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getString("senha"));

				passagem.setCliente(cliente);
				passagem.setVoo(voo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return passagem;
	}
}
