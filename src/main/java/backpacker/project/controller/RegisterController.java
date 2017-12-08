package backpacker.project.controller;

import backpacker.project.model.User;
import backpacker.project.service.UserService;
import backpacker.project.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class RegisterController extends HttpServlet {

    @Autowired
    private UserService userServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public ModelAndView showRegister() {

        ModelAndView modelAndView = new ModelAndView("register");

        modelAndView.addObject("newUser", new User());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createNewUser")
    public ModelAndView createClient(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }

        user.setPassword(Security.getHash(user.getPassword()));
        userServiceImp.newUser(user);

        modelAndView.setViewName("index");
        return modelAndView;

    }
}