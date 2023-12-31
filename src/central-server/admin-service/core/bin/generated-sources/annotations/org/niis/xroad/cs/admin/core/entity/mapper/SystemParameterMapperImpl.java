package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.SystemParameter;
import org.niis.xroad.cs.admin.core.entity.SystemParameterEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class SystemParameterMapperImpl implements SystemParameterMapper {

    @Override
    public SystemParameter toTarget(SystemParameterEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SystemParameter systemParameter = new SystemParameter();

        systemParameter.setCreatedAt( arg0.getCreatedAt() );
        systemParameter.setUpdatedAt( arg0.getUpdatedAt() );
        systemParameter.setHaNodeName( arg0.getHaNodeName() );
        systemParameter.setId( arg0.getId() );
        systemParameter.setKey( arg0.getKey() );
        systemParameter.setValue( arg0.getValue() );

        return systemParameter;
    }
}
