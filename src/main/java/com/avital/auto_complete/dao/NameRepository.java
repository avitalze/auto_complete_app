package com.avital.auto_complete.dao;

import com.avital.auto_complete.modle.Name;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name,String> {

}
