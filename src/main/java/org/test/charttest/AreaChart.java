//package org.test.charttest;
//
//import com.vaadin.addon.charts.Chart;
//import com.vaadin.addon.charts.model.ChartType;
//import com.vaadin.addon.charts.model.Configuration;
//import com.vaadin.addon.charts.model.DataSeries;
//import com.vaadin.addon.charts.model.DataSeriesItem;
//import com.vaadin.addon.charts.model.Hover;
//import com.vaadin.addon.charts.model.Labels;
//import com.vaadin.addon.charts.model.ListSeries;
//import com.vaadin.addon.charts.model.Marker;
//import com.vaadin.addon.charts.model.MarkerSymbolEnum;
//import com.vaadin.addon.charts.model.PlotOptionsArea;
//import com.vaadin.addon.charts.model.PlotOptionsColumn;
//import com.vaadin.addon.charts.model.States;
//import com.vaadin.addon.charts.model.Title;
//import com.vaadin.addon.charts.model.Tooltip;
//import com.vaadin.addon.charts.model.XAxis;
//import com.vaadin.addon.charts.model.YAxis;
//import com.vaadin.addon.charts.model.style.SolidColor;
//import com.vaadin.ui.Component;
//
//@SuppressWarnings("serial")
//public class AreaChart {
//
//	public static Chart getChart() {
//        Chart chart = new Chart(ChartType.AREA);
//
//        Configuration conf = chart.getConfiguration();
//
//        chart.getConfiguration().getChart().setBackgroundColor(SolidColor.LIGHTGRAY);
//
//        conf.setTitle(new Title("Test"));
//        PlotOptionsArea plotOptions = new PlotOptionsArea();
//        plotOptions.setPointStart(1940);
//        Marker marker = new Marker();
//        marker.setEnabled(false);
//        marker.setSymbol(MarkerSymbolEnum.CIRCLE);
//        marker.setRadius(2);
//        States states = new States();
//        states.setHover(new Hover(true));
//        marker.setStates(states);
//        plotOptions.setMarker(marker);
//        conf.setPlotOptions(plotOptions);
//
//        XAxis xAxis = new XAxis();
//        Labels labels = new Labels();
//        // Display x axis value (year) as non formatted integer
//        labels.setFormatter("this.value");
//        xAxis.setLabels(labels);
//        conf.addxAxis(xAxis);
//
//        YAxis yAxis = new YAxis();
//        labels = new Labels();
//        // display y axis value in kilos as there is such a pile of weapons
//        labels.setFormatter("this.value / 1000 +'k'");
//        yAxis.setLabels(labels);
//        yAxis.setGridLineWidth(0);
//        conf.addyAxis(yAxis);
//
//        Tooltip tooltip = new Tooltip();
//        tooltip.setFormatter("this.series.name +' produced <b>'+ Highcharts.numberFormat(this.y, 0) +'</b><br/>warheads in '+ this.x");
//        conf.setTooltip(tooltip);
//
//        final Number usaNumbers[] = new Number[] { 6, 11, 32, 110, 235, 369, 640, 1005, 1436, 2063, 3057,
//                4618, 6444, 9822, 15468, 20434, 24126, 27387, 29459, 31056,
//                31982, 32042, 26956, 27912, 28999,
//                28965, 27826, 25579, 25722, 24826, 24605, 24304, 23464, 23708,
//                24099, 14357, 14237, 3401, 4344, 100 };
//        conf.addSeries(new ListSeries("USA", usaNumbers));
//
//
//		PlotOptionsColumn plot = new PlotOptionsColumn();
//		plot.setPointWidth(1);
//		plot.setBorderColor(SolidColor.GRAY);
//		plot.setColor(SolidColor.GRAY);
//		DataSeries columns = new DataSeries();
//		columns.setPlotOptions(plot);
//
//		for (int i=0; i<usaNumbers.length; i++) {
//			columns.add(new DataSeriesItem(1940+i, usaNumbers[i]));
//		}
//
//
//		conf.addSeries(columns);
//
//        chart.drawChart(conf);
//
//        return chart;
//    }
//
//}