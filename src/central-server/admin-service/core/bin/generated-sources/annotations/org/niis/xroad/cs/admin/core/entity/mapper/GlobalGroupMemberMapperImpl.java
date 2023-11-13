package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.GlobalGroup;
import org.niis.xroad.cs.admin.api.domain.GlobalGroupMember;
import org.niis.xroad.cs.admin.core.entity.GlobalGroupEntity;
import org.niis.xroad.cs.admin.core.entity.GlobalGroupMemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class GlobalGroupMemberMapperImpl implements GlobalGroupMemberMapper {

    @Autowired
    private ClientIdMapper clientIdMapper;

    @Override
    public GlobalGroupMember toTarget(GlobalGroupMemberEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        GlobalGroupMember globalGroupMember = new GlobalGroupMember();

        globalGroupMember.setCreatedAt( arg0.getCreatedAt() );
        globalGroupMember.setUpdatedAt( arg0.getUpdatedAt() );
        globalGroupMember.setGlobalGroup( globalGroupEntityToGlobalGroup( arg0.getGlobalGroup() ) );
        globalGroupMember.setId( arg0.getId() );
        globalGroupMember.setIdentifier( clientIdMapper.toTarget( arg0.getIdentifier() ) );

        return globalGroupMember;
    }

    protected GlobalGroup globalGroupEntityToGlobalGroup(GlobalGroupEntity globalGroupEntity) {
        if ( globalGroupEntity == null ) {
            return null;
        }

        GlobalGroup globalGroup = new GlobalGroup();

        globalGroup.setCreatedAt( globalGroupEntity.getCreatedAt() );
        globalGroup.setUpdatedAt( globalGroupEntity.getUpdatedAt() );
        globalGroup.setDescription( globalGroupEntity.getDescription() );
        globalGroup.setGroupCode( globalGroupEntity.getGroupCode() );
        globalGroup.setId( globalGroupEntity.getId() );

        return globalGroup;
    }
}
