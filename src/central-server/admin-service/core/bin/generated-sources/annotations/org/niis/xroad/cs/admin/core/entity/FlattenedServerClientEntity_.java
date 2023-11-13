package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FlattenedServerClientEntity.class)
public abstract class FlattenedServerClientEntity_ {

	public static volatile SingularAttribute<FlattenedServerClientEntity, SecurityServerEntity> securityServer;
	public static volatile SingularAttribute<FlattenedServerClientEntity, FlattenedSecurityServerClientViewEntity> flattenedSecurityServerClientView;
	public static volatile SingularAttribute<FlattenedServerClientEntity, Integer> id;

	public static final String SECURITY_SERVER = "securityServer";
	public static final String FLATTENED_SECURITY_SERVER_CLIENT_VIEW = "flattenedSecurityServerClientView";
	public static final String ID = "id";

}

