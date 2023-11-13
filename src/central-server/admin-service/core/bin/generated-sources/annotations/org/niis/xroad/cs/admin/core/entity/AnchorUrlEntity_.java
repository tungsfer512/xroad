package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AnchorUrlEntity.class)
public abstract class AnchorUrlEntity_ {

	public static volatile SingularAttribute<AnchorUrlEntity, TrustedAnchorEntity> trustedAnchor;
	public static volatile SingularAttribute<AnchorUrlEntity, Integer> id;
	public static volatile SetAttribute<AnchorUrlEntity, AnchorUrlCertEntity> anchorUrlCerts;
	public static volatile SingularAttribute<AnchorUrlEntity, String> url;

	public static final String TRUSTED_ANCHOR = "trustedAnchor";
	public static final String ID = "id";
	public static final String ANCHOR_URL_CERTS = "anchorUrlCerts";
	public static final String URL = "url";

}

