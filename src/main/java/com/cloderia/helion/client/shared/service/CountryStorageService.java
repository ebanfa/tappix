package com.cloderia.helion.client.shared.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.errai.bus.client.api.ClientMessageBus;

import com.cloderia.helion.client.shared.model.Country;
import com.cloderia.helion.client.shared.operation.CountryOperation;
import com.cloderia.helion.server.service.CountryStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on {@link Country Countrys}.
 *
 * @see CountryStorageServiceImpl
 */
@Path("/country")
public interface CountryStorageService {

  /**
   * @return A list of all Countrys in this service.
   */
  @GET
  @Produces("application/json")
  List<Country> getAllCountrys();

  /**
   * An HTTP endpoint for creating a new {@link Country}.
   *
   * @param countryOperation
   *          Contains the {@link Country} to be created and the {@link ClientMessageBus#getSessionId() queue session
   *          id} of the client creating this contact.
   * @return A {@link Response} with status 201 and a {@code Location} header with the URL for the created Country, if
   *         successful. Otherwise a {@link Response} with an appropriate error status.
   */
  @POST
  @Consumes("application/json")
  Response create(CountryOperation countryOperation);

  /**
   * An HTTP endpoint for updating an existing {@link Country}.
   *
   * @param countryOperation
   *          Contains the {@link Country} to be updated and the {@link ClientMessageBus#getSessionId() queue session
   *          id} of the client creating this Country. The id of the contained contact must match an existing Country
   *          from this service.
   * @return A {@link Response} with status 204 if successful. Otherwise a {@link Response} with an appropriate error
   *         status.
   */
  @PUT
  @Consumes("application/json")
  Response update(CountryOperation countryOperation);

  /**
   * @param id
   *          The id number of an existing {@link Country} to be deleted.
   * @return A {@link Response} with status 204 if successful. Otherwise a {@link Response} with an appropriate error
   *         status.
   */
  @DELETE
  @Path("/{id:[0-9]+}")
  Response delete(@PathParam("id") Long id);

}
