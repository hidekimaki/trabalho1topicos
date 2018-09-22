/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.UserDAO;
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
import javax.validation.Valid;
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
    @Inject
    private UserDAO personDAO;
    
    
    @Public
    @Get(value = {"", "/",})
    public void login() {
        if(loggedUser.isLogged()){ 
           result.include("status", true);
           result.redirectTo(this).panel();
        }else{
           result.include("status", false);
        }
    
        System.out.println("Abrindo a página login");
    }

    
    @Path(value = {"{id}"}, priority = Path.LOW)
    @Get
    public void edit(String id) {
        result.include("carro", id);
        result.forwardTo(this).form();
    }

    @Path(value = {"/new"}, priority = Path.HIGH)
    @Get
    public void form() {

    }
    
    @Path(value = {"/register",})
    @Get
    public void register(){
        if(loggedUser.isLogged()){ 
           result.redirectTo(this).panel();
        }    
        System.out.println("Abrindo a página register");
    }
    
    @Post
    public void save(@Valid Person p) {
        validator.onErrorForwardTo(this).form();
        System.out.println("Marca: " + p.getName());
        System.out.println("Modelo: " + p.getUser());
        System.out.println("Modelo: " + p.getPass());
        
        try {
            //this.carroDAO.insert(carro);
            this.personDAO.save(p);
        }catch(Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Carro"));
        }
         result.redirectTo(this).panel();
        
    }
    
    @Path(value = {"/panel",})
    @Get
    public void panel(){
        result.include("status", true);
        result.include("nome", loggedUser.getPessoa());
    }
    
    @Get
    public void erro() {
        System.out.println("Erro de Autenticação");
    }

    @Public
    @Post
    public void done(Person p) {
        try {

        } catch (NullPointerException ex) {
            validator.add(new SimpleMessage("invalid", "Digite todos os dados!"));
        }
    }
    

    @Public
    @Get
    @Path(value = {"/logout",})
    public void logout(){
        loggedUser.logout();
        result.redirectTo(this).login();
    }

    @Public
    @Post
    public void autenticar(Person p) {
        try {
            if (p.getUser().equals("admin") && p.getPass().equals("1234")) {
                p.setName("Administrador do sistema");
                this.loggedUser.login(p);
                this.result.redirectTo("/portfolio/panel");
                
                return;
            } else {
                validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
            }
        } catch (NullPointerException ex) {
            validator.add(new SimpleMessage("invalid", "Login e/ou Senha inválidos!"));
        }
        validator.onErrorForwardTo(this).erro();
    }
}
