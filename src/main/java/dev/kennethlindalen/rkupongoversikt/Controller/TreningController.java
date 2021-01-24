package dev.kennethlindalen.rkupongoversikt.Controller;

import com.google.gson.Gson;
import dev.kennethlindalen.rkupongoversikt.Service.TreningService;
import dev.kennethlindalen.rkupongoversikt.model.Trening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreningController {

    @Autowired
    private TreningService treningService;

    Gson gson = new Gson();

    @RequestMapping("/")
    public String getAll(){
        return gson.toJson(treningService.getAll());
    }

    @RequestMapping("/create")
    public String create(@RequestParam String dato, @RequestParam String stil,
                         @RequestParam String tid, @RequestParam Boolean fullfort,
                         @RequestParam Boolean planlagt){
        Trening trening = treningService.create(dato, stil, tid, fullfort, planlagt);

        return gson.toJson(trening);
    }

    @RequestMapping("/update")
    public String update(@RequestParam String id,@RequestParam String dato, @RequestParam String stil,
                         @RequestParam String tid, @RequestParam Boolean fullfort,
                         @RequestParam Boolean planlagt){
        Trening trening = treningService.update(id,dato, stil, tid, fullfort, planlagt);

        return gson.toJson(trening);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id){
        treningService.delete(id);

        return gson.toJson("Deleted trening with id:" + id);
    }

}
