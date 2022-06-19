package com.osproject.shell.client.core;

import com.osproject.shell.client.components.LoginFrame;
import com.osproject.shell.client.components.MainFrame;
import com.osproject.shell.client.utils.InterfaceColors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayDeque;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PerformanceGraphics {

    private static final int points = 100;
    private final MainFrame main;
    private final Performance performance;

    public PerformanceGraphics(MainFrame main, LoginFrame loginFrame) {
        this.main = main;
        this.performance = new Performance(loginFrame);
    }

    public ChartPanel createPanelProccesor() {
        ArrayDeque<Double> arrayDeque = new ArrayDeque<>(points);

        for (int i = 0; i < points; i++) {
            arrayDeque.add(this.performance.getConsume("processor"));
        }

        XYSeries series = new XYSeries("Data");
        for (Double data : arrayDeque) {
            series.add(series.getItemCount(), data);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        new Timer(1000, (ActionEvent e) -> {
            arrayDeque.poll();
            arrayDeque.add(this.performance.getConsume("processor"));
            series.clear();
            for (Double data : arrayDeque) {
                series.add(series.getItemCount(), data);
            }
            String percent = arrayDeque.getLast() + "%";
            main.setProcessorPercent(percent);
        }).start();

        return getChartPanel(dataset);
    }

    public ChartPanel createPanelRam() {
        ArrayDeque<Double> arrayDeque = new ArrayDeque<>(points);

        for (int i = 0; i < points; i++) {
            arrayDeque.add(this.performance.getConsume("memory"));
        }

        XYSeries series = new XYSeries("Data");
        for (Double data : arrayDeque) {
            series.add(series.getItemCount(), data);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        new Timer(1000, (ActionEvent e) -> {
            arrayDeque.poll();
            arrayDeque.add(this.performance.getConsume("memory"));
            series.clear();
            for (Double data : arrayDeque) {
                series.add(series.getItemCount(), data);
            }
            String percent = arrayDeque.getLast() + "%";
            main.setRamPercent(percent);
        }).start();

        return getChartPanel(dataset);
    }

    public ChartPanel createPanelDrive() {
        ArrayDeque<Double> arrayDeque = new ArrayDeque<>(2);

        arrayDeque.add(this.performance.getConsume("drive"));
        arrayDeque.add(100 - arrayDeque.getFirst());

        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue("Usado", arrayDeque.getFirst());
        dataset.setValue("Libre", 100 - arrayDeque.getFirst());

        new Timer(1000, (ActionEvent e) -> {
            arrayDeque.clear();
            arrayDeque.add(this.performance.getConsume("drive"));
            arrayDeque.add(100 - arrayDeque.getFirst());

            dataset.clear();
            dataset.setValue("Usado", arrayDeque.getFirst());
            dataset.setValue("Libre", 100 - arrayDeque.getFirst());

            String percent = arrayDeque.getFirst() + "%";
            main.setDrivePercent(percent);
        }).start();

        JFreeChart chart = ChartFactory.createPieChart3D("", dataset, true, true, false);

        chart.getPlot().setBackgroundPaint(Color.white);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Usado", new Color(9, 121, 176));
        plot.setSectionPaint("Libre", Color.white);
        plot.setOutlinePaint(null);
        plot.setLabelGenerator(null);

        return new ChartPanel(plot.getChart()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(250, 250);
            }
        };
    }

    private ChartPanel getChartPanel(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("", "",
                "", dataset, PlotOrientation.VERTICAL, false, false, false);

        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().getRangeAxis().setRange(0, 100);
        chart.getXYPlot().setBackgroundPaint(Color.white);
        chart.getXYPlot().getRenderer().setSeriesPaint(0, InterfaceColors.BLUE);
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(415, 150);
            }
        };
    }
}
