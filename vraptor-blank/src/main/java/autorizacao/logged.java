/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Person;

@SessionScoped
@Named
public class logged implements Serializable{
    
    
    private Person p;
    public void login(Person p) {
        this.p = p;
    }
    public void logout() {
        this.p = null;
    }
    public boolean isLogged() {
        return this.p != null;
    }

    public Person getPessoa() {
        return p;
    }
}
