package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UiUserEntity.class)
public abstract class UiUserEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<UiUserEntity, Integer> id;
	public static volatile SingularAttribute<UiUserEntity, String> locale;
	public static volatile SingularAttribute<UiUserEntity, String> username;

	public static final String ID = "id";
	public static final String LOCALE = "locale";
	public static final String USERNAME = "username";

}

