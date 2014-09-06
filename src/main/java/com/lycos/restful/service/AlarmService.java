package com.lycos.restful.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: AlarmService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Lycos
 * @date 2014年9月4日 上午11:47:15
 */
@Path("alarm")
public class AlarmService {
    public static Logger log = Logger.getLogger(AlarmService.class);

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello World";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveAntiCheatData(String msg) {
        Map<String, Object> map;
        try {
            map = JSON.parseObject(msg);
        } catch (Exception e) {
            log.error(e);
            return "false";
        }

        if (map.containsKey("cheat")) {
            return (String) map.get("cheat");
        } else {
            return "false";
        }

    }
}
