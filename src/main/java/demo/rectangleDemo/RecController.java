package demo.rectangleDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecController {
    @GetMapping("/")
    public String index(){
        return "rectangle";
    }
    @GetMapping("/calculation")
    public String calcPerimAr(String w, String l, Model m){
        try {
            double width = Double.parseDouble(w);
            double length = Double.parseDouble(l);
            Rectangle r = new Rectangle(width, length);
            m.addAttribute("recArea", r.area());
            m.addAttribute("recPerim", r.perimeter());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            m.addAttribute("mistake", e.getMessage());
        }
        return "rect_result";
    }

}
