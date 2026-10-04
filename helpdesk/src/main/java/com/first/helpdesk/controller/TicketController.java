package com.first.helpdesk.controller;
import  com.first.helpdesk.service.TicketService;
import org.springframework.web.bind.annotation.*;
import com.first.helpdesk.entity.Ticket;
import java.util.List;
@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    public TicketController (TicketService ticketService){
        this.ticketService=ticketService;
    }
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable int id){
        return ticketService.getTicketById(id);
    }
    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        ticketService.deleteTicket(id);
    }
@PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable int id,@RequestBody Ticket ticket){
        return ticketService.updateTicket(id,ticket);
}
}
