/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao;

import Controllers.PortfolioController;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import javax.inject.Inject;

/**
 *
 * @author Hideki
 */
public class Interceptor {
    @Inject private logged loggedUser;
    @Inject private Result result;
    
    /* Condição de interceptação. É interceptado todo o método
       que não possui a anotação @Public
    */
    @Accepts
    public boolean accepts(ControllerMethod method) {
        return !method.containsAnnotation(Public.class);
    }
    
    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
        // Obtendo o usuário autenticado na sessão
        if(!loggedUser.isLogged()) {
            result.forwardTo(PortfolioController.class).login();
        }
        stack.next();
    }
    
    
}
