package net.megogo.core.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class DateTimeUtils {

    private static final int SECONDS_IN_HOUR = 60 * 60;

    public static LocalDateTime getLocalDateTimeFromTimestamp(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
    }

    public static long getLocalCurrentTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static long getLocalTimestampPlusHours(int hours) {
        return getLocalCurrentTimestamp() + ((long) hours * SECONDS_IN_HOUR);
    }
}
