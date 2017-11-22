package backpacker.project.controller;

import backpacker.project.model.User;
import backpacker.project.service.UserService;
import backpacker.project.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController extends HttpServlet {

    @Autowired
    private UserService userServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("login", new User());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ModelAndView doLogin(@Valid @ModelAttribute("login") User user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
            return modelAndView;
        }

        if (userServiceImp.authenticate(user.getUsername(), Security.getHash(user.getPassword()))) {
            System.out.println("inside login");
            modelAndView.setViewName("destination");
            return modelAndView;
        }
        System.out.println("user: " + user.getUsername() + "pass: " + Security.getHash(user.getPassword()) );

        System.out.println("ouside login");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}