package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TrustedAnchorEntity.class)
public abstract class TrustedAnchorEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<TrustedAnchorEntity, byte[]> trustedAnchorFile;
	public static volatile SingularAttribute<TrustedAnchorEntity, String> trustedAnchorHash;
	public static volatile SingularAttribute<TrustedAnchorEntity, Instant> generatedAt;
	public static volatile SetAttribute<TrustedAnchorEntity, AnchorUrlEntity> anchorUrls;
	public static volatile SingularAttribute<TrustedAnchorEntity, String> instanceIdentifier;
	public static volatile SingularAttribute<TrustedAnchorEntity, Integer> id;

	public static final String TRUSTED_ANCHOR_FILE = "trustedAnchorFile";
	public static final String TRUSTED_ANCHOR_HASH = "trustedAnchorHash";
	public static final String GENERATED_AT = "generatedAt";
	public static final String ANCHOR_URLS = "anchorUrls";
	public static final String INSTANCE_IDENTIFIER = "instanceIdentifier";
	public static final String ID = "id";

}

