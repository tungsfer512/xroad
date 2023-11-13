package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CaInfoEntity.class)
public abstract class CaInfoEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SetAttribute<CaInfoEntity, OcspInfoEntity> ocspInfos;
	public static volatile SingularAttribute<CaInfoEntity, ApprovedCaEntity> approvedCa;
	public static volatile SingularAttribute<CaInfoEntity, byte[]> cert;
	public static volatile SingularAttribute<CaInfoEntity, Integer> id;
	public static volatile SingularAttribute<CaInfoEntity, Instant> validFrom;
	public static volatile SingularAttribute<CaInfoEntity, Instant> validTo;

	public static final String OCSP_INFOS = "ocspInfos";
	public static final String APPROVED_CA = "approvedCa";
	public static final String CERT = "cert";
	public static final String ID = "id";
	public static final String VALID_FROM = "validFrom";
	public static final String VALID_TO = "validTo";

}

