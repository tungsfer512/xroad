package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuthenticationCertificateRegistrationRequestEntity.class)
public abstract class AuthenticationCertificateRegistrationRequestEntity_ extends org.niis.xroad.cs.admin.core.entity.RequestWithProcessingEntity_ {

	public static volatile SingularAttribute<AuthenticationCertificateRegistrationRequestEntity, String> address;
	public static volatile SingularAttribute<AuthenticationCertificateRegistrationRequestEntity, byte[]> authCert;

	public static final String ADDRESS = "address";
	public static final String AUTH_CERT = "authCert";

}

