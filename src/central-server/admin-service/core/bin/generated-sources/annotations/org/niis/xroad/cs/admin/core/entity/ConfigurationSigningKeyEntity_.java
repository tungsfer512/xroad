package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConfigurationSigningKeyEntity.class)
public abstract class ConfigurationSigningKeyEntity_ {

	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, Instant> keyGeneratedAt;
	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, String> keyIdentifier;
	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, byte[]> cert;
	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, Integer> id;
	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, String> tokenIdentifier;
	public static volatile SingularAttribute<ConfigurationSigningKeyEntity, ConfigurationSourceEntity> configurationSource;

	public static final String KEY_GENERATED_AT = "keyGeneratedAt";
	public static final String KEY_IDENTIFIER = "keyIdentifier";
	public static final String CERT = "cert";
	public static final String ID = "id";
	public static final String TOKEN_IDENTIFIER = "tokenIdentifier";
	public static final String CONFIGURATION_SOURCE = "configurationSource";

}

