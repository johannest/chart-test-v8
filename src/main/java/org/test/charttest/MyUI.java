package org.test.charttest;

import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.charts.Chart;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme-abc")
@Push
@Viewport("width=device-width,initial-scale=1,user-scalable=no")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		
		TabSheet tabSheet = new TabSheet();
		
		Chart chart1 = ChartWithRangeSelectorAndDataProvider.getChart();
		Button b2 = new Button("getSelectedRange", e-> {
			System.out.println(chart1.getConfiguration().getRangeSelector().getSelected());
		});
		tabSheet.addTab(new VerticalLayout(chart1,b2),"Chart with range");
		
		Chart chart2 = AnotherChart.getChart();
		tabSheet.addTab(chart2,"Chart with manual y-axis labels");
		
		Chart chart3 = AreaChart.getChart();
		tabSheet.addTab(chart3,"Area with columns");

		Chart chart4 = Chart3D.getChart();
		tabSheet.addTab(chart4,"3D chart");
		
//		tabSheet.addTab(RangeSelectorIssue.getChartLayout(), "RangeSelector issue");
//		tabSheet.addTab(VaadinTreeTest.getTestLayout(), "Tree test");
//
		layout.addComponents(tabSheet);
		
		Button b = new Button("open window");
		b.addClickListener(e-> {
			Window w = new Window("", getContentX());
			w.setModal(true);
			w.setClosable(true);
			w.setResizable(false);
			w.setSizeFull();
			getUI().addWindow(w);
			w.focus();
		});
		layout.addComponent(b);

		List<String> allItems = new ArrayList<>();

		ComboBox<String> cb = new ComboBox<>();
		ComboBox.NewItemProvider<String> itemHandler = newItem -> {
			System.out.println("#### "+newItem);
			if (!allItems.contains(newItem)) {
				allItems.add(newItem);
				cb.setItems(allItems);
				cb.setSelectedItem(newItem);
			}
			return Optional.ofNullable(newItem);
		};
		cb.setNewItemProvider(itemHandler);

		layout.addComponent(cb);
		
		setContent(layout);
	}
	
	private Component getContentX() {
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(new Label("adasd"));
		vl.addComponent(new DateField("date"));
		vl.addComponent(new ComboBox<>("select"));
		for (int i=0; i<3; i++) {
			vl.addComponent(new TextField("Textfield"));
		}
		vl.addComponent(new NativeSelect<>("test"));
		vl.addComponent(new TextField("Textfield"));
		return vl;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
