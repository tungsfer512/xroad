package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HAClusterStatusViewEntity.class)
public abstract class HAClusterStatusViewEntity_ {

	public static volatile SingularAttribute<HAClusterStatusViewEntity, String> nodeName;
	public static volatile SingularAttribute<HAClusterStatusViewEntity, Instant> configurationGenerated;
	public static volatile SingularAttribute<HAClusterStatusViewEntity, String> nodeAddress;

	public static final String NODE_NAME = "nodeName";
	public static final String CONFIGURATION_GENERATED = "configurationGenerated";
	public static final String NODE_ADDRESS = "nodeAddress";

}

