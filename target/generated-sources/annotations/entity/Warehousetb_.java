package entity;

import entity.Addresstb;
import entity.Bookingtb;
import entity.Scheduletb;
import entity.Servicetb;
import entity.Usertb;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Warehousetb.class)
public class Warehousetb_ { 

    public static volatile SingularAttribute<Warehousetb, Double> area;
    public static volatile SingularAttribute<Warehousetb, String> compliances;
    public static volatile SingularAttribute<Warehousetb, String> amenities;
    public static volatile SingularAttribute<Warehousetb, String> constructionType;
    public static volatile CollectionAttribute<Warehousetb, Scheduletb> scheduletbCollection;
    public static volatile SingularAttribute<Warehousetb, Integer> warehouseID;
    public static volatile CollectionAttribute<Warehousetb, Bookingtb> bookingtbCollection;
    public static volatile CollectionAttribute<Warehousetb, Addresstb> addresstbCollection;
    public static volatile SingularAttribute<Warehousetb, Servicetb> serviceID;
    public static volatile SingularAttribute<Warehousetb, Usertb> userID;
    public static volatile SingularAttribute<Warehousetb, String> productType;

}