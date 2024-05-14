package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.MemberClass;
import org.niis.xroad.cs.admin.api.domain.ServerClient;
import org.niis.xroad.cs.admin.api.domain.Subsystem;
import org.niis.xroad.cs.admin.api.domain.XRoadMember;
import org.niis.xroad.cs.admin.core.entity.MemberClassEntity;
import org.niis.xroad.cs.admin.core.entity.ServerClientEntity;
import org.niis.xroad.cs.admin.core.entity.SubsystemEntity;
import org.niis.xroad.cs.admin.core.entity.XRoadMemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class SecurityServerClientMapperImpl implements SecurityServerClientMapper {

    @Autowired
    private ClientIdMapper clientIdMapper;
    @Autowired
    private ServerClientMapper serverClientMapper;

    @Override
    public Subsystem toDto(SubsystemEntity source) {
        if ( source == null ) {
            return null;
        }

        Subsystem subsystem = new Subsystem();

        subsystem.setCreatedAt( source.getCreatedAt() );
        subsystem.setUpdatedAt( source.getUpdatedAt() );
        subsystem.setId( source.getId() );
        subsystem.setIdentifier( clientIdMapper.toTarget( source.getIdentifier() ) );
        subsystem.setServerClients( serverClientEntitySetToServerClientSet( source.getServerClients() ) );
        subsystem.setSubsystemCode( source.getSubsystemCode() );
        subsystem.setXroadMember( toDto( source.getXroadMember() ) );

        return subsystem;
    }

    @Override
    public XRoadMember toDto(XRoadMemberEntity source) {
        if ( source == null ) {
            return null;
        }

        XRoadMember xRoadMember = new XRoadMember();

        xRoadMember.setCreatedAt( source.getCreatedAt() );
        xRoadMember.setUpdatedAt( source.getUpdatedAt() );
        xRoadMember.setId( source.getId() );
        xRoadMember.setIdentifier( clientIdMapper.toTarget( source.getIdentifier() ) );
        xRoadMember.setServerClients( serverClientEntitySetToServerClientSet( source.getServerClients() ) );
        xRoadMember.setAdministrativeContact( source.getAdministrativeContact() );
        xRoadMember.setMemberClass( memberClassEntityToMemberClass( source.getMemberClass() ) );
        xRoadMember.setMemberCode( source.getMemberCode() );
        xRoadMember.setName( source.getName() );

        return xRoadMember;
    }

    protected Set<ServerClient> serverClientEntitySetToServerClientSet(Set<ServerClientEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<ServerClient> set1 = new LinkedHashSet<ServerClient>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ServerClientEntity serverClientEntity : set ) {
            set1.add( serverClientMapper.toTarget( serverClientEntity ) );
        }

        return set1;
    }

    protected MemberClass memberClassEntityToMemberClass(MemberClassEntity memberClassEntity) {
        if ( memberClassEntity == null ) {
            return null;
        }

        MemberClass memberClass = new MemberClass();

        memberClass.setCreatedAt( memberClassEntity.getCreatedAt() );
        memberClass.setUpdatedAt( memberClassEntity.getUpdatedAt() );
        memberClass.setCode( memberClassEntity.getCode() );
        memberClass.setDescription( memberClassEntity.getDescription() );
        memberClass.setId( memberClassEntity.getId() );

        return memberClass;
    }
}
