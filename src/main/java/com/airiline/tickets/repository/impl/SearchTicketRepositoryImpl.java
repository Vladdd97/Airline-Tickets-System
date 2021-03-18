package com.airiline.tickets.repository.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.SearchTicketRequest;
import com.airiline.tickets.repository.SearchTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchTicketRepositoryImpl implements SearchTicketRepository {

    private final EntityManager em;

    @Override
    public List<Ticket> searchByCriteria(SearchTicketRequest searchTicketRequest) {
        var criteriaBuilder = em.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        var root = criteriaQuery.from(Ticket.class);
        var predicates = getPredicates(searchTicketRequest, criteriaBuilder, root);

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery(criteriaQuery);

        return ticketTypedQuery.getResultList();
    }


    private List<javax.persistence.criteria.Predicate> getPredicates(SearchTicketRequest searchTicketRequest,
                                                                     CriteriaBuilder criteriaBuilder, Root<Ticket> ticketRoot) {
        var predicates = new ArrayList<Predicate>();

        if (searchTicketRequest.getPrice() != null)
            predicates.add(criteriaBuilder.equal(ticketRoot.get("price"), searchTicketRequest.getPrice()));

        if (searchTicketRequest.getSeatNumber() != null)
            predicates.add(criteriaBuilder.equal(ticketRoot.get("seatNumber"), searchTicketRequest.getSeatNumber()));

        if (searchTicketRequest.getTravelClass() != null)
            predicates.add(criteriaBuilder.equal(ticketRoot.get("travelClass"), searchTicketRequest.getTravelClass()));

        if (searchTicketRequest.getStatus() != null)
            predicates.add(criteriaBuilder.equal(ticketRoot.get("status"), searchTicketRequest.getStatus()));


        return predicates;
    }
}
