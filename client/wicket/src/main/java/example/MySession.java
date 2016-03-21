/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 *
 * @author Merzlikin V.S.
 */
public class MySession extends AbstractAuthenticatedWebSession {

    private Roles roles;

    public MySession(Request request) {
        super(request);
        roles = new Roles();
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public Roles getRoles() {
        return roles;
    }

    @Override
    public boolean isSignedIn() {
        return true;
    }
}
