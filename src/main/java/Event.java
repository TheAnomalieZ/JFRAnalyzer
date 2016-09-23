/**
 * Created by mani on 9/23/16.
 */
public interface Event {
    long startTimestamp = 0L;
    long endTimestamp = 0L;

    public long getEndTimestamp();
    public long getStartTimestamp();
}
