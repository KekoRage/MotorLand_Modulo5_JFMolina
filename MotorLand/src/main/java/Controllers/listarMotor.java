
package Controllers;
/**
 *
 * @author kekor
 */
import Models.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;

@Controller
public class listarMotor
{
    private JdbcTemplate jdbcTemplate;
    
    public listarMotor()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("lista.htm") /* indicamos a que pagina mapeamos con este controller*/
    public ModelAndView home(HttpServletRequest request)
    {
       
        ModelAndView mav=new ModelAndView();
        String sql="select * from motores";
        List motores=this.jdbcTemplate.queryForList(sql);
        mav.addObject("motores",motores);
        mav.setViewName("lista");
        return mav;
    }
}
