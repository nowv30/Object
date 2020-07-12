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
	
	/*
	 * 2. 기존에 enter 아래 로직을 티켓판매원이 가져갔다.
	 * 이제 가저간 로직을 호출하는 메소드만 간단하게 작성한다. 
	 * */
	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}
