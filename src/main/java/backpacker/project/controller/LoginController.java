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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController extends HttpServlet {

    @Autowired
    private UserService userServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newLogin", new User());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ModelAndView doLogin(HttpSession session, Model model, @Valid @ModelAttribute("newLogin") User user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
            return modelAndView;
            //return "redirect:/";
        }

        if (userServiceImp.authenticate(user.getUsername(), Security.getHash(user.getPassword()))) {

            session.setAttribute("user", user);
            modelAndView.setViewName("redirect:/destination");
            model.addAttribute("user", user);
            return modelAndView;
        }

        model.addAttribute("error", "Autenticação errada");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}