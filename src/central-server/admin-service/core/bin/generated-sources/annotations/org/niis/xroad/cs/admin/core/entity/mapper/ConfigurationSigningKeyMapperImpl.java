package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSigningKey;
import org.niis.xroad.cs.admin.core.entity.ConfigurationSigningKeyEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ConfigurationSigningKeyMapperImpl implements ConfigurationSigningKeyMapper {

    @Override
    public ConfigurationSigningKey toTarget(ConfigurationSigningKeyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ConfigurationSigningKey configurationSigningKey = new ConfigurationSigningKey();

        configurationSigningKey.setSourceType( mapSourceType( entity ) );
        configurationSigningKey.setActiveSourceSigningKey( mapActiveSourceSigningKey( entity ) );
        byte[] cert = entity.getCert();
        if ( cert != null ) {
            configurationSigningKey.setCert( Arrays.copyOf( cert, cert.length ) );
        }
        configurationSigningKey.setKeyGeneratedAt( entity.getKeyGeneratedAt() );
        configurationSigningKey.setKeyIdentifier( entity.getKeyIdentifier() );
        configurationSigningKey.setTokenIdentifier( entity.getTokenIdentifier() );

        return configurationSigningKey;
    }
}
