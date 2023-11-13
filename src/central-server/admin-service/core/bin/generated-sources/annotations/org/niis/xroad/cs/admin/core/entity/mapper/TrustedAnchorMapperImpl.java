package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.AnchorUrl;
import org.niis.xroad.cs.admin.api.domain.AnchorUrlCert;
import org.niis.xroad.cs.admin.api.domain.TrustedAnchor;
import org.niis.xroad.cs.admin.core.entity.AnchorUrlCertEntity;
import org.niis.xroad.cs.admin.core.entity.AnchorUrlEntity;
import org.niis.xroad.cs.admin.core.entity.TrustedAnchorEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class TrustedAnchorMapperImpl implements TrustedAnchorMapper {

    @Override
    public TrustedAnchor toTarget(TrustedAnchorEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TrustedAnchor trustedAnchor = new TrustedAnchor();

        trustedAnchor.setCreatedAt( arg0.getCreatedAt() );
        trustedAnchor.setUpdatedAt( arg0.getUpdatedAt() );
        trustedAnchor.setAnchorUrls( anchorUrlEntitySetToAnchorUrlSet( arg0.getAnchorUrls() ) );
        trustedAnchor.setGeneratedAt( arg0.getGeneratedAt() );
        trustedAnchor.setId( arg0.getId() );
        trustedAnchor.setInstanceIdentifier( arg0.getInstanceIdentifier() );
        byte[] trustedAnchorFile = arg0.getTrustedAnchorFile();
        if ( trustedAnchorFile != null ) {
            trustedAnchor.setTrustedAnchorFile( Arrays.copyOf( trustedAnchorFile, trustedAnchorFile.length ) );
        }
        trustedAnchor.setTrustedAnchorHash( arg0.getTrustedAnchorHash() );

        return trustedAnchor;
    }

    protected AnchorUrlCert anchorUrlCertEntityToAnchorUrlCert(AnchorUrlCertEntity anchorUrlCertEntity) {
        if ( anchorUrlCertEntity == null ) {
            return null;
        }

        AnchorUrlCert anchorUrlCert = new AnchorUrlCert();

        byte[] cert = anchorUrlCertEntity.getCert();
        if ( cert != null ) {
            anchorUrlCert.setCert( Arrays.copyOf( cert, cert.length ) );
        }

        return anchorUrlCert;
    }

    protected Set<AnchorUrlCert> anchorUrlCertEntitySetToAnchorUrlCertSet(Set<AnchorUrlCertEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<AnchorUrlCert> set1 = new LinkedHashSet<AnchorUrlCert>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnchorUrlCertEntity anchorUrlCertEntity : set ) {
            set1.add( anchorUrlCertEntityToAnchorUrlCert( anchorUrlCertEntity ) );
        }

        return set1;
    }

    protected AnchorUrl anchorUrlEntityToAnchorUrl(AnchorUrlEntity anchorUrlEntity) {
        if ( anchorUrlEntity == null ) {
            return null;
        }

        AnchorUrl anchorUrl = new AnchorUrl();

        anchorUrl.setAnchorUrlCerts( anchorUrlCertEntitySetToAnchorUrlCertSet( anchorUrlEntity.getAnchorUrlCerts() ) );
        anchorUrl.setId( anchorUrlEntity.getId() );
        anchorUrl.setUrl( anchorUrlEntity.getUrl() );

        return anchorUrl;
    }

    protected Set<AnchorUrl> anchorUrlEntitySetToAnchorUrlSet(Set<AnchorUrlEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<AnchorUrl> set1 = new LinkedHashSet<AnchorUrl>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnchorUrlEntity anchorUrlEntity : set ) {
            set1.add( anchorUrlEntityToAnchorUrl( anchorUrlEntity ) );
        }

        return set1;
    }
}
