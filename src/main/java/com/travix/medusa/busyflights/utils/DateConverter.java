package com.travix.medusa.busyflights.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by danilopereira on 15/03/18.
 */
public class DateConverter {

    public static String convertISOLocalDateTimeToISODateTime(String isoLocalDateTimeValue){
        LocalDateTime isoLocalDateTime = LocalDateTime.parse(isoLocalDateTimeValue, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Europe/Amsterdam")).format(isoLocalDateTime);
    }

    public static String convertISOInstantToISODateTime(String isoInstantValue){
        LocalDateTime isoInstant = LocalDateTime.parse(isoInstantValue, DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC")));
        return DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Europe/Amsterdam")).format(isoInstant);

    }


}
