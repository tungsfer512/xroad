package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.SecurityServerId;
import org.niis.xroad.cs.admin.core.entity.SecurityServerIdEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class SecurityServerIdMapperImpl implements SecurityServerIdMapper {

    @Override
    public SecurityServerId toTarget(SecurityServerIdEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SecurityServerId securityServerId = new SecurityServerId();

        securityServerId.setCreatedAt( arg0.getCreatedAt() );
        securityServerId.setUpdatedAt( arg0.getUpdatedAt() );
        securityServerId.setId( arg0.getId() );
        securityServerId.setMemberClass( arg0.getMemberClass() );
        securityServerId.setMemberCode( arg0.getMemberCode() );
        securityServerId.setObjectType( arg0.getObjectType() );
        securityServerId.setServerCode( arg0.getServerCode() );
        securityServerId.setServiceCode( arg0.getServiceCode() );
        securityServerId.setServiceVersion( arg0.getServiceVersion() );
        securityServerId.setSubsystemCode( arg0.getSubsystemCode() );
        securityServerId.setXRoadInstance( arg0.getXRoadInstance() );

        return securityServerId;
    }
}
