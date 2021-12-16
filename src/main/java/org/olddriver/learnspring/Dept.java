package org.olddriver.learnspring;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class Dept {

    public interface Add{};
    public interface Update{};

    /**
     * 主键
     */
    @Null(groups = {Add.class})
    @NotNull(groups = {Update.class})
    private Integer id;
    /**
     * 父级主键
     */
    @NotNull(groups = {Add.class})
    private Integer parentId;
    /**
     * 部门名称
     */
    @NotBlank(groups = {Add.class})
    private String name;
    /**
     * 创建时间
     */
    @PastOrPresent(groups = {Add.class})
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
