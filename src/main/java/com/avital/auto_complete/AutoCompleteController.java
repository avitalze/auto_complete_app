package com.avital.auto_complete;


import com.avital.auto_complete.logic.Trie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AutoComplete")
public class AutoCompleteController {
    private Trie paEmulatorEngine=new Trie();


    // ----- for check
    @GetMapping("/getAmigo")
    public String test() {

        return "hi hi amigo";
    }

    @GetMapping("/getOptions")
    public List<String> getCoralStatus() {

        return List.of("hi","my","friend");//new ArrayList<>();
    }


}
