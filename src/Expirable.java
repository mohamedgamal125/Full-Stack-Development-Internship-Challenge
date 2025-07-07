import java.util.Date;

public interface Expirable {

    Date getExpiryDate();
    boolean isExpired();

}
