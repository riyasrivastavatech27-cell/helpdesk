package com.first.helpdesk.repository; //repository connects to the database

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.helpdesk.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    //Ticket-Entity we are working with,Int-the id is int
}
