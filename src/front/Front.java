package front;

import java.util.List;
import java.util.Scanner;

import service.CinemaServiceImple;
import service.CinemaServiceInter;
import service.TicketServiceImple;
import service.TicketServiceInter;
import vo.CinemaVO;
import vo.TicketVO;

public class Front {
	private Scanner sc;
	private CinemaServiceInter cinemainter;
	private TicketServiceInter ticketinter;

	public Front() {
		sc = new Scanner(System.in);
		cinemainter = new CinemaServiceImple();
		ticketinter = new TicketServiceImple();
	}

	public void startApp() {
		ext1: while (true) {
			System.out.print("관리 대상 : 1. 영화 관리 , 2. 티켓 관리 , 3.관리프로그램 종료 => ");
			int category = Integer.parseInt(sc.nextLine());
			switch (category) {
			case 1:
				ext2: while (true) {
					System.out.print("관리 코드 입력 : 1. 등록, 2. 조회, 3. 수정, 4. 삭제" + " 5. 종료 => ");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
					case 1:
						CinemaVO vi = new CinemaVO();
						System.out.print("제목을 입력해주세요 => ");
						vi.setTitle(sc.nextLine());
						System.out.print("감독을 입력해주세요 => ");
						vi.setDir(sc.nextLine());
						System.out.print("장르를 입력해주세요 => ");
						vi.setGen(sc.nextLine());
						System.out.print("내용을 입력해주세요 => ");
						vi.setCont(sc.nextLine());
						System.out.print("상영관 번호를 입력해주세요 => ");
						vi.setTnum(Integer.parseInt(sc.nextLine()));
						cinemainter.addData(vi);
						break;
					case 2:
						List<CinemaVO> clist = cinemainter.getListData();
						for (CinemaVO e : clist) {
							System.out.println("제목 : " + e.getTitle());
							System.out.println("내용 : " + e.getCont());
							System.out.println("작성자 : " + e.getDir());
							System.out.println("장르 : " + e.getGen());
							System.out.println("등록날짜 : " + e.getRdate());
							System.out.println("상영관 번호 : " + e.getTnum());
							System.out.println("---------------------------------");
						}
						break;
					case 3:
						CinemaVO vu = new CinemaVO();
						System.out.print("상영 영화 일련 번호를 입력해주세요 => ");
						vu.setCnum(Integer.parseInt(sc.nextLine()));
						System.out.print("제목을 입력해주세요 => ");
						vu.setTitle(sc.nextLine());
						System.out.print("감독을 입력해주세요 => ");
						vu.setDir(sc.nextLine());
						System.out.print("장르를 입력해주세요 => ");
						vu.setGen(sc.nextLine());
						System.out.print("내용을 입력해주세요 => ");
						vu.setCont(sc.nextLine());
						System.out.print("상영관 번호를 입력해주세요 => ");
						vu.setTnum(Integer.parseInt(sc.nextLine()));
						cinemainter.cinemaAdjust(vu);
						break;
					case 4:
						System.out.println("삭제할 영화의 일련번호를 입력하세요 => ");
						CinemaVO vd = new CinemaVO();
						vd.setCnum(Integer.parseInt(sc.nextLine()));
						cinemainter.cinemaRemove(vd);
						break;
					case 5:
						break ext2;

					default:
						break;
					}
				}
				break;
			case 2:
				ext3: while (true) {

					System.out.print("관리 코드 입력 : 1. 등록, 2. 조회, 3. 수정, 4. 삭제" + " 5. 종료 => ");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
					case 1:
						TicketVO vi = new TicketVO();
						System.out.print("인원수 : ");
						vi.setHcount(Integer.parseInt(sc.nextLine()));
						System.out.print("개당가격 : ");
						vi.setPrice(Integer.parseInt(sc.nextLine()));
						System.out.print("총가격 : ");
						vi.setTotal(Integer.parseInt(sc.nextLine()));
						System.out.print("상영 영화 일련 번호 : ");
						vi.setCnum(Integer.parseInt(sc.nextLine()));
						ticketinter.addData(vi);
						break;
					case 2:
						List<TicketVO> tlist = ticketinter.getListData();
						for (TicketVO e : tlist) {
							System.out.println("인원수 : " + e.getHcount());
							System.out.println("개당 가격 : " + e.getPrice());
							System.out.println("총가격 : " + e.getTotal());
							System.out.println("구매날짜 : " + e.getRtime());
							System.out.println("상영 영화 일련 번호 : " + e.getCnum());
							System.out.println("---------------------------------");
						}
						break;
					case 3:
						TicketVO vu = new TicketVO();
						System.out.print("티켓 일련 번호 : ");
						vu.setNum(Integer.parseInt(sc.nextLine()));
						System.out.print("인원수 : ");
						vu.setHcount(Integer.parseInt(sc.nextLine()));
						System.out.print("개당 가격 : ");
						vu.setPrice(Integer.parseInt(sc.nextLine()));
						System.out.print("총가격 : ");
						vu.setTotal(Integer.parseInt(sc.nextLine()));
						System.out.print("상영 영화 일련 번호 : ");
						vu.setCnum(Integer.parseInt(sc.nextLine()));
						ticketinter.ticketAdjust(vu);
						break;
					case 4:
						System.out.println("삭제할 티켓의 일련번호를 입력하세요 => ");
						TicketVO vd = new TicketVO();
						System.out.print("티켓 일련 번호 : ");
						vd.setNum(Integer.parseInt(sc.nextLine()));
						ticketinter.ticketRemove(vd);
						break;
					case 5:
						break ext3;

					default:
						break;

					}

				}
				break;
			case 3:
				System.out.println("관리프로그램을 종료합니다.");
				break ext1;
			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		Front ref = new Front();
		ref.startApp();
	}

}