package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SecurityServerEntity.class)
public abstract class SecurityServerEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<SecurityServerEntity, XRoadMemberEntity> owner;
	public static volatile SingularAttribute<SecurityServerEntity, String> serverCode;
	public static volatile SingularAttribute<SecurityServerEntity, String> address;
	public static volatile SetAttribute<SecurityServerEntity, AuthCertEntity> authCerts;
	public static volatile SetAttribute<SecurityServerEntity, ServerClientEntity> serverClients;
	public static volatile SingularAttribute<SecurityServerEntity, Integer> id;

	public static final String OWNER = "owner";
	public static final String SERVER_CODE = "serverCode";
	public static final String ADDRESS = "address";
	public static final String AUTH_CERTS = "authCerts";
	public static final String SERVER_CLIENTS = "serverClients";
	public static final String ID = "id";

}

