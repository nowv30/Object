# Object
책 오브젝트 예제 정리

## 티켓 판매 프로그램 로직
![너무많은 클래스에 의존하는 Theater](https://github.com/nowv30/Object/blob/master/images/%EC%A3%BC%EC%84%9D%202020-07-12%20143244.png "너무많은 클래스에 의존하는 Theater")
- 영화관에서 영화를 상영하는데 관람객은 받은 초대장을 티켓으로 교환하거나 매표소에서 직원에게 티켓을 구매해야 한다.
```java
//1. 초대장에는 초대 날짜 변수가 있다.
public class Invitation {
	
	private LocalDateTime when;
}

//2. 티켓에는 티켓요금과 요금을 나타내는 매소드가 있다.
public class Ticket {
	private long fee;

	public long getFee() {
		return fee;
	}
}

/*
 * 3. 가방. 관람객의 소지품으로는 티켓 또는 초대장이 있고 초대장이 없을 때 구매할 돈이 있다.
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

//4. 관람객은 소지품을 보관할 가방을 소지한다.
public class Audience {
	private Bag bag;
	
	public Bag getBag() {
		return bag;
	}
}

//5. 매표소에는 판매할 티켓과 티켓의 판매 금액이 보관되어 있다.
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

//6. 티켓판매원은 초대장을 티켓을 교환하거나 티켓을 판매하는 역할을 한다.
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

//7. 극장에는 티켓 판매원이 반드시 있어야 하므로 생성자로 표시한다.
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

```

![너무많은 클래스에 의존하는 Theater](https://github.com/nowv30/Object/blob/master/images/%EC%A3%BC%EC%84%9D%202020-07-12%20143244.png "너무많은 클래스에 의존하는 Theater")
- 이대로 프로그램을 구현하면 문제없이 동작할 것이다.
- 그러나 이 프로그램은 기능은 정상적이나 변경 용이성과 읽는 사람과의 의사소통에 문제가 있다.

