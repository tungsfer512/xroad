package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XRoadMemberEntity.class)
public abstract class XRoadMemberEntity_ extends org.niis.xroad.cs.admin.core.entity.SecurityServerClientEntity_ {

	public static volatile SingularAttribute<XRoadMemberEntity, String> memberCode;
	public static volatile SingularAttribute<XRoadMemberEntity, String> name;
	public static volatile SingularAttribute<XRoadMemberEntity, String> administrativeContact;
	public static volatile SetAttribute<XRoadMemberEntity, SecurityServerEntity> ownedServers;
	public static volatile SetAttribute<XRoadMemberEntity, SubsystemEntity> subsystems;
	public static volatile SingularAttribute<XRoadMemberEntity, MemberClassEntity> memberClass;

	public static final String MEMBER_CODE = "memberCode";
	public static final String NAME = "name";
	public static final String ADMINISTRATIVE_CONTACT = "administrativeContact";
	public static final String OWNED_SERVERS = "ownedServers";
	public static final String SUBSYSTEMS = "subsystems";
	public static final String MEMBER_CLASS = "memberClass";

}

