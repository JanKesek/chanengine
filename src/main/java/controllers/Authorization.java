package controllers;
import java.security.AccessController;
import java.security.Principal;
import java.security.PrivilegedAction;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.security.acl.Group;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/login")
public class Authorization {

        @Context
        private HttpServletRequest req;

        @GET
        @Produces("text/plain")
        public String login(@QueryParam("user") String username, @QueryParam("pass") String password) {
            try {
                req.login(username, password);
                Subject subject = org.jboss.security.SecurityContextAssociation.getSubject();
                Optional<Group> rolesGroup = subject.getPrincipals(Group.class).stream().filter(p -> "Roles".equals(p.getName()))
                        .findFirst();
                if (rolesGroup.isPresent()) {
                    List<String> roleNames = Collections.list(rolesGroup.get().members()).stream().map(p -> p.getName())
                            .collect(Collectors.toList());
                    return "You're logged with roles: " + roleNames;
                } else {
                    return "You're logged without roles: " + subject;
                }
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return "Login failed for user " + username;
        }
}
