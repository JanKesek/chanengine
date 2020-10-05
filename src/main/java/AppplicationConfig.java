import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/boards")
@ApplicationScoped
@ManagedBean
public class AppplicationConfig extends Application {

    public AppplicationConfig(){}
}
