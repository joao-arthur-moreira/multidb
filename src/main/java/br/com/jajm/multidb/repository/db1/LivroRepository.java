package br.com.jajm.multidb.repository.db1;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jajm.multidb.model.db1.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
