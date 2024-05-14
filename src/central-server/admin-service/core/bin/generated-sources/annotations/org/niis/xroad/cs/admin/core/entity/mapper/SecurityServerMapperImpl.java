package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.AuthCert;
import org.niis.xroad.cs.admin.api.domain.SecurityServer;
import org.niis.xroad.cs.admin.core.entity.AuthCertEntity;
import org.niis.xroad.cs.admin.core.entity.SecurityServerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:53+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class SecurityServerMapperImpl implements SecurityServerMapper {

    @Autowired
    private SecurityServerClientMapper securityServerClientMapper;

    @Override
    public SecurityServer toTarget(SecurityServerEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SecurityServer securityServer = new SecurityServer();

        securityServer.setCreatedAt( arg0.getCreatedAt() );
        securityServer.setUpdatedAt( arg0.getUpdatedAt() );
        securityServer.setAddress( arg0.getAddress() );
        securityServer.setAuthCerts( authCertEntitySetToAuthCertSet( arg0.getAuthCerts() ) );
        securityServer.setId( arg0.getId() );
        securityServer.setOwner( securityServerClientMapper.toDto( arg0.getOwner() ) );
        securityServer.setServerCode( arg0.getServerCode() );

        return securityServer;
    }

    protected AuthCert authCertEntityToAuthCert(AuthCertEntity authCertEntity) {
        if ( authCertEntity == null ) {
            return null;
        }

        AuthCert authCert = new AuthCert();

        authCert.setCreatedAt( authCertEntity.getCreatedAt() );
        authCert.setUpdatedAt( authCertEntity.getUpdatedAt() );
        byte[] cert = authCertEntity.getCert();
        if ( cert != null ) {
            authCert.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        authCert.setId( authCertEntity.getId() );

        return authCert;
    }

    protected Set<AuthCert> authCertEntitySetToAuthCertSet(Set<AuthCertEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthCert> set1 = new LinkedHashSet<AuthCert>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthCertEntity authCertEntity : set ) {
            set1.add( authCertEntityToAuthCert( authCertEntity ) );
        }

        return set1;
    }
}
