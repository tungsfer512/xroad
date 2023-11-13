package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.GlobalGroup;
import org.niis.xroad.cs.admin.core.entity.GlobalGroupEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class GlobalGroupMapperImpl implements GlobalGroupMapper {

    @Override
    public GlobalGroup toTarget(GlobalGroupEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        GlobalGroup globalGroup = new GlobalGroup();

        globalGroup.setCreatedAt( arg0.getCreatedAt() );
        globalGroup.setUpdatedAt( arg0.getUpdatedAt() );
        globalGroup.setDescription( arg0.getDescription() );
        globalGroup.setGroupCode( arg0.getGroupCode() );
        globalGroup.setId( arg0.getId() );

        return globalGroup;
    }
}
