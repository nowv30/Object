package com.movieWebSite.domain;

//관람객은 소지품을 보관할 가방을 소지한다.
public class Audience {
	private Bag bag;
	

	public Bag getBag() {
		return bag;
	}
	
	//3-1. TicketSeller의 SellTo 메소드의 로직을 Audience가 직접 수행한다.
	//   Audience 스스로 Bag의 내용물을 확인하고 다른 곳에서 알지 못하게 한다.
	public Long buy(Ticket ticket) {
		if(bag.hasInvitation()) {
			bag.setTicket(ticket);
			return 0L;
		} else {
			bag.setTicket(ticket);
			bag.minusAmount(ticket.getFee());
			return ticket.getFee();
		}		
	}
}
