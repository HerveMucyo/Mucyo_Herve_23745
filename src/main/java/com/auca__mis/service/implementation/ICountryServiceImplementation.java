package com.auca__mis.service.implementation;

import com.auca__mis.dao.ICountryDao;
import com.auca__mis.dao.ICourseDefinitionDao;
import com.auca__mis.model.Country;
import com.auca__mis.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ICountryServiceImplementation implements ICountryService {
    private ICountryDao dao;
    @Autowired
    public ICountryServiceImplementation(ICountryDao dao) {
        this.dao = dao;
    }


    @Override
    public Country saveCountry(Country country) {
        return dao.save(country);
    }

    @Override
    public List<Country> findAll() {
        return dao.findAll();
    }
}
