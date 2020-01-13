
package Controllers;

import Models.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
public class listarMotor
{
    private JdbcTemplate jdbcTemplate;
    
    public listarMotor()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("lista.htm")
    public ModelAndView home(HttpServletRequest request)
    {
       
        ModelAndView mav=new ModelAndView();
        String sql="select * from motores";
        List motores=this.jdbcTemplate.queryForList(sql);
        /*switch (opc)
        {
            case "1":mav.addObject("cartel","<p class='alert alert-danger'>Cliente eliminado con éxito</p>");
            break;
            case "2":mav.addObject("cartel","<p class='alert alert-success'>Alta realizada</p>");
            break;
            case "3":mav.addObject("cartel","<p class='alert alert-warning'>Cliente modificado</p>");
            break;
            default:break;
        }
        */
        mav.addObject("motores",motores);
        mav.setViewName("lista");
        return mav;
    }
}
