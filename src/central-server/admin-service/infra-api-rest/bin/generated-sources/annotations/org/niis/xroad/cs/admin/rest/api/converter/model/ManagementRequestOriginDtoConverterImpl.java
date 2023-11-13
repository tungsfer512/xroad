package org.niis.xroad.cs.admin.rest.api.converter.model;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.Origin;
import org.niis.xroad.cs.openapi.model.ManagementRequestOriginDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:36+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ManagementRequestOriginDtoConverterImpl implements ManagementRequestOriginDtoConverter {

    @Override
    public ManagementRequestOriginDto convert(Origin source) {
        if ( source == null ) {
            return null;
        }

        ManagementRequestOriginDto managementRequestOriginDto;

        switch ( source ) {
            case CENTER: managementRequestOriginDto = ManagementRequestOriginDto.CENTER;
            break;
            case SECURITY_SERVER: managementRequestOriginDto = ManagementRequestOriginDto.SECURITY_SERVER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return managementRequestOriginDto;
    }

    @Override
    public Origin convert(ManagementRequestOriginDto source) {
        if ( source == null ) {
            return null;
        }

        Origin origin;

        switch ( source ) {
            case CENTER: origin = Origin.CENTER;
            break;
            case SECURITY_SERVER: origin = Origin.SECURITY_SERVER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return origin;
    }
}
