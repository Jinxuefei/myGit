package com.example.hours.controller;
import com.example.hours.model.HoursModel;
import com.example.hours.setvice.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/admin")
public class HoursController {
    @Autowired
    private HoursService hoursService;

    @RequestMapping(value = "/listHours",method = RequestMethod.GET)
    private Map<String,Object> listHours() throws  Exception{
        Map<String,Object> map = new HashMap<String,Object>();
         List<HoursModel>  listHours= hoursService.queryHours();
         map.put("listHours",listHours);
        return  map;
    }

    /**
     * 通过区域Id获取区域信息
     */
    @RequestMapping(value = "/hoursView", method = RequestMethod.GET)
    private Map<String, Object> hoursView(Integer hoursId) throws  Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        HoursModel hoursModel = hoursService.hoursView(hoursId);
        modelMap.put("hours", hoursModel);
        return modelMap;
    }
    /**
     * 添加区域信息
     */
    @RequestMapping(value = "/hoursAdd", method = RequestMethod.POST)
    private Map<String, Object> hoursAdd(@RequestBody HoursModel hoursModel)
            throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", hoursService.hoursAdd(hoursModel));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     */
    @RequestMapping(value = "/editHours", method = RequestMethod.POST)
    private Map<String, Object> editHours(@RequestBody HoursModel hoursModel) throws Exception{
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", hoursService.hoursEdit(hoursModel));
        return modelMap;
    }

    /**
     * 删除区域信息，主要修改名字
     */
    @RequestMapping(value = "/deleteHours", method = RequestMethod.GET)
    private Map<String, Object> deleteHours(Integer id) throws  Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 删除信息
        modelMap.put("success", hoursService.hoursDel(id));
        return modelMap;
    }

}
