package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalGroupMemberEntity.class)
public abstract class GlobalGroupMemberEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<GlobalGroupMemberEntity, ClientIdEntity> identifier;
	public static volatile SingularAttribute<GlobalGroupMemberEntity, GlobalGroupEntity> globalGroup;
	public static volatile SingularAttribute<GlobalGroupMemberEntity, Integer> id;

	public static final String IDENTIFIER = "identifier";
	public static final String GLOBAL_GROUP = "globalGroup";
	public static final String ID = "id";

}

