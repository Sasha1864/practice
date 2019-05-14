package org.communis.practice.controller.rest;

import org.communis.practice.dto.CountryWrapper;
import org.communis.practice.entity.Country;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryRestController {
    @Autowired
    private final CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add")
    public void add(@Valid CountryWrapper countryWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        countryService.add(countryWrapper);
    }

    @PutMapping("/edit")
    public void edit(@Valid CountryWrapper countryWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        countryService.edit(countryWrapper);
    }

    @GetMapping("{id}")
    public Country getById(@PathVariable Long id){
        return countryService.getById(id);
    }

    @GetMapping("/list")
    public List<Country> findAll(){
        return countryService.findAll();
    }

}
