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

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cloderia.helion.client.shared.model.Country;

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Country Countrys}.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CountryEntityService {

  @PersistenceContext(unitName = "forge-default")
  private EntityManager em;

  public List<Country> getAllCountrys() {
    return em.createNamedQuery(Country.ALL_COUNTRY_QUERY, Country.class).getResultList();
  }

  public void create(final Country newCountry) {
    em.persist(newCountry);
  }

  public void update(final Country country) {
    em.merge(country);
  }

  public void delete(final Long id) {
    final Country country = em.find(Country.class, id);
    if (country != null) {
      em.remove(country);
    } else {
      throw new IllegalArgumentException(
              "The given id, " + id + ", was not a key for any " + Country.class.getSimpleName());
    }
  }

}
