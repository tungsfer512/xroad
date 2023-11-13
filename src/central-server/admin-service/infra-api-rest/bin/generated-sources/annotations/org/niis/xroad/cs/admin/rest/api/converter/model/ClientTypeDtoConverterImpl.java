package org.niis.xroad.cs.admin.rest.api.converter.model;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.openapi.model.ClientTypeDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ClientTypeDtoConverterImpl implements ClientTypeDtoConverter {

    @Override
    public XRoadObjectType convert(ClientTypeDto clientTypeDto) {
        if ( clientTypeDto == null ) {
            return null;
        }

        XRoadObjectType xRoadObjectType;

        switch ( clientTypeDto ) {
            case MEMBER: xRoadObjectType = XRoadObjectType.MEMBER;
            break;
            case SUBSYSTEM: xRoadObjectType = XRoadObjectType.SUBSYSTEM;
            break;
            default: xRoadObjectType = null;
        }

        return xRoadObjectType;
    }

    @Override
    public ClientTypeDto convert(XRoadObjectType xRoadObjectType) {
        if ( xRoadObjectType == null ) {
            return null;
        }

        ClientTypeDto clientTypeDto;

        switch ( xRoadObjectType ) {
            case MEMBER: clientTypeDto = ClientTypeDto.MEMBER;
            break;
            case SUBSYSTEM: clientTypeDto = ClientTypeDto.SUBSYSTEM;
            break;
            default: clientTypeDto = null;
        }

        return clientTypeDto;
    }
}
