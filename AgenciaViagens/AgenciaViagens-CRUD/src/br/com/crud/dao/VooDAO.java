package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Voo;

public class VooDAO {

	// create
	public void create(Voo voo) {

		String sql = "insert into Voo (origem, destino) values (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, voo.getOrigem());
			pstm.setString(2, voo.getDestino());

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
	public List<Voo> read() {
		List<Voo> voo = new ArrayList<Voo>();
		String sql = "SELECT * FROM Voo;";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Voo voos = new Voo();
				voos.setId(rset.getInt("id_voo"));
				voos.setOrigem(rset.getString("origem"));
				voos.setDestino(rset.getString("destino"));


				voo.add(voos);

			}

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

		return voo;
	}

	// update
	public void update(Voo voo) {

		String sql = "UPDATE Voo SET origem = ?, destino = ? WHERE id_voo = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, voo.getDestino());
			pstm.setString(2, voo.getOrigem());
			pstm.setInt(3, voo.getId());

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
		String sql = "DELETE FROM Voo WHERE id_voo = ?";

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

	// readById
	public Voo readById(int id) {

		Voo voo = new Voo();

		String sql = "SELECT * FROM Voo WHERE id_voo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			voo.setId(rset.getInt("id_voo"));
			voo.setOrigem(rset.getString("origem"));
			voo.setDestino(rset.getString("destino"));

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

		return voo;
	}
}