package com.example.init.attachments.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 全局附件表
 * </p>
 *
 * @author StevenGuo
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Attachments对象", description="全局附件表")
public class Attachments extends Model<Attachments> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "附件后缀")
    private String fileExtension;

    @ApiModelProperty(value = "附件类型（图片IMAGE,文档DOC，音频AUDIO，视频VIDEO，其他OTHER,标准分类STANDARD_TYPE）")
    private String fileType;

    @ApiModelProperty(value = "附件名称")
    private String fileName;

    @ApiModelProperty(value = "文件存储路径")
    private String url;

    @ApiModelProperty(value = "创建用户")
    private Integer creator;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改用户")
    private Integer updator;

    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除标识")
    @TableLogic
    private String deleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
