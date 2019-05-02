package org.communis.practice.service;

import org.communis.practice.dto.CountryWrapper;
import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.entity.Country;
import org.communis.practice.entity.Message;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getById(Long id) {
        return countryRepository.findById(id);
    }

    public void add(CountryWrapper countryWrapper) {
        Country country = new Country();
        country.setDateCreate(new Date());
        countryWrapper.fromWrapper(country);

        countryRepository.save(country);
    }

    public void edit(CountryWrapper countryWrapper) throws ServerException {
        try {
            Country country = getById(countryWrapper.getId());
            countryWrapper.fromWrapper(country);
            countryRepository.save(country);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        Country country = countryRepository.findById(id);
        country.setDateClose(new Date());
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
