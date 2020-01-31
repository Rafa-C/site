package br.com.masterflix.masterflix.Repository;

import br.com.masterflix.masterflix.Model.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

    Optional<Filme> findByNome(String nome);
}
