package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ManagementServicesConfiguration;
import org.niis.xroad.cs.openapi.model.ManagementServicesConfigurationDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
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
