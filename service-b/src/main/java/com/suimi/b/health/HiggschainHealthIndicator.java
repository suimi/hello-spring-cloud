package com.suimi.b.health;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author suimi
 * @date 2019/5/20
 */
@Slf4j
@Component public class HiggschainHealthIndicator extends AbstractHealthIndicator {

    private String status;

    @Override protected void doHealthCheck(Health.Builder builder) throws Exception {
        if ("Offline".equals(status)) {
            builder.down();
//            infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
        } else if("Running".equals(status)){
//            infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
            builder.up();
        } else {
//            infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.OUT_OF_SERVICE);
            builder.down();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        log.info("update status to {}", status);
        this.status = status;
    }
}
