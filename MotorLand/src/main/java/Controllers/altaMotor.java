/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
/**
 *
 * @author kekor
 */
import Models.Conectar;
import Models.Motores;
import Models.ValidarMotor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/* Controlador del alta de motores, donde se llama a las validaciobnes, iniciamos la conexion con BBDD y 
realizamos la query para insertar los valores en la tabla*/
@Controller
@RequestMapping("alta.htm") /* indicamos a que pagina mapeamos con este controller*/
public class altaMotor {
    
    
    private JdbcTemplate jdbcTemplate;
    private ValidarMotor validar;
    
    public altaMotor()  /*constructor que crea a su vez la conexion, el validador y el JDBC*/
    {
                Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
        this.validar = new ValidarMotor();
    }
    @RequestMapping(method=RequestMethod.GET) /* le indicamos lo que tiene que hacer cuando venga por GET*/
    public ModelAndView alta()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("alta");
        mav.addObject("motor",new Motores());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST) /* le indicamos lo que tiene que hacer cuando venga por POST*/
    public ModelAndView alta
        (
                @ModelAttribute("motor") Motores m,
                BindingResult result
        )
    {
         this.validar.validate(m, result);
        if (result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            mav.setViewName("alta");
            mav.addObject("motor",new Motores());
            return mav;
        }
        else
        {
        this.jdbcTemplate.update
        (
        "insert into motores (modelo,fabricante,potencia,peso,cantidad ) values (?,?,?,?,?)",
         m.getModelo(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad() );
         return new ModelAndView("redirect:/lista.htm");
        }
    }
       
    }


