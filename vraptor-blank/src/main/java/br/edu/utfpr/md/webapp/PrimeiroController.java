package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class PrimeiroController {
    
    @Get
    public void pagina1() {
        System.out.println("Abrindo a página 1");
    }

    @Get
    public void pagina2() {
        System.out.println("Abrindo a página 2");
    }
}
