package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.ConfigurationParts;
import org.niis.xroad.cs.openapi.model.ConfigurationPartDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:36+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ConfigurationPartsDtoConverterImpl implements ConfigurationPartsDtoConverter {

    @Override
    public ConfigurationPartDto convert(ConfigurationParts configurationParts) {
        if ( configurationParts == null ) {
            return null;
        }

        ConfigurationPartDto configurationPartDto = new ConfigurationPartDto();

        configurationPartDto.setContentIdentifier( configurationParts.getContentIdentifier() );
        configurationPartDto.setFileName( configurationParts.getFileName() );
        configurationPartDto.setFileUpdatedAt( fromInstant( configurationParts.getFileUpdatedAt() ) );
        configurationPartDto.setOptional( configurationParts.isOptional() );
        configurationPartDto.version( configurationParts.getVersion() );

        return configurationPartDto;
    }
}
