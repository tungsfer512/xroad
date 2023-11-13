package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConfigurationSourceEntity.class)
public abstract class ConfigurationSourceEntity_ {

	public static volatile SetAttribute<ConfigurationSourceEntity, ConfigurationSigningKeyEntity> configurationSigningKeys;
	public static volatile SingularAttribute<ConfigurationSourceEntity, Instant> anchorGeneratedAt;
	public static volatile SingularAttribute<ConfigurationSourceEntity, String> sourceType;
	public static volatile SingularAttribute<ConfigurationSourceEntity, ConfigurationSigningKeyEntity> configurationSigningKey;
	public static volatile SingularAttribute<ConfigurationSourceEntity, byte[]> anchorFile;
	public static volatile SingularAttribute<ConfigurationSourceEntity, String> haNodeName;
	public static volatile SingularAttribute<ConfigurationSourceEntity, Integer> id;
	public static volatile SingularAttribute<ConfigurationSourceEntity, String> anchorFileHash;

	public static final String CONFIGURATION_SIGNING_KEYS = "configurationSigningKeys";
	public static final String ANCHOR_GENERATED_AT = "anchorGeneratedAt";
	public static final String SOURCE_TYPE = "sourceType";
	public static final String CONFIGURATION_SIGNING_KEY = "configurationSigningKey";
	public static final String ANCHOR_FILE = "anchorFile";
	public static final String HA_NODE_NAME = "haNodeName";
	public static final String ID = "id";
	public static final String ANCHOR_FILE_HASH = "anchorFileHash";

}

