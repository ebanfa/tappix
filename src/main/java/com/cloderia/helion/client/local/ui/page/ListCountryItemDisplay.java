package com.cloderia.helion.client.local.ui.page;


import javax.inject.Inject;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.shared.util.DateConverter;

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
    return countryListItem;
  }

}
