package com.gwd.thecompany.mapper;

import com.gwd.thecompany.common.Mapper;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapper implements Mapper<Office, OfficeDto> {


    @Override
    public OfficeDto map(Office from) {

        //todo dopisać funkcje
        return null;
    }

    @Override
    public Office revers(OfficeDto from) {
        return null;
    }
}
