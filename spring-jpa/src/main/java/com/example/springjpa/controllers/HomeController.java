package com.example.springjpa.controllers;

import com.example.springjpa.entity.Candle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springjpa.service.CandleService;
import com.example.springjpa.service.CandleServiceInterface;

@Controller
public class HomeController {
    private CandleServiceInterface csi;

    @Autowired
    public HomeController(CandleServiceInterface cs){
        this.csi = cs;
    }

    @RequestMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("candles", csi.getCandleList());
        return "index";
    }

    @RequestMapping("/candles/{candle}")
    public String showCandlePage(@PathVariable String candle, Model model){
        String amount = "";
        model.addAttribute("candle", csi.getCandle(candle));
        model.addAttribute("amount", amount);
        return "candle";
    }

    @PostMapping("/buy-candle")
    public String buyItem(@RequestParam int id, @RequestParam String amount){
        Candle c = csi.getCandle(id);
        csi.purchase(c.getId(), Integer.parseInt(amount));
        return "redirect:/";
    }
}
