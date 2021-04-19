package com.airiline.tickets.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private int pageNumber;
    private int pageSize;
    private int numberOfElements;
    private long totalElements;
    private boolean first;
    private boolean last;
    private List<T> content;

    public PageResponse(int pageNumber, int pageSize, long totalElements, List<T> content) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.numberOfElements = content.size();
        this.totalElements = totalElements;
        this.content = content;
        this.first = pageNumber == 0;
        this.last = (long) (pageNumber + 1) * pageSize >= totalElements;
    }

    private PageResponse(int pageNumber, int pageSize, int numberOfElements, long totalElements,
                         boolean first, boolean last, List<T> content) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.numberOfElements = numberOfElements;
        this.totalElements = totalElements;
        this.first = first;
        this.last = last;
        this.content = content;
    }

    public static <T, V> PageResponse<V> createPageResponse(PageResponse<T> fromPageResponse, List<V> newContent) {

        return new PageResponse<>(fromPageResponse.getPageNumber(), fromPageResponse.getPageSize(),
                fromPageResponse.getNumberOfElements(), fromPageResponse.getTotalElements(),
                fromPageResponse.isFirst(), fromPageResponse.isLast(), newContent);
    }

    public static <T, V> PageResponse<V> createPageResponse(Page<T> fromPage, List<V> newContent) {

        return new PageResponse<>(fromPage.getPageable().getPageNumber(), fromPage.getPageable().getPageSize(),
                fromPage.getNumberOfElements(), fromPage.getTotalElements(),
                fromPage.isFirst(), fromPage.isLast(), newContent);
    }
}
