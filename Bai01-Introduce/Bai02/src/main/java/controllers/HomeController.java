package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HomeController {
    @GetMapping("/converter")
    public String index() {
        return "index";
    }

    @PostMapping("/usd")
    public String submit(@RequestParam String usd, String rate, Model model) {
        float result = Float.parseFloat(usd)*Float.parseFloat(rate);
        model.addAttribute("result1", result);
        return "submit";
    }

}
