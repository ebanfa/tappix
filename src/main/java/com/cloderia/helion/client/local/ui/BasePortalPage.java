/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

/**
 * @author adrian
 *
 */
@Templated(value = "app-page.html#app-container", stylesheet = "app-page.css")
public class BasePortalPage extends BasePage {

	  @Inject
	  @DataField
	  protected Header header;
	  
	  @Inject
	  @DataField
	  protected Sidebar sidebar;

	  @Inject
	  @DataField
	  protected Footer footer;
}
