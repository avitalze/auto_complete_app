package com.avital.auto_complete;


import com.avital.auto_complete.dao.NameRepository;
import com.avital.auto_complete.logic.Trie;
import com.avital.auto_complete.modle.Name;
import com.avital.auto_complete.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/AutoComplete")
public class AutoCompleteController {
    @Autowired
    NameRepository nameRepo;
//    List <String> tempList=List.of("Jacob","Joshua","Joseph","Daniel","David", "D", "William");//new ArrayList<>();
    private Trie trie;// =new Trie(tempList);


    public void initializTrie(){
        Scanner scan = null;
        try {
            scan = new Scanner(new File("src/main/resources/BoyNames.txt"));
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

    @GetMapping("/getOptions")
    public List<String> getCoralStatus(@RequestParam String prefix) {
        // URL : http://localhost:9090/AutoComplete/getOptions?prefix=J
        // it case sensative !

        initializTrie();
        System.out.println(prefix);
        List<String> allSuggests= trie.suggest(prefix);

//        List<String> ans1= trie.suggest("j");
//        List<String> ans2= trie.suggest("J");
//        List<String> ans3= trie.suggest("Jo");
//        List<String> ans4= trie.suggest("D");
//        List<String> ans5= trie.suggest("W");

        return allSuggests; //List.of("hi","my","friend");
    }


}
