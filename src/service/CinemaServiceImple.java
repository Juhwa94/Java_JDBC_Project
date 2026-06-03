package service;

import java.util.List;

import dao.CinemaDaoImple;
import dao.CinemaDaoInter;
import vo.CinemaVO;

public class CinemaServiceImple implements CinemaServiceInter{

	@Override
	public void addData(CinemaVO vo) {
		CinemaDaoInter dao = new CinemaDaoImple();
		dao.save(vo);
	}

	@Override
	public List<CinemaVO> getListData() {
		CinemaDaoInter dao = new CinemaDaoImple();
		return dao.findAll();
	}

	@Override
	public void cinemaAdjust(CinemaVO vo) {
		CinemaDaoInter dao = new CinemaDaoImple();
		dao.cinemaUpdate(vo);
	}

	@Override
	public void cinemaRemove(CinemaVO vo) {
		CinemaDaoInter dao = new CinemaDaoImple();
		dao.cinemaDelete(vo);
	}

}
