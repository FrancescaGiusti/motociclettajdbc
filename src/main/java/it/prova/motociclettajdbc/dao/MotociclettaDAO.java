package it.prova.motociclettajdbc.dao;

import it.prova.motociclettajdbc.model.Motocicletta;
import it.prova.motociclettajdbc.connection.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotociclettaDAO {
    //insert
    public int insert(Motocicletta input){
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            connection = MyConnection.getConnection();
            ps = connection.prepareStatement("INSERT INTO motocicletta (marca, modello, cilindrata, dataimmatricolazione)" +"VALUES (?,?,?,?)");
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            ps.setInt(3, input.getCilindrata());
            ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

	// findAll
	public List<Motocicletta> findAll() {
		Connection connection = null;
		ResultSet rs = null;
		Statement s = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {
			connection = MyConnection.getConnection();
			s = connection.createStatement();
			rs = s.executeQuery("select * from motocicletta;");

			while (rs.next()) {
				temp = new Motocicletta();
                temp.setId(rs.getLong("id"));
                temp.setMarca(rs.getString("marca"));
                temp.setModello(rs.getString("modello"));
                temp.setCilindrata(rs.getInt("cilindrata"));
                temp.setDataImmatricolazione(rs.getDate("dataimmatricolazione"));
				result.add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

    //Delete
    public int delete(Long idElementToDelete) {

		if (idElementToDelete == null || idElementToDelete < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("DELETE from motocicletta where id=?;");
			ps.setLong(1, idElementToDelete);
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

    //Find by id
    public Motocicletta findById(Long input) {

		if (input == null || input < 1) {
			return null;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta result = null;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("select * from motocicletta u where u.id=?;");
			ps.setLong(1, input);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Motocicletta();
                result.setId(rs.getLong("id"));
                result.setMarca(rs.getString("marca"));
                result.setModello(rs.getString("modello"));
                result.setCilindrata(rs.getInt("cilindrata"));
                result.setDataImmatricolazione(rs.getDate("dataimmatricolazione"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// update
	public int update(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("UPDATE motocicletta SET marca=?, modello=?, "
                    + "cilindrata=?, dataimmatricolazione=? where id=?;");
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
            ps.setInt(3, input.getCilindrata());
			ps.setDate(4, new Date(input.getDataImmatricolazione().getTime()));
			ps.setLong(5, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}

