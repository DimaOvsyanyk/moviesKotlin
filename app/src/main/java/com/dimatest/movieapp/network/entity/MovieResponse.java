package com.dimatest.movieapp.network.entity;

import com.dimatest.movieapp.ui.movieList.models.MoviePagedData;
import com.squareup.moshi.Json;

import java.util.List;

public class MovieResponse {

    @Json(name = "results")
    private List<Movie> result;
    @Json(name = "page")
    private Integer page;
    @Json(name = "total_results")
    private Long totalResults;
    @Json(name = "total_pages")
    private Integer totalPages;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> result, Integer page, Long totalResults, Integer totalPages) {
        this.result = result;
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
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

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public MoviePagedData mapToPagedData() {
        return new MoviePagedData(page, totalResults, totalPages);
    }
}
