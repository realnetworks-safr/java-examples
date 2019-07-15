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
@JsonPropertyOrder({ "events" })
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class EventQueryResponse implements Serializable {
	private final static long serialVersionUID = -4581041071562719788L;
	
	@JsonProperty("events")
	private List<Event> events = new ArrayList<Event>();
	
	public EventQueryResponse withEvents(List<Event> events) {
		this.events = events;
		return this;
	}
}