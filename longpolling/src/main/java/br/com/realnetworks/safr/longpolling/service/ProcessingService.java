package br.com.realnetworks.safr.longpolling.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.realnetworks.safr.longpolling.dto.Event;
import br.com.realnetworks.safr.longpolling.dto.EventQueryResponse;
import br.com.realnetworks.safr.longpolling.dto.ServerStatusDTO;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class ProcessingService implements IProcessingService {

//	@Value("${safr.events.url:https://cv-event.int2.real.com}")
	private String eventUrl;
	
	@Autowired
	private ExecutorService executorService;
	@Autowired
	private RestTemplate restTemplate;

	public ProcessingService(final String eventUrl) {
		this.eventUrl = eventUrl;
	}
	@Override
	public void process() {
		executorService.execute(new Runnable() {
			
			/**
			 * Retrieve the time of the latest event registered/updated, 
			 * should the request timeout, the input will be set as the output
			 * 
			 * @param pLastModDate when provided
			 * @return time of the latest event
			 */
			private Long getLastModDate(final Long pLastModDate) {
				Long lLastModDate = pLastModDate;
				try {
					final StringBuilder lStatusQueryUrl = new StringBuilder(eventUrl).append("/event/status");
					if(pLastModDate != null) {
						lStatusQueryUrl.append("?since=").append(pLastModDate);
					}
					final ResponseEntity<ServerStatusDTO> lResponse =  restTemplate.exchange(lStatusQueryUrl.toString(), HttpMethod.GET, null, ServerStatusDTO.class);
					log.debug(String.valueOf(lResponse));
					if(HttpStatus.OK.equals(lResponse.getStatusCode())) {
						lLastModDate = lResponse.getBody().getLastModDate();
					}
				}catch(Exception ex) {
					log.error(ex.getMessage(), ex);
				}
				return lLastModDate;
			}
			
			/**
			 * Lists all events in a given period.
			 * 
			 * @param pLastModDate
			 * @param pSinceTime
			 * @return list of events
			 */
			private List<Event> getEvents(final Long pSinceTime, final Long pLastModDate) {
				final List<Event> lListEvents = new ArrayList<>();
				try {
					final String lQueryEventsUrl = MessageFormat.format(SAFR_QUERY_EVENT_URL, eventUrl, Long.toString(pSinceTime), Long.toString(pLastModDate));
					log.info(String.valueOf(lQueryEventsUrl));
					final ResponseEntity<EventQueryResponse> lResponse =  restTemplate.exchange(lQueryEventsUrl.toString(), HttpMethod.GET, null, EventQueryResponse.class);
					log.debug(String.valueOf(lResponse));
					if(HttpStatus.OK.equals(lResponse.getStatusCode())) {
						lListEvents.addAll(lResponse.getBody().getEvents());
					}
				}catch(Exception ex) {
					log.error(ex.getMessage(), ex);
				}
				return lListEvents;
			}
			
			@Override
			public void run() {
				Long lLastModDate = getLastModDate(null);
				final Long lOriginalModDate = lLastModDate;
				while(true) {
					try {
						final Long lPreviousLastModDate = lLastModDate;
						lLastModDate = getLastModDate(lLastModDate);
						final List<Event> lListEvents = getEvents(lPreviousLastModDate, lOriginalModDate);
						log.debug(String.valueOf(lListEvents));
						if(!lListEvents.isEmpty()) {
							for(final Event item : lListEvents) {
								log.info(String.valueOf(item));
							}
						}
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		});
	}
	
	public void shutdown() {
		log.info("Long Polling application has been stopped...");
	}
}
