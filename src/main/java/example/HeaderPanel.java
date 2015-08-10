/*
 * Copyright 2013 David Beer.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.ImmutableNavbarComponent;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarText;

/**
 * Created by dbeer on 12/12/13.
 */
public class HeaderPanel extends Panel {

	public HeaderPanel(String id) {
		super(id);

		add(navbar());
	}

	private Navbar navbar() {
		Navbar navbar = new Navbar("navbar");
		navbar.setInverted(true);
		navbar.fluid();
		navbar.setPosition(Navbar.Position.TOP);
		navbar.setBrandName(Model.of("Query Maker"));
		
		
		
		navbar.addComponents(new NavbarText(navbar.newExtraItemId(), "App version 1.0").position(Navbar.ComponentPosition.RIGHT));

		return navbar;
	}
}
