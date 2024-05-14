package org.niis.xroad.cs.admin.rest.api.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.CertificateDetails;
import org.niis.xroad.cs.admin.api.dto.KeyUsageEnum;
import org.niis.xroad.cs.admin.api.dto.SecurityServerAuthenticationCertificateDetails;
import org.niis.xroad.cs.openapi.model.CertificateDetailsDto;
import org.niis.xroad.cs.openapi.model.KeyUsageDto;
import org.niis.xroad.cs.openapi.model.SecurityServerAuthenticationCertificateDetailsDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CertificateDetailsDtoConverterImpl implements CertificateDetailsDtoConverter {

    @Override
    public CertificateDetailsDto convert(CertificateDetails certificateDetails) {
        if ( certificateDetails == null ) {
            return null;
        }

        CertificateDetailsDto certificateDetailsDto = new CertificateDetailsDto();

        certificateDetailsDto.setHash( certificateDetails.getHash() );
        certificateDetailsDto.setIssuerCommonName( certificateDetails.getIssuerCommonName() );
        certificateDetailsDto.setIssuerDistinguishedName( certificateDetails.getIssuerDistinguishedName() );
        certificateDetailsDto.setKeyUsages( keyUsageEnumSetToKeyUsageDtoList( certificateDetails.getKeyUsages() ) );
        certificateDetailsDto.setNotAfter( fromInstant( certificateDetails.getNotAfter() ) );
        certificateDetailsDto.setNotBefore( fromInstant( certificateDetails.getNotBefore() ) );
        certificateDetailsDto.setPublicKeyAlgorithm( certificateDetails.getPublicKeyAlgorithm() );
        if ( certificateDetails.getRsaPublicKeyExponent() != null ) {
            certificateDetailsDto.setRsaPublicKeyExponent( certificateDetails.getRsaPublicKeyExponent().intValue() );
        }
        certificateDetailsDto.setRsaPublicKeyModulus( certificateDetails.getRsaPublicKeyModulus() );
        certificateDetailsDto.setSerial( certificateDetails.getSerial() );
        certificateDetailsDto.signature( certificateDetails.getSignature() );
        certificateDetailsDto.signatureAlgorithm( certificateDetails.getSignatureAlgorithm() );
        certificateDetailsDto.subjectAlternativeNames( certificateDetails.getSubjectAlternativeNames() );
        certificateDetailsDto.subjectCommonName( certificateDetails.getSubjectCommonName() );
        certificateDetailsDto.subjectDistinguishedName( certificateDetails.getSubjectDistinguishedName() );
        certificateDetailsDto.version( certificateDetails.getVersion() );

        return certificateDetailsDto;
    }

    @Override
    public SecurityServerAuthenticationCertificateDetailsDto convert(SecurityServerAuthenticationCertificateDetails certificateDetails) {
        if ( certificateDetails == null ) {
            return null;
        }

        SecurityServerAuthenticationCertificateDetailsDto securityServerAuthenticationCertificateDetailsDto = new SecurityServerAuthenticationCertificateDetailsDto();

        securityServerAuthenticationCertificateDetailsDto.setHash( certificateDetails.getHash() );
        securityServerAuthenticationCertificateDetailsDto.setId( certificateDetails.getId() );
        securityServerAuthenticationCertificateDetailsDto.setIssuerCommonName( certificateDetails.getIssuerCommonName() );
        securityServerAuthenticationCertificateDetailsDto.setIssuerDistinguishedName( certificateDetails.getIssuerDistinguishedName() );
        securityServerAuthenticationCertificateDetailsDto.setKeyUsages( keyUsageEnumSetToKeyUsageDtoList( certificateDetails.getKeyUsages() ) );
        securityServerAuthenticationCertificateDetailsDto.setNotAfter( fromInstant( certificateDetails.getNotAfter() ) );
        securityServerAuthenticationCertificateDetailsDto.setNotBefore( fromInstant( certificateDetails.getNotBefore() ) );
        securityServerAuthenticationCertificateDetailsDto.setPublicKeyAlgorithm( certificateDetails.getPublicKeyAlgorithm() );
        if ( certificateDetails.getRsaPublicKeyExponent() != null ) {
            securityServerAuthenticationCertificateDetailsDto.setRsaPublicKeyExponent( certificateDetails.getRsaPublicKeyExponent().intValue() );
        }
        securityServerAuthenticationCertificateDetailsDto.setRsaPublicKeyModulus( certificateDetails.getRsaPublicKeyModulus() );
        securityServerAuthenticationCertificateDetailsDto.setSerial( certificateDetails.getSerial() );
        securityServerAuthenticationCertificateDetailsDto.signature( certificateDetails.getSignature() );
        securityServerAuthenticationCertificateDetailsDto.signatureAlgorithm( certificateDetails.getSignatureAlgorithm() );
        securityServerAuthenticationCertificateDetailsDto.subjectAlternativeNames( certificateDetails.getSubjectAlternativeNames() );
        securityServerAuthenticationCertificateDetailsDto.subjectCommonName( certificateDetails.getSubjectCommonName() );
        securityServerAuthenticationCertificateDetailsDto.subjectDistinguishedName( certificateDetails.getSubjectDistinguishedName() );
        securityServerAuthenticationCertificateDetailsDto.version( certificateDetails.getVersion() );

        return securityServerAuthenticationCertificateDetailsDto;
    }

    protected KeyUsageDto keyUsageEnumToKeyUsageDto(KeyUsageEnum keyUsageEnum) {
        if ( keyUsageEnum == null ) {
            return null;
        }

        KeyUsageDto keyUsageDto;

        switch ( keyUsageEnum ) {
            case CRL_SIGN: keyUsageDto = KeyUsageDto.CRL_SIGN;
            break;
            case DATA_ENCIPHERMENT: keyUsageDto = KeyUsageDto.DATA_ENCIPHERMENT;
            break;
            case DECIPHER_ONLY: keyUsageDto = KeyUsageDto.DECIPHER_ONLY;
            break;
            case DIGITAL_SIGNATURE: keyUsageDto = KeyUsageDto.DIGITAL_SIGNATURE;
            break;
            case ENCIPHER_ONLY: keyUsageDto = KeyUsageDto.ENCIPHER_ONLY;
            break;
            case KEY_AGREEMENT: keyUsageDto = KeyUsageDto.KEY_AGREEMENT;
            break;
            case KEY_CERT_SIGN: keyUsageDto = KeyUsageDto.KEY_CERT_SIGN;
            break;
            case KEY_ENCIPHERMENT: keyUsageDto = KeyUsageDto.KEY_ENCIPHERMENT;
            break;
            case NON_REPUDIATION: keyUsageDto = KeyUsageDto.NON_REPUDIATION;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + keyUsageEnum );
        }

        return keyUsageDto;
    }

    protected List<KeyUsageDto> keyUsageEnumSetToKeyUsageDtoList(Set<KeyUsageEnum> set) {
        if ( set == null ) {
            return null;
        }

        List<KeyUsageDto> list = new ArrayList<KeyUsageDto>( set.size() );
        for ( KeyUsageEnum keyUsageEnum : set ) {
            list.add( keyUsageEnumToKeyUsageDto( keyUsageEnum ) );
        }

        return list;
    }
}
