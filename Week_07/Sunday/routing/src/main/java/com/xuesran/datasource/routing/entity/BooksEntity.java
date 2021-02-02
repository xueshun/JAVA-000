package com.xuesran.datasource.routing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * 
 * @author xueshun
 * @email xuesran@gmail.com
 * @date 2021-02-02 20:02:43
 */
@Data
@Builder
@TableName("books")
@NoArgsConstructor
@AllArgsConstructor
public class BooksEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * <pre>
	 * 名称：
	 * 属性名：id
	 * 类型：Long
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：authorName
	 * 类型：String
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private String authorName;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：createdAt
	 * 类型：LocalDateTime
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private LocalDateTime createdAt;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：genre
	 * 类型：String
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private String genre;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：name
	 * 类型：String
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private String name;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：price
	 * 类型：Double
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private Double price;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：rating
	 * 类型：Integer
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private Integer rating;

	/**
	 * <pre>
	 * 名称：
	 * 属性名：updatedAt
	 * 类型：LocalDateTime
	 * 允许为空：
	 * 默认值:
	 * 长度:
	 * 示例：
	 * 描述：
	 * </pre>
	 */
	private LocalDateTime updatedAt;

}
