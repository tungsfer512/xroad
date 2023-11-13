package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServerClientEntity.class)
public abstract class ServerClientEntity_ {

	public static volatile SingularAttribute<ServerClientEntity, SecurityServerEntity> securityServer;
	public static volatile SingularAttribute<ServerClientEntity, Integer> id;
	public static volatile SingularAttribute<ServerClientEntity, SecurityServerClientEntity> securityServerClient;

	public static final String SECURITY_SERVER = "securityServer";
	public static final String ID = "id";
	public static final String SECURITY_SERVER_CLIENT = "securityServerClient";

}

