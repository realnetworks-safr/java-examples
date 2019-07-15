package br.com.realnetworks.safr.longpolling.service;

public interface IProcessingService {
	final String SAFR_QUERY_EVENT_URL = "{0}/events?sinceModDate={1}&sinceTime={2}";
	
	void process();

}