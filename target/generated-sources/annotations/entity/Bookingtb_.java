package entity;

import entity.Invoicetb;
import entity.Usertb;
import entity.Warehousetb;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Bookingtb.class)
public class Bookingtb_ { 

    public static volatile SingularAttribute<Bookingtb, Date> bookingStartDate;
    public static volatile SingularAttribute<Bookingtb, Warehousetb> warehouseID;
    public static volatile SingularAttribute<Bookingtb, Date> bookingEndDate;
    public static volatile CollectionAttribute<Bookingtb, Invoicetb> invoicetbCollection;
    public static volatile SingularAttribute<Bookingtb, Usertb> userID;
    public static volatile SingularAttribute<Bookingtb, Integer> bookingID;

}