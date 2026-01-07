package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.Usuario;
import com.gil.skillhubapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById( Long id ) {
        return usuarioRepository.findById( id ).orElse( null );
    }

    public Usuario findByEmail( String email ) {
        return usuarioRepository.findByEmail( email );
    }

    public Usuario save( Usuario usuario ) {
        return usuarioRepository.save( usuario );
    }

    public void deleteById( Long id ) {
        usuarioRepository.deleteById( id );
    }
}
