package org.niis.xroad.cs.admin.core.entity.mapper;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.MemberClass;
import org.niis.xroad.cs.admin.core.entity.MemberClassEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class MemberClassMapperImpl implements MemberClassMapper {

    @Override
    public MemberClass toTarget(MemberClassEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        MemberClass memberClass = new MemberClass();

        memberClass.setCreatedAt( arg0.getCreatedAt() );
        memberClass.setUpdatedAt( arg0.getUpdatedAt() );
        memberClass.setCode( arg0.getCode() );
        memberClass.setDescription( arg0.getDescription() );
        memberClass.setId( arg0.getId() );

        return memberClass;
    }
}
