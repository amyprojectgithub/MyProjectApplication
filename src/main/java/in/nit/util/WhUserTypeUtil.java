package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class WhUserTypeUtil {
	public void generatePie(String path,List<Object[]> data) {
		//create Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		//get array objects from List
		for(Object[] obj:data) {
			dataset.setValue(obj[0].toString(), Double.valueOf(obj[1].toString()));
		}
		//create JFreeChart obj using ChartFactory
		JFreeChart chart=ChartFactory.createPieChart3D("WhUserType", dataset, true, true, false);
		//Save as image using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/whUserPie.jpg"), chart, 400, 400);
		}catch(IOException io) {
			io.printStackTrace();
		}			
	}
	//:::::::::::ShipmentTypeMode BarChart Generation
	public void generateBar(String path,List<Object[]> data) {
		//craete Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		//get data from  list and set to dataset
		for(Object[] obj:data){
			dataset.setValue(Double.valueOf(obj[1].toString()),obj[0].toString(), "");
		}
		//craete JfreeChart object using ChartFactory
		  JFreeChart chart=ChartFactory.createBarChart("WhUserType", "Types", "Count", dataset);
		  //save as image using ChartUtils
		  try {
		  ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/whUserBar.jpg"), chart, 450, 400);
		  }catch (IOException e) {
			e.printStackTrace();
		}
	}

}
