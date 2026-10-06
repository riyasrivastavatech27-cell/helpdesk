package com.first.helpdesk.service;
import com.first.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.first.helpdesk.entity.Ticket;
import java.util.List;
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public Ticket getTicketById(int id){
        return ticketRepository.findById(id).orElseThrow();
    }
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public Ticket updateTicket(int id,Ticket updatedTicket){
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(updatedTicket.getTicketStatus());
        ticket.setTitle(updatedTicket.getTitle());
        ticket.setAgent(updatedTicket.getAgent());
        ticket.setCustomer(updatedTicket.getCustomer());
        ticket.setPriority(updatedTicket.getPriority());
        ticket.setCategory(updatedTicket.getCategory());
        return ticket;
    }
    public void deleteTicket(int id){
        ticketRepository.deleteById(id);
    }
}
