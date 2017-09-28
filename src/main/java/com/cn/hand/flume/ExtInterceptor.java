package com.cn.hand.flume;

import com.cn.hand.test.Dates;
import com.google.common.collect.Lists;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import org.apache.flume.interceptor.RegexExtractorInterceptorPassThroughSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Interceptor that extracts matches using a specified regular expression and
 * appends the matches to the event headers using the specified serializers</p>
 * Note that all regular expression matching occurs through Java's built in
 * java.util.regex package</p>. Properties:
 * <p>
 * regex: The regex to use
 * <p>
 * serializers: Specifies the group the serializer will be applied to, and the
 * name of the header that will be added. If no serializer is specified for a
 * group the default {@link RegexExtractorInterceptorPassThroughSerializer} will
 * be used
 * <p>
 * Sample config:
 * <p>
 * agent.sources.r1.channels = c1
 * <p>
 * agent.sources.r1.type = SEQ
 * <p>
 * agent.sources.r1.interceptors = i1
 * <p>
 * agent.sources.r1.interceptors.i1.type = REGEX_EXTRACTOR
 * <p>
 * agent.sources.r1.interceptors.i1.regex = (WARNING)|(ERROR)|(FATAL)
 * <p>
 * agent.sources.r1.interceptors.i1.serializers = s1 s2
 * agent.sources.r1.interceptors.i1.serializers.s1.type =
 * com.blah.SomeSerializer agent.sources.r1.interceptors.i1.serializers.s1.name
 * = warning agent.sources.r1.interceptors.i1.serializers.s2.type =
 * org.apache.flume.interceptor.RegexExtractorInterceptorTimestampSerializer
 * agent.sources.r1.interceptors.i1.serializers.s2.name = error
 * agent.sources.r1.interceptors.i1.serializers.s2.dateFormat = yyyy-MM-dd
 * </code>
 * </p>
 * <p>
 * <pre>
 * Example 1:
 * </p>
 * EventBody: 1:2:3.4foobar5</p> Configuration:
 * agent.sources.r1.interceptors.i1.regex = (\\d):(\\d):(\\d)
 * </p>
 * agent.sources.r1.interceptors.i1.serializers = s1 s2 s3
 * agent.sources.r1.interceptors.i1.serializers.s1.name = one
 * agent.sources.r1.interceptors.i1.serializers.s2.name = two
 * agent.sources.r1.interceptors.i1.serializers.s3.name = three
 * </p>
 * results in an event with the the following
 *
 * body: 1:2:3.4foobar5 headers: one=>1, two=>2, three=3
 *
 * Example 2:
 *
 * EventBody: 1:2:3.4foobar5
 *
 * Configuration: agent.sources.r1.interceptors.i1.regex = (\\d):(\\d):(\\d)
 *
 * agent.sources.r1.interceptors.i1.serializers = s1 s2
 * agent.sources.r1.interceptors.i1.serializers.s1.name = one
 * agent.sources.r1.interceptors.i1.serializers.s2.name = two
 *
 *
 * results in an event with the the following
 *
 * body: 1:2:3.4foobar5 headers: one=>1, two=>2
 * </pre>
 */
public class ExtInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(ExtInterceptor.class);

    private SimpleDateFormat sd = null;

    private ExtInterceptor() {
        sd = new SimpleDateFormat("yyyyMMdd");
    }

    public void initialize() {
        // NO-OP...
    }

    public void close() {
        // NO-OP...
    }

    public Event intercept(Event event) {

        //获取headers参数
        Map<String, String> headers = event.getHeaders();
        String body;
        try {
            body = new String(event.getBody(), "utf8");
            logger.info("intercept body is null: " + (null==body));
            if (null == body || "".equals(body)) {
                return null;
            }
            JSONObject jsonObject = JSONObject.fromObject(body);
            String resourceId = jsonObject.getString("resourceId");
            String remark = jsonObject.getString("remark");
            if (StringUtils.isEmpty(resourceId) || StringUtils.isEmpty(remark)) {
                return null;
            }
            for (String str : Dates.numStr) {
                if (resourceId.equals(str)) {
                    return null;
                }
            }
            String sdStr = sd.format(new Date());
            headers.put("fileName", remark + "_" + sdStr);
            headers.put("filePath", remark + "/" + sdStr);
            event.setHeaders(headers);
            return event;
        } catch (Exception e) {
            logger.error("intercept error", e);
        }
        return null;
    }

    public List<Event> intercept(List<Event> events) {
        logger.info("intercept list size = " + events.size());
        List<Event> intercepted = Lists.newArrayListWithCapacity(events.size());
        for (Event event : events) {
            Event interceptedEvent = intercept(event);
            if (interceptedEvent != null) {
                intercepted.add(interceptedEvent);
            }
        }
        return intercepted;
    }

    public static class Builder implements Interceptor.Builder {

        public void configure(Context context) {

        }

        public Interceptor build() {
            return new ExtInterceptor();
        }
    }
}