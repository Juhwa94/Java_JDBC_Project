package service;

import java.util.List;

import dao.TicketDaoImple;
import dao.TicketDaoInter;
import vo.CinemaVO;
import vo.TicketVO;

public class TicketServiceImple implements TicketServiceInter{

	@Override
	public void addData(TicketVO vo) {

		TicketDaoInter dao = new TicketDaoImple();
		dao.save(vo);
	}

	@Override
	public List<TicketVO> getListData() {
		TicketDaoInter dao = new TicketDaoImple();
		return dao.findAll();
	}

	@Override
	public void ticketAdjust(TicketVO vo) {
		TicketDaoInter dao = new TicketDaoImple();
		dao.ticketUpdate(vo);
	}

	@Override
	public void ticketRemove(TicketVO vo) {
		TicketDaoInter dao = new TicketDaoImple();
		dao.ticketDelete(vo);
	}

}
