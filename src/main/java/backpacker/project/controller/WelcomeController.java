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

    @RequestMapping(method = RequestMethod.POST, value = "/newTrip")
    public ModelAndView newTrip(Model model, String origin, String destiny) {

        ModelAndView modelAndView = new ModelAndView();

        if (origin.trim().isEmpty() && destiny.trim().isEmpty()) {
            model.addAttribute("error", "Por favor preencha a Origem e o Destino");
            modelAndView.setViewName("destination");
            return modelAndView;
        } else if (origin.trim().isEmpty()) {
            model.addAttribute("error", "Por favor indique o ponto de partida");
            modelAndView.setViewName("destination");
            return modelAndView;
        } else if (destiny.trim().isEmpty()) {
            model.addAttribute("error", "Por favor indique o destino");
            modelAndView.setViewName("destination");
            return modelAndView;
        }

        GoogleMapsAPI googleMaps = new GoogleMapsAPI(origin, destiny);
        int km = googleMaps.calculateDistance();

        if (km == -1) {
            model.addAttribute("error", "Não foi possivel encontrar a sua origem");
            modelAndView.setViewName("destination");
            return modelAndView;
        } else if (km == -2) {
            model.addAttribute("error", "Não foi possivel encontrar o seu destino");
            modelAndView.setViewName("destination");
            return modelAndView;
        }
        model.addAttribute("success", "Distancia: " + km + " km");
        modelAndView.setViewName("destination");
        return modelAndView;
    }

}
