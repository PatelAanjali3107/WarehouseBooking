package entity;

import entity.Bookingtb;
import entity.Usertb;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Invoicetb.class)
public class Invoicetb_ { 

    public static volatile SingularAttribute<Invoicetb, Date> date;
    public static volatile SingularAttribute<Invoicetb, Double> amount;
    public static volatile SingularAttribute<Invoicetb, Integer> invoiceID;
    public static volatile SingularAttribute<Invoicetb, Usertb> userID;
    public static volatile SingularAttribute<Invoicetb, Integer> transactionID;
    public static volatile SingularAttribute<Invoicetb, Bookingtb> bookingID;

}