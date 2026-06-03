package service;

import java.util.List;

import vo.CinemaVO;

public interface CinemaServiceInter {

	public void addData(CinemaVO vo);
	public List<CinemaVO> getListData();
	public void cinemaAdjust(CinemaVO vo);
	public void cinemaRemove(CinemaVO vo);
}
