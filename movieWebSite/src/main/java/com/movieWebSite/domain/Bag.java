package com.movieWebSite.domain;

//
/*
 * 가방. 관람객의 소지품으로는 티켓 또는 초대장이 있고 초대장이 없을 때 구매할 돈이 있다.
 * */
public class Bag {
	private long amount;
	private Invitation invitation;
	private Ticket ticket;
/*
 * 초대장 유무, 티켓 유무, 티켓 구매, 구매시 현금 변화 메서드가 있다.
 * */
	public boolean hasInvitation() {
		return invitation !=null;
	}
	
	public boolean hasTicket() {
		return ticket != null;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void minusAmount(long amount) {
		this.amount -=amount;
	}
	
	public void plusAmount(long amount) {
		this.amount +=amount;
	}

	
/*
 * 가방에는 초대장과 현금, 초대장 없이 현금만 있는 경우 두 가지 상태가 있을 수 있다.(티켓 구매 안한 상태) 이를 생성자로 표현한다.
 * */
	public Bag(long amount, Invitation invitation) {
		this.amount = amount;
		this.invitation = invitation;
	}
	
}


