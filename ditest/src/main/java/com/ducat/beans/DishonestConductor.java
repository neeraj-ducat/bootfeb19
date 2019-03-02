package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DishonestConductor extends Conductor {

	//dependency of the conductor
	@Autowired
	private Ticket ticket;
	
	@Override
	public Ticket getTicket() {
		
		return ticket;
	}

}
