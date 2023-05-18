package com.qkk.pigsmall.entity;

import com.qkk.pigsmall.cache.BaseCacheObject;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName GlobalConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月18日 20:56:02
 */
@Data
@Entity
@Table(name = "global_config")
@Where(clause = "is_deleted = 0")
public class GlobalConfig extends BaseCacheObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
    private Date createTime;
    private Date modifyTime;
    private Integer isDeleted;

    @Override
    protected long getTimeOut() {
        return ONE_MINUIT;
    }
}
