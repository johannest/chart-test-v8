//package org.test.charttest;
//
//import com.vaadin.addon.charts.Chart;
//import com.vaadin.addon.charts.PointClickEvent;
//import com.vaadin.addon.charts.PointClickListener;
//import com.vaadin.addon.charts.model.AxisTitle;
//import com.vaadin.addon.charts.model.ChartType;
//import com.vaadin.addon.charts.model.Configuration;
//import com.vaadin.addon.charts.model.DashStyle;
//import com.vaadin.addon.charts.model.HorizontalAlign;
//import com.vaadin.addon.charts.model.Label;
//import com.vaadin.addon.charts.model.LayoutDirection;
//import com.vaadin.addon.charts.model.Legend;
//import com.vaadin.addon.charts.model.ListSeries;
//import com.vaadin.addon.charts.model.PlotLine;
//import com.vaadin.addon.charts.model.PlotOptionsArea;
//import com.vaadin.addon.charts.model.Title;
//import com.vaadin.addon.charts.model.VerticalAlign;
//import com.vaadin.addon.charts.model.XAxis;
//import com.vaadin.addon.charts.model.YAxis;
//import com.vaadin.addon.charts.model.style.SolidColor;
//
//public class AnotherChart {
//
//	public static Chart getChart() {
//		Chart chart = new Chart(ChartType.AREA);
//		Configuration conf = chart.getConfiguration();
//		conf.getChart().setSpacingBottom(30);
//		conf.setTitle(new Title(""));
//		XAxis xAxis = new XAxis();
//		xAxis.setMin(0);
//		xAxis.setMax(23);
//		xAxis.setCategories("0", "1", "2", "3",
//		"4", "5", "6","7","8","9","10","11", "12", "13", "14",
//		"15", "16", "17","18","19","20","21","22","23");
//		xAxis.getLabels().getStyle().setFontSize("8px");
//		xAxis.setTitle(new AxisTitle("Hour"));
//		conf.addxAxis(xAxis);
//
//		YAxis yAxis = new YAxis();
//		yAxis.setTitle(new AxisTitle("Average Duration"));
//		yAxis.getLabels().getStyle().setFontSize("8px");
//
//		yAxis.setMin(0);
//		yAxis.setMax(0.045f);
//		yAxis.getLabels().setFormat("{value:.3f}");
//		yAxis.setGridLineWidth(0);
//		yAxis.setTickAmount(10);
//
//
//		conf.addyAxis(yAxis);
//
//		Legend legend = new Legend();
//		legend.setLayout(LayoutDirection.HORIZONTAL);
//		legend.setAlign(HorizontalAlign.LEFT);
//		legend.setFloating(true);
//		legend.setVerticalAlign(VerticalAlign.TOP);
//		legend.setX(200);
//		legend.setY(200);
//		legend.setBorderWidth(1);
//		legend.setEnabled(false);
//		conf.setLegend(legend);
//
//		chart.addPointClickListener(new PointClickListener() {
//			@Override
//			public void onClick(PointClickEvent pointClickEvent) {
//				System.out.println("zzz: "+pointClickEvent.getButton().getName());
//			}
//		});
//
//		PlotOptionsArea plotOptions = new PlotOptionsArea();
//		plotOptions.setFillOpacity(0.5);
//		plotOptions.setColor(SolidColor.LIGHTGRAY);
//		plotOptions.setLineColor(SolidColor.DARKGRAY);
//		conf.setPlotOptions(plotOptions);
//		conf.addSeries(new ListSeries("wmn", 0.020,0.020,0.035,0.025,0.023,0.021,0.020,0.020,0.032,0.023,0.021,0.020,0.019,0.044,0.024,0.033,0.029,0.034,0.032,0.025,0.026,0.027,0.026));
//		chart.drawChart(conf);
//		return chart;
//	}
//
//}
