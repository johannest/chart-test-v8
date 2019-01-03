//package org.test.charttest;
//
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.joda.time.DateTime;
//
//import com.vaadin.addon.charts.Chart;
//import com.vaadin.addon.charts.model.Configuration;
//import com.vaadin.addon.charts.model.DataProviderSeries;
//import com.vaadin.addon.charts.model.PlotOptionsBar;
//import com.vaadin.addon.charts.model.PlotOptionsColumn;
//import com.vaadin.data.provider.ListDataProvider;
//
//public class ChartWithRangeSelectorAndDataProvider {
//
//	public static Chart getChart() {
//
//		final Chart chart = new Chart();
//        chart.setHeight("450px");
//        chart.setWidth("100%");
//        chart.setTimeline(true);
//
//        Configuration configuration = chart.getConfiguration();
//        configuration.getTitle().setText("AAPL Stock Price");
//        configuration.getLegend().setEnabled(true);
//
//        List<ExampleDTO> items = new ArrayList<>();
//        DateTime startdate = new DateTime();
//        startdate.minusDays(400);
//        for(int i=0; i<1000; i++) {
//        	DateTime newDT = startdate.plusHours(8*i);
//        	ExampleDTO dto = new ExampleDTO((float)Math.random(), newDT.toDate());
//        	items.add(dto);
//	 	}
//
//        PlotOptionsColumn plotOptions = new PlotOptionsColumn();
//
//
//		ListDataProvider<ExampleDTO> dataProvider = new ListDataProvider<>(items);
//		DataProviderSeries<ExampleDTO> series = new DataProviderSeries<>(dataProvider);
//		series.setAutomaticChartUpdateEnabled(true);
//		series.setY(ExampleDTO::getyValue);
//		series.setX(ExampleDTO::getDate);
//		series.setPlotOptions(plotOptions);
//
//		ListDataProvider<ExampleDTO> dataProvider2 = new ListDataProvider<>(items);
//		DataProviderSeries<ExampleDTO> series2 = new DataProviderSeries<>(dataProvider);
//		series2.setAutomaticChartUpdateEnabled(true);
//		series2.setY(ExampleDTO::getyValue);
//		series2.setX(ExampleDTO::getDate);
//		series2.setPlotOptions(plotOptions);
//
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					try {
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					dataProvider.getItems().add(new ExampleDTO(0.2f, new Date()));
//					dataProvider2.getItems().add(new ExampleDTO(0.5f, new Date()));
//				}
//			}
//		});
//		t.start();
//
////
////        DataSeries dataSeries = new DataSeries();
////
////        DateTime startdate = new DateTime();
////        startdate.minusDays(400);
////        for(int i=0; i<1000; i++) {
////            DataSeriesItem item = new DataSeriesItem();
////            DateTime newDT = startdate.plusHours(8*i);
////            item.setX(newDT.toDate());
////            item.setY(Math.random());
////            dataSeries.add(item);
////        }
////        configuration.setSeries(dataSeries);
////
////        RangeSelector rangeSelector = new RangeSelector();
////        //rangeSelector.setSelected(1);
////        configuration.setRangeSelector(rangeSelector);
//
//		configuration.setSeries(series, series2);
//        chart.drawChart(configuration);
//
//
//        chart.addXAxesExtremesChangeListener(e-> {
//
//        });
//
//        return chart;
//
//	}
//
//}
