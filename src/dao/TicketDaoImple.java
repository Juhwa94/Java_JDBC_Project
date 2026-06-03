package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.CinemaVO;
import vo.TicketVO;

public class TicketDaoImple implements TicketDaoInter {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "mytess2";
	private String dbpwd = "mytess2";

	@Override
	public void save(TicketVO vo) {
		String sql = "insert into ticket values(ticket_seq.NEXTVAl, ?, ?, ?, sysdate, ?)";
		try (Connection con = DriverManager.getConnection(url, user, dbpwd);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, vo.getHcount());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getTotal());
			pstmt.setInt(4, vo.getCnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TicketVO> findAll() {
		String sql = "SELECT hcount, price, total, rtime, cnum" + " FROM Ticket ORDER BY 1 DESC";
		List<TicketVO> mv = new ArrayList<TicketVO>();
		try (Connection con = DriverManager.getConnection(url, user, dbpwd);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				TicketVO vo = new TicketVO();
				vo.setHcount(rs.getInt("hcount"));
				vo.setPrice(rs.getInt("price"));
				vo.setTotal(rs.getInt("total"));
				vo.setRtime(rs.getString("rtime"));
				vo.setCnum(rs.getInt("cnum"));
				mv.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public void ticketUpdate(TicketVO vo) {
		String sql = "update ticket set hcount=?, price=?, total=?, cnum=?"
				+ "where num =?";
		try (
				Connection con = DriverManager.getConnection(url, user, dbpwd);
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1,  vo.getHcount());
			pstmt.setInt(2,  vo.getPrice());
			pstmt.setInt(3,  vo.getTotal());
			pstmt.setInt(4,  vo.getCnum());
			pstmt.setInt(5,  vo.getNum());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ticketDelete(TicketVO vo) {
		String sql = "delete from ticket where num = ?";
		try (
				Connection con = DriverManager.getConnection(url, user, dbpwd);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
