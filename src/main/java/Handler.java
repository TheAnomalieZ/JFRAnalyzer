import com.jrockit.mc.flightrecorder.spi.IView;

/**
 * Created by mani on 9/23/16.
 */
public interface Handler {
    IView view = null;
    String EVENT_TYPE = "";

    public void getSeries();

}
