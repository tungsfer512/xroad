package org.niis.xroad.cs.admin.core.entity;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FlattenedSecurityServerClientViewEntity.class)
public abstract class FlattenedSecurityServerClientViewEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, String> memberCode;
	public static volatile SetAttribute<FlattenedSecurityServerClientViewEntity, FlattenedServerClientEntity> flattenedServerClients;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, ClientIdEntity> identifier;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, String> memberName;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, Integer> id;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, XRoadObjectType> type;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, String> xroadInstance;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, MemberClassEntity> memberClass;
	public static volatile SingularAttribute<FlattenedSecurityServerClientViewEntity, String> subsystemCode;

	public static final String MEMBER_CODE = "memberCode";
	public static final String FLATTENED_SERVER_CLIENTS = "flattenedServerClients";
	public static final String IDENTIFIER = "identifier";
	public static final String MEMBER_NAME = "memberName";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String XROAD_INSTANCE = "xroadInstance";
	public static final String MEMBER_CLASS = "memberClass";
	public static final String SUBSYSTEM_CODE = "subsystemCode";

}

