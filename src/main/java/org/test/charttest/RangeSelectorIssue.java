//package org.test.charttest;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.time.ZoneOffset;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.vaadin.addon.charts.Chart;
//import com.vaadin.addon.charts.model.Configuration;
//import com.vaadin.addon.charts.model.DataProviderSeries;
//import com.vaadin.addon.charts.model.PlotOptionsColumn;
//import com.vaadin.addon.charts.model.Stacking;
//import com.vaadin.addon.charts.model.YAxis;
//import com.vaadin.addon.charts.model.style.SolidColor;
//import com.vaadin.data.provider.ConfigurableFilterDataProvider;
//import com.vaadin.data.provider.ListDataProvider;
//import com.vaadin.server.SerializablePredicate;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Component;
//import com.vaadin.ui.VerticalLayout;
//
//public class RangeSelectorIssue {
//
//	public static Component getChartLayout() {
//		/*Create BarChart*/
//        YAxis barChartYAxis = new YAxis();
//        barChartYAxis.setAllowDecimals(false);
//        barChartYAxis.setMin(0);
//        barChartYAxis.setMax(100);
//
//        Chart barChart = new Chart();
//        barChart.setTimeline(true);
//
//        Configuration barChartConfiguration = barChart.getConfiguration();
//        barChartConfiguration.getNavigator().setEnabled(false);
//
//        List<LocalDate> august = LocalDate.of(2018, Month.AUGUST, 1)
//                .datesUntil(LocalDate.of(2018, Month.AUGUST, 31))
//                .collect(Collectors.toList());
//
//        List<LocalDate> july = LocalDate.of(2018, Month.JULY, 1)
//                .datesUntil(LocalDate.of(2018, Month.JULY, 31))
//                .collect(Collectors.toList());
//
//        List<LocalDate> allDates = new ArrayList<>();
//        allDates.addAll(august);
//        allDates.addAll(july);
//
//        final ListDataProvider<LocalDate> dataProvider = new ListDataProvider<>(allDates);
//        barChartConfiguration.addSeries(createSeries(dataProvider, Month.AUGUST));
//        barChartConfiguration.addSeries(createSeries(dataProvider, Month.JULY));
//
//        Button hideAugust = new Button("Show / Hide AUGUST");
//        hideAugust.addClickListener(event1 -> {
//            if (allDates.containsAll(august)) {
//                allDates.removeAll(august);
//            } else {
//                allDates.addAll(august);
//            }
//            dataProvider.refreshAll();
//        });
//
//        Button hideJuly = new Button("Show / Hide JULY");
//        hideJuly.addClickListener(event1 -> {
//            if (allDates.containsAll(july)) {
//                allDates.removeAll(july);
//            } else {
//                allDates.addAll(july);
//            }
//            dataProvider.refreshAll();
//        });
//
//        VerticalLayout verticalLayout = new VerticalLayout();
//        verticalLayout.addComponent(barChart);
//        verticalLayout.addComponent(hideAugust);
//        verticalLayout.addComponent(hideJuly);
//        return verticalLayout;
//	}
//
//	private static DataProviderSeries<LocalDate> createSeries(ListDataProvider<LocalDate> dataProvider, Month month) {
//        final ConfigurableFilterDataProvider<LocalDate, Void, SerializablePredicate<LocalDate>> dataProviderWithFilter = dataProvider.withConfigurableFilter();
//        dataProviderWithFilter.setFilter(localDate -> localDate.getMonth().equals(month));
//
//        DataProviderSeries<LocalDate> dataProviderSeries = new DataProviderSeries<>(dataProviderWithFilter);
//
//        final PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
//        plotOptionsColumn.setStacking(Stacking.NONE);
//        plotOptionsColumn.setColor(month.equals(Month.AUGUST) ? SolidColor.BLUE : SolidColor.RED);
//
//        dataProviderSeries.setName(month.toString());
//        dataProviderSeries.setPlotOptions(plotOptionsColumn);
//        dataProviderSeries.setX(localDate -> Date.from(localDate.atTime(0, 0).toInstant(ZoneOffset.UTC)));
//        dataProviderSeries.setY(localDate -> Math.random() * 100);
//        dataProviderSeries.setAutomaticChartUpdateEnabled(true);
//
//        return dataProviderSeries;
//    }
//
//}
