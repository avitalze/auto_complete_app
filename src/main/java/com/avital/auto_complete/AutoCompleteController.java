package com.avital.auto_complete;


import com.avital.auto_complete.logic.Trie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/AutoComplete")
public class AutoCompleteController {
    List <String> tempList=List.of("Jacob","Joshua","Joseph","Daniel","David", "D", "William");//new ArrayList<>();
    private Trie trie=new Trie(tempList);


    // ----- for check
    @GetMapping("/getAmigo")
    public String test() {

        return "hi hi amigo";
    }

    @GetMapping("/getOptions")
    public List<String> getCoralStatus(@RequestParam String prefix) {
        // URL : http://localhost:9090/AutoComplete/getOptions?prefix=J
        // it case sensative !
        System.out.println(prefix);
        List<String> ans_fromUrl= trie.suggest(prefix);

        List<String> ans1= trie.suggest("j");
        List<String> ans2= trie.suggest("J");
        List<String> ans3= trie.suggest("Jo");
        List<String> ans4= trie.suggest("D");
        List<String> ans5= trie.suggest("W");

        return ans_fromUrl; //List.of("hi","my","friend");
    }


}
