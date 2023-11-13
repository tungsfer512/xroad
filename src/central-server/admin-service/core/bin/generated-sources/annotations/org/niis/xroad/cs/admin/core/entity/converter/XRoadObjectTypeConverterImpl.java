package org.niis.xroad.cs.admin.core.entity.converter;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class XRoadObjectTypeConverterImpl implements XRoadObjectTypeConverter {

    @Override
    public XRoadObjectType convert(String source) {
        if ( source == null ) {
            return null;
        }

        XRoadObjectType xRoadObjectType;

        switch ( source ) {
            case "SERVER": xRoadObjectType = XRoadObjectType.SERVER;
            break;
            case "SERVICE": xRoadObjectType = XRoadObjectType.SERVICE;
            break;
            case "MEMBER": xRoadObjectType = XRoadObjectType.MEMBER;
            break;
            case "SUBSYSTEM": xRoadObjectType = XRoadObjectType.SUBSYSTEM;
            break;
            case "GLOBALGROUP": xRoadObjectType = XRoadObjectType.GLOBALGROUP;
            break;
            case "LOCALGROUP": xRoadObjectType = XRoadObjectType.LOCALGROUP;
            break;
            default: xRoadObjectType = null;
        }

        return xRoadObjectType;
    }

    @Override
    public String convert(XRoadObjectType source) {
        if ( source == null ) {
            return null;
        }

        String string;

        switch ( source ) {
            case SERVER: string = "SERVER";
            break;
            case SERVICE: string = "SERVICE";
            break;
            case MEMBER: string = "MEMBER";
            break;
            case SUBSYSTEM: string = "SUBSYSTEM";
            break;
            case GLOBALGROUP: string = "GLOBALGROUP";
            break;
            case LOCALGROUP: string = "LOCALGROUP";
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return string;
    }
}
