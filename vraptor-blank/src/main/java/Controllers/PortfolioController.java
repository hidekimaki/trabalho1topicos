/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import autorizacao.Public;
import autorizacao.logged;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import javax.inject.Inject;
import modelo.Person;

@Controller
@Path("/portfolio")
public class PortfolioController {

     @Inject
    private Validator validator;
    @Inject
    private logged loggedUser;
    @Inject
    private Result result;
    
    
    
    @Get(value = {"", "/"})
    public void login() {
        System.out.println("Abrindo a página login");
    }

    public void erro() {
        System.out.println("Erro");
    }

    
    @Public
    @Post
    public void autenticar(Person p) {
        try {
            if (p.getUser().equals("admin") && p.getPass().equals("1234")) {
                p.setName("Administrador do sistema");
                this.loggedUser.login(p);
                this.result.redirectTo("/");
            } else {
                validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
            }
        } catch (NullPointerException ex) {
            validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
        }
        validator.onErrorForwardTo(this).erro();
    }
     
}
