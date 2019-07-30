package br.com.tokiomarine.prova.view;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.prova.domain.Contato;

@Controller
@RequestMapping("/")
public class HelloController {

    public HelloController(){
        List<Contato> contatos = new ArrayList<>();
        Contato c1 = new Contato(1l, "Pessoa 01", "+5511999999999");
        Contato c2 = new Contato(2l, "Pessoa 02", "+5511988888888");
        contatos.add(c1);
        contatos.add(c2);
        this.contatos =  contatos;
    }

    private List<Contato> contatos;

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    private String getHello(Model model) {

        logger.info("Contatos: {}", this.contatos);

        model.addAttribute("contatos", this.contatos);
        model.addAttribute("contato", new Contato(20l, "Um contato", "+55119983495344"));

        return "index";
    }

    @PostMapping
    public String inserirContato (@ModelAttribute("contato") Contato contato, Model model){
        
        this.contatos.add(contato);

        model.addAttribute("contatos", contatos);
        model.addAttribute("contato", new Contato(20l, "Um contato", "+55119983495344"));
        model.addAttribute("mensagem", "Sucesso!");

        return "index";

    }


}