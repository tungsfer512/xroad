package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OcspInfoEntity.class)
public abstract class OcspInfoEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<OcspInfoEntity, CaInfoEntity> caInfo;
	public static volatile SingularAttribute<OcspInfoEntity, byte[]> cert;
	public static volatile SingularAttribute<OcspInfoEntity, Integer> id;
	public static volatile SingularAttribute<OcspInfoEntity, String> url;

	public static final String CA_INFO = "caInfo";
	public static final String CERT = "cert";
	public static final String ID = "id";
	public static final String URL = "url";

}

