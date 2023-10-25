
package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Type;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TypeService {
    Type saveType(Type type);

    Type getTypeById(Integer id);

    List<Type> getAllTypes();

    void deleteType(Integer id);
}
