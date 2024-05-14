package org.niis.xroad.cs.admin.rest.api.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSigningKeyWithDetails;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSourceType;
import org.niis.xroad.cs.admin.api.dto.KeyLabel;
import org.niis.xroad.cs.admin.api.dto.PossibleKeyAction;
import org.niis.xroad.cs.openapi.model.ConfigurationSigningKeyDto;
import org.niis.xroad.cs.openapi.model.ConfigurationTypeDto;
import org.niis.xroad.cs.openapi.model.KeyLabelDto;
import org.niis.xroad.cs.openapi.model.PossibleKeyActionDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ConfigurationSigningKeyDtoMapperImpl implements ConfigurationSigningKeyDtoMapper {

    @Override
    public ConfigurationSigningKeyDto toTarget(ConfigurationSigningKeyWithDetails model) {
        if ( model == null ) {
            return null;
        }

        ConfigurationSigningKeyDto configurationSigningKeyDto = new ConfigurationSigningKeyDto();

        configurationSigningKeyDto.setId( model.getKeyIdentifier() );
        configurationSigningKeyDto.tokenId( model.getTokenIdentifier() );
        configurationSigningKeyDto.setCreatedAt( fromInstant( model.getKeyGeneratedAt() ) );
        configurationSigningKeyDto.setActive( model.isActiveSourceSigningKey() );
        configurationSigningKeyDto.setAvailable( model.getAvailable() );
        configurationSigningKeyDto.setLabel( keyLabelToKeyLabelDto( model.getLabel() ) );
        configurationSigningKeyDto.setPossibleActions( possibleKeyActionListToPossibleKeyActionDtoList( model.getPossibleActions() ) );
        configurationSigningKeyDto.sourceType( configurationSourceTypeToConfigurationTypeDto( model.getSourceType() ) );

        return configurationSigningKeyDto;
    }

    protected KeyLabelDto keyLabelToKeyLabelDto(KeyLabel keyLabel) {
        if ( keyLabel == null ) {
            return null;
        }

        KeyLabelDto keyLabelDto = new KeyLabelDto();

        keyLabelDto.setLabel( keyLabel.getLabel() );

        return keyLabelDto;
    }

    protected PossibleKeyActionDto possibleKeyActionToPossibleKeyActionDto(PossibleKeyAction possibleKeyAction) {
        if ( possibleKeyAction == null ) {
            return null;
        }

        PossibleKeyActionDto possibleKeyActionDto;

        switch ( possibleKeyAction ) {
            case ACTIVATE: possibleKeyActionDto = PossibleKeyActionDto.ACTIVATE;
            break;
            case DELETE: possibleKeyActionDto = PossibleKeyActionDto.DELETE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + possibleKeyAction );
        }

        return possibleKeyActionDto;
    }

    protected List<PossibleKeyActionDto> possibleKeyActionListToPossibleKeyActionDtoList(List<PossibleKeyAction> list) {
        if ( list == null ) {
            return null;
        }

        List<PossibleKeyActionDto> list1 = new ArrayList<PossibleKeyActionDto>( list.size() );
        for ( PossibleKeyAction possibleKeyAction : list ) {
            list1.add( possibleKeyActionToPossibleKeyActionDto( possibleKeyAction ) );
        }

        return list1;
    }

    protected ConfigurationTypeDto configurationSourceTypeToConfigurationTypeDto(ConfigurationSourceType configurationSourceType) {
        if ( configurationSourceType == null ) {
            return null;
        }

        ConfigurationTypeDto configurationTypeDto;

        switch ( configurationSourceType ) {
            case EXTERNAL: configurationTypeDto = ConfigurationTypeDto.EXTERNAL;
            break;
            case INTERNAL: configurationTypeDto = ConfigurationTypeDto.INTERNAL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + configurationSourceType );
        }

        return configurationTypeDto;
    }
}
