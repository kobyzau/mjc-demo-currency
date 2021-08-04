package com.epam.mjc.currency.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Currency {
    USD(431), EUR(451),RUB(456), BYN(0);

    private final int id;


}
