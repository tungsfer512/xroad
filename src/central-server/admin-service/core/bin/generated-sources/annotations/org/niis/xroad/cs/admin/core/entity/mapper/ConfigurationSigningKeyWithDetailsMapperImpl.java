package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSigningKey;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSigningKeyWithDetails;
import org.niis.xroad.cs.admin.api.dto.PossibleKeyAction;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ConfigurationSigningKeyWithDetailsMapperImpl implements ConfigurationSigningKeyWithDetailsMapper {

    @Override
    public ConfigurationSigningKeyWithDetails toTarget(ConfigurationSigningKey source, List<PossibleKeyAction> possibleActions, String label, Boolean available) {
        if ( source == null && possibleActions == null && label == null && available == null ) {
            return null;
        }

        ConfigurationSigningKeyWithDetails configurationSigningKeyWithDetails = new ConfigurationSigningKeyWithDetails();

        if ( source != null ) {
            configurationSigningKeyWithDetails.setActiveSourceSigningKey( source.isActiveSourceSigningKey() );
            byte[] cert = source.getCert();
            if ( cert != null ) {
                configurationSigningKeyWithDetails.setCert( Arrays.copyOf( cert, cert.length ) );
            }
            configurationSigningKeyWithDetails.setKeyGeneratedAt( source.getKeyGeneratedAt() );
            configurationSigningKeyWithDetails.setKeyIdentifier( source.getKeyIdentifier() );
            configurationSigningKeyWithDetails.setSourceType( source.getSourceType() );
            configurationSigningKeyWithDetails.setTokenIdentifier( source.getTokenIdentifier() );
        }
        List<PossibleKeyAction> list = possibleActions;
        if ( list != null ) {
            configurationSigningKeyWithDetails.setPossibleActions( new ArrayList<PossibleKeyAction>( list ) );
        }
        configurationSigningKeyWithDetails.setLabel( map( label ) );
        configurationSigningKeyWithDetails.setAvailable( available );

        return configurationSigningKeyWithDetails;
    }
}
