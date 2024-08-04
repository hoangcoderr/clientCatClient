package cleanCatClient.event;

import java.util.Iterator;
import java.util.ArrayList;

public class Event {
    public Event call() {
        final ArrayList<EventData> dataList = EventManager.get(this.getClass());
        if (dataList != null) {
            for (final EventData data : dataList) {
                try {
                    data.target.invoke(data.source, new Object[] { this });
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
}
