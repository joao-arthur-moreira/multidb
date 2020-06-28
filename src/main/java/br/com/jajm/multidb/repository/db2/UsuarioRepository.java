package br.com.jajm.multidb.repository.db2;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jajm.multidb.model.db2.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
