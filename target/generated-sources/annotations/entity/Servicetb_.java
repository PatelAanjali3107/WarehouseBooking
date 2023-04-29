package entity;

import entity.Usertb;
import entity.Warehousetb;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Servicetb.class)
public class Servicetb_ { 

    public static volatile SingularAttribute<Servicetb, String> serviceType;
    public static volatile CollectionAttribute<Servicetb, Usertb> usertbCollection;
    public static volatile SingularAttribute<Servicetb, Float> charge;
    public static volatile CollectionAttribute<Servicetb, Warehousetb> warehousetbCollection;
    public static volatile SingularAttribute<Servicetb, String> chargePer;
    public static volatile SingularAttribute<Servicetb, Integer> serviceID;

}