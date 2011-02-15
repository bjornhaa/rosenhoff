package no.rosenhoff.servlet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 23, 2010
 * Time: 2:10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input = (String) value;

    }
}
