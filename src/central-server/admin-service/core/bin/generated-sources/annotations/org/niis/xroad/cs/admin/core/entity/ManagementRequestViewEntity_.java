package org.niis.xroad.cs.admin.core.entity;

import ee.ria.xroad.common.identifier.XRoadObjectType;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.niis.xroad.cs.admin.api.domain.ManagementRequestStatus;
import org.niis.xroad.cs.admin.api.domain.Origin;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ManagementRequestViewEntity.class)
public abstract class ManagementRequestViewEntity_ {

	public static volatile SingularAttribute<ManagementRequestViewEntity, String> memberCode;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> clientMemberCode;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> clientSubsystemCode;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> comments;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> address;
	public static volatile SingularAttribute<ManagementRequestViewEntity, Origin> origin;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> securityServerOwnerName;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> type;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> clientMemberClass;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> memberClass;
	public static volatile SingularAttribute<ManagementRequestViewEntity, Instant> createdAt;
	public static volatile SingularAttribute<ManagementRequestViewEntity, ManagementRequestStatus> requestProcessingStatus;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> serverCode;
	public static volatile SingularAttribute<ManagementRequestViewEntity, XRoadObjectType> clientType;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> clientOwnerName;
	public static volatile SingularAttribute<ManagementRequestViewEntity, Integer> requestProcessingId;
	public static volatile SingularAttribute<ManagementRequestViewEntity, byte[]> authCert;
	public static volatile SingularAttribute<ManagementRequestViewEntity, Integer> id;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> clientXroadInstance;
	public static volatile SingularAttribute<ManagementRequestViewEntity, String> xroadInstance;
	public static volatile SingularAttribute<ManagementRequestViewEntity, Integer> securityServerIdentifierId;

	public static final String MEMBER_CODE = "memberCode";
	public static final String CLIENT_MEMBER_CODE = "clientMemberCode";
	public static final String CLIENT_SUBSYSTEM_CODE = "clientSubsystemCode";
	public static final String COMMENTS = "comments";
	public static final String ADDRESS = "address";
	public static final String ORIGIN = "origin";
	public static final String SECURITY_SERVER_OWNER_NAME = "securityServerOwnerName";
	public static final String TYPE = "type";
	public static final String CLIENT_MEMBER_CLASS = "clientMemberClass";
	public static final String MEMBER_CLASS = "memberClass";
	public static final String CREATED_AT = "createdAt";
	public static final String REQUEST_PROCESSING_STATUS = "requestProcessingStatus";
	public static final String SERVER_CODE = "serverCode";
	public static final String CLIENT_TYPE = "clientType";
	public static final String CLIENT_OWNER_NAME = "clientOwnerName";
	public static final String REQUEST_PROCESSING_ID = "requestProcessingId";
	public static final String AUTH_CERT = "authCert";
	public static final String ID = "id";
	public static final String CLIENT_XROAD_INSTANCE = "clientXroadInstance";
	public static final String XROAD_INSTANCE = "xroadInstance";
	public static final String SECURITY_SERVER_IDENTIFIER_ID = "securityServerIdentifierId";

}

