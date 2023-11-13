package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.FlattenedSecurityServerClientView;
import org.niis.xroad.cs.admin.api.domain.MemberClass;
import org.niis.xroad.cs.admin.core.entity.FlattenedSecurityServerClientViewEntity;
import org.niis.xroad.cs.admin.core.entity.MemberClassEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class FlattenedSecurityServerClientViewMapperImpl implements FlattenedSecurityServerClientViewMapper {

    @Override
    public FlattenedSecurityServerClientView toTarget(FlattenedSecurityServerClientViewEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        FlattenedSecurityServerClientView flattenedSecurityServerClientView = new FlattenedSecurityServerClientView();

        flattenedSecurityServerClientView.setCreatedAt( arg0.getCreatedAt() );
        flattenedSecurityServerClientView.setUpdatedAt( arg0.getUpdatedAt() );
        flattenedSecurityServerClientView.setId( arg0.getId() );
        flattenedSecurityServerClientView.setMemberClass( memberClassEntityToMemberClass( arg0.getMemberClass() ) );
        flattenedSecurityServerClientView.setMemberCode( arg0.getMemberCode() );
        flattenedSecurityServerClientView.setMemberName( arg0.getMemberName() );
        flattenedSecurityServerClientView.setSubsystemCode( arg0.getSubsystemCode() );
        flattenedSecurityServerClientView.setType( arg0.getType() );
        flattenedSecurityServerClientView.setXroadInstance( arg0.getXroadInstance() );

        return flattenedSecurityServerClientView;
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
