package org.niis.xroad.cs.admin.rest.api.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.CertificationService;
import org.niis.xroad.cs.admin.api.dto.CertificationServiceListItem;
import org.niis.xroad.cs.openapi.model.ApprovedCertificationServiceDto;
import org.niis.xroad.cs.openapi.model.ApprovedCertificationServiceListItemDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ApprovedCertificationServiceDtoConverterImpl implements ApprovedCertificationServiceDtoConverter {

    @Override
    public ApprovedCertificationServiceDto convert(CertificationService certificationService) {
        if ( certificationService == null ) {
            return null;
        }

        ApprovedCertificationServiceDto approvedCertificationServiceDto = new ApprovedCertificationServiceDto();

        approvedCertificationServiceDto.setCertificateProfileInfo( certificationService.getCertificateProfileInfo() );
        approvedCertificationServiceDto.setId( certificationService.getId() );
        approvedCertificationServiceDto.setIssuerDistinguishedName( certificationService.getIssuerDistinguishedName() );
        approvedCertificationServiceDto.setName( certificationService.getName() );
        approvedCertificationServiceDto.setNotAfter( fromInstant( certificationService.getNotAfter() ) );
        approvedCertificationServiceDto.setNotBefore( fromInstant( certificationService.getNotBefore() ) );
        approvedCertificationServiceDto.subjectDistinguishedName( certificationService.getSubjectDistinguishedName() );
        approvedCertificationServiceDto.tlsAuth( certificationService.getTlsAuth() );

        return approvedCertificationServiceDto;
    }

    @Override
    public ApprovedCertificationServiceListItemDto convertListItem(CertificationServiceListItem listItem) {
        if ( listItem == null ) {
            return null;
        }

        ApprovedCertificationServiceListItemDto approvedCertificationServiceListItemDto = new ApprovedCertificationServiceListItemDto();

        approvedCertificationServiceListItemDto.setId( listItem.getId() );
        approvedCertificationServiceListItemDto.setName( listItem.getName() );
        approvedCertificationServiceListItemDto.setNotAfter( fromInstant( listItem.getNotAfter() ) );
        approvedCertificationServiceListItemDto.setNotBefore( fromInstant( listItem.getNotBefore() ) );

        return approvedCertificationServiceListItemDto;
    }

    @Override
    public List<ApprovedCertificationServiceListItemDto> convertListItems(Collection<CertificationServiceListItem> items) {
        if ( items == null ) {
            return null;
        }

        List<ApprovedCertificationServiceListItemDto> list = new ArrayList<ApprovedCertificationServiceListItemDto>( items.size() );
        for ( CertificationServiceListItem certificationServiceListItem : items ) {
            list.add( convertListItem( certificationServiceListItem ) );
        }

        return list;
    }
}
