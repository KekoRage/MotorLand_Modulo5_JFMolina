
package Models;
/**
 *
 * @author kekor
 */
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/* Clase java donde le ponemos los atributos necesarios para realizar la conexion con BBDD.*/
public class Conectar {
 
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/motorland");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
}
