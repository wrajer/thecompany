package com.gwd.thecompany.common;

import org.springframework.stereotype.Component;

public interface Mapper<F, T> { //deklaracja nowego interfacu który jest w typie Crud Repositories

    T map (F from); //zamienia jeden obiekt w drugi
    F revers (T from); //odwrotność funkcji map


}
