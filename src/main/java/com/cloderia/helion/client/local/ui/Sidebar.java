/**
 * 
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
 * @author adrian
 *
 */
@ApplicationScoped
@Templated("app-page.html#sidebar")
public class Sidebar implements IsElement {

	@Inject @Named("aside")
	@DataField
	private HTMLElement sidebar;
	
	/* (non-Javadoc)
	 * @see org.jboss.errai.common.client.api.IsElement#getElement()
	 */
	@Override
	public HTMLElement getElement() {
		return sidebar;
	}

}
