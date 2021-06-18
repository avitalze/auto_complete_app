package com.avital.auto_complete.dao;

import com.avital.auto_complete.modle.Name;
import org.springframework.data.repository.CrudRepository;

public interface NameRepository extends CrudRepository<Name,String> {

}
