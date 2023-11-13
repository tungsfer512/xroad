package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuthCertEntity.class)
public abstract class AuthCertEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<AuthCertEntity, SecurityServerEntity> securityServer;
	public static volatile SingularAttribute<AuthCertEntity, byte[]> cert;
	public static volatile SingularAttribute<AuthCertEntity, Integer> id;

	public static final String SECURITY_SERVER = "securityServer";
	public static final String CERT = "cert";
	public static final String ID = "id";

}

