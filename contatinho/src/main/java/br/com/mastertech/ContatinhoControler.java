package br.com.mastertech;

import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
class contatoControler {
    @GetMapping
    public String mostraHome(){ return "index";}

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String mostrarReposta(Contato contato, Model model){
        model.addAttribute("nome", contato.getNome());
        model.addAttribute("email", contato.getEmail());

        return "resposta";
    }

}
