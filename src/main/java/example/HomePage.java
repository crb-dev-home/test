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

import java.util.Date;

import org.apache.wicket.model.Model;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.DateTextField;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.DateTextFieldConfig;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.DateTextFieldConfig.TodayButton;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		DateTextField start = new DateTextField("from", new DateTextFieldConfig()
		.showTodayButton(TodayButton.LINKED).highlightToday(true));
		start.setModel(Model.of(new Date()));
		DateTextField end = new DateTextField("to", new DateTextFieldConfig()
		.showTodayButton(TodayButton.LINKED).highlightToday(true));
		end.setModel(Model.of(new Date()));
		
		add(start);
		add(end);

	}
}
