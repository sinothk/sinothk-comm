package com.siniothk.comm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ApiModel(description = "版本实体")
@Data
@ToString
@TableName(value = "tb_dict")
public class DictEntity {
//    Field       Type         Collation        Null    Key     Default  Extra           Privileges                       Comment
//----------  -----------  ---------------  ------  ------  -------  --------------  -------------------------------  ---------
//    id          bigint(20)   (NULL)           NO      PRI     (NULL)   auto_increment  select,insert,update,references
//    key         varchar(16)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
//    value       varchar(32)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
//    parent_key  varchar(16)  utf8_general_ci  YES             (NULL)                   select,insert,update,references

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "键")
    @TableField("dict_key")
    private String dictKey;

    @ApiModelProperty(value = "值")
    @TableField("dict_value")
    private String dictValue;

    @ApiModelProperty(value = "父键")
    @TableField("parent_key")
    private String parentKey;

    @ApiModelProperty(value = "新增时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "启用时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "启用时间")
    @TableField("dict_status")
    private Integer dictStatus;

    @ApiModelProperty(value = "排序码")
    @TableField("dict_order")
    private String dictOrder;
}
