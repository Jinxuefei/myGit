package com.example.hours.setvice;
import com.example.hours.dao.HoursMapper;
import com.example.hours.model.HoursModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HoursService {

    @Autowired
    HoursMapper hoursMapper;

    @Transactional(rollbackFor ={Exception.class})
    public HoursModel hoursView(int id)  throws Exception {
        return hoursMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor ={Exception.class})
    public List<HoursModel> queryHours() throws  Exception{
         return hoursMapper.selectAll();
    }

    @Transactional(rollbackFor ={Exception.class})
    public int hoursDel(Integer id) throws  Exception{
        if(id>0){
            int count = hoursMapper.deleteByPrimaryKey(id);
            if(count>0){
                return count;
            }else{
                throw  new RuntimeException("删除数据失败!");
            }
        }else{
            throw new RuntimeException("ID不能0!:");
        }
     }

    @Transactional(rollbackFor ={Exception.class})
    public int hoursEdit(HoursModel hoursModel) throws  Exception{
        if(hoursModel.getId()>0){
            try {
                  int count = hoursMapper.updateByPrimaryKey(hoursModel);
                if(count>0){
                    return  count;
                }else{
                    throw new RuntimeException("更新数据失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("更新数据失败:"+ e.getMessage());
            }
        }else{
            throw new RuntimeException("ID不能为0!:");
        }
    }

    @Transactional(rollbackFor ={Exception.class})
    public int hoursAdd(HoursModel hoursModel) throws  Exception {
        if(hoursModel.getName()!=null && ""!=hoursModel.getName()){
            hoursModel.setCreatetime(new Date());
            try {
                int count = hoursMapper.insertSelective(hoursModel);
                if(count>0){
                    return  count;
                }else{
                    throw new RuntimeException("插入数据失败!");
                }
            }catch (Exception e){
                    throw new RuntimeException("插入数据失败:"+ e.getMessage());
            }
        }else{
            throw new RuntimeException("房间名称不能为空!");
        }
     }
}
