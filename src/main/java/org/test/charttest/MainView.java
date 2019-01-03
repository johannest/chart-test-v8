package org.test.charttest;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@StyleSheet("context://css/main.css")
@Route("")
public class MainView extends Div implements PageConfigurator {

	public MainView() {
//		Tabs tabSheet = new Tabs();
//		tabSheet.setSizeFull();
//
//		Chart chart4 = Chart3D.getChart();
//		Tab tab = new Tab(chart4);
//		tab.setLabel("3D Chart");
//		tabSheet.add(tab);
//		tabSheet.add(new Tab(""));
//
//
//		add(tabSheet);

		setSizeFull();
//		Chart chart4 = Chart3D.getChart();
//		add(chart4);
		PhoneNumberForm phoneNumberForm = new PhoneNumberForm();
		phoneNumberForm.setSizeFull();
		add(phoneNumberForm);
	}

	@Override
	public void configurePage(InitialPageSettings settings) {
		settings.addMetaTag("apple-mobile-web-app-capable", "yes");
		settings.addMetaTag("apple-mobile-web-app-status-bar-style", "black");
	}
}
