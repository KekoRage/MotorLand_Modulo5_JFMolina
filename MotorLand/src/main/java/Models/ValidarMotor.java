/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
/**
 *
 * @author kekor
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/* Clase para realizar las validaciones*/
public class ValidarMotor implements Validator {

   
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Motores.class.isAssignableFrom(type);
       // return TuClase.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Motores motor=(Motores)o;
        
     
       
        if (motor.getModelo().length()!=5)
        {
            errors.rejectValue("modelo", "verificamodelo","El modelo debe de ser de 5 caracteres.");
        }
        
        if(motor.getPeso()<0)
        {
	    errors.rejectValue("peso", "verificapeso","El peso tiene que ser mayor que 0.");
	}
         if( motor.getPotencia()<0)
        {
	    errors.rejectValue("potencia", "verificapotencia","La potencia tiene que ser mayor que 0.");
	}
        if( motor.getCantidad()<=0)
        {
	    errors.rejectValue("cantidad", "verificapotencia","La cantidad no puede ser negativa.");
	}
    }
    
}