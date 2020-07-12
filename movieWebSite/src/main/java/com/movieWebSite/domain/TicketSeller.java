package com.movieWebSite.domain;

//티켓판매원은 초대장을 티켓을 교환하거나 티켓을 판매하는 역할을 한다.
//판매원은 자신이 일하는 매표소 위치를 알아야 한다.
public class TicketSeller {
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
	public TicketOffice getTicketOffice() {
		return ticketOffice;
	}
}
