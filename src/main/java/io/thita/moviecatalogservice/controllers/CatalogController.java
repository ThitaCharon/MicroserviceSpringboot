package io.thita.moviecatalogservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @RequestMapping("/{userId}")
    public String getCatalog(@PathVariable("userId") String userId){
        return new String("a list of catalog associate with userId : " + userId) ;
    }
}
