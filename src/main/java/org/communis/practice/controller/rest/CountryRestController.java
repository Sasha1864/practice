package org.communis.practice.controller.rest;

import org.communis.practice.dto.CountryWrapper;
import org.communis.practice.entity.Country;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.NotFoundException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "countries")
public class CountryRestController {
    @Autowired
    private final CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/add")
    public void add(@Valid CountryWrapper countryWrapper, BindingResult bindingResult) throws InvalidDataException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        countryService.add(countryWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid CountryWrapper countryWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        countryService.edit(countryWrapper);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Country getById(@Valid CountryWrapper countryWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return countryService.getById(countryWrapper.getId());
    }

    @RequestMapping(value = "/list")
    public List<Country> findAll(BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return countryService.findAll();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getCaInfo() {
        return countryService.findAll().toString();
    }
}
