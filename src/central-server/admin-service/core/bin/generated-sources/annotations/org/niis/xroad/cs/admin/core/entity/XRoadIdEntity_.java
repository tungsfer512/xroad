package org.niis.xroad.cs.admin.core.entity;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XRoadIdEntity.class)
public abstract class XRoadIdEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<XRoadIdEntity, String> memberCode;
	public static volatile SingularAttribute<XRoadIdEntity, String> serviceVersion;
	public static volatile SingularAttribute<XRoadIdEntity, String> serverCode;
	public static volatile SingularAttribute<XRoadIdEntity, String> serviceCode;
	public static volatile SingularAttribute<XRoadIdEntity, String> xRoadInstance;
	public static volatile SingularAttribute<XRoadIdEntity, Integer> id;
	public static volatile SingularAttribute<XRoadIdEntity, String> memberClass;
	public static volatile SingularAttribute<XRoadIdEntity, String> subsystemCode;
	public static volatile SingularAttribute<XRoadIdEntity, XRoadObjectType> objectType;

	public static final String MEMBER_CODE = "memberCode";
	public static final String SERVICE_VERSION = "serviceVersion";
	public static final String SERVER_CODE = "serverCode";
	public static final String SERVICE_CODE = "serviceCode";
	public static final String X_ROAD_INSTANCE = "xRoadInstance";
	public static final String ID = "id";
	public static final String MEMBER_CLASS = "memberClass";
	public static final String SUBSYSTEM_CODE = "subsystemCode";
	public static final String OBJECT_TYPE = "objectType";

}

