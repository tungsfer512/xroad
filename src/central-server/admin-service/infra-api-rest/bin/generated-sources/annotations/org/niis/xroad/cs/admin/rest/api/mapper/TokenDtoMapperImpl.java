package org.niis.xroad.cs.admin.rest.api.mapper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.ConfigurationSigningKeyWithDetails;
import org.niis.xroad.cs.admin.api.dto.PossibleTokenAction;
import org.niis.xroad.cs.admin.api.dto.TokenInfo;
import org.niis.xroad.cs.admin.api.dto.TokenStatus;
import org.niis.xroad.cs.openapi.model.ConfigurationSigningKeyDto;
import org.niis.xroad.cs.openapi.model.PossibleTokenActionDto;
import org.niis.xroad.cs.openapi.model.TokenDto;
import org.niis.xroad.cs.openapi.model.TokenStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:36+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class TokenDtoMapperImpl implements TokenDtoMapper {

    @Autowired
    private ConfigurationSigningKeyDtoMapper configurationSigningKeyDtoMapper;

    @Override
    public TokenDto toTarget(TokenInfo tokenInfo) {
        if ( tokenInfo == null ) {
            return null;
        }

        TokenDto tokenDto = new TokenDto();

        tokenDto.setName( tokenInfo.getFriendlyName() );
        tokenDto.setLoggedIn( tokenInfo.isActive() );
        tokenDto.setActive( tokenInfo.isActive() );
        tokenDto.setAvailable( tokenInfo.isAvailable() );
        tokenDto.setConfigurationSigningKeys( configurationSigningKeyWithDetailsListToConfigurationSigningKeyDtoList( tokenInfo.getConfigurationSigningKeys() ) );
        tokenDto.setId( tokenInfo.getId() );
        tokenDto.setPossibleActions( possibleTokenActionEnumSetToPossibleTokenActionDtoList( tokenInfo.getPossibleActions() ) );
        tokenDto.setSerialNumber( tokenInfo.getSerialNumber() );
        tokenDto.status( tokenStatusToTokenStatusDto( tokenInfo.getStatus() ) );

        return tokenDto;
    }

    protected List<ConfigurationSigningKeyDto> configurationSigningKeyWithDetailsListToConfigurationSigningKeyDtoList(List<ConfigurationSigningKeyWithDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<ConfigurationSigningKeyDto> list1 = new ArrayList<ConfigurationSigningKeyDto>( list.size() );
        for ( ConfigurationSigningKeyWithDetails configurationSigningKeyWithDetails : list ) {
            list1.add( configurationSigningKeyDtoMapper.toTarget( configurationSigningKeyWithDetails ) );
        }

        return list1;
    }

    protected PossibleTokenActionDto possibleTokenActionToPossibleTokenActionDto(PossibleTokenAction possibleTokenAction) {
        if ( possibleTokenAction == null ) {
            return null;
        }

        PossibleTokenActionDto possibleTokenActionDto;

        switch ( possibleTokenAction ) {
            case CHANGE_PIN: possibleTokenActionDto = PossibleTokenActionDto.CHANGE_PIN;
            break;
            case EDIT_FRIENDLY_NAME: possibleTokenActionDto = PossibleTokenActionDto.EDIT_FRIENDLY_NAME;
            break;
            case GENERATE_EXTERNAL_KEY: possibleTokenActionDto = PossibleTokenActionDto.GENERATE_EXTERNAL_KEY;
            break;
            case GENERATE_INTERNAL_KEY: possibleTokenActionDto = PossibleTokenActionDto.GENERATE_INTERNAL_KEY;
            break;
            case LOGIN: possibleTokenActionDto = PossibleTokenActionDto.LOGIN;
            break;
            case LOGOUT: possibleTokenActionDto = PossibleTokenActionDto.LOGOUT;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + possibleTokenAction );
        }

        return possibleTokenActionDto;
    }

    protected List<PossibleTokenActionDto> possibleTokenActionEnumSetToPossibleTokenActionDtoList(EnumSet<PossibleTokenAction> enumSet) {
        if ( enumSet == null ) {
            return null;
        }

        List<PossibleTokenActionDto> list = new ArrayList<PossibleTokenActionDto>( enumSet.size() );
        for ( PossibleTokenAction possibleTokenAction : enumSet ) {
            list.add( possibleTokenActionToPossibleTokenActionDto( possibleTokenAction ) );
        }

        return list;
    }

    protected TokenStatusDto tokenStatusToTokenStatusDto(TokenStatus tokenStatus) {
        if ( tokenStatus == null ) {
            return null;
        }

        TokenStatusDto tokenStatusDto;

        switch ( tokenStatus ) {
            case NOT_INITIALIZED: tokenStatusDto = TokenStatusDto.NOT_INITIALIZED;
            break;
            case OK: tokenStatusDto = TokenStatusDto.OK;
            break;
            case USER_PIN_COUNT_LOW: tokenStatusDto = TokenStatusDto.USER_PIN_COUNT_LOW;
            break;
            case USER_PIN_EXPIRED: tokenStatusDto = TokenStatusDto.USER_PIN_EXPIRED;
            break;
            case USER_PIN_FINAL_TRY: tokenStatusDto = TokenStatusDto.USER_PIN_FINAL_TRY;
            break;
            case USER_PIN_INCORRECT: tokenStatusDto = TokenStatusDto.USER_PIN_INCORRECT;
            break;
            case USER_PIN_INVALID: tokenStatusDto = TokenStatusDto.USER_PIN_INVALID;
            break;
            case USER_PIN_LOCKED: tokenStatusDto = TokenStatusDto.USER_PIN_LOCKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + tokenStatus );
        }

        return tokenStatusDto;
    }
}
