package backpacker.project.controller;

import backpacker.project.model.User;
import backpacker.project.service.UserService;
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
public class UserController extends HttpServlet {

    @Autowired
    private UserService userServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("newUser", new User());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "newUser")
    public String createClient(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        userServiceImp.newUser(user);

        redirectAttributes.addFlashAttribute("Added user " + user.getUsername() + " successfully!");

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public String login(@Valid User user) {

        if (userServiceImp.authenticate(user.getUsername(), user.getPassword())) {
            return "redirect:/yesssss";
        }

        return "redirect:/";
    }
}