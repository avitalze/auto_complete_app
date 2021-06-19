package com.avital.auto_complete;


import com.avital.auto_complete.dao.NameRepository;
import com.avital.auto_complete.service.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/AutoComplete")
public class AutoCompleteController {
    @Autowired
    Initializer init=new Initializer();


    @GetMapping("/getOptions")
    public List<String> getCoralStatus(@RequestParam String prefix) {
        // URL exe : http://localhost:9090/AutoComplete/getOptions?prefix=J
        init.initializTrie();
        List<String> allSuggests= Initializer.trie.suggest(prefix);
        if(allSuggests.size()==0){
            allSuggests.add("No match");
        }
        return allSuggests;
    }

}
