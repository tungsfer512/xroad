package org.niis.xroad.cs.admin.rest.api.converter.model;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.openapi.model.XRoadIdDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class XRoadObjectTypeDtoConverterImpl implements XRoadObjectTypeDtoConverter {

    @Override
    public XRoadIdDto.TypeEnum convert(XRoadObjectType source) {
        if ( source == null ) {
            return null;
        }

        XRoadIdDto.TypeEnum typeEnum;

        switch ( source ) {
            case SERVER: typeEnum = XRoadIdDto.TypeEnum.SERVER;
            break;
            case SERVICE: typeEnum = XRoadIdDto.TypeEnum.SERVICE;
            break;
            case MEMBER: typeEnum = XRoadIdDto.TypeEnum.MEMBER;
            break;
            case SUBSYSTEM: typeEnum = XRoadIdDto.TypeEnum.SUBSYSTEM;
            break;
            case GLOBALGROUP: typeEnum = XRoadIdDto.TypeEnum.GLOBALGROUP;
            break;
            case LOCALGROUP: typeEnum = XRoadIdDto.TypeEnum.LOCALGROUP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return typeEnum;
    }

    @Override
    public XRoadObjectType convert(XRoadIdDto.TypeEnum source) {
        if ( source == null ) {
            return null;
        }

        XRoadObjectType xRoadObjectType;

        switch ( source ) {
            case SERVER: xRoadObjectType = XRoadObjectType.SERVER;
            break;
            case SERVICE: xRoadObjectType = XRoadObjectType.SERVICE;
            break;
            case MEMBER: xRoadObjectType = XRoadObjectType.MEMBER;
            break;
            case SUBSYSTEM: xRoadObjectType = XRoadObjectType.SUBSYSTEM;
            break;
            case GLOBALGROUP: xRoadObjectType = XRoadObjectType.GLOBALGROUP;
            break;
            case LOCALGROUP: xRoadObjectType = XRoadObjectType.LOCALGROUP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return xRoadObjectType;
    }
}
