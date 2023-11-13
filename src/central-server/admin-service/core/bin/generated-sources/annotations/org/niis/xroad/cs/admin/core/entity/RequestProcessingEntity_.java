package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.niis.xroad.cs.admin.api.domain.ManagementRequestStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RequestProcessingEntity.class)
public abstract class RequestProcessingEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<RequestProcessingEntity, Integer> id;
	public static volatile SetAttribute<RequestProcessingEntity, RequestWithProcessingEntity> requests;
	public static volatile SingularAttribute<RequestProcessingEntity, ManagementRequestStatus> status;

	public static final String ID = "id";
	public static final String REQUESTS = "requests";
	public static final String STATUS = "status";

}

