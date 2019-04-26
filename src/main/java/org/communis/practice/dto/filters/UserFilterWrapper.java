package org.communis.practice.dto.filters;

import lombok.Data;

@Data
public class UserFilterWrapper extends ObjectFilter
{
    private String name;
    private String surname;
}