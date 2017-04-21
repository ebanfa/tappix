/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Country;

/**
 * @author adrian
 *
 */
@Portable
public class CountryOperation {

	private final Country country;
  	private final String sourceQueueSessionId;

  	public CountryOperation(final @MapsTo("country") Country country, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.country = country;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Country} that has been created or updated.
   	 */
  	public Country getData() {
    	return country;
  	}

  	/**
   	 * The value of {@link ClientMessageBus#getSessionId()} from the browser session from which the event is caused.
   	 */
  	public String getSourceQueueSessionId() {
    	return sourceQueueSessionId;
  	}

}

