package lab10;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CustomEgnValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String test = "";
		
		
		test = "fsfs";
		
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Message Content."));
		
	}

}
