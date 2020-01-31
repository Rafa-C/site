package br.com.masterflix.masterflix.Controller;

import br.com.masterflix.masterflix.Model.Filme;
import br.com.masterflix.masterflix.Service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String pagcadastro(){
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastro(Filme filme){
        service.cadastroFilme(filme);
        return "cadastro";
    }

    @GetMapping("/buscar")
     public String buscarFilme(){
     return "buscar";
        }

        @GetMapping("/filmes")
        public ModelAndView listaFilme(){
        ModelAndView pagina = new ModelAndView("filmes");
        Iterable<Filme> Fil = service.listaFilme();
        pagina.addObject("filmes", Fil);
        return pagina;
         }


        @GetMapping("filmes")
        public String buscarFilme(@RequestParam("nome") String nome, Model model){
        Filme filme = service.buscarFilme(nome);
        }

}
