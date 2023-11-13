package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ApprovedTsa;
import org.niis.xroad.cs.admin.core.converter.CertificateConverter;
import org.niis.xroad.cs.admin.core.entity.ApprovedTsaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ApprovedTsaMapperImpl implements ApprovedTsaMapper {

    @Autowired
    private CertificateConverter certificateConverter;

    @Override
    public ApprovedTsa toTarget(ApprovedTsaEntity approvedTsaEntity) {
        if ( approvedTsaEntity == null ) {
            return null;
        }

        ApprovedTsa approvedTsa = new ApprovedTsa();

        approvedTsa.setCertificate( certificateConverter.toCertificateDetails( approvedTsaEntity.getCert() ) );
        approvedTsa.setCreatedAt( approvedTsaEntity.getCreatedAt() );
        approvedTsa.setUpdatedAt( approvedTsaEntity.getUpdatedAt() );
        approvedTsa.setId( approvedTsaEntity.getId() );
        approvedTsa.setName( approvedTsaEntity.getName() );
        approvedTsa.setUrl( approvedTsaEntity.getUrl() );
        approvedTsa.setValidFrom( approvedTsaEntity.getValidFrom() );
        approvedTsa.setValidTo( approvedTsaEntity.getValidTo() );

        approvedTsa.setTimestampingInterval( 60 );
        approvedTsa.setCost( ApprovedTsa.ApprovedTsaCost.UNDEFINED );

        return approvedTsa;
    }
}
