package com.avp.cdai.web.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StationShareFlowPredict.class)
public abstract class StationShareFlowPredict_ {

	public static volatile SingularAttribute<StationShareFlowPredict, Date> insertTime;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> lineId;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> flowCount;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> section;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> id;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> stationId;
	public static volatile SingularAttribute<StationShareFlowPredict, Integer> direction;
	public static volatile SingularAttribute<StationShareFlowPredict, Date> timestamp;

}
