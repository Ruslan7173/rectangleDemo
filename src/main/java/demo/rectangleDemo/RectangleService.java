package demo.rectangleDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RectangleService {
    List<Rectangle> rectangleList = new ArrayList<>();

    public void add(Rectangle r){
        rectangleList.add(r);
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }
}
