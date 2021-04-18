package com.airiline.tickets.repository.impl;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.flight.SearchFlightRequest;
import com.airiline.tickets.repository.SearchFlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchFlightRepositoryImpl implements SearchFlightRepository {

    private final EntityManager em;

    @Override
    public PageResponse<Flight> searchByCriteria(SearchFlightRequest searchFlightRequest, int page, int size) {
        var offset = page * size;
        var limit = offset + size;
        var criteriaBuilder = em.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Flight.class);
        var root = criteriaQuery.from(Flight.class);
        var predicates = getPredicates(searchFlightRequest, criteriaBuilder, root);

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        var flightTypedQuery = em.createQuery(criteriaQuery);
        flightTypedQuery.setFirstResult(offset);
        flightTypedQuery.setMaxResults(limit);

        return new PageResponse<>(page, size,
                count(criteriaBuilder, predicates), flightTypedQuery.getResultList());
    }

    private List<javax.persistence.criteria.Predicate> getPredicates(SearchFlightRequest searchFlightRequest,
                                                                     CriteriaBuilder criteriaBuilder, Root<Flight> flightRoot) {
        var predicates = new ArrayList<Predicate>();
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (searchFlightRequest.getId() != null)
            predicates.add(criteriaBuilder.equal(flightRoot.get("id"), searchFlightRequest.getId()));

        if (searchFlightRequest.getTicketPrice() != null)
            predicates.add(criteriaBuilder.equal(flightRoot.get("ticketPrice"), searchFlightRequest.getTicketPrice()));

        if (searchFlightRequest.getDepartureCity() != null)
            predicates.add(criteriaBuilder.equal(flightRoot.get("departureAirport").get("city"), searchFlightRequest.getDepartureCity()));

        if (searchFlightRequest.getArrivalCity() != null)
            predicates.add(criteriaBuilder.equal(flightRoot.get("arrivalAirport").get("city"), searchFlightRequest.getArrivalCity()));

        if (searchFlightRequest.getDepartureDate() != null)
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.function("TO_CHAR", String.class, flightRoot.get("departureDate"),
                            criteriaBuilder.literal("yyyy-MM-dd")),
                            dateFormat.format(searchFlightRequest.getDepartureDate())));

        if (searchFlightRequest.getArrivalDate() != null)
            predicates.add(
                    criteriaBuilder.equal(criteriaBuilder.function("TO_CHAR", String.class, flightRoot.get("arrivalDate"),
                            criteriaBuilder.literal("yyyy-MM-dd")),
                            dateFormat.format(searchFlightRequest.getArrivalDate())));

        return predicates;
    }

    private long count(CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
        var countQuery = criteriaBuilder.createQuery(Long.class);
        var root = countQuery.from(Flight.class);

        countQuery.select(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[0]));

        return em.createQuery(countQuery).getSingleResult();
    }
}
