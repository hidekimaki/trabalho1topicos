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
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import modelo.Category;
import modelo.Document;
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
<<<<<<< HEAD
    

=======
    @Inject 
    private CategoryDAO cateDAO;
>>>>>>> 359739d2636c507219ede5c3c48435b331f40b2d
    
    @Public
    @Get(value = {"", "/",})
    public void login() {
        if (loggedUser.isLogged()) {
            result.include("status", true);
            result.redirectTo(this).panel();
        } else {
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

    @Path(value = {"/documents/new"}, priority = Path.HIGH)
    @Get
    public void form() {
        
    }

    
    @Public
    @Path(value = {"/register",})
    @Get
<<<<<<< HEAD
    public void register() {
        if (loggedUser.isLogged()) {
            result.redirectTo(this).panel();
        }
=======
    public void register(){
        if(loggedUser.isLogged()){ 
           result.redirectTo(this).login();
        }    
>>>>>>> 359739d2636c507219ede5c3c48435b331f40b2d
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
        } catch (Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Carro"));
        }
        result.redirectTo(this).panel();
    }

    @Path(value = {"/panel",})
    @Get
    public void panel() {
        result.include("status", true);
        result.include("usuario", loggedUser.getPessoa());
    }

    @Get
    public void erro() {
        System.out.println("Erro de Autenticação");
    }

    
    @Public
    @Get
    @Path(value = {"/logout",})
    public void logout() {
        loggedUser.logout();
        result.redirectTo(this).login();
    }

    @Get
    @Path(value = {"/categories/new",})
<<<<<<< HEAD
    public void categoria() {

    }

    @Get
    @Path(value = {"/categories/all",})
    public void listcategories() {

    }

=======
    public void categoria(){
    }
    
    @Post
    public void savecat(@Valid Category c) {
        validator.onErrorForwardTo(this).form();
        System.out.println("Nome: " + c.getName());
        try {
            this.cateDAO.save(c);
        }catch(Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Categoria"));
        }
         result.redirectTo(this).panel();
    }
    
    
    
    
>>>>>>> 359739d2636c507219ede5c3c48435b331f40b2d
    @Public
    @Post
    public void autenticar(Person p) {
        Person teste = personDAO.createQuery().field("user").equal(p.getUser()).get();
        if (teste == null) {
            System.out.println("null");

            validator.add(new SimpleMessage("invalid", "User inválidos!"));
        } else {
            System.out.println("User  exite");
            if (teste.getPass().equals(p.getPass())) {
                this.loggedUser.login(teste);
                this.result.redirectTo("/portfolio/panel");
                return;
            } else {
                validator.add(new SimpleMessage("invalid", "Senha inválidos!"));
            }
        }
        validator.onErrorRedirectTo(this).login();
    }
}
