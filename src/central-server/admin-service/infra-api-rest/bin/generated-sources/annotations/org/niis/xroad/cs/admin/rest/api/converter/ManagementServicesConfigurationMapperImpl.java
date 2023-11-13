package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ManagementServicesConfiguration;
import org.niis.xroad.cs.openapi.model.ManagementServicesConfigurationDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:33+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ManagementServicesConfigurationMapperImpl implements ManagementServicesConfigurationMapper {

    @Override
    public ManagementServicesConfigurationDto toTarget(ManagementServicesConfiguration arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ManagementServicesConfigurationDto managementServicesConfigurationDto = new ManagementServicesConfigurationDto();

        managementServicesConfigurationDto.setSecurityServerId( arg0.getSecurityServerId() );
        managementServicesConfigurationDto.setSecurityServerOwnersGlobalGroupCode( arg0.getSecurityServerOwnersGlobalGroupCode() );
        managementServicesConfigurationDto.setServiceProviderId( arg0.getServiceProviderId() );
        managementServicesConfigurationDto.setServiceProviderName( arg0.getServiceProviderName() );
        managementServicesConfigurationDto.setServicesAddress( arg0.getServicesAddress() );
        managementServicesConfigurationDto.wsdlAddress( arg0.getWsdlAddress() );

        return managementServicesConfigurationDto;
    }
}
