/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CategoryDAO;
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

    @Inject
    private CategoryDAO cateDAO;

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

        result.include("person", id);
        result.forwardTo(this).form();
    }

    @Path(value = {"/documents/new"}, priority = Path.HIGH)
    @Get
    public void form() {
        result.include("categories", cateDAO.find().asList());

    }

    @Path(value = {"/documents/save",})
    @Get
    public void saveForm() {
        Document newdoc = new Document();
        loggedUser.getPessoa().Add(newdoc);
        result.redirectTo(this).panel();
    }

    @Public
    @Path(value = {"/register",})
    @Get
    public void register() {
        if (loggedUser.isLogged()) {
            result.redirectTo(this).panel();
        }
    }
    
 

    @Post
    public void save(@Valid Person p) {
        validator.onErrorForwardTo(this).form();
        System.out.println("Marca: " + p.getName());
        System.out.println("Modelo: " + p.getUser());
        System.out.println("Modelo: " + p.getPass());
        p.setRank(2);
        try {
            //this.carroDAO.insert(carro);
            this.personDAO.save(p);
        } catch (Exception ex) {
            validator.add(new SimpleMessage("dao", "Erro ao gravar Carro"));
        }
        result.redirectTo(this).login();
    }

    @Path(value = {"/panel",})
    @Get
    public void panel() {
        if (loggedUser.isLogged()) {
            result.include("status", true);
            result.include("usuario", loggedUser.getPessoa());
            Person teste = personDAO.get(loggedUser.getPessoa().getId());

            //Tentei add um documento diretamente na classe de usuario para exibir porém ele fica dando null eu sinceramente não sei o porque...
            
            Document meuDoc = new Document();
            //tenta adicionar desta forma
            personDAO.get(loggedUser.getPessoa().getId()).Add(meuDoc);
            //teste.Add(meuDoc);
            //teste.Add(teste2);
            result.include("documentoList", teste.getDocumentos());
            //result.include("documentoList", teste.getDocumentos());
        }
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
    public void categoria() {
        result.include("status", true);
        result.include("usuario", loggedUser.getPessoa());
        if (loggedUser.getPessoa().getRank() != 2) {
            result.redirectTo(this).panel();
             System.out.println("Erro de usuario nao autorizado");
        }
    }

    @Get
    @Path(value = {"/categories/all",})
    public List<Category> listcategories() {
        result.include("status", true);
        result.include("usuario", loggedUser.getPessoa());
        if (loggedUser.getPessoa().getRank() != 2) {
            result.redirectTo(this).panel();
        }
        return cateDAO.find().asList();

    }

    @Post
    public void savecat(@Valid Category c) {
        System.out.println(c.getName());
        if (c.getName() == null) {
            validator.add(new SimpleMessage("dao", "Favor Informe o nome da categoria"));
        } else {
            try {
                this.cateDAO.save(c);
            } catch (Exception ex) {
                validator.add(new SimpleMessage("dao", "Erro ao gravar Categoria"));
            }
            result.redirectTo(this).listcategories();
        }
        validator.onErrorForwardTo(this).categoria();
    }
    
    @Post
    public void deletecat(Category cat){
        this.cateDAO.deleteById(cat.getId());
        result.redirectTo(this).listcategories();
    }
    
    @Path(value = {"/categories/{id}"}, priority = Path.LOW)
    @Get
    public void editcat(String id) {

        result.include("cat", id);
        result.forwardTo(this).categoria();
    }

    @Post
    public void updatePerson() {
        personDAO.updateUserDAO(this.loggedUser.getPessoa());
         result.redirectTo(this).panel();
    }
    
    
    
    
    

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
