package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.servis.CarServisImp;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private CarServisImp carServis;

    @Autowired
    public CarsController(CarServisImp carServ) {
        this.carServis = carServ;
    }


    @GetMapping()
    public String getCoutCars (@RequestParam(value = "count",defaultValue = "5") int count,
                               CarServisImp carServis, Model model) {
        model.addAttribute("cars", carServis.getCars(count));

        return "cars";
    }

}
