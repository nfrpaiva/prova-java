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
@RequestMapping("/hello")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    private String getHello(Model model) {

        List<Contato> contatos = contatos();

        logger.info("Contatos: {}", contatos);

        model.addAttribute("contatos", contatos);
        model.addAttribute("contato1", new Contato());

        return "hello";
    }

    private List<Contato> contatos() {
        List<Contato> contatos = new ArrayList<>();
        Contato c1 = new Contato(1l, "Pessoa 01", "+5511999999999");
        Contato c2 = new Contato(2l, "Pessoa 02", "+5511988888888");
        contatos.add(c1);
        contatos.add(c2);
        return contatos;
    }

    @PostMapping("contato")
    public String inserirContato (@ModelAttribute("contato1") Contato contato, Model model){
        logger.info("Vejamos se o contato chegou : {}", contato);

        List<Contato> contatos = contatos();

        logger.info("Contatos: {}", contatos);

        contatos.add(contato);

        model.addAttribute("contatos", contatos);
        model.addAttribute("contato1", new Contato());

        return "hello";

    }


}