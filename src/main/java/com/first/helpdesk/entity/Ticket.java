package com.first.helpdesk.entity;
import jakarta.persistence.*;

@Entity
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name="customer_id")//ci is foreign key to connect ticket and user
    private Category category;
    private User customer;
    @ManyToOne
    @JoinColumn(name="agent_id")
    private User agent;
    public enum TicketStatus{
        OPEN,
        ASSIGNED,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }
    public enum Priority{
        LOW,
        MEDIUM,
        HIGH
    }
    private TicketStatus ticketStatus;
    private Priority priority;

    public Ticket(){

    }
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
public User getCustomer(){
        return customer;
}
public void setCustomer(User customer){
        this.customer=customer;
}
public User getAgent(){
        return agent;
}
public void setAgent(User agent){
        this.agent=agent;
}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}