/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author Merzlikin V.S.
 */
public class ExampleApplication extends AuthenticatedWebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return ExamplePage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return MySession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void init() {
        super.init();
        /*getAjaxRequestTargetListeners().add(new AjaxRequestTarget.AbstractListener() {
            @Override
            public void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                attributes.getAjaxCallListeners().add(new AjaxCallListener() {
                    @Override
                    public CharSequence getSuccessHandler(Component component) {
                        CharSequence handler = super.getSuccessHandler(component);
                        String var = "console.log(\"success\", textStatus, jqXHR, data, attrs)";
                        return handler == null ? var : handler + ";" + var;
                    }

                    @Override
                    public CharSequence getCompleteHandler(Component component) {
                        CharSequence handler = super.getCompleteHandler(component);
                        String var = "console.log(\"complete\", textStatus, jqXHR, attrs)";
                        return handler == null ? var : handler + ";" + var;
                    }

                    @Override
                    public CharSequence getFailureHandler(Component component) {
                        CharSequence handler = super.getFailureHandler(component);
                        String var = "console.log(\"failure\", textStatus, jqXHR, attrs)";
                        return handler == null ? var : handler + ";" + var;
                    }

                    @Override
                    public CharSequence getAfterHandler(Component component) {
                        CharSequence handler = super.getAfterHandler(component);
                        String var = "console.log(\"after\", attrs)";
                        return handler == null ? var : handler + ";" + var;
                    }

                    @Override
                    public CharSequence getDoneHandler(Component component) {
                        CharSequence handler = super.getDoneHandler(component);
                        String var = "console.log(\"done\", attrs)";
                        return handler == null ? var : handler + ";" + var;
                    }
                });
                super.updateAjaxAttributes(attributes);
            }

        });*/
    }

}
