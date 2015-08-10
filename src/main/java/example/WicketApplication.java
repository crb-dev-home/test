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

import org.apache.wicket.ResourceBundles;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import base.FixBootstrapStylesCssResourceReference;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.prettyprint.PrettifyCssResourceReference;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.DefaultThemeProvider;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ThemeProvider;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchTheme;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchThemeProvider;
import de.agilecoders.wicket.themes.markup.html.wicket.WicketTheme;
import example.upload.FileUploadPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see example.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @return HomePage.class
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		configureBootstrap();
		addResourceReplacement(
				JQueryResourceReference.get(),
				new UrlResourceReference(Url
						.parse("http://code.jquery.com/jquery-1.11.0.min.js")));

		mountPage("account", UserAccountPage.class);
		mountPage("fileUpload", FileUploadPage.class);
	}

	private void configureBootstrap() {

		final IBootstrapSettings settings = new BootstrapSettings();
		settings.useCdnResources(false);

		// final ThemeProvider themeProvider = new
		// BootswatchThemeProvider(BootswatchTheme.Flatly);
		//
		// settings.setJsResourceFilterName("footer-container")
		// .setThemeProvider(themeProvider);

		final ThemeProvider themeProvider = new BootswatchThemeProvider(
				BootswatchTheme.Paper);
		DefaultThemeProvider defaultTheme = new DefaultThemeProvider();
		defaultTheme.add(new WicketTheme());
		// settings.setThemeProvider(defaultTheme);
		// settings.setCssResourceReference(new
		// WicketThemeCssResourceReference());

		final ThemeProvider themeProvider2 = new DefaultThemeProvider() {
			{
				add(new WicketTheme());

				defaultTheme("wicket");
			}
		};

		settings.setThemeProvider(themeProvider2);
		// settings.setCssResourceReference((CssResourceReference)
		// PrettifyCssResourceReference.INSTANCE);
		// settings.setCssResourceReference(FixBootstrapStylesCssResourceReference.INSTANCE);
		Bootstrap.install(this, settings);
		// BootstrapLess.install(this);
		ResourceBundles bundles = getResourceBundles();

		bundles.addCssBundle(WicketApplication.class, "application.css",
				(CssResourceReference) PrettifyCssResourceReference.INSTANCE,
				FixBootstrapStylesCssResourceReference.INSTANCE);

	}
}
