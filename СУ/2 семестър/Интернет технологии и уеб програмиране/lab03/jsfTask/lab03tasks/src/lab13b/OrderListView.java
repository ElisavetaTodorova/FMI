package lab13b;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="orderListView")
@RequestScoped
public class OrderListView {
	


	    private List<String> cities;

	    @PostConstruct
	    public void init() {
	        //Cities
	        cities = new ArrayList<>();
	        cities.add("San Francisco");
	        cities.add("London");
	        cities.add("Paris");
	        cities.add("Istanbul");
	        cities.add("Berlin");
	        cities.add("Barcelona");
	        cities.add("Rome");

	    }

	 

	    public List<String> getCities() {
	        return cities;
	    }

	    public void setCities(List<String> cities) {
	        this.cities = cities;
	    }

	    public void onReorder() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
	    }

}
