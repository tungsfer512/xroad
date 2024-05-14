package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.GlobalGroupMemberView;
import org.niis.xroad.cs.admin.core.entity.GlobalGroupMembersViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class GlobalGroupMemberViewMapperImpl implements GlobalGroupMemberViewMapper {

    @Autowired
    private ClientIdMapper clientIdMapper;

    @Override
    public GlobalGroupMemberView toTarget(GlobalGroupMembersViewEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        GlobalGroupMemberView globalGroupMemberView = new GlobalGroupMemberView();

        globalGroupMemberView.setCreatedAt( arg0.getCreatedAt() );
        globalGroupMemberView.setId( arg0.getId() );
        globalGroupMemberView.setIdentifier( clientIdMapper.toTarget( arg0.getIdentifier() ) );
        globalGroupMemberView.setMemberName( arg0.getMemberName() );

        return globalGroupMemberView;
    }
}
