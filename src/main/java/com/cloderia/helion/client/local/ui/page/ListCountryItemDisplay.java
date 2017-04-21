package com.cloderia.helion.client.local.ui.page;

import static org.jboss.errai.demo.client.local.Click.Type.DOUBLE;
import static org.jboss.errai.demo.client.local.Click.Type.SINGLE;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.Heading;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.databinding.client.components.ListComponent;
import org.jboss.errai.demo.client.shared.Country;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

/**
 * 
 */
@Templated(value = "list-country-page.html#countryListItem")
public class ListCountryItemDisplay extends BaseCountryView implements IsElement {

  /**
   * This element is the root element of this component (as declared in the {@code #country} fragment of the
   * {@link Templated#value()} above).
   */
  @Inject
  @DataField
  private Div countryListItem;

  @Inject
  @Bound @DataField
  private Div name;

  /*
   * We specify a converter because Errai does not provide built-in conversion from String to Date.
   */
  @Inject
  @Bound(converter = DateConverter.class) @DataField
  private Div dateCreated;
  
  @Inject
  @Bound @DataField
  private Div description;

  @Override
  public HTMLElement getElement() {
    return country;
  }

}
