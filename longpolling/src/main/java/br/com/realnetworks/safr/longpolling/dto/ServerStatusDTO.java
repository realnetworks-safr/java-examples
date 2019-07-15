package br.com.realnetworks.safr.longpolling.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "serverDate", "lastModDate" })
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ServerStatusDTO implements Serializable {
	private static final long serialVersionUID = -5834314183764157971L;

	@JsonProperty("serverDate")
	private Long serverDate;
	@JsonProperty("lastModDate")
	private Long lastModDate;
	
	public ServerStatusDTO withServerDate(final Long pServerDate) {
		this.serverDate = pServerDate;
		return this;
	}
	
	public ServerStatusDTO withLastModDate(final Long pLastModDate) {
		this.lastModDate = pLastModDate;
		return this;
	}
}
