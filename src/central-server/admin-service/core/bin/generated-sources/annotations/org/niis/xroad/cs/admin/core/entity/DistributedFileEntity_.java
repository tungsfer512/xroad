package org.niis.xroad.cs.admin.core.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DistributedFileEntity.class)
public abstract class DistributedFileEntity_ {

	public static volatile SingularAttribute<DistributedFileEntity, String> fileName;
	public static volatile SingularAttribute<DistributedFileEntity, byte[]> fileData;
	public static volatile SingularAttribute<DistributedFileEntity, Instant> fileUpdatedAt;
	public static volatile SingularAttribute<DistributedFileEntity, String> haNodeName;
	public static volatile SingularAttribute<DistributedFileEntity, Integer> id;
	public static volatile SingularAttribute<DistributedFileEntity, String> contentIdentifier;
	public static volatile SingularAttribute<DistributedFileEntity, Integer> version;

	public static final String FILE_NAME = "fileName";
	public static final String FILE_DATA = "fileData";
	public static final String FILE_UPDATED_AT = "fileUpdatedAt";
	public static final String HA_NODE_NAME = "haNodeName";
	public static final String ID = "id";
	public static final String CONTENT_IDENTIFIER = "contentIdentifier";
	public static final String VERSION = "version";

}

