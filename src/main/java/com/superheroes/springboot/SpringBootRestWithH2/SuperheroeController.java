package com.superheroes.springboot.SpringBootRestWithH2;

import com.superheroes.springboot.SpringBootRestWithH2.model.Superheroe;
import com.superheroes.springboot.SpringBootRestWithH2.service.SuperheroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SuperheroeController {

    @Autowired
    private SuperheroeService superheroeService;

    // Select, Insert, Delete, Update Operations for an Superheroe

    @RequestMapping(value = "/superheroe/{id}", method = RequestMethod.GET)
    Superheroe getSuperheroe(@PathVariable Integer id){
        return  superheroeService.findById(id).get();
    }

    @RequestMapping(value = "/superheroesByName/{name}", method = RequestMethod.GET)
    List<Superheroe> getAllSuperheroesByName(@PathVariable String name){
        return superheroeService.findByName(name);
    }

    @RequestMapping(value = "/superheroe", method = RequestMethod.POST)
    String addSuperheroe(@RequestBody Superheroe superheroe){
        Superheroe savedSuperheroe = superheroeService.save(superheroe);
        return "SUCCESS";
    }

    @RequestMapping(value = "/superheroe", method = RequestMethod.PUT)
    Superheroe updateSuperheroe(@RequestBody Superheroe superheroe){
        Superheroe updatedSuperheroe = superheroeService.save(superheroe);
        return updatedSuperheroe;
    }

    @RequestMapping(value = "/superheroe", method = RequestMethod.DELETE)
    Map<String, String> deleteSuperheroe(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Superheroe> superheroe = superheroeService.findById(id);
        if(superheroe.isPresent()) {
            superheroeService.delete(superheroe.get());
            status.put("Status", "Superheroe deleted successfully");
        }
        else {
            status.put("Status", "Superheroe not exist");
        }
        return status;
    }

    // Select, Insert, Delete for List of Superheroes

    @RequestMapping(value = "/superheroes", method = RequestMethod.GET)
    List<Superheroe> getAllSuperheroe(){
        return superheroeService.findAll();
    }

    @RequestMapping(value = "/superheroes", method = RequestMethod.POST)
    String addAllSuperheroes(@RequestBody List<Superheroe> superheroeList){
        superheroeService.saveAll(superheroeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/superheroes", method = RequestMethod.DELETE)
    String deleteAllSuperheroes(){
        superheroeService.deleteAll();
        return "SUCCESS";
    }
}
