package com.Library.Library.controller;

import com.Library.Library.model.Library;
import com.Library.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library-app")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add-library")
    public String addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
        return "Hey, Your task has been completed !";
    }

    @GetMapping("/get-all-library")
    public List<Library> getLibrary(){
        return libraryService.getLibrary();
    }

    @GetMapping("/get-by-name/name/{name}")
    public Library getByName(@PathVariable String name){
        return libraryService.getByName(name);
    }

}
