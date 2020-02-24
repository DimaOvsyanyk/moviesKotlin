package com.dimatest.movieapp.network.entity;

import com.dimatest.movieapp.database.entity.MovieDO;
import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    @Json(name = "popularity")
    private Double popularity;
    @Json(name = "vote_count")
    private Integer voteCount;
    @Json(name = "video")
    private Boolean video;
    @Json(name = "poster_path")
    private String posterPath;
    @Json(name = "id")
    private Long id;
    @Json(name = "adult")
    private Boolean adult;
    @Json(name = "backdrop_path")
    private String backdropPath;
    @Json(name = "original_language")
    private String originalLanguage;
    @Json(name = "original_title")
    private String originalTitle;
    @Json(name = "genre_ids")
    private List<Integer> genreIds = null;
    @Json(name = "title")
    private String title;
    @Json(name = "vote_average")
    private Double voteAverage;
    @Json(name = "overview")
    private String overview;
    @Json(name = "release_date")
    private String releaseDate;

    public Movie() {
    }

    public Movie(Double popularity, Integer voteCount, Boolean video, String posterPath, Long id,
                 Boolean adult, String backdropPath, String originalLanguage, String originalTitle,
                 List<Integer> genreIds, String title, Double voteAverage, String overview, String releaseDate) {
        super();
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.posterPath = posterPath;
        this.id = id;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NotNull
    @Override
    public String toString() {
        return "Movie{" +
                "popularity=" + popularity +
                ", voteCount=" + voteCount +
                ", video=" + video +
                ", posterPath='" + posterPath + '\'' +
                ", id=" + id +
                ", adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", genreIds=" + genreIds +
                ", title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    private MovieDO mapToMovieDO() {
        return new MovieDO(popularity, voteCount, video, posterPath, id, adult, backdropPath,
                originalLanguage, originalTitle, getGenreIdsString(), title, voteAverage, overview, releaseDate);
    }

    private String getGenreIdsString() {
        StringBuilder newGenreIds = new StringBuilder();
        for (int i = 0; i < genreIds.size(); i++) {
            if (i > 0) {
                newGenreIds.append(",");
            }
            newGenreIds.append(id);
        }
        return newGenreIds.toString();
    }
}
