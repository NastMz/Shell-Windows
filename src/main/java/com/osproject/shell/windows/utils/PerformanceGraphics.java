package com.osproject.shell.windows.utils;

import com.osproject.shell.windows.components.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/a/15715096/230513
 * @see https://stackoverflow.com/a/11949899/230513
 */
public class PerformanceGraphics {

    private static final Random random = new Random();   
    private int n = 100;
    private MainFrame main;

    public PerformanceGraphics(MainFrame main) {
        this.main = main;
    }

    public ChartPanel createPaneProccesor() { 
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>(n);
        
        for (int i = 0; i < n; i++) {
            arrayDeque.add(random.nextInt(101));
        }
        XYSeries series = new XYSeries("Data");
        for (Integer data : arrayDeque) {
            series.add(series.getItemCount(), data);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                arrayDeque.poll();
                arrayDeque.add(random.nextInt(101));
                series.clear();
                for (Integer data : arrayDeque) {
                    series.add(series.getItemCount(), data);
                }
                String percent = arrayDeque.getLast().toString()+"%";
                main.setProcessorPercent(percent);
            }
        }).start();
        JFreeChart chart = ChartFactory.createXYLineChart("", "",
                "", dataset, PlotOrientation.VERTICAL, false, false, false);
        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().setBackgroundPaint(Color.white);
        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(9, 121, 176));
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(415, 150);
            }
        };
    }
    
    public ChartPanel createPaneRam() {   
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>(n);
        
        for (int i = 0; i < n; i++) {
            arrayDeque.add(random.nextInt(101));
        }
        
        XYSeries series = new XYSeries("Data");
        for (Integer data : arrayDeque) {
            series.add(series.getItemCount(), data);
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                arrayDeque.poll();
                arrayDeque.add(random.nextInt(101));
                series.clear();
                for (Integer data : arrayDeque) {
                    series.add(series.getItemCount(), data);
                }
                String percent = arrayDeque.getLast().toString()+"%";
                main.setRamPercent(percent);
            }
        }).start();
        
        JFreeChart chart = ChartFactory.createXYLineChart("", "",
                "", dataset, PlotOrientation.VERTICAL, false, false, false);
        
        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().setBackgroundPaint(Color.white);
        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(9, 121, 176));
        
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(415, 150);
            }
        };
    }
    
    public ChartPanel createPaneDrive() {   
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>(2);

        arrayDeque.add(random.nextInt(101));
        arrayDeque.add(100-arrayDeque.getFirst());
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Usado", arrayDeque.getFirst());
        dataset.setValue("Libre", 100-arrayDeque.getFirst());
        
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                arrayDeque.clear();
                arrayDeque.add(random.nextInt(101));
                arrayDeque.add(100-arrayDeque.getFirst());
                
                dataset.clear();
                dataset.setValue("Usado", arrayDeque.getFirst());
                dataset.setValue("Libre", 100-arrayDeque.getFirst());
        
                String percent = arrayDeque.getFirst().toString()+"%";
                main.setDrivePercent(percent);
            }
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
}
