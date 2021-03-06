package com.movieWebSite.domain;

//티켓판매원은 초대장을 티켓을 교환하거나 티켓을 판매하는 역할을 한다.
//판매원은 자신이 일하는 매표소 위치를 알아야 한다.
public class TicketSeller {
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
	
//	1-1. 이 메소드를 제거함으로 TIcketSeller 이외에 다른 클래스에서 TicketOffice에 직접 접근할 수 없다.
//	public TicketOffice getTicketOffice() {
//		return ticketOffice;
//	}
	
	//1-2. 기존에 Theater.enter(Audience audience)에 있던 로직을 가져왔다.
	//이제 티켓판매원이 판매를 직접 관리한다.
	public void sellTo(Audience audience) {
	//3-2. 아래 로직을 Audience로 이동한다. 이제 Audience의 buy 메소드 이외에 다른 정보를 알지 못한다.	
//		if(audience.getBag().hasInvitation()) {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().setTicket(ticket);
//		}else {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().minusAmount(ticket.getFee());
//			ticketOffice.plusAmount(ticket.getFee());
//			audience.getBag().setTicket(ticket);
//		}
		//3-3.audience의 buy메소드의 리턴값인 Long타입을 받아 ticketOffice의 amount를 추가한다.
		//역시 audience의 내부를 알지 못한다.
		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
		
	}
}
