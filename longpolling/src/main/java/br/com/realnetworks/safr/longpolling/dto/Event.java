package br.com.realnetworks.safr.longpolling.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "eventId", "siteId", "sourceId", "date", "startTime", "endTime", "type", "rootPersonId",
		"rootPersonAddDate", "personId", "personType", "age", "gender", "maxSentiment", "minSentiment", "avgSentiment",
		"smileDuration", "name", "validationPhone", "validationEmail", "similarityScore", "directGazeDuration",
		"idClass", "topAtStart", "leftAtStart", "heightAtStart", "widthAtStart", "top", "left", "height", "width",
		"sourceEventIds", "autoEnded", "personTags", "moniker", "company", "homeLocation", "objectType", "objectId" })
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Event implements Serializable {
	private final static long serialVersionUID = -5817616295991058111L;
	@JsonProperty("eventId")
	private String eventId;
	@JsonProperty("siteId")
	private String siteId;
	@JsonProperty("sourceId")
	private String sourceId;
	@JsonProperty("date")
	private Long date;
	@JsonProperty("startTime")
	private Long startTime;
	@JsonProperty("endTime")
	private Long endTime;
	@JsonProperty("type")
	private String type;
	@JsonProperty("rootPersonId")
	private String rootPersonId;
	@JsonProperty("rootPersonAddDate")
	private Long rootPersonAddDate;
	@JsonProperty("personId")
	private String personId;
	@JsonProperty("personType")
	private String personType;
	@JsonProperty("age")
	private Long age;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("maxSentiment")
	private Float maxSentiment;
	@JsonProperty("minSentiment")
	private Float minSentiment;
	@JsonProperty("avgSentiment")
	private Float avgSentiment;
	@JsonProperty("smileDuration")
	private Long smileDuration;
	@JsonProperty("name")
	private String name;
	@JsonProperty("validationPhone")
	private String validationPhone;
	@JsonProperty("validationEmail")
	private String validationEmail;
	@JsonProperty("similarityScore")
	private Float similarityScore;
	@JsonProperty("directGazeDuration")
	private Long directGazeDuration;
	@JsonProperty("idClass")
	private String idClass;
	@JsonProperty("topAtStart")
	private Float topAtStart;
	@JsonProperty("leftAtStart")
	private Float leftAtStart;
	@JsonProperty("heightAtStart")
	private Float heightAtStart;
	@JsonProperty("widthAtStart")
	private Float widthAtStart;
	@JsonProperty("top")
	private Float top;
	@JsonProperty("left")
	private Float left;
	@JsonProperty("height")
	private Float height;
	@JsonProperty("width")
	private Float width;
	@JsonProperty("sourceEventIds")
	private List<String> sourceEventIds = new ArrayList<String>();
	@JsonProperty("autoEnded")
	private Boolean autoEnded;
	@JsonProperty("personTags")
	private List<String> personTags = new ArrayList<String>();
	@JsonProperty("moniker")
	private String moniker;
	@JsonProperty("company")
	private String company;
	@JsonProperty("homeLocation")
	private String homeLocation;
	@JsonProperty("objectType")
	private String objectType;
	@JsonProperty("objectId")
	private String objectId;

	public Event withEventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	public Event withSiteId(String siteId) {
		this.siteId = siteId;
		return this;
	}

	public Event withSourceId(String sourceId) {
		this.sourceId = sourceId;
		return this;
	}

	public Event withDate(Long date) {
		this.date = date;
		return this;
	}

	public Event withStartTime(Long startTime) {
		this.startTime = startTime;
		return this;
	}

	public Event withEndTime(Long endTime) {
		this.endTime = endTime;
		return this;
	}

	public Event withType(String type) {
		this.type = type;
		return this;
	}

	public Event withRootPersonId(String rootPersonId) {
		this.rootPersonId = rootPersonId;
		return this;
	}

	public Event withRootPersonAddDate(Long rootPersonAddDate) {
		this.rootPersonAddDate = rootPersonAddDate;
		return this;
	}

	public Event withPersonId(String personId) {
		this.personId = personId;
		return this;
	}

	public Event withPersonType(String personType) {
		this.personType = personType;
		return this;
	}

	public Event withAge(Long age) {
		this.age = age;
		return this;
	}

	public Event withGender(String gender) {
		this.gender = gender;
		return this;
	}

	public Event withMaxSentiment(Float maxSentiment) {
		this.maxSentiment = maxSentiment;
		return this;
	}

	public Event withMinSentiment(Float minSentiment) {
		this.minSentiment = minSentiment;
		return this;
	}

	public Event withAvgSentiment(Float avgSentiment) {
		this.avgSentiment = avgSentiment;
		return this;
	}

	public Event withSmileDuration(Long smileDuration) {
		this.smileDuration = smileDuration;
		return this;
	}

	public Event withName(String name) {
		this.name = name;
		return this;
	}

	public Event withValidationPhone(String validationPhone) {
		this.validationPhone = validationPhone;
		return this;
	}

	public Event withValidationEmail(String validationEmail) {
		this.validationEmail = validationEmail;
		return this;
	}

	public Event withSimilarityScore(Float similarityScore) {
		this.similarityScore = similarityScore;
		return this;
	}

	public Event withDirectGazeDuration(Long directGazeDuration) {
		this.directGazeDuration = directGazeDuration;
		return this;
	}

	public Event withIdClass(String idClass) {
		this.idClass = idClass;
		return this;
	}

	public Event withTopAtStart(Float topAtStart) {
		this.topAtStart = topAtStart;
		return this;
	}

	public Event withLeftAtStart(Float leftAtStart) {
		this.leftAtStart = leftAtStart;
		return this;
	}

	public Event withHeightAtStart(Float heightAtStart) {
		this.heightAtStart = heightAtStart;
		return this;
	}

	public Event withWidthAtStart(Float widthAtStart) {
		this.widthAtStart = widthAtStart;
		return this;
	}

	public Event withTop(Float top) {
		this.top = top;
		return this;
	}

	public Event withLeft(Float left) {
		this.left = left;
		return this;
	}

	public Event withHeight(Float height) {
		this.height = height;
		return this;
	}

	public Event withWidth(Float width) {
		this.width = width;
		return this;
	}

	public Event withSourceEventIds(List<String> sourceEventIds) {
		this.sourceEventIds = sourceEventIds;
		return this;
	}

	public Event withAutoEnded(Boolean autoEnded) {
		this.autoEnded = autoEnded;
		return this;
	}

	public Event withPersonTags(List<String> personTags) {
		this.personTags = personTags;
		return this;
	}

	public Event withMoniker(String moniker) {
		this.moniker = moniker;
		return this;
	}

	public Event withCompany(String company) {
		this.company = company;
		return this;
	}

	public Event withHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
		return this;
	}

	public Event withObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	public Event withObjectId(String objectId) {
		this.objectId = objectId;
		return this;
	}
}