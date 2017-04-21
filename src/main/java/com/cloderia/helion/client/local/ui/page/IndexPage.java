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

package com.cloderia.helion.client.local.ui.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.components.ListComponent;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.NavigationPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageHiding;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.cloderia.helion.client.local.ui.BasePortalPage;
import com.cloderia.helion.client.shared.model.Country;
import com.cloderia.helion.client.shared.operation.Operation;

/**
 * <p>
 * An Errai UI component for creating, displaying, updating, and deleting {@link FixData Contacts}. This component is
 * also an Errai Navigation {@link Page}; it will be displayed on the GWT host page whenever the navigation URL fragment
 * is {@code #/contacts}.
 *
 * <p>
 * The HTML markup for this {@link Templated} component is the HTML element with the CSS class {@code contact-list} in
 * the file {@code contact-page.html} in this package. This component uses CSS from the file {@code contact-page.css} in
 * this package.
 *
 * <p>
 * The {@link DataField} annotation marks fields that replace HTML elements from the template file. As an example, the
 * field {@link FixDataDisplay#editor} replaces the {@code <div>} element in the template with the CSS class
 * {@code modal-fields}. Because {@link ContactEditor} is an Errai UI component, the markup for {@link ContactEditor}
 * will replace the contents of the {@code modal-fields} div in this component.
 *
 * <p>
 * This component uses a {@link ListComponent} to display a list of {@link FixData Contacts}. The {@code List<FixData>}
 * returned by calling {@link DataBinder#getModel()} on {@link #binder} is a model bound to a table of
 * {@link FixDataDisplay ContactDisplays} in an HTML table. Any changes to the model list (such as adding or removing
 * items) will be automatically reflected in the displayed table.
 *
 * <p>
 * Instances of this type should be obtained via Errai IoC, either by using {@link Inject} in another container managed
 * bean, or by programmatic lookup through the bean manager.
 */
@Page(role = DefaultPage.class, path = "/index")
@Templated(value = "index-page.html#app-container")
public class IndexPage extends BasePortalPage {

  @Inject
  private ClientMessageBus bus;

  @Inject
  private Logger logger;

  /**
   * Register handlers and populate the list of {@link Country Contacts}.
   */
  @PostConstruct
  private void setup() {
   
  }

  /**
   * This method is invoked when this {@link Page} is attached to the {@link NavigationPanel}.
   */
  @PageShown
  public void addNavBarButtons() {
  }

  /**
   * This method is invoked when this {@link Page} is being removed from the {@link NavigationPanel}.
   */
  @PageHiding
  public void removeNavBarButtons() {
  }

  /**
   * For ignoring remote events that originate from this client.
   */
  private boolean sourceIsNotThisClient(final Operation opData) {
    return true;
  }
}
