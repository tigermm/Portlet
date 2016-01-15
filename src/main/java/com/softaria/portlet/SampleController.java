package com.softaria.portlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.portlet.mvc.AbstractController;

import javax.portlet.*;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("demo")
public class SampleController extends AbstractController{

    @ModelAttribute("someData") // send data to portlet on render phase.(see @ModelAttribute for method)
    public String getSomeData() {
        return "some data";
    }

    @RequestMapping  // send data to portlet on render phase.
    public ModelAndView showSiteForm() {
        // Used for the initial form as well as for redisplaying with errors.
        ModelAndView model = new ModelAndView("demo");
        model.addObject("message1", "data");
        return model;
    }

    @RenderMapping(params = "action=goSmt")
    public String renderGoMethod(Map<String, Object> map){
        UserName userName = new UserName();
        map.put("userName", userName);
        return "edit";
    }

    @RenderMapping(params = "action=showUserName")
    public String viewSuccess() {
        /**
         * Display userName.jsp
         */
        return "userName";

    }

    @ActionMapping(value = "actionOne")
    public void actionOneMethod(@ModelAttribute("userName") UserName userName, ActionRequest request, ActionResponse response, Model model) {
        logger.info("userName is==>" + userName.getName());
        logger.info("userName is==>" + ((UserName)(model.asMap().get("userName"))).getName());
        response.setRenderParameter("action", "showUserName");

        model.addAttribute("successModel", userName);
    }

    @ResourceMapping(value = "doSomeAjax")
    public void doSomeAjax(ResourceRequest request, ResourceResponse response) throws IOException {

    }

    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("demo");
        mav.addObject("message", "Check it out!");
        return mav;
    }
}