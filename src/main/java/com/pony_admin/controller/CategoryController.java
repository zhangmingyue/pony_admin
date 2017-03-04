package com.pony_admin.controller;

import com.google.common.base.Strings;
import com.pony_admin.domain.CategoryEntity;
import com.pony_admin.enumeration.CategoryType;
import com.pony_admin.service.CategoryService;
import com.pony_admin.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showCategory(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        List<CategoryEntity> level1List = categoryService.getCategoryByType(CategoryType.level1);
        List<CategoryEntity> level2 = categoryService.getCategoryByType(CategoryType.level2);

        CategoryEntity categoryEntry = new CategoryEntity();
        categoryEntry.setParent(null);
        categoryEntry.setType(null);
        categoryEntry.setName("未选择");
        categoryEntry.setId(-1);
        level1List.add(0, categoryEntry);
        level2.add(0, categoryEntry);

        model.addAttribute("level1", level1List);
        model.addAttribute("level2", level2);
        return "category";
    }

    @RequestMapping(value = "/get_by_id/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getCategoryByType(@PathVariable int id) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (id < 0) {
            modelMap.put("result", false);
            return modelMap;
        }

        List<CategoryEntity> list = categoryService.getCategoryByType(String.valueOf(id));
        modelMap.put("orgModelList", list);
        return modelMap;
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> inputCategory(HttpServletRequest request,
                                             HttpServletResponse response) throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String level1 = request.getParameter("level1");
        String level2_level1 = request.getParameter("level2_level1");
        String level2_level2 = request.getParameter("level2_level2");
        String level3_level2 = request.getParameter("level3_level2");
        String level3 = request.getParameter("level3");

        level2_level1 = ("-1").equals(level2_level1) ? null : level2_level1;
        level3_level2 = ("-1").equals(level3_level2) ? null : level3_level2;

        if (Strings.isNullOrEmpty(level1) && Strings.isNullOrEmpty(level2_level1) &&
                Strings.isNullOrEmpty(level2_level2) && Strings.isNullOrEmpty(level3_level2) &&
                Strings.isNullOrEmpty(level3)) {
            modelMap.put("result", false);
            modelMap.put("msg", "传递参数全部为空,请输入相应的参数");
            return modelMap;
        }

        Date date = new Date();
        CategoryEntity categoryEntity = new CategoryEntity();

        if ((!Strings.isNullOrEmpty(level1)) && Strings.isNullOrEmpty(level2_level1) &&
                Strings.isNullOrEmpty(level2_level2) && Strings.isNullOrEmpty(level3_level2) &&
                Strings.isNullOrEmpty(level3)) {

            categoryEntity.setName(level1);
            categoryEntity.setType(CategoryType.level1);
            categoryEntity.setParent(CategoryType.root);
            categoryEntity.setDate(date);

            int result = categoryService.insert(categoryEntity);
            if (result >= 1) {
                modelMap.put("result", true);
                return modelMap;
            }

            modelMap.put("result", false);
            modelMap.put("msg", "添加一级目录失败,失败原因: 添加数据库错误");
        }


        if (Strings.isNullOrEmpty(level1) && !(Strings.isNullOrEmpty(level2_level1) &&
                Strings.isNullOrEmpty(level2_level2)) && Strings.isNullOrEmpty(level3_level2) &&
                Strings.isNullOrEmpty(level3)) {

            categoryEntity.setName(level2_level2);
            categoryEntity.setType(CategoryType.level2);
            categoryEntity.setParent(level2_level1);
            categoryEntity.setDate(date);

            int result = categoryService.insert(categoryEntity);
            if (result >= 1) {
                modelMap.put("result", true);
                return modelMap;
            }

            modelMap.put("result", false);
            modelMap.put("msg", "添加二级目录失败,失败原因: 添加数据库错误");
        }

        if (Strings.isNullOrEmpty(level1) && Strings.isNullOrEmpty(level2_level1) &&
                Strings.isNullOrEmpty(level2_level2) && !(Strings.isNullOrEmpty(level3_level2) &&
                Strings.isNullOrEmpty(level3))) {

            categoryEntity.setName(level3);
            categoryEntity.setType(CategoryType.level3);
            categoryEntity.setParent(level3_level2);
            categoryEntity.setDate(date);

            int result = categoryService.insert(categoryEntity);
            if (result >= 1) {
                modelMap.put("result", true);
                return modelMap;
            }

            modelMap.put("result", false);
            modelMap.put("msg", "添加三级目录失败,失败原因: 添加数据库错误");
        }

        modelMap.put("result", false);
        modelMap.put("msg", "添加目录失败,失败原因:参数不符合要求(如添加二级或三级目录时,需要选择前一个目录)");
        return modelMap;
    }

}
