package com.movieWebSite;

import com.movieWebSite.domain.Audience;
import com.movieWebSite.domain.Ticket;
import com.movieWebSite.domain.TicketSeller;

//극장에는 티켓 판매원이 반드시 있어야 하므로 생성자로 표시한다.
public class Theater {
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller=ticketSeller;
	}
//관객이 극장에 입장할 때 초대장의 유무를 확인한다.
//초대장이 있으면 티켓판매원이 매표소에서 티켓을 꺼내고 관람객은 티켓을 받는다.
//초대장이 없으면 티켓판매원이 티켓을 꺼내고 관람객은 가방에서 금액을 티켓가격만큼 지불한다.
//판매원은 매표소에 티켓 가격만큼의 금액을 추가하고 관람객은 티켓을 받는다.
	public void enter(Audience audience) {
		if(audience.getBag().hasInvitation()) {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);
		}else {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().minusAmount(ticket.getFee());
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
			audience.getBag().setTicket(ticket);
		}
	}
}
