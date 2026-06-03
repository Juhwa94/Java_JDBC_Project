package dao;

import java.util.List;

import vo.CinemaVO;
import vo.TicketVO;

public interface TicketDaoInter {

	public void save(TicketVO vo);
	public List<TicketVO> findAll();
	public void ticketUpdate(TicketVO vo);
	public void ticketDelete(TicketVO vo);
}
