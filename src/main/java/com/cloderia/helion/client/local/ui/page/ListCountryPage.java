package com.cloderia.helion.client.local.ui.page;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.components.ListComponent;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.NavigationPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageHiding;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.cloderia.helion.client.local.ui.BasePortalPage;
import com.cloderia.helion.client.shared.model.Country;
import com.cloderia.helion.client.shared.operation.CountryOperation;
import com.cloderia.helion.client.shared.service.CountryStorageService;

/**
 * 
 */
@Page(path = "/country")
@Templated(value = "country-list-page.html#app-container")
public class ListCountryPage extends BasePortalPage {

  @Inject
  @AutoBound
  private DataBinder<List<Country>> binder;

  /**
   * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   * request to the service defined by {@link CountryStorageService} (a JaxRS service).
   */
  @Inject
  private Caller<CountryStorageService> countryDataService;

  @Inject
  private ClientMessageBus bus;

  @Inject
  private Logger logger;

  /**
   * Register handlers and populate the list of {@link Country Contacts}.
   */
  @PostConstruct
  private void setup() {
    /*
     * Triggers an HTTP request to the CountryStorageService. The call back will be invoked asynchronously to display
     * all retrieved contacts.
     */
	//countryService.call((final List<Country> countrys) -> binder.getModel().addAll(countrys)).getAllContacts();

    // Remove placeholder table row from template.
    //DOMUtil.removeAllElementChildren(list.getElement());

    /*
     * Configure actions for when a CountryDisplay in the list is selected or deselected.
     */
    //list.setSelector(display -> display.setSelected(true));
    //list.setDeselector(display -> display.setSelected(false));
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
  private boolean sourceIsNotThisClient(final CountryOperation countryOperation) {
    return countryOperation.getSourceQueueSessionId() == null || !countryOperation.getSourceQueueSessionId().equals(bus.getSessionId());
  }
}
