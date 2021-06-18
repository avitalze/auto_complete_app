package com.avital.auto_complete.service;

import com.avital.auto_complete.dao.NameRepository;
import com.avital.auto_complete.modle.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameService {

    @Autowired
    NameRepository nameRepo;

    //get all names records
    public List<Name> getAllNames()
    {
        List<Name> names = new ArrayList<Name>();
        nameRepo.findAll().forEach(name -> names.add(name));
        return names;
    }

    //add new name
    public void saveOrUpdate(Name name)
    {
        nameRepo.save(name);
    }
}
