package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.TrustedAnchor;
import org.niis.xroad.cs.openapi.model.TrustedAnchorDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class TrustedAnchorConverterImpl implements TrustedAnchorConverter {

    @Override
    public TrustedAnchorDto toTarget(TrustedAnchor trustedAnchor) {
        if ( trustedAnchor == null ) {
            return null;
        }

        TrustedAnchorDto trustedAnchorDto = new TrustedAnchorDto();

        trustedAnchorDto.setHash( trustedAnchor.getTrustedAnchorHash() );
        trustedAnchorDto.setGeneratedAt( fromInstant( trustedAnchor.getGeneratedAt() ) );
        trustedAnchorDto.setInstanceIdentifier( trustedAnchor.getInstanceIdentifier() );

        return trustedAnchorDto;
    }
}
