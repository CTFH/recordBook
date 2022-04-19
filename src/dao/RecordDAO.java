package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.RecordBook;

public class RecordDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/gcp");
		this.db = ds.getConnection();
	}

	private void disconnect()  {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ConnectCheck() {
		try {
			this.connect();
			System.out.println("OK");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public void insertOne(RecordBook recordBook) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO record(r_date, content, price)VALUES(?,?,?)");
			ps.setString(1, recordBook.getDate());
			ps.setString(2, recordBook.getContent());
			ps.setInt(3, recordBook.getPrice());
			ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public List<RecordBook>findAll(){
		List<RecordBook> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM record");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String date = rs.getString("r_date");
				String content = rs.getString("content");
				int price = rs.getInt("price");
				list.add(new RecordBook(id, date, content, price));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}

	public RecordBook findOne(int id) {
		RecordBook rb = null;
			try {
				this.connect();
				ps=db.prepareStatement("SELECT *FROM record WHERE id=?");
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					String date = rs.getString("r_date");
					String content = rs.getString("content");
					int price = rs.getInt("price");
					rb=new RecordBook(id, date, content, price);
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		return rb;
	}

	public void updateOne(RecordBook rb) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE record SET r_date=?, content=?, price=? WHERE id=?");
			ps.setString(1,  rb.getDate());
			ps.setString(2,  rb.getContent());
			ps.setInt(3,  rb.getPrice());
			ps.setInt(4, rb.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM record WHERE id=?");
			ps.setInt(1,  id);
			ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

}
