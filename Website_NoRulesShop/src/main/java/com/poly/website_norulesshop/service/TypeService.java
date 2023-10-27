
package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TypeService {
    Type saveType(Type type);

    Type getTypeById(Integer id);

    List<Type> getAllTypes();

    void deleteType(Integer id);
}
