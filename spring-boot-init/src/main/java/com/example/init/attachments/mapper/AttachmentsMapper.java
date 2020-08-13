package com.example.init.attachments.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.init.attachments.entity.Attachments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 全局附件表 Mapper 接口
 * </p>
 *
 * @author StevenGuo
 * @since 2020-04-14
 */
@Mapper
@Repository
public interface AttachmentsMapper extends BaseMapper<Attachments> {
}
