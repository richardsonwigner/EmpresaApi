package com.example.EmpresaApi.Security;

import java.util.Optional;

import com.example.EmpresaApi.Repository.UsuarioRepository;
import com.example.EmpresaApi.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Usuario> user = usuarioRepository.findByEmail(username);

        if(user != null)
        {
            return user.get();
        }
        return null;
    }

}
