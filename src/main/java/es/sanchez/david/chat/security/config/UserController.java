package es.sanchez.david.chat.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
public class UserController {
    @RequestMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean login(@RequestBody SecurityProperties.User user) {
        // TODO validate user has access
        return
                user.getName().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
}
