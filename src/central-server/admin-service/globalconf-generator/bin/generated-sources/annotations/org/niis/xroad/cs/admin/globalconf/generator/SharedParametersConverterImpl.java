package org.niis.xroad.cs.admin.globalconf.generator;

import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.ApprovedCATypeV2;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.ApprovedTSAType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.CaInfoType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.GlobalGroupType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.GlobalSettingsType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.MemberClassType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.MemberType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.ObjectFactory;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.OcspInfoType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.SecurityServerType;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.SharedParametersTypeV2;
import ee.ria.xroad.common.conf.globalconf.sharedparameters.v2.SubsystemType;
import ee.ria.xroad.common.identifier.ClientId;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.xml.bind.JAXBElement;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:49+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
class SharedParametersConverterImpl extends SharedParametersConverter {

    private final ObjectFactory objectFactory = new ObjectFactory();
    private final MappingUtils mappingUtils = new MappingUtils();

    @Override
    SharedParametersTypeV2 convert(SharedParameters sharedParameters, Map<ClientId, Object> clientMap) {
        if ( sharedParameters == null ) {
            return null;
        }

        SharedParametersTypeV2 sharedParametersTypeV2 = objectFactory.createSharedParametersTypeV2();

        if ( sharedParametersTypeV2.getApprovedCA() != null ) {
            List<ApprovedCATypeV2> list = approvedCAListToApprovedCATypeV2List( sharedParameters.getApprovedCAs(), clientMap );
            if ( list != null ) {
                sharedParametersTypeV2.getApprovedCA().addAll( list );
            }
        }
        if ( sharedParametersTypeV2.getApprovedTSA() != null ) {
            List<ApprovedTSAType> list1 = approvedTSAListToApprovedTSATypeList( sharedParameters.getApprovedTSAs(), clientMap );
            if ( list1 != null ) {
                sharedParametersTypeV2.getApprovedTSA().addAll( list1 );
            }
        }
        if ( sharedParametersTypeV2.getMember() != null ) {
            List<MemberType> list2 = memberListToMemberTypeList( sharedParameters.getMembers(), clientMap );
            if ( list2 != null ) {
                sharedParametersTypeV2.getMember().addAll( list2 );
            }
        }
        if ( sharedParametersTypeV2.getSecurityServer() != null ) {
            List<SecurityServerType> list3 = securityServerListToSecurityServerTypeList( sharedParameters.getSecurityServers(), clientMap );
            if ( list3 != null ) {
                sharedParametersTypeV2.getSecurityServer().addAll( list3 );
            }
        }
        if ( sharedParametersTypeV2.getGlobalGroup() != null ) {
            List<GlobalGroupType> list4 = globalGroupListToGlobalGroupTypeList( sharedParameters.getGlobalGroups(), clientMap );
            if ( list4 != null ) {
                sharedParametersTypeV2.getGlobalGroup().addAll( list4 );
            }
        }
        sharedParametersTypeV2.setGlobalSettings( convert( sharedParameters.getGlobalSettings() ) );
        sharedParametersTypeV2.setInstanceIdentifier( sharedParameters.getInstanceIdentifier() );

        return sharedParametersTypeV2;
    }

    @Override
    GlobalSettingsType convert(SharedParameters.GlobalSettings globalSettings) {
        if ( globalSettings == null ) {
            return null;
        }

        GlobalSettingsType globalSettingsType = objectFactory.createGlobalSettingsType();

        if ( globalSettingsType.getMemberClass() != null ) {
            List<MemberClassType> list = memberClassListToMemberClassTypeList( globalSettings.getMemberClasses() );
            if ( list != null ) {
                globalSettingsType.getMemberClass().addAll( list );
            }
        }
        if ( globalSettings.getOcspFreshnessSeconds() != null ) {
            globalSettingsType.setOcspFreshnessSeconds( BigInteger.valueOf( globalSettings.getOcspFreshnessSeconds() ) );
        }

        return globalSettingsType;
    }

