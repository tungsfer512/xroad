package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.AuthenticationCertificateDeletionRequest;
import org.niis.xroad.cs.admin.api.domain.AuthenticationCertificateRegistrationRequest;
import org.niis.xroad.cs.admin.api.domain.ClientDeletionRequest;
import org.niis.xroad.cs.admin.api.domain.ClientRegistrationRequest;
import org.niis.xroad.cs.admin.api.domain.ManagementRequestStatus;
import org.niis.xroad.cs.admin.api.domain.OwnerChangeRequest;
import org.niis.xroad.cs.admin.core.entity.AuthenticationCertificateDeletionRequestEntity;
import org.niis.xroad.cs.admin.core.entity.AuthenticationCertificateRegistrationRequestEntity;
import org.niis.xroad.cs.admin.core.entity.ClientDeletionRequestEntity;
import org.niis.xroad.cs.admin.core.entity.ClientRegistrationRequestEntity;
import org.niis.xroad.cs.admin.core.entity.OwnerChangeRequestEntity;
import org.niis.xroad.cs.admin.core.entity.RequestProcessingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:43+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class RequestMapperImpl implements RequestMapper {

    @Autowired
    private ClientIdMapper clientIdMapper;
    @Autowired
    private SecurityServerIdMapper securityServerIdMapper;

    @Override
    public AuthenticationCertificateDeletionRequest toDto(AuthenticationCertificateDeletionRequestEntity source) {
        if ( source == null ) {
            return null;
        }

        AuthenticationCertificateDeletionRequest authenticationCertificateDeletionRequest = new AuthenticationCertificateDeletionRequest();

        authenticationCertificateDeletionRequest.setCreatedAt( source.getCreatedAt() );
        authenticationCertificateDeletionRequest.setUpdatedAt( source.getUpdatedAt() );
        authenticationCertificateDeletionRequest.setComments( source.getComments() );
        authenticationCertificateDeletionRequest.setId( source.getId() );
        authenticationCertificateDeletionRequest.setOrigin( source.getOrigin() );
        authenticationCertificateDeletionRequest.setSecurityServerId( securityServerIdMapper.toTarget( source.getSecurityServerId() ) );
        byte[] authCert = source.getAuthCert();
        if ( authCert != null ) {
            authenticationCertificateDeletionRequest.setAuthCert( Arrays.copyOf( authCert, authCert.length ) );
        }

        return authenticationCertificateDeletionRequest;
    }

    @Override
    public ClientDeletionRequest toDto(ClientDeletionRequestEntity source) {
        if ( source == null ) {
            return null;
        }

        ClientDeletionRequest clientDeletionRequest = new ClientDeletionRequest();

        clientDeletionRequest.setCreatedAt( source.getCreatedAt() );
        clientDeletionRequest.setUpdatedAt( source.getUpdatedAt() );
        clientDeletionRequest.setComments( source.getComments() );
        clientDeletionRequest.setId( source.getId() );
        clientDeletionRequest.setOrigin( source.getOrigin() );
        clientDeletionRequest.setSecurityServerId( securityServerIdMapper.toTarget( source.getSecurityServerId() ) );
        clientDeletionRequest.setClientId( clientIdMapper.toTarget( source.getClientId() ) );

        return clientDeletionRequest;
    }

    @Override
    public AuthenticationCertificateRegistrationRequest toDto(AuthenticationCertificateRegistrationRequestEntity source) {
        if ( source == null ) {
            return null;
        }

        AuthenticationCertificateRegistrationRequest authenticationCertificateRegistrationRequest = new AuthenticationCertificateRegistrationRequest();

        authenticationCertificateRegistrationRequest.setProcessingStatus( sourceRequestProcessingStatus( source ) );
        authenticationCertificateRegistrationRequest.setCreatedAt( source.getCreatedAt() );
        authenticationCertificateRegistrationRequest.setUpdatedAt( source.getUpdatedAt() );
        authenticationCertificateRegistrationRequest.setComments( source.getComments() );
        authenticationCertificateRegistrationRequest.setId( source.getId() );
        authenticationCertificateRegistrationRequest.setOrigin( source.getOrigin() );
        authenticationCertificateRegistrationRequest.setSecurityServerId( securityServerIdMapper.toTarget( source.getSecurityServerId() ) );
        authenticationCertificateRegistrationRequest.setAddress( source.getAddress() );
        byte[] authCert = source.getAuthCert();
        if ( authCert != null ) {
            authenticationCertificateRegistrationRequest.setAuthCert( Arrays.copyOf( authCert, authCert.length ) );
        }

        return authenticationCertificateRegistrationRequest;
    }

    @Override
    public ClientRegistrationRequest toDto(ClientRegistrationRequestEntity source) {
        if ( source == null ) {
            return null;
        }

        ClientRegistrationRequest clientRegistrationRequest = new ClientRegistrationRequest();

        clientRegistrationRequest.setProcessingStatus( sourceRequestProcessingStatus1( source ) );
        clientRegistrationRequest.setCreatedAt( source.getCreatedAt() );
        clientRegistrationRequest.setUpdatedAt( source.getUpdatedAt() );
        clientRegistrationRequest.setComments( source.getComments() );
        clientRegistrationRequest.setId( source.getId() );
        clientRegistrationRequest.setOrigin( source.getOrigin() );
        clientRegistrationRequest.setSecurityServerId( securityServerIdMapper.toTarget( source.getSecurityServerId() ) );
        clientRegistrationRequest.setClientId( clientIdMapper.toTarget( source.getClientId() ) );

        return clientRegistrationRequest;
    }

    @Override
    public OwnerChangeRequest toDto(OwnerChangeRequestEntity source) {
        if ( source == null ) {
            return null;
        }

        OwnerChangeRequest ownerChangeRequest = new OwnerChangeRequest();

        ownerChangeRequest.setProcessingStatus( sourceRequestProcessingStatus2( source ) );
        ownerChangeRequest.setCreatedAt( source.getCreatedAt() );
        ownerChangeRequest.setUpdatedAt( source.getUpdatedAt() );
        ownerChangeRequest.setComments( source.getComments() );
        ownerChangeRequest.setId( source.getId() );
        ownerChangeRequest.setOrigin( source.getOrigin() );
        ownerChangeRequest.setSecurityServerId( securityServerIdMapper.toTarget( source.getSecurityServerId() ) );
        ownerChangeRequest.setClientId( clientIdMapper.toTarget( source.getClientId() ) );

        return ownerChangeRequest;
    }

    private ManagementRequestStatus sourceRequestProcessingStatus(AuthenticationCertificateRegistrationRequestEntity authenticationCertificateRegistrationRequestEntity) {
        if ( authenticationCertificateRegistrationRequestEntity == null ) {
            return null;
        }
        RequestProcessingEntity requestProcessing = authenticationCertificateRegistrationRequestEntity.getRequestProcessing();
        if ( requestProcessing == null ) {
            return null;
        }
        ManagementRequestStatus status = requestProcessing.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }

    private ManagementRequestStatus sourceRequestProcessingStatus1(ClientRegistrationRequestEntity clientRegistrationRequestEntity) {
        if ( clientRegistrationRequestEntity == null ) {
            return null;
        }
        RequestProcessingEntity requestProcessing = clientRegistrationRequestEntity.getRequestProcessing();
        if ( requestProcessing == null ) {
            return null;
        }
        ManagementRequestStatus status = requestProcessing.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }

    private ManagementRequestStatus sourceRequestProcessingStatus2(OwnerChangeRequestEntity ownerChangeRequestEntity) {
        if ( ownerChangeRequestEntity == null ) {
            return null;
        }
        RequestProcessingEntity requestProcessing = ownerChangeRequestEntity.getRequestProcessing();
        if ( requestProcessing == null ) {
            return null;
        }
        ManagementRequestStatus status = requestProcessing.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }
}
