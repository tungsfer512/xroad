package org.niis.xroad.cs.admin.rest.api.converter.model;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ManagementRequestStatus;
import org.niis.xroad.cs.openapi.model.ManagementRequestStatusDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ManagementRequestStatusConverterImpl implements ManagementRequestStatusConverter {

    @Override
    public ManagementRequestStatusDto convert(ManagementRequestStatus source) {
        if ( source == null ) {
            return null;
        }

        ManagementRequestStatusDto managementRequestStatusDto;

        switch ( source ) {
            case WAITING: managementRequestStatusDto = ManagementRequestStatusDto.WAITING;
            break;
            case APPROVED: managementRequestStatusDto = ManagementRequestStatusDto.APPROVED;
            break;
            case DECLINED: managementRequestStatusDto = ManagementRequestStatusDto.DECLINED;
            break;
            case SUBMITTED_FOR_APPROVAL: managementRequestStatusDto = ManagementRequestStatusDto.SUBMITTED_FOR_APPROVAL;
            break;
            case REVOKED: managementRequestStatusDto = ManagementRequestStatusDto.REVOKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return managementRequestStatusDto;
    }

    @Override
    public ManagementRequestStatus convert(ManagementRequestStatusDto source) {
        if ( source == null ) {
            return null;
        }

        ManagementRequestStatus managementRequestStatus;

        switch ( source ) {
            case WAITING: managementRequestStatus = ManagementRequestStatus.WAITING;
            break;
            case APPROVED: managementRequestStatus = ManagementRequestStatus.APPROVED;
            break;
            case DECLINED: managementRequestStatus = ManagementRequestStatus.DECLINED;
            break;
            case SUBMITTED_FOR_APPROVAL: managementRequestStatus = ManagementRequestStatus.SUBMITTED_FOR_APPROVAL;
            break;
            case REVOKED: managementRequestStatus = ManagementRequestStatus.REVOKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + source );
        }

        return managementRequestStatus;
    }
}
