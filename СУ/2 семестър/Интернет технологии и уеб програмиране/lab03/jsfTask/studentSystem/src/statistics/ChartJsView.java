package statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

import dao.UserCourseDao;
import dao.UserCourseService;

@ManagedBean(name = "chartJsView")
@RequestScoped
public class ChartJsView implements Serializable {

	private BarChartModel barModel2;

	@PostConstruct
	public void init() {
		createBarModel2();
	}

	public void createBarModel2() {
		Map<String,  int[]> data1 = UserCourseService.getData();
		UserCourseService.getUserCourseResults();
		barModel2 = new BarChartModel();
		ChartData data = new ChartData();

		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Семантичен Уеб");
		barDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
		barDataSet.setBorderColor("rgb(255, 99, 132)");
		barDataSet.setBorderWidth(1);
		List<Number> values = new ArrayList<>();
		
		int[] firstCourse = data1.get("C01");
		values.add(firstCourse[0]);
		values.add(firstCourse[1]);
		values.add(firstCourse[2]);
		values.add(firstCourse[3]);
		barDataSet.setData(values);

		BarChartDataSet barDataSet2 = new BarChartDataSet();
		barDataSet2.setLabel("Интернет технологии и уеб програмиране");
		barDataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
		barDataSet2.setBorderColor("rgb(255, 159, 64)");
		barDataSet2.setBorderWidth(1);
		List<Number> values2 = new ArrayList<>();
		int[] secondCourse = data1.get("C02");
		values2.add(secondCourse[0]);
		values2.add(secondCourse[1]);
		values2.add(secondCourse[2]);
		values2.add(secondCourse[3]);
		
		barDataSet2.setData(values2);
		
		BarChartDataSet barDataSet3 = new BarChartDataSet();
		barDataSet3.setLabel("Софтуерни технологии 2 (проект)");
		barDataSet3.setBackgroundColor("rgba(26, 8, 237, 0.2)");
		barDataSet3.setBorderColor("rgb(26, 8, 237)");
		barDataSet3.setBorderWidth(1);
		List<Number> values3 = new ArrayList<>();
		int[] thirdCourse = data1.get("C03");
		values3.add(thirdCourse[0]);
		values3.add(thirdCourse[1]);
		values3.add(thirdCourse[2]);
		values3.add(thirdCourse[3]);
		
		barDataSet3.setData(values3);
		
		BarChartDataSet barDataSet4 = new BarChartDataSet();
		barDataSet4.setLabel("Модели на софтуерни системи");
		barDataSet4.setBackgroundColor("rgba(51, 238, 138, 0.2)");
		barDataSet4.setBorderColor("rgb(51, 238, 138)");
		barDataSet4.setBorderWidth(1);
		List<Number> values4 = new ArrayList<>();
		int[] forthCourse = data1.get("C04");
		values4.add(forthCourse[0]);
		values4.add(forthCourse[1]);
		values4.add(forthCourse[2]);
		values4.add(forthCourse[3]);
		
		barDataSet4.setData(values4);
		
		

		data.addChartDataSet(barDataSet);
		data.addChartDataSet(barDataSet2);
		data.addChartDataSet(barDataSet3);
		data.addChartDataSet(barDataSet4);

		List<String> labels = new ArrayList<>();
		labels.add("Първо желание");
		labels.add("Второ желание");
		labels.add("Трето желание");
		labels.add("Четвърто желание");
		data.setLabels(labels);
		barModel2.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		linearAxes.setOffset(true);
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Bar Chart");
		options.setTitle(title);

		barModel2.setOptions(options);
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public BarChartModel getBarModel2() {
		return barModel2;
	}

	public void setBarModel2(BarChartModel barModel2) {
		this.barModel2 = barModel2;
	}

}