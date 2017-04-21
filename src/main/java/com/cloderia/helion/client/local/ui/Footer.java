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
@Templated("app-page.html#footer")
public class Footer implements IsElement {

	@Inject @Named("footer")
	@DataField
	private HTMLElement footer;

	@Override
	public HTMLElement getElement() {
		return footer;
	}

}
