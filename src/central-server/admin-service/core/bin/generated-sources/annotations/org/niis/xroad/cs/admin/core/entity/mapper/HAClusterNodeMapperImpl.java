package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.HAClusterNode;
import org.niis.xroad.cs.admin.core.entity.HAClusterStatusViewEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class HAClusterNodeMapperImpl extends HAClusterNodeMapper {

    @Override
    public HAClusterNode toTarget(HAClusterStatusViewEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HAClusterNode hAClusterNode = new HAClusterNode();

        hAClusterNode.setStatus( mapNodeStatus( entity ) );
        hAClusterNode.setConfigurationGenerated( entity.getConfigurationGenerated() );
        hAClusterNode.setNodeAddress( entity.getNodeAddress() );
        hAClusterNode.setNodeName( entity.getNodeName() );

        return hAClusterNode;
    }
}
