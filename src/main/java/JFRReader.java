import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.io.File;

/**
 * Created by mani on 9/23/16.
 */
public class JFRReader {
    private static JFRReader jfrReader = new JFRReader();

    public static JFRReader getInstance() {
        return jfrReader;
    }

    private JFRReader() {
    }

    public void readJFR(String filepath){
        FlightRecording recording = FlightRecordingLoader.loadFile(new File(filepath));
        IView view = recording.createView();

    }
}
