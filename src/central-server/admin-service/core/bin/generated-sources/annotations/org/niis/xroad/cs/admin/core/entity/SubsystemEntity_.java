package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SubsystemEntity.class)
public abstract class SubsystemEntity_ extends org.niis.xroad.cs.admin.core.entity.SecurityServerClientEntity_ {

	public static volatile SingularAttribute<SubsystemEntity, XRoadMemberEntity> xroadMember;
	public static volatile SingularAttribute<SubsystemEntity, String> subsystemCode;

	public static final String XROAD_MEMBER = "xroadMember";
	public static final String SUBSYSTEM_CODE = "subsystemCode";

}

