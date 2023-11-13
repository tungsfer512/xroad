package org.niis.xroad.cs.admin.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApprovedCaEntity.class)
public abstract class ApprovedCaEntity_ extends org.niis.xroad.cs.admin.core.entity.AuditableEntity_ {

	public static volatile SingularAttribute<ApprovedCaEntity, String> identifierDecoderMethodName;
	public static volatile SingularAttribute<ApprovedCaEntity, Boolean> authenticationOnly;
	public static volatile SetAttribute<ApprovedCaEntity, CaInfoEntity> intermediateCaInfos;
	public static volatile SingularAttribute<ApprovedCaEntity, CaInfoEntity> caInfo;
	public static volatile SingularAttribute<ApprovedCaEntity, String> name;
	public static volatile SingularAttribute<ApprovedCaEntity, String> identifierDecoderMemberClass;
	public static volatile SingularAttribute<ApprovedCaEntity, Integer> id;
	public static volatile SingularAttribute<ApprovedCaEntity, String> certProfileInfo;

	public static final String IDENTIFIER_DECODER_METHOD_NAME = "identifierDecoderMethodName";
	public static final String AUTHENTICATION_ONLY = "authenticationOnly";
	public static final String INTERMEDIATE_CA_INFOS = "intermediateCaInfos";
	public static final String CA_INFO = "caInfo";
	public static final String NAME = "name";
	public static final String IDENTIFIER_DECODER_MEMBER_CLASS = "identifierDecoderMemberClass";
	public static final String ID = "id";
	public static final String CERT_PROFILE_INFO = "certProfileInfo";

}

