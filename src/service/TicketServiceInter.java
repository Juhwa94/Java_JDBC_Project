package service;

import java.util.List;

import vo.CinemaVO;
import vo.TicketVO;

public interface TicketServiceInter {

	public void addData(TicketVO vo);
	public List<TicketVO> getListData();
	public void ticketAdjust(TicketVO vo);
	public void ticketRemove(TicketVO vo);
}
