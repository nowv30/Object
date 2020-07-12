package com.movieWebSite.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//매표소에는 판매할 티켓과 티켓의 판매 금액이 보관되어 있다.
public class TicketOffice {
	private long amount;
	private List<Ticket> tickets = new ArrayList<>();
	
/*
 * 티켓을 판매하는 getTicket은 편의를 위해 tickets 컬랙션에서 맨 첫 번째 위치에 저장된 Ticket을 반환한다.
 * 판매금액을 더하거나 빼는 메서드 구현
 * */
	public TicketOffice(long amount, Ticket ...tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets));
	}
	
	public Ticket getTicket() {
		return tickets.remove(0);
	}
	
	public void minusAmount(long amount) {
		this.amount -=amount;
	}
	
	public void plusAmount(long amount) {
		this.amount +=amount;
	}
}
