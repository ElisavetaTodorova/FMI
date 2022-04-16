package lab10;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "example")
@RequestScoped
public class Example {

	private String text;

	private String count;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void updateText() {
		
		
		int c = Integer.parseInt(count);
		
		if (c == 0) {
			this.text = "няма поръчани стоки";
		} else if (c < 10) {
			this.text = "цена на дребно";
		} else if (c >= 10) {
			this.text = "цена на едро(10 % отстъпка)";
		}
		
	}
}
