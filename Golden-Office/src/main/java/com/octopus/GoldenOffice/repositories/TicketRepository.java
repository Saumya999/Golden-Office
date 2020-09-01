package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
