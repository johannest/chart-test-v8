package org.test.charttest;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;

import java.util.ArrayList;
import java.util.List;

public class Chart3D {

    public static Chart getChart() {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Monthly Average Rainfall");
        conf.setSubTitle("Source: WorldClimate.com");

        XAxis x = new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr");
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("Rainfall (mm)");
        conf.addyAxis(y);

        YAxis y2 = new YAxis();
        y2.setMin(0);
        y2.setTitle("Rainfall (mm)");
        y2.setOpposite(true);
        conf.addyAxis(y2);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.x +': '+ this.y +' mm'");
        conf.setTooltip(tooltip);

        PlotOptionsColumn plot = new PlotOptionsColumn();
        plot.setPointPadding(0.2);
        plot.setBorderWidth(0);
        plot.setGroupZPadding(10);
        conf.setPlotOptions(plot);

        Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(0);
        options3d.setBeta(0);
        options3d.setDepth(10);
        options3d.setViewDistance(100);
        Frame frame = new Frame();
        options3d.setFrame(frame);
        conf.getChart().setOptions3d(options3d);

        conf.addSeries(new ListSeries("Tokyo", 49.9, 71.5, 106.4, 129.2));
        conf.addSeries(new ListSeries("New York", 83.6, 78.8, 98.5, 93.4));
        conf.addSeries(new ListSeries("London", 48.9, 38.8, 39.3, 41.4));
        conf.addSeries(new ListSeries("Berlin", 42.4, 33.2, 34.5, 39.7));

        DataSeries totalHourSeries = new DataSeries();
        List<Number> totals = new ArrayList<>();
        totals.add(230);
        totals.add(210);
        totals.add(280);
        totals.add(310);

        PlotOptionsSpline splinePlotOptions = new PlotOptionsSpline();

        Marker marker = new Marker();
        marker.setLineWidth(2);
        marker.setLineColor(new SolidColor("black"));
        marker.setFillColor(new SolidColor("white"));
        //splinePlotOptions.setPointPlacement(PointPlacement.BETWEEN);
        splinePlotOptions.setShowInLegend(false);
        splinePlotOptions.setMarker(marker);
        splinePlotOptions.setColor(new SolidColor("black"));

        totalHourSeries.setyAxis(1);
        totalHourSeries.setData(totals.toArray(new Number[totals.size()]));
        totalHourSeries.setPlotOptions(splinePlotOptions);
        totalHourSeries.setName("Totals by Hour");

        conf.addSeries(totalHourSeries);

        chart.drawChart(conf);
        return chart;
    }
}
