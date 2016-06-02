package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean
public class PpcCharBean implements Serializable {

	/**
	 * 
	 */
 	private static final long serialVersionUID = 1L;
	
    private LineChartModel ppcChartLine;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel2() {
        return ppcChartLine;
    }
     
    private void createLineModels() {      
    	ppcChartLine = initCategoryModel();
    	ppcChartLine.setTitle("PPC Acumulado");
    	ppcChartLine.setLegendPosition("e");
    	ppcChartLine.setShowPointLabels(true);
    	ppcChartLine.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        Axis yAxis = ppcChartLine.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
          
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Porcentaje real");
        boys.set("2004", 80);
        boys.set("2005", 50);
        boys.set("2006", 44);
        boys.set("2007", 15);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Porcentaje minimo");
        girls.set("2004", 70);
        girls.set("2005", 70);
        girls.set("2006", 70);
        girls.set("2007", 70);
        girls.set("2008", 70);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
    
} 