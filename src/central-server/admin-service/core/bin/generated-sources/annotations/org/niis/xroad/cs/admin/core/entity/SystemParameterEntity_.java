package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SystemParameterEntity.class)
public abstract class SystemParameterEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<SystemParameterEntity, String> haNodeName;
	public static volatile SingularAttribute<SystemParameterEntity, Integer> id;
	public static volatile SingularAttribute<SystemParameterEntity, String> value;
	public static volatile SingularAttribute<SystemParameterEntity, String> key;

	public static final String HA_NODE_NAME = "haNodeName";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String KEY = "key";

}

