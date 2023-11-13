package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalGroupEntity.class)
public abstract class GlobalGroupEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SetAttribute<GlobalGroupEntity, GlobalGroupMemberEntity> globalGroupMembers;
	public static volatile SingularAttribute<GlobalGroupEntity, String> description;
	public static volatile SingularAttribute<GlobalGroupEntity, Integer> id;
	public static volatile SingularAttribute<GlobalGroupEntity, String> groupCode;

	public static final String GLOBAL_GROUP_MEMBERS = "globalGroupMembers";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String GROUP_CODE = "groupCode";

}

