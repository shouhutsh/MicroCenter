package cn.edu.zzti.pi.micro_center.controller;

import cn.edu.zzti.pi.micro_center.service.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @Autowired
    private NodeManagerService nodeManagerService;

    @GetMapping("/")
    public String index() {
        return "test";
    }
}
