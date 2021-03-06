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

package com.cloderia.helion.client.local.ui;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;


/**
 * <p>
 * An Errai UI component for displaying a bootstrap 3 navigation bar.
 */
@ApplicationScoped
@Templated("app-page.html#header")
public class Header implements IsElement {

  @Inject 
  @Named("header")
  @DataField
  private HTMLElement header;

  @Override
  public HTMLElement getElement() {
    return header;
  }

  public void add(final HTMLElement element) {
  
  }

  public void remove(final HTMLElement element) {
    
  }
}
