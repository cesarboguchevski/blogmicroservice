package br.com.blogMicroservice.util;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@lombok.Data
public class DateBucket {
    final Instant from;
    final Instant to;

    public static List<DateBucket> bucketize(
            ZonedDateTime fromDate,
            ZonedDateTime toDate,
            int bucketSize,
            ChronoUnit bucketSizeUnit
    ) {
        List<DateBucket> buckets = new ArrayList<>();

        boolean reachedDate = false;

        for (int i = 0; !reachedDate; i++) {
            ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
            ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
            reachedDate = toDate.isBefore(maxDate);
            buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
        }
        return buckets;
    }



    public static List<DateBucket> bucketizeWithStream(ZonedDateTime fromDate, ZonedDateTime toDate,
                                             int bucketSize, ChronoUnit bucketSizeUnit) {

        return LongStream.range(0, bucketSizeUnit.between(fromDate, toDate)/bucketSize + 1)
                .mapToObj( nb -> new DateBucket(
                        fromDate.plus(nb * bucketSize, bucketSizeUnit).toInstant(),
                        fromDate.plus((nb+1) * bucketSize, bucketSizeUnit).toInstant()))
                .collect(Collectors.toList());
    }
}