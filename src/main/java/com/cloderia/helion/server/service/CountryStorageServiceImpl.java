/**
 * Copyright (C) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloderia.helion.server.service;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.DELETE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.UPDATE;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.cloderia.helion.client.shared.model.Country;
import com.cloderia.helion.client.shared.operation.CountryOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.CountryStorageService;

/**
 * Server-side implementation for the RPC service, {@link CountryStorageService}. Performs database CRUD operations
 * using the {@link CountryEntityService} and fires Errai CDI {@link Event Events} that are observed by clients over the
 * wire to publish creation, update, and deletion of {@link Country Country}.
 */
@Stateless
public class CountryStorageServiceImpl implements CountryStorageService {

  @Inject
  private CountryEntityService entityService;

  @Inject
  @Operation(CREATE)
  private Event<CountryOperation> created;

  @Inject
  @Operation(UPDATE)
  private Event<CountryOperation> updated;

  @Inject
  @Operation(DELETE)
  private Event<Long> deleted;

  @Override
  public List<Country> getAllCountrys() {
    return entityService.getAllCountrys();
  }

  @Override
  public Response create(final CountryOperation countryOperation) {
    entityService.create(countryOperation.getData());
    // This event is delivered to call connected clients.
    created.fire(countryOperation);

    return Response.created(UriBuilder.fromResource(CountryStorageService.class)
            .path(String.valueOf(countryOperation.getData().getId())).build()).build();
  }

  @Override
  public Response update(final CountryOperation countryOperation) {
    entityService.update(countryOperation.getData());
    // This event is delivered to call connected clients.
    updated.fire(countryOperation);

    return Response.noContent().build();
  }

  @Override
  public Response delete(Long id) {
    entityService.delete(id);
    // This event is delivered to call connected clients.
    deleted.fire(id);

    return Response.noContent().build();
  }

}
