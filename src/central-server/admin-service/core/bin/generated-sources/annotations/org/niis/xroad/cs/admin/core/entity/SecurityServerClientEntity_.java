package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SecurityServerClientEntity.class)
public abstract class SecurityServerClientEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<SecurityServerClientEntity, ClientIdEntity> identifier;
	public static volatile SetAttribute<SecurityServerClientEntity, ServerClientEntity> serverClients;
	public static volatile SingularAttribute<SecurityServerClientEntity, Integer> id;

	public static final String IDENTIFIER = "identifier";
	public static final String SERVER_CLIENTS = "serverClients";
	public static final String ID = "id";

}

