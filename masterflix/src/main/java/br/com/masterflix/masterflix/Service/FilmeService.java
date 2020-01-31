package br.com.masterflix.masterflix.Service;

import br.com.masterflix.masterflix.Model.Filme;
import br.com.masterflix.masterflix.Repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public Filme cadastroFilme(Filme filme){
        filme.setAtivo(Boolean.TRUE);
        filme.setDatacriacao(LocalDate.now());
        return repository.save(filme);
    }

    public Iterable<Filme> listaFilme(){
        Iterable<Filme> filme = repository.findAll();
        return filme;
    }

    public Filme buscarFilme(String nome) {
        Optional<Filme> filme= repository.findByNome(nome);
        if(filme.isPresent()){
            return filme.get();
        }
        return null;
    }
}
