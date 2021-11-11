package br.com.blogMicroservice;

import br.com.blogMicroservice.util.DateBucket;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class BlogMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldBucketizeWithoutStream() {

		// 'yyyy-MM-dd KK:mm:ss a' pattern
		ZonedDateTime fromDate = ZonedDateTime.parse("2021-11-11 10:20:30 AM",
				DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a").withZone(ZoneId.systemDefault()));

		ZonedDateTime toDate = ZonedDateTime.parse("2021-11-11 10:20:35 AM",
				DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a").withZone(ZoneId.systemDefault()));

		List<DateBucket> bucketList = DateBucket.bucketize(fromDate, toDate, 1, ChronoUnit.SECONDS);

		assertTrue(bucketList.isEmpty() ? false : true);
	}

	@Test
	public void shouldBucketizeWithStream() {

		// 'yyyy-MM-dd KK:mm:ss a' pattern
		ZonedDateTime fromDate = ZonedDateTime.parse("2021-11-11 10:20:30 AM",
				DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a").withZone(ZoneId.systemDefault()));

		ZonedDateTime toDate = ZonedDateTime.parse("2021-11-11 10:20:35 AM",
				DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a").withZone(ZoneId.systemDefault()));

		List<DateBucket> bucketList = DateBucket.bucketizeWithStream(fromDate, toDate, 1, ChronoUnit.SECONDS);

		assertTrue(bucketList.isEmpty() ? false : true);
	}



}
