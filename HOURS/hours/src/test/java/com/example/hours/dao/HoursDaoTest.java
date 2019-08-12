package com.example.hours.dao;
import com.example.hours.model.HoursModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HoursDaoTest {
    @Autowired
    private HoursMapper hoursDao;

    @Test
     public void view() {
        HoursModel count = hoursDao.selectByPrimaryKey(1);
        Assert.assertEquals(1, count);
    }
    @Test
     public void queryHours() {
        List<HoursModel> hoursList = hoursDao.selectAll();
        Assert.assertEquals(1, hoursList.size());
    }

    @Test
     public void del() {
        int count = hoursDao.deleteByPrimaryKey(1);
        Assert.assertEquals(1, count);
    }

/*    @Test
     public void edit() {
        int count = hoursDao.edit(1);
        Assert.assertEquals(1, count);
    }*/

    @Test
     public void add() {
        HoursModel hoursModel = new HoursModel();
        hoursModel.setName("银河小区");
        hoursModel.setMemo("硚口路");
        hoursModel.setCreatetime(new Date());
        int count = hoursDao.insertSelective(hoursModel);
        Assert.assertEquals("1",count);
    }
}
