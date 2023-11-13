package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApprovedTsaEntity.class)
public abstract class ApprovedTsaEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<ApprovedTsaEntity, String> name;
	public static volatile SingularAttribute<ApprovedTsaEntity, byte[]> cert;
	public static volatile SingularAttribute<ApprovedTsaEntity, Integer> id;
	public static volatile SingularAttribute<ApprovedTsaEntity, Instant> validFrom;
	public static volatile SingularAttribute<ApprovedTsaEntity, String> url;
	public static volatile SingularAttribute<ApprovedTsaEntity, Instant> validTo;

	public static final String NAME = "name";
	public static final String CERT = "cert";
	public static final String ID = "id";
	public static final String VALID_FROM = "validFrom";
	public static final String URL = "url";
	public static final String VALID_TO = "validTo";

}

