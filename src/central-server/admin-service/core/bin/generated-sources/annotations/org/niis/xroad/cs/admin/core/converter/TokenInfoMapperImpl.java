package org.niis.xroad.cs.admin.core.converter;

import ee.ria.xroad.signer.protocol.dto.TokenInfo;
import ee.ria.xroad.signer.protocol.dto.TokenStatusInfo;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.TokenStatus;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class TokenInfoMapperImpl extends TokenInfoMapper {

    @Override
    public org.niis.xroad.cs.admin.api.dto.TokenInfo toTarget(TokenInfo tokenInfo) {
        if ( tokenInfo == null ) {
            return null;
        }

        org.niis.xroad.cs.admin.api.dto.TokenInfo tokenInfo1 = new org.niis.xroad.cs.admin.api.dto.TokenInfo();

        tokenInfo1.setActive( tokenInfo.isActive() );
        tokenInfo1.setAvailable( tokenInfo.isAvailable() );
        tokenInfo1.setFriendlyName( tokenInfo.getFriendlyName() );
        tokenInfo1.setId( tokenInfo.getId() );
        tokenInfo1.setLabel( tokenInfo.getLabel() );
        tokenInfo1.setReadOnly( tokenInfo.isReadOnly() );
        tokenInfo1.setSerialNumber( tokenInfo.getSerialNumber() );
        tokenInfo1.setSlotIndex( tokenInfo.getSlotIndex() );
        tokenInfo1.setStatus( tokenStatusInfoToTokenStatus( tokenInfo.getStatus() ) );
        tokenInfo1.setType( tokenInfo.getType() );

        enrichToken( tokenInfo, tokenInfo1 );

        return tokenInfo1;
    }

    protected TokenStatus tokenStatusInfoToTokenStatus(TokenStatusInfo tokenStatusInfo) {
        if ( tokenStatusInfo == null ) {
            return null;
        }

        TokenStatus tokenStatus;

        switch ( tokenStatusInfo ) {
            case NOT_INITIALIZED: tokenStatus = TokenStatus.NOT_INITIALIZED;
            break;
            case OK: tokenStatus = TokenStatus.OK;
            break;
            case USER_PIN_COUNT_LOW: tokenStatus = TokenStatus.USER_PIN_COUNT_LOW;
            break;
            case USER_PIN_EXPIRED: tokenStatus = TokenStatus.USER_PIN_EXPIRED;
            break;
            case USER_PIN_FINAL_TRY: tokenStatus = TokenStatus.USER_PIN_FINAL_TRY;
            break;
            case USER_PIN_INCORRECT: tokenStatus = TokenStatus.USER_PIN_INCORRECT;
            break;
            case USER_PIN_INVALID: tokenStatus = TokenStatus.USER_PIN_INVALID;
            break;
            case USER_PIN_LOCKED: tokenStatus = TokenStatus.USER_PIN_LOCKED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + tokenStatusInfo );
        }

        return tokenStatus;
    }
}
