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

import java.util.List;

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
        countryRepository.delete(id);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
