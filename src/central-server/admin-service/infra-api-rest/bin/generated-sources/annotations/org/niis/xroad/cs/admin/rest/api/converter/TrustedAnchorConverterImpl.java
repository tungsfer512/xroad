package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.TrustedAnchor;
import org.niis.xroad.cs.openapi.model.TrustedAnchorDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
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
