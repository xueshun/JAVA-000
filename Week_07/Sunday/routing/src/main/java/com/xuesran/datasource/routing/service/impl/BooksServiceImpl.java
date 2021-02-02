package com.xuesran.datasource.routing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuesran.datasource.routing.entity.BooksEntity;
import com.xuesran.datasource.routing.mapper.IBooksMapper;
import com.xuesran.datasource.routing.service.IBooksService;
import org.springframework.stereotype.Service;


/**
 * The type Books service.
 *
 * @author xueshun
 */
@Service("booksService")
public class BooksServiceImpl extends ServiceImpl<IBooksMapper, BooksEntity> implements IBooksService {

}