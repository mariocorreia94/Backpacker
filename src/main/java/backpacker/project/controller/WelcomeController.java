package backpacker.project.controller;

import backpacker.project.service.UserService;
import backpacker.project.utils.GoogleMapsAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class WelcomeController extends HttpServlet{

    @Autowired
    private UserService userServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/destination")
    public ModelAndView showLogin(HttpSession session, Model model) {

        ModelAndView modelAndView = new ModelAndView("destination");

        if (session.getAttribute("user") == null)
        {
            model.addAttribute("error", "Sessão inválida, por favor efectuar login novemante");
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "newTrip")
    public ModelAndView newTrip(String origin, String destiny) {

        GoogleMapsAPI googleMaps = new GoogleMapsAPI(origin, destiny);
        System.out.println("Distancia: " + googleMaps.calculateDistance() + " km");
        return null;
    }

}
