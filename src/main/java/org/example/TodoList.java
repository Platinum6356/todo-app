package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> items = new ArrayList<>();
    private final List<Boolean> doneFlags = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
                doneFlags.add(false);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            doneFlags.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        List<String> combined = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            String prefix = doneFlags.get(i) ? "[done] " : "";
            combined.add(prefix + items.get(i));
        }
        return combined;
    }

    public int size() {
        return items.size();
    }

    public void clearAll() {
        items.clear();
        doneFlags.clear();
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < doneFlags.size()) {
            doneFlags.set(index, true);
            return true;
        }
        return false;
    }

    public boolean isDone(int index) {
        if (index >= 0 && index < doneFlags.size()) {
            return doneFlags.get(index);
        }
        return false;
    }

    public List<String> search(String substring) {
        List<String> result = new ArrayList<>();
        if (substring == null) return result;
        String lowerSub = substring.toLowerCase();
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i).toLowerCase();
            if (item.contains(lowerSub)) {
                String prefix = doneFlags.get(i) ? "[done] " : "";
                result.add(prefix + items.get(i));
            }
        }
        return result;
    }
}
