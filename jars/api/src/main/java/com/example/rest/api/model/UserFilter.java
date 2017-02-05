package com.example.rest.api.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 * Created by turisto on 05/02/2017.
 */
public class UserFilter {
    /**
     * Default page size.
     */
    private static final long DEFAULT_PAGE_SIZE = 10L;

    /**
     * Page number to query.
     */
    @QueryParam("f")
    @DefaultValue("0")
    private Long first = 0L;

    /**
     * Page size to query.
     */
    @QueryParam("p")
    @DefaultValue("10")
    private Long pageSize = DEFAULT_PAGE_SIZE;

    /**
     * @return the first
     */
    public Long getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Long first) {
        this.first = first;
    }

    /**
     * @return the pageSize
     */
    public Long getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
