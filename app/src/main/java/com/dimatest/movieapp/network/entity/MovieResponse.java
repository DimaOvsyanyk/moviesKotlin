package com.dimatest.movieapp.network.entity;

import com.squareup.moshi.Json;

import java.util.List;

public class MovieResponse {

    @Json(name = "result")
    private List<Movie> result;
    @Json(name = "page")
    private Integer page;
    @Json(name = "total_results")
    private Long total_results;
    @Json(name = "total_pages")
    private Integer total_pages;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> result, Integer page, Long total_results, Integer total_pages) {
        this.result = result;
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }

    public List<Movie> getResult() {
        return result;
    }

    public void setResult(List<Movie> result) {
        this.result = result;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Long total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
}
