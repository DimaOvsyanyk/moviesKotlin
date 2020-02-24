package com.dimatest.movieapp.database.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "movies")
public class MovieDO {

    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private String posterPath;
    @PrimaryKey
    private Long id;
    private Boolean adult;
    private String backdropPath;
    private String originalLanguage;
    private String originalTitle;
    private String genreIds;
    private String title;
    private Double voteAverage;
    private String overview;
    private String releaseDate;

    public MovieDO() {
    }

    @Ignore
    public MovieDO(Double popularity, Integer voteCount, Boolean video, String posterPath, Long id,
                   Boolean adult, String backdropPath, String originalLanguage, String originalTitle,
                   String genreIds, String title, Double voteAverage, String overview, String releaseDate) {
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

    public String getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(String genreIds) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDO movieDO = (MovieDO) o;
        return Objects.equals(getPopularity(), movieDO.getPopularity()) &&
                Objects.equals(getVoteCount(), movieDO.getVoteCount()) &&
                Objects.equals(getVideo(), movieDO.getVideo()) &&
                Objects.equals(getPosterPath(), movieDO.getPosterPath()) &&
                getId().equals(movieDO.getId()) &&
                Objects.equals(getAdult(), movieDO.getAdult()) &&
                Objects.equals(getBackdropPath(), movieDO.getBackdropPath()) &&
                Objects.equals(getOriginalLanguage(), movieDO.getOriginalLanguage()) &&
                Objects.equals(getOriginalTitle(), movieDO.getOriginalTitle()) &&
                Objects.equals(getGenreIds(), movieDO.getGenreIds()) &&
                Objects.equals(getTitle(), movieDO.getTitle()) &&
                Objects.equals(getVoteAverage(), movieDO.getVoteAverage()) &&
                Objects.equals(getOverview(), movieDO.getOverview()) &&
                Objects.equals(getReleaseDate(), movieDO.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPopularity(), getVoteCount(), getVideo(), getPosterPath(), getId(), getAdult(), getBackdropPath(), getOriginalLanguage(), getOriginalTitle(), getGenreIds(), getTitle(), getVoteAverage(), getOverview(), getReleaseDate());
    }
}
