package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AnchorUrlCertEntity.class)
public abstract class AnchorUrlCertEntity_ {

	public static volatile SingularAttribute<AnchorUrlCertEntity, byte[]> cert;
	public static volatile SingularAttribute<AnchorUrlCertEntity, Integer> id;
	public static volatile SingularAttribute<AnchorUrlCertEntity, AnchorUrlEntity> anchorUrl;

	public static final String CERT = "cert";
	public static final String ID = "id";
	public static final String ANCHOR_URL = "anchorUrl";

}

