package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.PlaneBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airport")
public class AirportAPI {

    PlaneBean[] tab = new PlaneBean[5];

    //http://localhost:8080/airport/nextplace
    @GetMapping("/nextplace")
    public int nextplace() {
        System.out.println("/nextplace");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                return i;
            }
        }

        return -1;
    }

    //http://localhost:8080/airport/nextplace
    @PostMapping("/park")
    public int park(@RequestBody PlaneBean plane, Integer position) {
        System.out.println("/park plane=" + plane + "\nposition=" + position);

        //Controle
        if(position == null || position <0|| position >= tab.length) {
            return 216;
        }
        else if (tab[position] != null) {
            //Position déjà prise
            return 215;
        }
        //Données reçus incomplètes
        else if(plane == null || plane.getName() == null || plane.getId() == null){
            return 214;
        }

        tab[position] = plane;

        return 200;
    }

    @GetMapping("/takeoff")
    public int takeoff(Integer position){
        System.out.println("/takeoff position=" + position);

        //Controle
        if(position == null || position <0|| position >= tab.length) {
            return 216;
        }
        else if (tab[position] == null) {
            //Position vide
            return 215;
        }
        tab[position] = null;

        return 200;
    }

    @GetMapping("/state")
    public PlaneBean[] state(){
        System.out.println("/state");

        return tab;
    }

    //Méthode qui permet de réinitialiser les données entre 2 tests
    //http://localhost:8080/airport/reset
    @GetMapping("/reset")
    public void reset() {
        tab = new PlaneBean[5];
    }

}
