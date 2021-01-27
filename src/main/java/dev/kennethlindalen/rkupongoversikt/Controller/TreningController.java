package dev.kennethlindalen.rkupongoversikt.Controller;

import com.google.gson.Gson;
import dev.kennethlindalen.rkupongoversikt.Controller.Models.TreningDTO;
import dev.kennethlindalen.rkupongoversikt.Service.TreningService;
import dev.kennethlindalen.rkupongoversikt.Models.Trening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TreningController {

    @Autowired
    private TreningService treningService;

    Gson gson = new Gson();

    @RequestMapping("/")
    public String getAll(){
        return gson.toJson(treningService.getAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody TreningDTO t){
        Trening trening = treningService.create(
                t.getDato(), t.getStil(),
                t.getTid(), t.getFullfort(),
                t.getPlanlagt());

        return gson.toJson(trening);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody TreningDTO t){
        Trening trening = treningService.update(
                t.getId(), t.getDato(),
                t.getStil(), t.getTid(),
                t.getFullfort(), t.getPlanlagt()
        );

        return gson.toJson(trening);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id){
        treningService.delete(id);

        return gson.toJson(String.format("Trening med id: %s er slettet.", id));
    }

}
