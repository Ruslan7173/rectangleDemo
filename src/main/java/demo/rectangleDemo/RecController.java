package demo.rectangleDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecController {
    //Вариант "на коленке" - сделать список прямо полем Контроллера
    //List<Rectangle> historyList = new ArrayList<>();
    //кондовый способ


    //Вариант "по-спрнговски" - сделать бин Службы и связать с бином Контроллера
    @Autowired
    RectangleService rectangleService;

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
            //historyList.add(r);
            rectangleService.add(r);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            m.addAttribute("mistake", e.getMessage());
        }
        //return "rect_result";
        return "rectangle";
    }

    @GetMapping("/history")
    public String showHistory(Model m){
        //m.addAttribute("message", historyList.toString());
        m.addAttribute("message", rectangleService.getRectangleList().toString());
        return "rectangle";
    }
}
