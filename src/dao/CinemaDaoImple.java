package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.CinemaVO;

public class CinemaDaoImple implements CinemaDaoInter {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "mytess2";
	private String pwd = "mytess2";

	@Override
	public void save(CinemaVO vo) {
		String sql = "insert into cinema values(cinema_seq.NEXTVAl, ?, ?, ?, sysdate, ?, ?)";
		try (Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getDir());
			pstmt.setString(3, vo.getGen());
			pstmt.setString(4, vo.getCont());
			pstmt.setInt(5, vo.getTnum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CinemaVO> findAll() {
		List<CinemaVO> myList = new ArrayList<CinemaVO>();
		String sql = "select title, dir, gen, rdate, cont, tnum from cinema order by 1 desc";
		try (Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CinemaVO v = new CinemaVO();
				v.setTitle(rs.getString("title"));
				v.setDir(rs.getString("dir"));
				v.setGen(rs.getString("gen"));
				v.setRdate(rs.getString("rdate"));
				v.setCont(rs.getString("cont"));
				v.setTnum(rs.getInt("tnum"));
				// myList에 저장
				// CinemaVO를 저장할 공간이 필요 -> List<MyDataVO>
				myList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myList;
	}

	@Override
	public void cinemaUpdate(CinemaVO vo) {
		String sql = "update cinema set title = ?, dir = ?, gen = ?, cont =?" + "where cnum = ?";
		try (Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getDir());
			pstmt.setString(3, vo.getGen());
			pstmt.setString(4, vo.getCont());
			pstmt.setInt(5, vo.getCnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cinemaDelete(CinemaVO vo) {
		String sql = "delete from cinema where cnum = ?";
		try (Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, vo.getCnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}