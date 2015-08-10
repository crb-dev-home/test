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

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;

import base.BaseStyleCssResourceReference;
import base.FixBootstrapStylesCssResourceReference;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.prettyprint.PrettifyCssResourceReference;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;
public class BasePage extends WebPage {

	public BasePage() {
		super();
		add(new HtmlTag("html"));
		add(new HeaderPanel("header"));
		add(new FooterPanel("footer"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		response.render(CssHeaderItem.forReference(FontAwesomeCssReference.instance()));
		response.render(CssHeaderItem.forReference(FixBootstrapStylesCssResourceReference.INSTANCE));
		response.render(CssHeaderItem.forReference(PrettifyCssResourceReference.INSTANCE));
		response.render(CssHeaderItem.forReference(BaseStyleCssResourceReference.INSTANCE));
		Bootstrap.renderHead(response);
	}

}
