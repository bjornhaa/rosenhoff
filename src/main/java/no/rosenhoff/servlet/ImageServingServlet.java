package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Aktivitet;
import no.rosenhoff.common.db.Poll;
import no.rosenhoff.common.db.PollDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Nov 30, 2011
 * Time: 9:22:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageServingServlet extends HttpServlet {

    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String antPositive = request.getParameter("antPositive");
        String antNegative = request.getParameter("antNegative");

        JFreeChart chart = getChartImage(new Integer(antPositive), new Integer(antNegative));

        response.setContentType("image/png");

        OutputStream outputStream = response.getOutputStream();

        int width = 400;
        int height = 150;
        ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);

        close(outputStream);


    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }


    public JFreeChart getChartImage(int antPositive, int antNegative) {
        JFreeChart jfreechart = null;
        try {
            jfreechart = ChartFactory.createBarChart(
                    "",         // chart title
                    "",               // domain axis label
                    "",                  // range axis label
                    createDataset(antPositive, antNegative),                  // data
                    PlotOrientation.HORIZONTAL, // orientation
                    false,                     // include legend
                    false,                     // tooltips?
                    false                     // URLs?
            );

            // get a reference to the plot for further customisation...
            final CategoryPlot plot = jfreechart.getCategoryPlot();
            plot.setNoDataMessage("NO DATA!");

            // set the range axis to display integers only...
            final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            final CategoryItemRenderer renderer = new CustomRenderer(
                    new Paint[]{Color.green, Color.yellow}
            );
//        renderer.setLabelGenerator(new StandardCategoryLabelGenerator());
            renderer.setItemLabelsVisible(true);
            final ItemLabelPosition p = new ItemLabelPosition(
                    ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 45.0
            );
            renderer.setPositiveItemLabelPosition(p);
            plot.setRenderer(renderer);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return jfreechart;

    }

    private CategoryDataset createDataset(int antPositive, int antNegative) {
        final String series1 = "Er med";
        final String series2 = "Ikke med";


        // column keys...
        final String category1 = "";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(antPositive, series1, category1);
        dataset.addValue(antNegative, series2, category1);


        return dataset;
    }

    /**
     * A custom renderer that returns a different color for each item in a single series.
     */
    class CustomRenderer extends BarRenderer {

        /**
         * The colors.
         */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item.  Overrides the default behaviour inherited from
         * AbstractSeriesRenderer.
         *
         * @param row    the series.
         * @param column the category.
         * @return The item color.
         */
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[row % this.colors.length];
        }
    }


}
