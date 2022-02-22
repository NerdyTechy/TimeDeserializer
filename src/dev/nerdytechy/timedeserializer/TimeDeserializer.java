package dev.nerdytechy.timedeserializer;

import java.util.concurrent.TimeUnit;

public class TimeDeserializer {

    /**
     * Converts time in a string format (2w) to a long format (1209600)
     * @param str   the string formatted time frame
     * @return      a long with the amount of equivalent seconds
     */
    public Long deserialize(String str) {
        if (str.isEmpty()) return 0L;

        String str2 = str.replaceAll("[^0-9smhdw:,]", "");

        if (str2.isEmpty()) return 0L;

        long total = 0L;

        String[] splitChar = str2.split("[:,]");

        for (String s : splitChar) {
            if (s.isEmpty()) continue;

            if (s.contains("w")) {
                s = s.replaceAll("[^0-9]", "");
                total += TimeUnit.DAYS.toSeconds(Long.parseLong(s) * 7);
                continue;
            }

            TimeUnit unit = s.contains("d") ? TimeUnit.DAYS
                    : s.contains("h") ? TimeUnit.HOURS
                    : s.contains("m") ? TimeUnit.MINUTES
                    : TimeUnit.SECONDS;

            s = s.replaceAll("[^0-9]", "");

            total += unit.toSeconds(Long.parseLong(s));
        }
        return total;
    }

}
