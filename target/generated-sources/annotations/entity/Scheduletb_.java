package entity;

import entity.Usertb;
import entity.Warehousetb;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Scheduletb.class)
public class Scheduletb_ { 

    public static volatile SingularAttribute<Scheduletb, Date> dateTIme;
    public static volatile SingularAttribute<Scheduletb, Warehousetb> warehouseID;
    public static volatile SingularAttribute<Scheduletb, Usertb> userID;
    public static volatile SingularAttribute<Scheduletb, Integer> scheduleID;

}