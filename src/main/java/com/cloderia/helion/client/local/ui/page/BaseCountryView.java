
package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import com.cloderia.helion.client.shared.model.Country;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;

import com.google.gwt.user.client.TakesValue;

/**
 * <p>
 * A base class for Errai UI components that are views for {@link Country Countrys}.
 *
 * <p>
 * This class has an {@link AutoBound @AutoBound} {@link DataBinder} so that UI components in subclasses annotated with
 * {@link Bound @Bound} are kept in sync with the assigned {@link Country} model properties via Errai Data Binding.
 */
public class BaseCountryView implements TakesValue<Country> {

  @Inject
  @AutoBound
  protected DataBinder<Country> binder;

  @Override
  public Country getValue() {
    return binder.getModel();
  }

  @Override
  public void setValue(final Country model) {
    binder.setModel(model);
  }

}