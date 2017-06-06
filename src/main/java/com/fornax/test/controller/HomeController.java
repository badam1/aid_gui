package com.fornax.test.controller;

/*
 * Created by Adam Bodansky on 2017.06.06..
 */

import com.fornax.test.dto.AidDTO;
import com.fornax.test.service.AidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final AidService aidService;

    @Autowired
    public HomeController(AidService aidService) {
        this.aidService = aidService;
    }

    @GetMapping("/")
    public String openHome() {
        log.info("openHome()");
        return "home";
    }

    @GetMapping("/listAllAid")
    public String listAllAid(Model model) {
        List<AidDTO> aidDTOList = aidService.createAidDTOListFromJsonAidList();
        log.info("listAllAid() {}", aidDTOList);
        model.addAttribute("aidDTOList", aidDTOList);
        return "home";
    }
}