    @Override
    ApprovedCATypeV2 convert(SharedParameters.ApprovedCA approvedCa) {
        if ( approvedCa == null ) {
            return null;
        }

        ApprovedCATypeV2 approvedCATypeV2 = objectFactory.createApprovedCATypeV2();

        if ( approvedCATypeV2.getIntermediateCA() != null ) {
            List<CaInfoType> list = caInfoListToCaInfoTypeList( approvedCa.getIntermediateCAs() );
            if ( list != null ) {
                approvedCATypeV2.getIntermediateCA().addAll( list );
            }
        }
        approvedCATypeV2.setAuthenticationOnly( approvedCa.getAuthenticationOnly() );
        approvedCATypeV2.setCertificateProfileInfo( approvedCa.getCertificateProfileInfo() );
        approvedCATypeV2.setName( approvedCa.getName() );
        approvedCATypeV2.setTopCA( caInfoToCaInfoType( approvedCa.getTopCA() ) );

        return approvedCATypeV2;
    }

    @Override
    SecurityServerType convert(SharedParameters.SecurityServer securityServer, Map<ClientId, Object> clientMap) {
        if ( securityServer == null ) {
            return null;
        }

        SecurityServerType securityServerType = objectFactory.createSecurityServerType();

        if ( securityServerType.getAuthCertHash() != null ) {
            List<byte[]> list = securityServer.getAuthCertHashes();
            if ( list != null ) {
                securityServerType.getAuthCertHash().addAll( list );
            }
        }
        if ( securityServerType.getClient() != null ) {
            List<JAXBElement<Object>> list1 = xmlClientIds( securityServer.getClients(), clientMap );
            if ( list1 != null ) {
                securityServerType.getClient().addAll( list1 );
            }
        }
        securityServerType.setOwner( xmlClientId( securityServer.getOwner(), clientMap ) );
        securityServerType.setAddress( securityServer.getAddress() );
        securityServerType.setServerCode( securityServer.getServerCode() );

        return securityServerType;
    }

    @Override
    GlobalGroupType convert(SharedParameters.GlobalGroup globalGroup) {
        if ( globalGroup == null ) {
            return null;
        }

        GlobalGroupType globalGroupType = objectFactory.createGlobalGroupType();

        if ( globalGroupType.getGroupMember() != null ) {
            List<ClientId.Conf> list = clientIdListToConfList( globalGroup.getGroupMembers() );
            if ( list != null ) {
                globalGroupType.getGroupMember().addAll( list );
            }
        }
        globalGroupType.setDescription( globalGroup.getDescription() );
        globalGroupType.setGroupCode( globalGroup.getGroupCode() );

        return globalGroupType;
    }

    @Override
    MemberType convertMember(SharedParameters.Member member, String id) {
        if ( member == null && id == null ) {
            return null;
        }

        MemberType memberType = objectFactory.createMemberType();

        if ( member != null ) {
            memberType.setMemberClass( memberClassToMemberClassType( member.getMemberClass() ) );
            memberType.setMemberCode( member.getMemberCode() );
            memberType.setName( member.getName() );
        }
        memberType.setId( id );

        return memberType;
    }

    @Override
    SubsystemType convertSubsystem(SharedParameters.Subsystem subsystem, String id) {
        if ( subsystem == null && id == null ) {
            return null;
        }

        SubsystemType subsystemType = objectFactory.createSubsystemType();

        if ( subsystem != null ) {
            subsystemType.setSubsystemCode( subsystem.getSubsystemCode() );
        }
        subsystemType.setId( id );

        return subsystemType;
    }

    protected List<ApprovedCATypeV2> approvedCAListToApprovedCATypeV2List(List<SharedParameters.ApprovedCA> list, Map<ClientId, Object> clientMap) {
        if ( list == null ) {
            return null;
        }

        List<ApprovedCATypeV2> list1 = new ArrayList<ApprovedCATypeV2>( list.size() );
        for ( SharedParameters.ApprovedCA approvedCA : list ) {
            list1.add( convert( approvedCA ) );
        }

        return list1;
    }

