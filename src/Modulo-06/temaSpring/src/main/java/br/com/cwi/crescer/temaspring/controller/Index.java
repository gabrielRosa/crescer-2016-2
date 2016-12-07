package br.com.cwi.crescer.temaspring.controller;

// @author Gabriel
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class Index {

    @RequestMapping(method = GET)
    public String toIndex() {
        return "index";
    }
}
