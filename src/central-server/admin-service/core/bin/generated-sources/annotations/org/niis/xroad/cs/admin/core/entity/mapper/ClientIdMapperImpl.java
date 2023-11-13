package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.MemberId;
import org.niis.xroad.cs.admin.api.domain.SubsystemId;
import org.niis.xroad.cs.admin.core.entity.MemberIdEntity;
import org.niis.xroad.cs.admin.core.entity.SubsystemIdEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ClientIdMapperImpl implements ClientIdMapper {

    @Override
    public MemberId toMemberId(MemberIdEntity source) {
        if ( source == null ) {
            return null;
        }

        MemberId memberId = new MemberId();

        memberId.setCreatedAt( source.getCreatedAt() );
        memberId.setUpdatedAt( source.getUpdatedAt() );
        memberId.setId( source.getId() );
        memberId.setMemberClass( source.getMemberClass() );
        memberId.setMemberCode( source.getMemberCode() );
        memberId.setObjectType( source.getObjectType() );
        memberId.setServerCode( source.getServerCode() );
        memberId.setServiceCode( source.getServiceCode() );
        memberId.setServiceVersion( source.getServiceVersion() );
        memberId.setSubsystemCode( source.getSubsystemCode() );
        memberId.setXRoadInstance( source.getXRoadInstance() );

        return memberId;
    }

    @Override
    public SubsystemId toSubsystemId(SubsystemIdEntity source) {
        if ( source == null ) {
            return null;
        }

        SubsystemId subsystemId = new SubsystemId();

        subsystemId.setCreatedAt( source.getCreatedAt() );
        subsystemId.setUpdatedAt( source.getUpdatedAt() );
        subsystemId.setId( source.getId() );
        subsystemId.setMemberClass( source.getMemberClass() );
        subsystemId.setMemberCode( source.getMemberCode() );
        subsystemId.setObjectType( source.getObjectType() );
        subsystemId.setServerCode( source.getServerCode() );
        subsystemId.setServiceCode( source.getServiceCode() );
        subsystemId.setServiceVersion( source.getServiceVersion() );
        subsystemId.setSubsystemCode( source.getSubsystemCode() );
        subsystemId.setXRoadInstance( source.getXRoadInstance() );

        return subsystemId;
    }
}
