package org.niis.xroad.cs.admin.core.entity.converter;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class ClientIdConverterImpl implements ClientIdConverter {

    @Override
    public String convert(XRoadObjectType attribute) {
        if ( attribute == null ) {
            return null;
        }

        String string;

        switch ( attribute ) {
            case MEMBER: string = "XRoadMember";
            break;
            case SUBSYSTEM: string = "Subsystem";
            break;
            default: string = null;
        }

        return string;
    }

    @Override
    public XRoadObjectType convert(String dbIdentifier) {
        if ( dbIdentifier == null ) {
            return null;
        }

        XRoadObjectType xRoadObjectType;

        switch ( dbIdentifier ) {
            case "XRoadMember": xRoadObjectType = XRoadObjectType.MEMBER;
            break;
            case "Subsystem": xRoadObjectType = XRoadObjectType.SUBSYSTEM;
            break;
            default: xRoadObjectType = null;
        }

        return xRoadObjectType;
    }
}
