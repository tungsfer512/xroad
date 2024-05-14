package org.niis.xroad.cs.admin.globalconf.generator;

import ee.ria.xroad.common.conf.globalconf.privateparameters.v2.ConfigurationAnchorType;
import ee.ria.xroad.common.conf.globalconf.privateparameters.v2.ConfigurationSourceType;
import ee.ria.xroad.common.conf.globalconf.privateparameters.v2.ManagementServiceType;
import ee.ria.xroad.common.conf.globalconf.privateparameters.v2.ObjectFactory;
import ee.ria.xroad.common.conf.globalconf.privateparameters.v2.PrivateParametersType;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:49+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
class PrivateParametersConverterImpl implements PrivateParametersConverter {

    private final ObjectFactory objectFactory = new ObjectFactory();
    private final MappingUtils mappingUtils = new MappingUtils();
    private final DatatypeFactory datatypeFactory;

    public PrivateParametersConverterImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public PrivateParametersType convert(PrivateParameters parameters) {
        if ( parameters == null ) {
            return null;
        }

        PrivateParametersType privateParametersType = objectFactory.createPrivateParametersType();

        if ( privateParametersType.getConfigurationAnchor() != null ) {
            List<ConfigurationAnchorType> list = configurationAnchorListToConfigurationAnchorTypeList( parameters.getConfigurationAnchors() );
            if ( list != null ) {
                privateParametersType.getConfigurationAnchor().addAll( list );
            }
        }
        privateParametersType.setInstanceIdentifier( parameters.getInstanceIdentifier() );
        privateParametersType.setManagementService( managementServiceToManagementServiceType( parameters.getManagementService() ) );
        if ( parameters.getTimeStampingIntervalSeconds() != null ) {
            privateParametersType.setTimeStampingIntervalSeconds( BigInteger.valueOf( parameters.getTimeStampingIntervalSeconds() ) );
        }

        return privateParametersType;
    }

    @Override
    public ConfigurationAnchorType convertAnchor(PrivateParameters.ConfigurationAnchor configurationAnchor) {
        if ( configurationAnchor == null ) {
            return null;
        }

        ConfigurationAnchorType configurationAnchorType = objectFactory.createConfigurationAnchorType();

        if ( configurationAnchorType.getSource() != null ) {
            List<ConfigurationSourceType> list = configurationSourceListToConfigurationSourceTypeList( configurationAnchor.getSources() );
            if ( list != null ) {
                configurationAnchorType.getSource().addAll( list );
            }
        }
        configurationAnchorType.setGeneratedAt( zonedDateTimeToXmlGregorianCalendar( mappingUtils.mapInstant( configurationAnchor.getGeneratedAt() ) ) );
        configurationAnchorType.setInstanceIdentifier( configurationAnchor.getInstanceIdentifier() );

        return configurationAnchorType;
    }

    @Override
    public ConfigurationSourceType convertSource(PrivateParameters.ConfigurationSource configurationSource) {
        if ( configurationSource == null ) {
            return null;
        }

        ConfigurationSourceType configurationSourceType = objectFactory.createConfigurationSourceType();

        if ( configurationSourceType.getVerificationCert() != null ) {
            List<byte[]> list = configurationSource.getVerificationCerts();
            if ( list != null ) {
                configurationSourceType.getVerificationCert().addAll( list );
            }
        }
        configurationSourceType.setDownloadURL( configurationSource.getDownloadURL() );

        return configurationSourceType;
    }

    private XMLGregorianCalendar zonedDateTimeToXmlGregorianCalendar( ZonedDateTime zdt ) {
        if ( zdt == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar( GregorianCalendar.from( zdt ) );
    }

    protected List<ConfigurationAnchorType> configurationAnchorListToConfigurationAnchorTypeList(List<PrivateParameters.ConfigurationAnchor> list) {
        if ( list == null ) {
            return null;
        }

        List<ConfigurationAnchorType> list1 = new ArrayList<ConfigurationAnchorType>( list.size() );
        for ( PrivateParameters.ConfigurationAnchor configurationAnchor : list ) {
            list1.add( convertAnchor( configurationAnchor ) );
        }

        return list1;
    }

    protected ManagementServiceType managementServiceToManagementServiceType(PrivateParameters.ManagementService managementService) {
        if ( managementService == null ) {
            return null;
        }

        ManagementServiceType managementServiceType = objectFactory.createManagementServiceType();

        managementServiceType.setAuthCertRegServiceAddress( managementService.getAuthCertRegServiceAddress() );
        byte[] authCertRegServiceCert = managementService.getAuthCertRegServiceCert();
        if ( authCertRegServiceCert != null ) {
            managementServiceType.setAuthCertRegServiceCert( Arrays.copyOf( authCertRegServiceCert, authCertRegServiceCert.length ) );
        }
        managementServiceType.setManagementRequestServiceProviderId( mappingUtils.mapClientId( managementService.getManagementRequestServiceProviderId() ) );

        return managementServiceType;
    }

    protected List<ConfigurationSourceType> configurationSourceListToConfigurationSourceTypeList(List<PrivateParameters.ConfigurationSource> list) {
        if ( list == null ) {
            return null;
        }

        List<ConfigurationSourceType> list1 = new ArrayList<ConfigurationSourceType>( list.size() );
        for ( PrivateParameters.ConfigurationSource configurationSource : list ) {
            list1.add( convertSource( configurationSource ) );
        }

        return list1;
    }
}
