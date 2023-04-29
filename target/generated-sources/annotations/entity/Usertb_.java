package entity;

import entity.Addresstb;
import entity.Bookingtb;
import entity.Invoicetb;
import entity.Roletb;
import entity.Scheduletb;
import entity.Servicetb;
import entity.Warehousetb;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-04-30T02:46:19")
@StaticMetamodel(Usertb.class)
public class Usertb_ { 

    public static volatile CollectionAttribute<Usertb, Servicetb> servicetbCollection;
    public static volatile SingularAttribute<Usertb, String> lastName;
    public static volatile SingularAttribute<Usertb, Roletb> roleID;
    public static volatile CollectionAttribute<Usertb, Warehousetb> warehousetbCollection;
    public static volatile SingularAttribute<Usertb, Date> regDate;
    public static volatile CollectionAttribute<Usertb, Bookingtb> bookingtbCollection;
    public static volatile SingularAttribute<Usertb, Integer> userID;
    public static volatile SingularAttribute<Usertb, String> phoneNo;
    public static volatile SingularAttribute<Usertb, String> firstName;
    public static volatile SingularAttribute<Usertb, String> password;
    public static volatile CollectionAttribute<Usertb, Scheduletb> scheduletbCollection;
    public static volatile CollectionAttribute<Usertb, Addresstb> addresstbCollection;
    public static volatile CollectionAttribute<Usertb, Invoicetb> invoicetbCollection;
    public static volatile SingularAttribute<Usertb, String> email;

}