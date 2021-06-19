package com.avital.auto_complete.service;

import com.avital.auto_complete.dao.NameRepository;
import com.avital.auto_complete.logic.Trie;
import com.avital.auto_complete.modle.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Initializer {
    @Autowired
    NameRepository nameRepo;
    private String path="src/main/resources/BoyNames.txt";
    public static Trie trie;
    private boolean inited=false;


    public void initializTrie(){
        Scanner scan = null;
        if(!inited){
            inited=true;
            try {
                scan = new Scanner(new File(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(scan.hasNextLine()){
                String line = scan.nextLine(); // dell
                Name n =new Name(line);
                nameRepo.save(n);
            }
            List<String> names = new ArrayList<String>();
            nameRepo.findAll().forEach(name -> names.add(name.getFirstName()));
            this.trie=new Trie(names);
        }


    }

}
