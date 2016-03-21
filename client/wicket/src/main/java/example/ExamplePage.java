/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 *
 * @author Merzlikin V.S.
 */
public class ExamplePage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Form form1 = new Form("form1") {
            @Override
            protected void onSubmit() {
                success("Success");
                Session.get().invalidateNow();
            }
        };
        form1.add(new FeedbackPanel("feedback", new ComponentFeedbackMessageFilter(form1)));
        add(form1);
        WebMarkupContainer c = new WebMarkupContainer("cont");
        c.setOutputMarkupId(true);
        Form form2 = new Form("form2");
        form2.add(new FeedbackPanel("feedback", new ComponentFeedbackMessageFilter(form2)));
        form2.add(new AjaxSubmitLink("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                form.success("Ajax success");
                target.add(form2);
            }
        });
        c.add(form2);
        add(c);
    }
}
