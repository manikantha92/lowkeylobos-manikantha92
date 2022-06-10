package com.directtv.lowkeylobos.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Metadata {

	private String resourceType;
	private String itemType;
	private String title;
	private String description;
	private String metadataLanguage;
	private List<String> genres;
	private List<Season> seasons;
	private String parentalRating;
	private Augmentation augmentation;
	private List<String> categories;
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMetadataLanguage() {
		return metadataLanguage;
	}
	public void setMetadataLanguage(String metadataLanguage) {
		this.metadataLanguage = metadataLanguage;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<Season> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}
	public String getParentalRating() {
		return parentalRating;
	}
	public void setParentalRating(String parentalRating) {
		this.parentalRating = parentalRating;
	}
	public Augmentation getAugmentation() {
		return augmentation;
	}
	public void setAugmentation(Augmentation augmentation) {
		this.augmentation = augmentation;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getProgramAttribution() {
		return programAttribution;
	}
	public void setProgramAttribution(String programAttribution) {
		this.programAttribution = programAttribution;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getDisplayTitle() {
		return displayTitle;
	}
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}
	public String getOriginalAirDate() {
		return originalAirDate;
	}
	public void setOriginalAirDate(String originalAirDate) {
		this.originalAirDate = originalAirDate;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCcId() {
		return ccId;
	}
	public void setCcId(String ccId) {
		this.ccId = ccId;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	private String programAttribution;
	@Id
	private String resourceId;
	private String contentType;
	private String displayTitle;
	private String originalAirDate;
	private String releaseYear;
	private String name;
	private String ccId;
	private String marketId;
	
}
