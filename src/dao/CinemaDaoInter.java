package dao;

import java.util.List;

import vo.CinemaVO;

public interface CinemaDaoInter {

	public void save(CinemaVO vo);
	public List<CinemaVO> findAll();
	public void cinemaUpdate(CinemaVO vo);
	public void cinemaDelete(CinemaVO vo);
}
