package com.Library.Library.service;

import com.Library.Library.model.Library;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {

    private static List<Library> libraries=new ArrayList<>();
    static {
        libraries.add(new Library("ABS","Thakur Gang ,lucknow",1,"well maintainability"));
        libraries.add(new Library("Angel","Raja Ji Puram, lucknow",2,"well maintainability"));
        libraries.add(new Library("Auxford","Aiya Gang lucknow",3,"well maintainability"));
        libraries.add(new Library("Knowlegefull","Gomti Nagar Gang lucknow",4,"well maintainability"));
        libraries.add(new Library("Expert","Hajarat Gang lucknow",5,"well maintainability"));
    }

    public void addLibrary(Library library){
        libraries.add(library);
    }

    public List<Library> getLibrary(){
        return libraries;
    }

    public Library getByName(String name){
        for (Library obj:libraries){
            if(name.equals(obj.getLibraryName())){
                return obj;
            }
        }
        return null;
    }


}
