package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> timeEntries = new ArrayList<TimeEntry>();
    private long incrementer = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        incrementer++;
        timeEntries.add(timeEntry);
        timeEntry.setId(incrementer);
        return timeEntry;
    }

    public List list() {
        return timeEntries;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        for(TimeEntry entry: timeEntries){
            if (entry.getId() == id) {
                timeEntries.remove(entry);
                timeEntry.setId(id);
                timeEntries.add(timeEntry);
                return timeEntry;
            }
        }
        return null;
    }

    public TimeEntry find(long id){
        for (TimeEntry timeEntry : timeEntries) {
            if (timeEntry.getId() == id) {
                return timeEntry;
            }
        }

        return null;
    }

    public void delete(long id){
         TimeEntry timeEntry = find(id);
         timeEntries.remove(timeEntry);
    }
}
