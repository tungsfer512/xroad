package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.HAClusterNode;
import org.niis.xroad.cs.admin.api.domain.HAClusterNodeStatus;
import org.niis.xroad.cs.openapi.model.HighAvailabilityClusterNodeDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class HAClusterNodeDtoConverterImpl implements HAClusterNodeDtoConverter {

    @Override
    public HighAvailabilityClusterNodeDto toTarget(HAClusterNode entity) {
        if ( entity == null ) {
            return null;
        }

        HighAvailabilityClusterNodeDto highAvailabilityClusterNodeDto = new HighAvailabilityClusterNodeDto();

        highAvailabilityClusterNodeDto.setConfigurationGenerated( fromInstant( entity.getConfigurationGenerated() ) );
        highAvailabilityClusterNodeDto.setNodeAddress( entity.getNodeAddress() );
        highAvailabilityClusterNodeDto.setNodeName( entity.getNodeName() );
        highAvailabilityClusterNodeDto.status( hAClusterNodeStatusToStatusEnum( entity.getStatus() ) );

        return highAvailabilityClusterNodeDto;
    }

    protected HighAvailabilityClusterNodeDto.StatusEnum hAClusterNodeStatusToStatusEnum(HAClusterNodeStatus hAClusterNodeStatus) {
        if ( hAClusterNodeStatus == null ) {
            return null;
        }

        HighAvailabilityClusterNodeDto.StatusEnum statusEnum;

        switch ( hAClusterNodeStatus ) {
            case ERROR: statusEnum = HighAvailabilityClusterNodeDto.StatusEnum.ERROR;
            break;
            case OK: statusEnum = HighAvailabilityClusterNodeDto.StatusEnum.OK;
            break;
            case UNKNOWN: statusEnum = HighAvailabilityClusterNodeDto.StatusEnum.UNKNOWN;
            break;
            case WARN: statusEnum = HighAvailabilityClusterNodeDto.StatusEnum.WARN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + hAClusterNodeStatus );
        }

        return statusEnum;
    }
}
