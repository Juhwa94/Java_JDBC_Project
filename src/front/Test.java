package front;

import java.util.List;

import service.CinemaServiceImple;
import service.CinemaServiceInter;
import service.TicketServiceImple;
import service.TicketServiceInter;
import vo.CinemaVO;
import vo.TicketVO;

public class Test {
	private CinemaServiceInter cinemainter;
	private TicketServiceInter ticketinter;

	public Test() {
		cinemainter = new CinemaServiceImple();
		ticketinter = new TicketServiceImple();
	}

	public void startApp() {

//		CinemaVO vo = new CinemaVO();
//		vo.setTitle("제목1");
//		vo.setDir("감독1");
//		vo.setGen("장르1");
//		vo.setCont("내용1");
//		vo.setTnum(1);
//		cinemainter.addData(vo);

//		List<CinemaVO> clist = cinemainter.getListData();
//	    for (CinemaVO e : clist) {
//	        System.out.println("내용 : " + e.getCont());
//	        if(e.getCont().equals("내용1")) {
//	            System.out.println("조회 테스트 성공");
//	        }
//	    }

//		CinemaVO vo = new CinemaVO();
//        vo.setTitle("제목a");
//        vo.setDir("감독a");
//        vo.setGen("장르a");
//        vo.setCont("내용a");
//        vo.setTnum(77);
//        vo.setCnum(1);
//        cinemainter.cinemaAdjust(vo);

//		CinemaVO vo = new CinemaVO();
//        vo.setCnum(1);
//        cinemainter.cinemaRemove(vo);

//		TicketVO v1 = new TicketVO();
//		v1.setHcount(2);
//		v1.setPrice(10000);
//		v1.setTotal(20000);
//		v1.setCnum(10);
//		ticketinter.addData(v1);
		
//		List<TicketVO> tlist = ticketinter.getListData();
//		for (TicketVO e : tlist) {
//			System.out.println("인원수 : " + e.getHcount());
//			if (e.getHcount() == 2) {
//				System.out.println("조회 테스트 성공");
//			}
//		}
		
//		TicketVO v1 = new TicketVO();
//        v1.setHcount(4);
//        v1.setPrice(8000);
//        v1.setTotal(32000);
//        v1.setCnum(10);
//        v1.setNum(1); // DB 확인 하실때 6번 확인해주세요
//        ticketinter.ticketAdjust(v1);
		
		TicketVO v1 = new TicketVO();
        v1.setNum(1);
        ticketinter.ticketRemove(v1);
        
	}
	
	

	public static void main(String[] args) {
		Test ref = new Test();
		ref.startApp();
	}
}
