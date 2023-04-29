package entity;

import entity.Usertb;
import entity.Warehousetb;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Addresstb.class)
public class Addresstb_ { 

    public static volatile SingularAttribute<Addresstb, Integer> zip;
    public static volatile SingularAttribute<Addresstb, String> country;
    public static volatile SingularAttribute<Addresstb, String> city;
    public static volatile SingularAttribute<Addresstb, Warehousetb> warehouseID;
    public static volatile SingularAttribute<Addresstb, String> street;
    public static volatile SingularAttribute<Addresstb, String> state;
    public static volatile SingularAttribute<Addresstb, Usertb> userID;
    public static volatile SingularAttribute<Addresstb, Integer> addressID;

}