    protected ApprovedTSAType approvedTSAToApprovedTSAType(SharedParameters.ApprovedTSA approvedTSA, Map<ClientId, Object> clientMap) {
        if ( approvedTSA == null ) {
            return null;
        }

        ApprovedTSAType approvedTSAType = objectFactory.createApprovedTSAType();

        byte[] cert = approvedTSA.getCert();
        if ( cert != null ) {
            approvedTSAType.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        approvedTSAType.setName( approvedTSA.getName() );
        approvedTSAType.setUrl( approvedTSA.getUrl() );

        return approvedTSAType;
    }

    protected List<ApprovedTSAType> approvedTSAListToApprovedTSATypeList(List<SharedParameters.ApprovedTSA> list, Map<ClientId, Object> clientMap) {
        if ( list == null ) {
            return null;
        }

        List<ApprovedTSAType> list1 = new ArrayList<ApprovedTSAType>( list.size() );
        for ( SharedParameters.ApprovedTSA approvedTSA : list ) {
            list1.add( approvedTSAToApprovedTSAType( approvedTSA, clientMap ) );
        }

        return list1;
    }

    protected List<MemberType> memberListToMemberTypeList(List<SharedParameters.Member> list, Map<ClientId, Object> clientMap) {
        if ( list == null ) {
            return null;
        }

        List<MemberType> list1 = new ArrayList<MemberType>( list.size() );
        for ( SharedParameters.Member member : list ) {
            list1.add( convertMember( member, clientMap ) );
        }

        return list1;
    }

    protected List<SecurityServerType> securityServerListToSecurityServerTypeList(List<SharedParameters.SecurityServer> list, Map<ClientId, Object> clientMap) {
        if ( list == null ) {
            return null;
        }

        List<SecurityServerType> list1 = new ArrayList<SecurityServerType>( list.size() );
        for ( SharedParameters.SecurityServer securityServer : list ) {
            list1.add( convert( securityServer, clientMap ) );
        }

        return list1;
    }

    protected List<GlobalGroupType> globalGroupListToGlobalGroupTypeList(List<SharedParameters.GlobalGroup> list, Map<ClientId, Object> clientMap) {
        if ( list == null ) {
            return null;
        }

        List<GlobalGroupType> list1 = new ArrayList<GlobalGroupType>( list.size() );
        for ( SharedParameters.GlobalGroup globalGroup : list ) {
            list1.add( convert( globalGroup ) );
        }

        return list1;
    }

    protected MemberClassType memberClassToMemberClassType(SharedParameters.MemberClass memberClass) {
        if ( memberClass == null ) {
            return null;
        }

        MemberClassType memberClassType = objectFactory.createMemberClassType();

        memberClassType.setCode( memberClass.getCode() );
        memberClassType.setDescription( memberClass.getDescription() );

        return memberClassType;
    }

    protected List<MemberClassType> memberClassListToMemberClassTypeList(List<SharedParameters.MemberClass> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberClassType> list1 = new ArrayList<MemberClassType>( list.size() );
        for ( SharedParameters.MemberClass memberClass : list ) {
            list1.add( memberClassToMemberClassType( memberClass ) );
        }

        return list1;
    }

    protected OcspInfoType ocspInfoToOcspInfoType(SharedParameters.OcspInfo ocspInfo) {
        if ( ocspInfo == null ) {
            return null;
        }

        OcspInfoType ocspInfoType = objectFactory.createOcspInfoType();

        byte[] cert = ocspInfo.getCert();
        if ( cert != null ) {
            ocspInfoType.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        ocspInfoType.setUrl( ocspInfo.getUrl() );

        return ocspInfoType;
    }

    protected List<OcspInfoType> ocspInfoListToOcspInfoTypeList(List<SharedParameters.OcspInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<OcspInfoType> list1 = new ArrayList<OcspInfoType>( list.size() );
        for ( SharedParameters.OcspInfo ocspInfo : list ) {
            list1.add( ocspInfoToOcspInfoType( ocspInfo ) );
        }

        return list1;
    }

    protected CaInfoType caInfoToCaInfoType(SharedParameters.CaInfo caInfo) {
        if ( caInfo == null ) {
            return null;
        }

        CaInfoType caInfoType = objectFactory.createCaInfoType();

        byte[] cert = caInfo.getCert();
        if ( cert != null ) {
            caInfoType.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        if ( caInfoType.getOcsp() != null ) {
            List<OcspInfoType> list = ocspInfoListToOcspInfoTypeList( caInfo.getOcsp() );
            if ( list != null ) {
                caInfoType.getOcsp().addAll( list );
            }
        }

        return caInfoType;
    }

    protected List<CaInfoType> caInfoListToCaInfoTypeList(List<SharedParameters.CaInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<CaInfoType> list1 = new ArrayList<CaInfoType>( list.size() );
        for ( SharedParameters.CaInfo caInfo : list ) {
            list1.add( caInfoToCaInfoType( caInfo ) );
        }

        return list1;
    }

    protected List<ClientId.Conf> clientIdListToConfList(List<ClientId> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientId.Conf> list1 = new ArrayList<ClientId.Conf>( list.size() );
        for ( ClientId clientId : list ) {
            list1.add( mappingUtils.mapClientId( clientId ) );
        }

        return list1;
    }
}
