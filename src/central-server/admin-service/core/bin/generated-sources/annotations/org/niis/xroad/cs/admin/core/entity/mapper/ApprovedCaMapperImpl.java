package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ApprovedCa;
import org.niis.xroad.cs.admin.api.domain.CaInfo;
import org.niis.xroad.cs.admin.api.domain.OcspInfo;
import org.niis.xroad.cs.admin.core.entity.ApprovedCaEntity;
import org.niis.xroad.cs.admin.core.entity.CaInfoEntity;
import org.niis.xroad.cs.admin.core.entity.OcspInfoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ApprovedCaMapperImpl implements ApprovedCaMapper {

    @Override
    public ApprovedCa toTarget(ApprovedCaEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ApprovedCa approvedCa = new ApprovedCa();

        approvedCa.setCreatedAt( arg0.getCreatedAt() );
        approvedCa.setUpdatedAt( arg0.getUpdatedAt() );
        approvedCa.setAuthenticationOnly( arg0.getAuthenticationOnly() );
        approvedCa.setCaInfo( caInfoEntityToCaInfo( arg0.getCaInfo() ) );
        approvedCa.setCertProfileInfo( arg0.getCertProfileInfo() );
        approvedCa.setId( arg0.getId() );
        approvedCa.setIdentifierDecoderMemberClass( arg0.getIdentifierDecoderMemberClass() );
        approvedCa.setIdentifierDecoderMethodName( arg0.getIdentifierDecoderMethodName() );
        approvedCa.setIntermediateCaInfos( caInfoEntitySetToCaInfoSet( arg0.getIntermediateCaInfos() ) );
        approvedCa.setName( arg0.getName() );

        return approvedCa;
    }

    protected OcspInfo ocspInfoEntityToOcspInfo(OcspInfoEntity ocspInfoEntity) {
        if ( ocspInfoEntity == null ) {
            return null;
        }

        OcspInfo ocspInfo = new OcspInfo();

        ocspInfo.setCreatedAt( ocspInfoEntity.getCreatedAt() );
        ocspInfo.setUpdatedAt( ocspInfoEntity.getUpdatedAt() );
        byte[] cert = ocspInfoEntity.getCert();
        if ( cert != null ) {
            ocspInfo.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        ocspInfo.setId( ocspInfoEntity.getId() );
        ocspInfo.setUrl( ocspInfoEntity.getUrl() );

        return ocspInfo;
    }

    protected Set<OcspInfo> ocspInfoEntitySetToOcspInfoSet(Set<OcspInfoEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<OcspInfo> set1 = new LinkedHashSet<OcspInfo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OcspInfoEntity ocspInfoEntity : set ) {
            set1.add( ocspInfoEntityToOcspInfo( ocspInfoEntity ) );
        }

        return set1;
    }

    protected CaInfo caInfoEntityToCaInfo(CaInfoEntity caInfoEntity) {
        if ( caInfoEntity == null ) {
            return null;
        }

        CaInfo caInfo = new CaInfo();

        caInfo.setCreatedAt( caInfoEntity.getCreatedAt() );
        caInfo.setUpdatedAt( caInfoEntity.getUpdatedAt() );
        byte[] cert = caInfoEntity.getCert();
        if ( cert != null ) {
            caInfo.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        caInfo.setId( caInfoEntity.getId() );
        caInfo.setOcspInfos( ocspInfoEntitySetToOcspInfoSet( caInfoEntity.getOcspInfos() ) );
        caInfo.setValidFrom( caInfoEntity.getValidFrom() );
        caInfo.setValidTo( caInfoEntity.getValidTo() );

        return caInfo;
    }

    protected Set<CaInfo> caInfoEntitySetToCaInfoSet(Set<CaInfoEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<CaInfo> set1 = new LinkedHashSet<CaInfo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CaInfoEntity caInfoEntity : set ) {
            set1.add( caInfoEntityToCaInfo( caInfoEntity ) );
        }

        return set1;
    }
}
