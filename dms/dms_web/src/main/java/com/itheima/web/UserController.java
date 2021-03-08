package com.itheima.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.user.User;
import com.itheima.domain.user.UserExample;
import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;

    /**
     * 初始index网页自动访问findAll方法,拿到用户数据跳转user-list页面
     * @param model
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "5") Integer pageSize){
        //获取查询条件
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        //调用方法查询数据
        PageInfo<User> pageInfo = userService.findAll(example, page, pageSize);
        //数据存入域中
        model.addAttribute("pageInfo",pageInfo);
        return "user/user-list";
    }

    /**
     *新增和修改,请求转发到user-list页面
     * @param user
     * @return
     */
    @RequestMapping("/edit")
    public String edit(User user){
        if (StringUtils.isEmpty(user.getId())) {
            //id不存在,保存
            userService.save(user);

        } else {
            //id存在,修改
            userService.update(user);
        }
        return "redirect:/user/findAll";
    }

    /**
     * 点击编辑跳转修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        //查询对应id用户的数据
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/user-edit";
    }
}
