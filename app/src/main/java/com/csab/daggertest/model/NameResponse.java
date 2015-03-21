package com.csab.daggertest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NameResponse {

    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("objects")
    @Expose
    private List<Name> names = new ArrayList<>();
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    /**
     *
     * @return
     * The numResults
     */
    public Integer getNumResults() {
        return numResults;
    }

    /**
     *
     * @param numResults
     * The num_results
     */
    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    /**
     *
     * @return
     * The objects
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     *
     * @param names
     * The objects
     */
    public void setNames(List<Name> names) {
        this.names = names;
    }

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
