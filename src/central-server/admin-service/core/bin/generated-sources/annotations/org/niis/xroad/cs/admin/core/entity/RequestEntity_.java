package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.niis.xroad.cs.admin.api.domain.Origin;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RequestEntity.class)
public abstract class RequestEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<RequestEntity, String> comments;
	public static volatile SingularAttribute<RequestEntity, Origin> origin;
	public static volatile SingularAttribute<RequestEntity, Integer> id;
	public static volatile SingularAttribute<RequestEntity, SecurityServerIdEntity> securityServerId;

	public static final String COMMENTS = "comments";
	public static final String ORIGIN = "origin";
	public static final String ID = "id";
	public static final String SECURITY_SERVER_ID = "securityServerId";

}

