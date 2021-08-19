package br.com.letscode.infraestrutraescolareevasaoescolarapi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return new User("admin", "$2a$10$3hOb.yRrvRnv.SqPbUE3tuMUXYq8DujFBYAt95SAAhFkaiTZvZb0O",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Não foi encontrado usuário com o  username: " + username);
        }
    }
}
