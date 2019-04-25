package org.communis.practice.repository;

import org.communis.practice.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<Country, Long>, JpaSpecificationExecutor<Country>
{
    Country findById(Long id);

}
