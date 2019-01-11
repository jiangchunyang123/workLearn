package com.learn.spring.Chap5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpittleController {
    SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping("/spittles")
    public ModelAndView getSpittleList() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        modelAndView.getModel().put("spittleList", list);
        return modelAndView;
    }
}
